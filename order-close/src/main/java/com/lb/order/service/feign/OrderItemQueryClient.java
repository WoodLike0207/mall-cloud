package com.lb.order.service.feign;

import com.lb.mall.beans.OrderItem;
import com.lb.order.service.feign.fallback.OrderItemQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "orderitem-query",fallbackFactory = OrderItemQueryClientFallback.class)
public interface OrderItemQueryClient {
    @GetMapping("/orderitem/query")
    List<OrderItem> query(@RequestParam("orderId") String orderId);

}
