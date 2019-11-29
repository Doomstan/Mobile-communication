package com.stan.wechcatconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class WechcatConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechcatConfigServerApplication.class, args);
    }

}
