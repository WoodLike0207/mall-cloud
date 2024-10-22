package com.lb.api.service.feign.fallback;

import com.lb.api.service.feign.UserCheckClient;
import com.lb.mall.beans.Users;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserCheckClientFallback implements FallbackFactory<UserCheckClient> {

    @Override
    public UserCheckClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new UserCheckClient() {
            @Override
            public Users check(String username) {
                System.out.println("UserCheckClientFallback 服务降级");
                return null;
            }
        };
    }
}
