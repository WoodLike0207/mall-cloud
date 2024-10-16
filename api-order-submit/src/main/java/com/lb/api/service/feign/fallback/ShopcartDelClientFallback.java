package com.lb.api.service.feign.fallback;

import com.lb.api.service.feign.ShopcartDelClient;
import org.springframework.stereotype.Component;

@Component
public class ShopcartDelClientFallback implements ShopcartDelClient {

    public int delete(String cids) {
        System.out.println("shopcart-del ~~~~~~~ 服务降级");
        return 0;
    }

}