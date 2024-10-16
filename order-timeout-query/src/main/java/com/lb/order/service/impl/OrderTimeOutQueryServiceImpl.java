package com.lb.order.service.impl;


import com.lb.mall.entity.Orders;
import com.lb.order.dao.OrdersMapper;
import com.lb.order.service.OrderTimeOutQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class OrderTimeOutQueryServiceImpl implements OrderTimeOutQueryService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> listOrders() {
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","1");
        Date time = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
        criteria.andLessThan("createTime",time);
        List<Orders> orders = ordersMapper.selectByExample(example);
        return orders;
    }
}
