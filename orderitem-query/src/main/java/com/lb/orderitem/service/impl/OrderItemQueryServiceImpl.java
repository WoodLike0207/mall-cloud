package com.lb.orderitem.service.impl;

import com.lb.mall.entity.OrderItem;
import com.lb.orderitem.dao.OrderItemMapper;
import com.lb.orderitem.service.OrderItemQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderItemQueryServiceImpl implements OrderItemQueryService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> queryOrderItem(String orderId) {
        Example example = new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example);
        return orderItems;
    }
}
