package com.lb.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lb.stock.dao")
public class StockQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockQueryApplication.class, args);
    }

}
