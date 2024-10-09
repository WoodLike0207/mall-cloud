package com.lb.api.feign;

import com.lb.api.feign.fallback.UserSaveClientFallback;
import com.lb.mall.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-save",fallback = UserSaveClientFallback.class)
public interface UserSaveClient {
    @PostMapping("/user/save")
    int saveUser(Users user);
}
