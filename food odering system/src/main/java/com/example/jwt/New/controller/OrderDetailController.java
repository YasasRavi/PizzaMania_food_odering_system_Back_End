package com.example.jwt.New.controller;

import com.example.jwt.New.entity.OrderDetail;
import com.example.jwt.New.entity.OrderInput;
import com.example.jwt.New.service.OrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder/{isSingleProductCheckout}"})
    public void placeOrder(@PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
            @RequestBody OrderInput orderInput){
        orderDetailService.placeOrder(orderInput, isSingleProductCheckout);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getOrderDetails"})
    public List<OrderDetail> getOrderDetails() {
         return orderDetailService.getOrderDetails();
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/getAllOrderDetails/{status}"})

    public List<OrderDetail> getAllOrderDetails (@PathVariable(name = "status") String status) {
         return orderDetailService.getAllOrderDetails(status);
    }


    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/markOrderAsDeliverd/{orderId}"})

    public void markOrderAsDelivered(@PathVariable(name = "orderId") Integer orderId ) {

            orderDetailService.markOderAsDelivered(orderId);

    }

}
