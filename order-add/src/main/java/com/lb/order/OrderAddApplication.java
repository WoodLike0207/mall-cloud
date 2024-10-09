package com.lb.order;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@FeignClient
@Hystrix
@MapperScan("com.lb.order.dao")
public class OrderAddApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderAddApplication.class, args);
    }

}
