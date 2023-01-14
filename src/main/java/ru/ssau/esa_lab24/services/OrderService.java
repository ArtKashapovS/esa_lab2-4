package ru.ssau.esa_lab24.services;

import org.springframework.stereotype.Service;
import ru.ssau.esa_lab24.models.Order;
import ru.ssau.esa_lab24.models.Seller;
import ru.ssau.esa_lab24.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public List<Order> getOrdersBySeller(Seller seller) {
        return orderRepository.findBySeller(seller);
    }


    public Order findOrderById(Integer orderId) {
        Optional<Order> foundOrder = orderRepository.findById(orderId);
        return foundOrder.orElse(null);
    }


    public void save(Order order) {
        orderRepository.save(order);
    }
}
