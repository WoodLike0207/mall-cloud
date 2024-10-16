package com.lb.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lb.order.dao")
public class OrderTimeoutQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTimeoutQueryApplication.class, args);
    }
}
