package com.lb.order.feign.fallback;

import com.lb.mall.beans.Orders;
import com.lb.order.feign.OrderStatusUpdateClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusUpdateClientFallback implements FallbackFactory<OrderStatusUpdateClient> {
    @Override
    public OrderStatusUpdateClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new OrderStatusUpdateClient() {
            @Override
            public int update(Orders order) {
                System.out.println("order-status-update ~~~~~ 服务降级");
                return 0;
            }
        };
    }
}
