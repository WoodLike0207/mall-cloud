package com.lb.api.service.feign;

import com.lb.api.service.feign.fallback.OrderitemAddClientFallback;
import com.lb.mall.beans.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "orderitem-add",fallback = OrderitemAddClientFallback.class)
public interface OrderitemAddClient {

    @PostMapping("/item/save")
    int addOrderItem(List<ShoppingCartVO> list, @RequestParam("orderId") String orderId);

}