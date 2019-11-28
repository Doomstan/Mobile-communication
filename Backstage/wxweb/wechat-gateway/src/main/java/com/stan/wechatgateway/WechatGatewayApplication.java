package com.stan.wechatgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WechatGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatGatewayApplication.class, args);
    }

}
