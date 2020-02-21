package com.sparrow.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sparrow.pojo.UserT;
import om.sparrow.user.service.UserTService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 落叶尘纷
 * @Date 2020/2/21 17:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserTController {
    @Reference
    private UserTService userTService;


    @RequestMapping("/findAll")
    public List<UserT> findAll(){
        return userTService.findAll();
    }

}
