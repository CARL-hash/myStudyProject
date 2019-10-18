package com.web.controller;

import com.web.pojo.Boke;
import com.web.pojo.PL;
import com.web.pojo.User;
import com.web.service.BokeServerService;
import com.web.util.PageUtil;
import com.web.vo.BokeVo;
import com.web.vo.PLVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BokeServerController
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 20:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("/boke")
public class BokeServerController {
    @Autowired
    private BokeServerService bokeServerService;



    /**
     * 模糊分页查询boke信息
     * @return Map<String,Object>
     * @param pageNum
     * @param title
     * */
    @GetMapping("/findBokesByLikeTitleConming")
    public Map<String,Object> findBokesByLikeTitleConming(@RequestParam("title") String title,
                                                          @RequestParam("pageNum") String pageNum){

        return bokeServerService.findBokesByLikeTitleConmingt(title,pageNum);
    }


    /**
     * 点赞
     * @param id
     * @param userId
     * */
    @GetMapping("/likenum")
    public void likenum(@RequestParam("id") Integer id,
                        @RequestParam("userId")Integer userId){
        bokeServerService.likenum(id,userId);

    }

    /**
     * 删除博客内容
     * @param id
     * @param userId
     *
     * */
    @GetMapping("/deleteThis")
    public void deleteThis(@RequestParam("id") Integer id,
                           @RequestParam("userId") Integer userId){
        bokeServerService.deleteThis(id,userId);
    }

    /**
     * 发布boke
     * @param boke
     * */
    @PostMapping("/sendBoke")
    public void sendBoke(@RequestBody Boke boke){
        bokeServerService.sendBoke(boke);
    }


    /**
     * 查询回显的boke信息
     * @param id
     * @return BokeVo
     */
    @GetMapping("/findBokeById")
    public BokeVo findBokeById(@RequestParam("id") Integer id){
        return bokeServerService.findBokeById(id);
    }

    /**
     * 查询该文章的所有评论
     * @param id
     * */
    @GetMapping("/findThisBokePLs")
    public List<PLVo> findThisBokePLs(@RequestParam("id") Integer id){
        return bokeServerService.findThisBokePLs(id);
    }


    /**
     * 发布评论
     * @param pl
     *
     * */
    @PostMapping("/sendPL")
    public void sentPL(@RequestBody PL pl){
        bokeServerService.sendPL(pl);
    }


    /**
     * 查询所有自己的评论
     * */
    @PostMapping("/findAllPLsByMyslef/{userId}/{id}")
    public List<PLVo> findAllPLsByMyslef(@RequestParam("userId") Integer userId,
                                         @RequestParam("id") Integer id){
        return bokeServerService.findAllPLsByMyslef(userId,id);
    }

    /**
     * 判断是否是自己的评论如果时的跳转到修改页面进行数据修改
     * @param id
     * @param userId
     * @return Boolean
     * */
    @GetMapping("/toUpateBokePage/{id}/{userId}")
    public Boolean toUpateBokePage(@RequestParam("id")Integer id,@RequestParam("userId") Integer userId){

        return bokeServerService.toUpateBokePage(id,userId);
    }

    /**
     * 修改boke信息
     * @param boke
     * */
    @PostMapping("/updateThisBoke")
    public void updateThisBoke(@RequestBody Boke boke){
        bokeServerService.updateThisBoke(boke);
    }
}
