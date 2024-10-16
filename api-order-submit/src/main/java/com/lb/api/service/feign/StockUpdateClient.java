package com.lb.api.service.feign;

import com.lb.api.service.feign.fallback.StockUpdateClientFallback;
import com.lb.mall.beans.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(value = "stock-update",fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus);

}