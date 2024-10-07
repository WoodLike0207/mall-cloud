package com.lb.api.service.feign;

import com.lb.api.service.feign.fallback.UserCheckClientFallback;
import com.lb.mall.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-check",fallback = UserCheckClientFallback.class)
public interface UserCheckClient {
    @GetMapping("user/check")
    Users check(@RequestParam("username") String username);
}
