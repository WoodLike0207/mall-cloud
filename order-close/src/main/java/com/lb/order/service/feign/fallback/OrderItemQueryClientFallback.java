package com.lb.order.service.feign.fallback;

import com.lb.mall.beans.OrderItem;
import com.lb.order.service.feign.OrderItemQueryClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemQueryClientFallback implements FallbackFactory<OrderItemQueryClient> {
    @Override
    public OrderItemQueryClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new OrderItemQueryClient() {
            @Override
            public List<OrderItem> query(String orderId) {
                System.out.println("orderitem-query ~~~~~~ 服务降级");
                return null;
            }
        };
    }
}
