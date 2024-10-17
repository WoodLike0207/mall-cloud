package com.lb.order.service.feign.fallback;

import com.lb.mall.beans.ProductSku;
import com.lb.order.service.feign.ProductSkuQueryClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductSkuQueryClientFallback implements FallbackFactory<ProductSkuQueryClient> {
    @Override
    public ProductSkuQueryClient create(Throwable throwable) {
        throwable.printStackTrace();

        return new ProductSkuQueryClient(){
            @Override
            public ProductSku query(String skuId) {
                System.out.println("product-sku-query ~~~~~~ 服务降级");
                return null;
            }
        };
    }
}
