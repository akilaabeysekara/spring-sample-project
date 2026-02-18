package lk.ijse.posebackend.controller;

import lk.ijse.posebackend.dto.OrderDTO;
import lk.ijse.posebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO) {
        // Changed method name to match the interface definition
        orderService.PlaceOrder(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}