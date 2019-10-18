package com.web.service.impl;

import com.web.mapper.UserMapper;
import com.web.pojo.User;
import com.web.service.UserServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @ClassName UserServerServiceImpl
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/16 9:11
 * @Version 1.0
 **/
@Service
public class UserServerServiceImpl implements UserServerService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册账号
     * @return Boolean
     * @param user
     * */
    @Override
    public Boolean reginster(User user) {

        // 密码加密
        String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(s);

        Integer result = userMapper.reginster(user);

        if (result == null){
            return false;
        }

        return true ;
    }

    @Override
    public User login(User user) {
        String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(s);
        return userMapper.login(user);
    }
}
