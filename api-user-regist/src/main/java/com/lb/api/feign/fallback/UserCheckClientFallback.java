package com.lb.api.feign.fallback;

import com.lb.api.feign.UserCheckClient;
import com.lb.mall.beans.Users;
import org.springframework.stereotype.Component;

@Component
public class UserCheckClientFallback implements UserCheckClient {
    @Override
    public Users check(String username) {
        return new Users();
    }
}
