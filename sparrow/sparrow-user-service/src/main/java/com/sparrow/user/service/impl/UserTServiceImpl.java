package com.sparrow.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sparrow.pojo.UserT;
import com.sparrow.user.mapper.UserTMapper;
import om.sparrow.user.service.UserTService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 落叶尘纷
 * @Date 2020/2/21 16:29
 * @Version 1.0
 */
@org.springframework.stereotype.Service
@Service
public class UserTServiceImpl implements UserTService {

    @Autowired
    private UserTMapper userTMapper;

    @Override
    public List<UserT> findAll(){
        return userTMapper.findAll();
    }


}
