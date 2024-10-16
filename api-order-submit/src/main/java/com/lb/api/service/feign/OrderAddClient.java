package com.lb.api.service.feign;

import com.lb.api.service.feign.fallback.OrderAddClientFallback;
import com.lb.mall.beans.Orders;
import com.lb.mall.beans.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order-add",fallbackFactory = OrderAddClientFallback.class)
public interface OrderAddClient {

    @PostMapping("/order/save")
    List<ShoppingCartVO> saveOrder(@RequestBody Orders order, @RequestParam("cids") String cids);

}