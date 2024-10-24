package com.lb.order.controller;

import com.lb.mall.entity.Orders;
import com.lb.order.service.OrderQueryByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderQueryByIdController {
    @Autowired
    private OrderQueryByIdService orderQueryByIdService;

    @GetMapping("/order/query/{oid}")
    public Orders query(@PathVariable("oid") String oid){
        return orderQueryByIdService.queryOrderById(oid);
    }
}
