package com.lb.order.feign;

import com.lb.mall.beans.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("order-querybyid")
public interface OrderQueryByIdClient {
    @GetMapping("/order/query/{oid}")
    Orders query(@PathVariable("oid") String oid);
}
