package com.lb.order.feign.fallback;

import com.lb.mall.beans.Orders;
import com.lb.order.feign.OrderTimeoutQueryClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderTimeoutQueryClientFallback implements FallbackFactory<OrderTimeoutQueryClient> {
    @Override
    public OrderTimeoutQueryClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new OrderTimeoutQueryClient() {
            @Override
            public List<Orders> query() {
                System.out.println("order-timeout-query ~~~~~~ 服务降级");
                return new ArrayList<>();
            }
        };
    }
}
