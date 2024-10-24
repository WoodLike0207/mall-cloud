package com.lb.order.feign.fallback;

import com.lb.mall.beans.Orders;
import com.lb.order.feign.OrderQueryByIdClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderQueryByIdClientFallback implements FallbackFactory<OrderQueryByIdClient> {
    @Override
    public OrderQueryByIdClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new OrderQueryByIdClient() {
            @Override
            public Orders query(String oid) {
                return null;
            }
        };
    }
}
