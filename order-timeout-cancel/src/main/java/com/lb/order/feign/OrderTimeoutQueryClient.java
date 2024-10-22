package com.lb.order.feign;

import com.lb.mall.beans.Orders;
import com.lb.order.feign.fallback.OrderTimeoutQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "order-timeout-query",fallbackFactory = OrderTimeoutQueryClientFallback.class)
public interface OrderTimeoutQueryClient {
    @GetMapping("/order/query/timeout")
    List<Orders> query();
}
