package com.lb.order.service.feign;

import com.lb.mall.entity.ShoppingCartVO;
import com.lb.order.service.feign.fallback.StockQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "stock-query",fallback = StockQueryClientFallback.class)
public interface StockQueryClient {

    @GetMapping("/stock/query")
    List<ShoppingCartVO> query(@RequestParam("cids") String cids);

}