package com.stan.wechatfriend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableEurekaClient
@EnableFeignClients("com.stan.service.api")
@SpringBootApplication(scanBasePackages = "com.stan")
@MapperScan("com.stan.mapper")
public class WechatFriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatFriendApplication.class, args);
    }

}
