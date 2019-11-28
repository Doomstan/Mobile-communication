package com.stan.wechatconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer  //开启
@SpringBootApplication
public class WechatConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatConfigServerApplication.class, args);
    }

}
