package com.stan.wechateurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WechatEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatEurekaServerApplication.class, args);
    }

}
