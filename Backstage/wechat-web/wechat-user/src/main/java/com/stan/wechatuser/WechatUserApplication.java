package com.stan.wechatuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.stan")
@MapperScan(basePackages = "com.stan.mapper")
public class WechatUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatUserApplication.class, args);
    }

}
