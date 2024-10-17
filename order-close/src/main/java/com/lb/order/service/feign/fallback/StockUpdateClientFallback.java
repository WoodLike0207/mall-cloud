package com.lb.order.service.feign.fallback;

import com.lb.mall.beans.ProductSku;
import com.lb.order.service.feign.StockUpdateClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockUpdateClientFallback implements FallbackFactory<StockUpdateClient> {
    @Override
    public StockUpdateClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new StockUpdateClient() {
            @Override
            public int update(List<ProductSku> skus) {
                System.out.println("stock-update ~~~~~ 服务降级");
                return 0;
            }
        };
    }
}
