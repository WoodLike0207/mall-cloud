package com.lb.api.service.feign.fallback;

import com.lb.api.service.feign.UserCheckClient;
import com.lb.mall.beans.Users;
import org.springframework.stereotype.Component;

@Component
public class UserCheckClientFallback implements UserCheckClient {
    @Override
    public Users check(String username) {
        return null;
    }
}
