package lk.ijse.posebackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.posebackend.dto.OrderDTO;
import lk.ijse.posebackend.dto.OrderDetailDTO;
import lk.ijse.posebackend.entity.Customer;
import lk.ijse.posebackend.entity.Item;
import lk.ijse.posebackend.entity.Order;
import lk.ijse.posebackend.entity.OrderDetail;
import lk.ijse.posebackend.repository.CustomerRepository;
import lk.ijse.posebackend.repository.ItemRepository;
import lk.ijse.posebackend.repository.OrderRepository;
import lk.ijse.posebackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    @Override
    public void saveOrder(OrderDTO dto) {
        validateOrderDTO(dto);
        if (orderRepository.existsById(dto.getOrderId())) {
            throw new RuntimeException("Order already exists with ID: " + dto.getOrderId());
        }
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + dto.getCustomerId()));
        Order order = buildOrderFromDTO(dto, customer);
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(OrderDTO dto) {
        validateOrderDTO(dto);
        Order existingOrder = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + dto.getOrderId()));
        restoreStockForOrder(existingOrder);
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + dto.getCustomerId()));
        existingOrder.getOrderDetails().clear();
        existingOrder.setCustomer(customer);
        existingOrder.setOrderDate(dto.getOrderDate());
        List<OrderDetail> newOrderDetails = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (OrderDetailDTO detailDTO : dto.getOrderDetails()) {
            Item item = itemRepository.findById(detailDTO.getItemCode())
                    .orElseThrow(() -> new RuntimeException("Item not found with code: " + detailDTO.getItemCode()));
            validateStock(item, detailDTO.getQty());
            BigDecimal unitPrice = item.getIPrice();
            BigDecimal lineTotal = unitPrice.multiply(BigDecimal.valueOf(detailDTO.getQty()));
            total = total.add(lineTotal);
            item.setIQty(item.getIQty() - detailDTO.getQty());
            itemRepository.save(item);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(existingOrder);
            orderDetail.setItem(item);
            orderDetail.setQty(detailDTO.getQty());
            orderDetail.setUnitPrice(unitPrice);
            newOrderDetails.add(orderDetail);
        }
        existingOrder.setTotal(total);
        existingOrder.setOrderDetails(newOrderDetails);
        orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        restoreStockForOrder(order);
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        return convertToDTO(order);
    }

    private void validateOrderDTO(OrderDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Order DTO cannot be null");
        }
        if (dto.getOrderId() == null || dto.getOrderId().trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        if (dto.getCustomerId() == null || dto.getCustomerId().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        if (dto.getOrderDetails() == null || dto.getOrderDetails().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
    }

    private void validateStock(Item item, Integer requestedQty) {
        if (requestedQty == null || requestedQty <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (item.getIQty() < requestedQty) {
            throw new RuntimeException(
                    String.format("Insufficient stock for item %s. Available: %d, Requested: %d",
                            item.getICode(), item.getIQty(), requestedQty)
            );
        }
    }

    private Order buildOrderFromDTO(OrderDTO dto, Customer customer) {
        Order order = new Order();
        order.setOrderId(dto.getOrderId());
        order.setCustomer(customer);
        order.setOrderDate(dto.getOrderDate());
        List<OrderDetail> orderDetails = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (OrderDetailDTO detailDTO : dto.getOrderDetails()) {
            Item item = itemRepository.findById(detailDTO.getItemCode())
                    .orElseThrow(() -> new RuntimeException("Item not found with code: " + detailDTO.getItemCode()));
            validateStock(item, detailDTO.getQty());
            BigDecimal unitPrice = item.getIPrice();
            BigDecimal lineTotal = unitPrice.multiply(BigDecimal.valueOf(detailDTO.getQty()));
            total = total.add(lineTotal);
            item.setIQty(item.getIQty() - detailDTO.getQty());
            itemRepository.save(item);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setItem(item);
            orderDetail.setQty(detailDTO.getQty());
            orderDetail.setUnitPrice(unitPrice);
            orderDetails.add(orderDetail);
        }
        order.setTotal(total);
        order.setOrderDetails(orderDetails);
        return order;
    }

    private void restoreStockForOrder(Order order) {
        for (OrderDetail detail : order.getOrderDetails()) {
            Item item = detail.getItem();
            item.setIQty(item.getIQty() + detail.getQty());
            itemRepository.save(item);
        }
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getOrderId());
        dto.setCustomerId(order.getCustomer().getCId());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotal(order.getTotal());
        List<OrderDetailDTO> detailDTOList = order.getOrderDetails().stream()
                .map(this::convertDetailToDTO)
                .collect(Collectors.toList());
        dto.setOrderDetails(detailDTOList);
        return dto;
    }

    private OrderDetailDTO convertDetailToDTO(OrderDetail detail) {
        OrderDetailDTO detailDTO = new OrderDetailDTO();
        detailDTO.setId(detail.getId());
        detailDTO.setOrderId(detail.getOrder().getOrderId());
        detailDTO.setItemCode(detail.getItem().getICode());
        detailDTO.setQty(detail.getQty());
        detailDTO.setUnitPrice(detail.getUnitPrice());
        return detailDTO;
    }
}