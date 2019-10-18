package com.web.service.impl;

import com.web.mapper.BokeMapper;
import com.web.mapper.UserMapper;
import com.web.pojo.Boke;
import com.web.pojo.PL;
import com.web.pojo.User;
import com.web.service.BokeServerService;
import com.web.util.PageUtil;
import com.web.vo.BokeVo;
import com.web.vo.PLVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BokeServerServiceImpl
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 20:25
 * @Version 1.0
 **/
@Service
public class BokeServerServiceImpl implements BokeServerService {
    @Autowired
    private BokeMapper bokeMapper;


    /**
     * 模糊统计数
     * @param title
     * @return Integer
     * */
    @Override
    public Integer countBokesByLikeTitle(String title) {
        return bokeMapper.countBokesByLikeTitle(title);
    }

    /**
     * 模糊分页查询
     * @param title
     * @param pageNum
     * @return Map<String,Object>
     * */
    @Override
    public Map<String, Object> findBokesByLikeTitleConmingt(String title, String pageNum) {
        // 获取模糊统计数
        Integer counBoke = bokeMapper.countBokesByLikeTitle(title);
        // 封装模糊查询的信息
        PageUtil pageUtil = new PageUtil(pageNum,2,counBoke);
        pageUtil.setMohu(title);

        // System.out.println(pageUtil);
        // 模糊分页查询
        List<BokeVo> bokeVos = bokeMapper.findBokesByLikeTitleConmingt(pageUtil);

        // 封装结果集
        Map<String,Object> map = new HashMap<>();
        map.put("pageUtil",pageUtil);
        map.put("bokeVos",bokeVos);

        return map;
    }

    /**
     * 点赞
     *   逻辑分析：一个用户只能对一个篇博客进行点赞
     *   首先判断是否点赞,即条件查询如果有 则进行删除没有则添加一条相关信息
     *
     * */
    @Override
    public void likenum(Integer id, Integer userId){

        // 查询记录信息
        PL pl = bokeMapper.likenum(id,userId);

        // 判断是否已经点赞
        if(pl != null){
            // 删除删除点赞量
            bokeMapper.deleteThisPL(id,userId);
        }else{
            // 添加点赞量
            bokeMapper.addThisPL(id,userId);
        }
    }

    /**
     * 删除的逻辑分析  ：
     *    自己写的博客不能随意让别人删除
     *    需要判断博客是否是登录者的
     *
     *    boke删除后所有的相关信息连带删除
     *
     * */
    @Override
    public void deleteThis(Integer id, Integer userId) {
        Boke boke = bokeMapper.findThisBokeByMyslef(id,userId);
        // 删除自己的这篇boke所有信息
        if(boke != null){
            bokeMapper.deleteThisBoke(id);
            bokeMapper.deleteThisBokePL(id);
            bokeMapper.deleteThisBokeDZ(id);
        }
    }

    /**
     * 发布新闻
     * @param boke
     *
     * */
    @Override
    public void sendBoke(Boke boke) {
        // 设置当前时间
        boke.setCreateDate(new Date(System.currentTimeMillis()));
        System.out.println(boke);
        bokeMapper.sendBoke(boke);
    }

    /**
     * 查询回显的boke信息
     * */
    @Override
    public BokeVo findBokeById(Integer id) {
        BokeVo bokeById = bokeMapper.findBokeById(id);
        // System.out.println(bokeById);
        return bokeById;
    }

    /**
     * 查询该文章的所有评论
     * @param id
     * */
    @Override
    public List<PLVo> findThisBokePLs(Integer id) {
        return bokeMapper.findThisBokePLs(id);
    }

    /**
     * 发布评论
     * @param pl
     *
     * */
    @Override
    public void sendPL(PL pl) {
        pl.setCreateDate(new Date(System.currentTimeMillis()));
        System.out.println(pl);

        bokeMapper.sendPL(pl);
    }

    /**
     * 查询所有与自己相关的评论
     * @param userId
     * @param id
     * @return List
     * */
    @Override
    public List<PLVo> findAllPLsByMyslef(Integer userId,Integer id) {

        return bokeMapper.findAllPLsByMyslef(userId,id);
    }

    /**
     * 判断是否是自己的评论如果时的跳转到修改页面进行数据修改
     * @param id
     * @param userId
     * @return Boolean
     * */
    @Override
    public Boolean toUpateBokePage(Integer id, Integer userId) {
       Boke boke = bokeMapper.findThisBokeByMyslef(id,userId);

       if( boke != null){
           return true;
       }

        return false;
    }

    /**
     * 修改boke信息
     * @param boke
     * */
    @Override
    public void updateThisBoke(Boke boke) {
        boke.setCreateDate(new Date(System.currentTimeMillis()));

        bokeMapper.updateThisBoke(boke);
    }


}
