package com.web.service;

import com.web.pojo.User;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserService
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/16 9:02
 * @Version 1.0
 *
 *
 * 知识点1 . 传递实体类型的时候不能使用 get传递方法，只能使用post
 *         改用post请求，添加@RequestBodey注解
 *
 *         新增@SpringQueryMaq注解，如下：
 *
 *         @GetMapping("/hello")
 *         String hello(@SpringQueryMap Params params) throws Exception;
 *
 *
 **/
@FeignClient("boke-server")
public interface UserService {

    /**
     * 注册用户方
     * @param user  User
     * @return Boolean 执行结果
     * */
    @PostMapping("/user/reginster")
    Boolean reginster(@RequestBody User user);

    /**
     *登录
     * @param user
     * @return Boolean 类型
     * */
    @PostMapping("/user/login")
    User login(@RequestBody User user);

}
