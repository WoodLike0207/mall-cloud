package com.lb.order.service.feign;

import com.lb.mall.beans.Orders;
import com.lb.order.service.feign.fallback.OrderStatusUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order-status-update",fallbackFactory = OrderStatusUpdateClientFallback.class)
public interface OrderStatusUpdateClient {
    @PutMapping("/order/status/update")
    int update(@RequestBody Orders order);
}
