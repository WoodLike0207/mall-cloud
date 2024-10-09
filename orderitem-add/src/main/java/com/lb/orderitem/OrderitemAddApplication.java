package com.lb.orderitem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lb.orderitem.dao")
public class OrderitemAddApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderitemAddApplication.class, args);
    }

}
