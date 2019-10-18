package com.web.mapper;

import com.web.pojo.Boke;
import com.web.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 20:32
 * @Version 1.0
 **/
public interface UserMapper {
    /**
     * 注册用户方法
     * @param user  User
     * @return Integer 主键序列
     * */
    Integer reginster(User user);

    /**
     * 登录
     * @param user
     * @return User
     * */
    User login(User user);



}
