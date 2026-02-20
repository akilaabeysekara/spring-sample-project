package lk.ijse.posebackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.posebackend.dto.OrderDTO;
import lk.ijse.posebackend.dto.OrderDetailDTO;
import lk.ijse.posebackend.entity.Customer;
import lk.ijse.posebackend.entity.Item;
import lk.ijse.posebackend.entity.Orders;
import lk.ijse.posebackend.entity.OrderDetail;
import lk.ijse.posebackend.repository.CustomerRepository;
import lk.ijse.posebackend.repository.ItemRepository;
import lk.ijse.posebackend.repository.OrderRepository;
import lk.ijse.posebackend.repository.OrderDetailRepository;
import lk.ijse.posebackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    @Override
    public void PlaceOrder(OrderDTO dto) {

        // CHECK ORDER ID DUPLICATE
        if (orderRepository.existsById(dto.getOrderId())) {
            throw new RuntimeException("Order ID already exists: " + dto.getOrderId());
        }

        //  VALIDATE CUSTOMER
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() ->
                        new RuntimeException("Customer not found with ID: " + dto.getCustomerId()));

        // SAVE ORDER
        Orders order = new Orders();
        order.setOrderId(dto.getOrderId());
        order.setCustomerId(dto.getCustomerId());

        orderRepository.save(order);

        // SAVE ORDER DETAILS
        for (OrderDetailDTO detailDTO : dto.getOrderDetails()) {

            //  CHECK ORDER DETAIL DUPLICATE
            if (orderDetailRepository.existsById(detailDTO.getId())) {
                throw new RuntimeException("Order Detail ID already exists: " + detailDTO.getId());
            }

            //  VALIDATE ITEM
            Item item = itemRepository.findById(detailDTO.getItemId())
                    .orElseThrow(() ->
                            new RuntimeException("Item not found with ID: " + detailDTO.getItemId()));

            //  CHECK STOCK
            if (item.getQty() < detailDTO.getQty()) {
                throw new RuntimeException(
                        "Insufficient stock for item: " + detailDTO.getItemId() +
                                ". Available: " + item.getQty() +
                                ", Required: " + detailDTO.getQty()
                );
            }

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setId(detailDTO.getId());
            orderDetail.setItemId(detailDTO.getItemId());
            orderDetail.setPrice(detailDTO.getPrice());
            orderDetail.setQty(detailDTO.getQty());
            orderDetail.setTotal(detailDTO.getTotal());

            orderDetailRepository.save(orderDetail);

            //  UPDATE STOCK
            item.setQty(item.getQty() - detailDTO.getQty());
            itemRepository.save(item);
        }
    }
}