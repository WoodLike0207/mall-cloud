package com.lb.api.feign.fallback;

import com.lb.api.feign.UserSaveClient;
import com.lb.mall.beans.Users;
import org.springframework.stereotype.Component;

@Component
public class UserSaveClientFallback implements UserSaveClient {
    @Override
    public int saveUser(Users user) {
        return 0;
    }
}
