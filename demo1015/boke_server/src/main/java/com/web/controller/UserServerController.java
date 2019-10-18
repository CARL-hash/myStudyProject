package com.web.controller;

import com.web.pojo.User;
import com.web.service.UserServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserServerController
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/16 9:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserServerController {
    @Autowired
    private UserServerService userServerService;

    /**
     * 注册用户方法
     * @param user  User
     * @return Boolean 执行结果
     * */
    @PostMapping("/reginster")
    Boolean reginster(@RequestBody User user){
        System.out.println(user);
        return  userServerService.reginster(user);
    }


    /**
     *登录
     * @param user
     * @return User 类型
     * */
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userServerService.login(user);
    }


}
