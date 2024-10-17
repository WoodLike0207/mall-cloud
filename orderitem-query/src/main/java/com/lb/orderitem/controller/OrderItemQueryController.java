package com.lb.orderitem.controller;

import com.lb.mall.entity.OrderItem;
import com.lb.orderitem.service.OrderItemQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemQueryController {
    @Autowired
    private OrderItemQueryService orderItemQueryService;

    @GetMapping("/orderitem/query")
    public List<OrderItem> query(String orderId){
        List<OrderItem> orderItems = orderItemQueryService.queryOrderItem(orderId);
        return orderItems;
    }
}
