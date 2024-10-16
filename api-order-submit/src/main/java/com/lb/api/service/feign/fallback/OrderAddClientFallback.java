package com.lb.api.service.feign.fallback;

import com.lb.api.service.feign.OrderAddClient;
import com.lb.mall.beans.Orders;
import com.lb.mall.beans.ShoppingCartVO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderAddClientFallback implements FallbackFactory<OrderAddClient> {
    /*@Override
    public List<ShoppingCartVO> saveOrder(Orders order, String cids) {

        return null;
    }*/

    @Override
    public OrderAddClient create(Throwable throwable) {
        // 打印错误日志
        throwable.printStackTrace();
        return new OrderAddClient() {

            @Override
            public List<ShoppingCartVO> saveOrder(Orders order, String cids) {
                System.out.println("order-add-------服务降级");
                return null;
            }
        };
    }
}