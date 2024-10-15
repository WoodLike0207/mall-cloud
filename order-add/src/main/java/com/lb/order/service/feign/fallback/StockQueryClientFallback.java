package com.lb.order.service.feign.fallback;

import com.lb.mall.entity.ShoppingCartVO;
import com.lb.order.service.feign.StockQueryClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockQueryClientFallback implements StockQueryClient {
    @Override
    public List<ShoppingCartVO> query(String cids) {
        System.out.println("stock-query------服务降级");
        return null;
    }
}
