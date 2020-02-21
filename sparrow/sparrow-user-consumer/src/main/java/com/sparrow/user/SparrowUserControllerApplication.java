package com.sparrow.user;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 落叶尘纷
 * @Date 2020/2/21 17:13
 * @Version 1.0
 *
 * 普通用户控制层入口
 */
@SpringBootApplication
@EnableDubboConfiguration
public class SparrowUserControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparrowUserControllerApplication.class);
    }
}
