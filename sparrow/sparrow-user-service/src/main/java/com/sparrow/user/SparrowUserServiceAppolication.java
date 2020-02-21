package com.sparrow.user;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 落叶尘纷
 * @Date 2020/2/21 15:37
 * @Version 1.0
 *
 * 蜂鸟用户服务启动入口
 */
@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("com.sparrow.user.mapper")
public class SparrowUserServiceAppolication {
    public static void main(String[] args) {
        SpringApplication.run(SparrowUserServiceAppolication.class,args);
    }
}
