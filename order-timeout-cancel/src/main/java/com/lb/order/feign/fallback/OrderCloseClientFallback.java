package com.lb.order.feign.fallback;

import com.lb.order.feign.OrderCloseClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderCloseClientFallback implements FallbackFactory<OrderCloseClient> {
    @Override
    public OrderCloseClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new OrderCloseClient() {
            @Override
            public int close(String orderId, int closeType) {
                System.out.println("order-close ~~~~~~~ 服务降级");
                return 0;
            }
        };
    }
}
