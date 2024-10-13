package com.lb.orderitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lb.orderitem.dao")
public class OrderitemAddApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderitemAddApplication.class, args);
    }

}
