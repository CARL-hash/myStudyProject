package com.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName BokeServerApplication
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 10:01
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.web.mapper")
public class BokeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BokeServerApplication.class,args);
    }
}
