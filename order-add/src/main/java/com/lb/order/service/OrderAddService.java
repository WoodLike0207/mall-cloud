package com.lb.order.service;

import com.lb.mall.entity.Orders;
import com.lb.mall.entity.ShoppingCartVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderAddService {
    List<ShoppingCartVO> save(@RequestBody Orders order, String cids);

}