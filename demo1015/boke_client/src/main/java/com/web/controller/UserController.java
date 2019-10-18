package com.web.controller;

import com.web.pojo.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/16 9:01
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *thymeleaf页面效果测试及客户端测试
     * */
    @RequestMapping("/show")
    public  String showName(){
        return "showName";
    }


    /**
     * 前往登录页面
     * @return String 页面名称
     * */
    @GetMapping("/toLoginPage")
    public  String  toLoginPage(){
        return "login";
    }

   /**
     * 账号登录
    * @param user
     * @return Boolean 页面名称
     * */
    @PostMapping("/login")
    @ResponseBody
    public  Boolean  login(User user, HttpSession session){
        // 查询登录者信息
        User user1 = userService.login(user);

        // 判断是否登录成功
        if(user1 != null){
            session.setAttribute("user",user1);
            return true;
        }

        return false;
    }


    /**
     * 前往注册页面
     * @return String 页面名称
     * */
    @GetMapping("/toReginsterPage")
    public String toReginsterPage(){
        return "reginster";
    }

    /**
     * 注册新用户
     * @param user  User 用户信息
     * @return Boolean 执行结果
     * */
    @PostMapping("/reginster")
    @ResponseBody
    public Boolean reginster(User user){
        System.out.println(user);
        Boolean result = userService.reginster(user);
        return true;
    }



}
