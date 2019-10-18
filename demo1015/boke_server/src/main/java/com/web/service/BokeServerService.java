package com.web.service;

import com.web.pojo.Boke;
import com.web.pojo.PL;
import com.web.pojo.User;
import com.web.util.PageUtil;
import com.web.vo.BokeVo;
import com.web.vo.PLVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BokeServerService
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 20:25
 * @Version 1.0
 **/
public interface BokeServerService {

    /**
     * 模糊统计数
     * @param title
     * @return Integer
     * */
    Integer countBokesByLikeTitle(String title);

    /**
     * 模糊分页查询
     * @param title
     * @param pageNum
     * @return Map<String,Object>
     * */
    Map<String, Object> findBokesByLikeTitleConmingt(String title, String pageNum);

    /**
     * 点赞
     * @param id
     * @param userId
     * */
    void likenum(Integer id, Integer userId);

    /**
     * 删除
     * @param id
     * @param userId
     *
     * */
    void deleteThis(Integer id, Integer userId);

    /**
     * 发布boke
     * @param boke
     *
     * */
    void sendBoke(Boke boke);

    /**
     * 查询回显的boke信息
     * @param id
     * @return BokeVo
     */
    BokeVo findBokeById(Integer id);

    /**
     * 查询该文章的所有评论
     * @param id
     * */
    List<PLVo> findThisBokePLs(Integer id);

    /**
     * 发布评论
     * @param pl
     *
     * */
    void sendPL(PL pl);

    /**
     * 查询所有与自己相关的评论
     * @param userId
     * */
    List<PLVo> findAllPLsByMyslef(Integer userId,Integer id);

    /**
     * 判断是否是自己的评论如果时的跳转到修改页面进行数据修改
     * @param id
     * @param userId
     * @return Boolean
     * */
    Boolean toUpateBokePage(Integer id, Integer userId);

    /**
     * 修改boke信息
     * @param boke
     * */
    void updateThisBoke(Boke boke);
}
