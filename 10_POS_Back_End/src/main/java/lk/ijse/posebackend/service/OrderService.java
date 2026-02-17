package lk.ijse.posebackend.service;

import lk.ijse.posebackend.dto.OrderDTO;
import java.util.List;

public interface OrderService {

    void saveOrder(OrderDTO orderDTO);

    void updateOrder(OrderDTO orderDTO);

    void deleteOrder(String orderId);

    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(String orderId);
}
