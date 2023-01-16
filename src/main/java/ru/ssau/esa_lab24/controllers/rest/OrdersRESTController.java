package ru.ssau.esa_lab24.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ssau.esa_lab24.models.Order;
import ru.ssau.esa_lab24.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrdersRESTController {
    private final OrderService orderService;

    @Autowired
    public OrdersRESTController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.findAll();
    }
}