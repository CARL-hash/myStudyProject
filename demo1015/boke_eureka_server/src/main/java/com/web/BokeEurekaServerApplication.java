package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName BokeEurekaServerApplication
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 9:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class BokeEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BokeEurekaServerApplication.class,args);
    }
}
