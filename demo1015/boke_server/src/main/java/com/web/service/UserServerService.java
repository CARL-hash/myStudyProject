package com.web.service;

import com.web.pojo.User;

/**
 * @ClassName UserServerService
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/16 9:10
 * @Version 1.0
 **/
public interface UserServerService  {
    /**
     * 注册用户方法
     * @param user  User
     * @return int
     * */
    Boolean reginster(User user);

    /**
     * 登录方法
     * @param user
     * @return  User
     * */
    User login(User user);
}
