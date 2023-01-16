package ru.ssau.esa_lab24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ssau.esa_lab24.security.SellerDetails;
import ru.ssau.esa_lab24.services.OrderService;
import ru.ssau.esa_lab24.services.SellerService;

@Controller
public class OrdersController {
    private final OrderService orderService;
    private final SellerService sellerService;

    @Autowired
    public OrdersController(OrderService orderService, SellerService sellerService) {
        this.orderService = orderService;
        this.sellerService = sellerService;
    }

    @GetMapping("/orders")
    public String showOrders(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SellerDetails sellerDetails = (SellerDetails) authentication.getPrincipal();

        model.addAttribute("orders", orderService.getOrdersBySeller(sellerDetails.getSeller()));

        return "orders/index";
    }
}
