package com.web.service;

import com.web.pojo.Boke;
import com.web.pojo.PL;
import com.web.pojo.User;
import com.web.vo.BokeVo;
import com.web.vo.PLVo;
import feign.Param;
import javafx.beans.binding.ObjectExpression;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BokeService
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 14:27
 * @Version 1.0
 *
 * boke连接服务层
 *  单个服务层可以使用request Mapping 多个服务的时候不能使用requestMapping在该类上
 *
 **/
@FeignClient("boke-server")
public interface BokeService {
    /**
     * 模糊分页查询boke信息
     *
     * @param pageNum
     * @param title
     * @return Map<String, Object>
     */
    @GetMapping("/boke/findBokesByLikeTitleConming")
    Map<String, Object> findBokesByLikeTitleConming(@RequestParam("title") String title,
                                                    @RequestParam("pageNum") String pageNum);

    /**
     * 点赞
     *
     * @param id
     * @param userId
     */
    @GetMapping("/boke/likenum")
    void likenum(@RequestParam("id") Integer id,
                 @RequestParam("userId") Integer userId);

    /**
     * 删除博客内容
     *
     * @param id
     * @param userId
     */
    @GetMapping("/boke/deleteThis")
    void deleteThis(@RequestParam("id") Integer id, @RequestParam("userId") Integer userId);

    /**
     * 发布boke
     *
     * @param boke
     */
    @PostMapping("/boke/sendBoke")
    void sendBoke(@RequestBody Boke boke);

    /**
     * 查询回显的boke信息
     * @param id
     * @return BokeVo
     */
    @GetMapping("/boke/findBokeById")
    BokeVo findBokeById(@RequestParam("id") Integer id);

    /**
     * 查询该文章的所有评论
     * @param id
     * */
    @GetMapping("/boke/findThisBokePLs")
    List<PLVo> findThisBokePLs(@RequestParam("id") Integer id);

    /**
     * 发布评论
     * @param pl
     *
     * */
    @PostMapping("/boke/sendPL")
    void sentPL(@RequestBody PL pl);


    /**
     * 查询所有自己的评论
     * */
    @PostMapping("/boke/findAllPLsByMyslef/{userId}/{id}")
    List<PLVo> findAllPLsByMyslef(@RequestParam("userId") Integer userId,@RequestParam("id") Integer id);

    /**
     * 判断是否是自己的评论如果时的跳转到修改页面进行数据修改
     * @param id
     * @param userId
     * @return Boolean
     * */
    @GetMapping("/boke/toUpateBokePage/{id}/{userId}")
    Boolean toUpateBokePage(@RequestParam("id")Integer id,@RequestParam("userId") Integer userId);

    /**
     * 修改boke信息
     * @param boke
     * */
    @PostMapping("/boke/updateThisBoke")
    void updateThisBoke(@RequestBody Boke boke);

}