package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName BokeClientApplication
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 10:10
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BokeClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(BokeClientApplication.class,args);
    }
}
