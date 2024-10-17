package com.lb.order.service.feign;

import com.lb.mall.beans.ProductSku;
import com.lb.order.service.feign.fallback.ProductSkuQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-sku-query",fallbackFactory = ProductSkuQueryClientFallback.class)
public interface ProductSkuQueryClient {
    @GetMapping("product/sku/query")
    public ProductSku query(@RequestParam("skuId") String skuId);
}
