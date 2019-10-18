package com.web.controller;

import com.web.pojo.Boke;
import com.web.pojo.PL;
import com.web.pojo.User;
import com.web.service.BokeService;
import com.web.vo.BokeVo;
import com.web.vo.PLVo;
import javafx.beans.binding.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BokeController
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 10:11
 * @Version 1.0
 **/
@Controller
@RequestMapping("/boke")
public class BokeController {

    @Autowired
    private BokeService bokeService;

     /**
      * 模糊分页查询
      * @param pageNum String
      * @param title  String
      * @param model Model
      * @return String
      * */
    @GetMapping("/findBokesByLikeTitleConming")
    public String findBokesByLikeTitleConming(Model model,
                           @RequestParam(defaultValue = "") String title,
                           @RequestParam(defaultValue = "1") String pageNum){

        // 获取模糊查询的结果
        Map<String,Object> map = bokeService.findBokesByLikeTitleConming(title,pageNum);
        // 放置页面信息
        model.addAttribute("map",map);
       // System.out.println(map.get("bokeVos"));
       // System.out.println(map.get("pageUtil"));
        return "bokeList";
    }

    /**
     * 点赞
     * @param id
     * @param session
     * @return String
     * */
    @GetMapping("/likenum/{id}")
    public String likenum(@PathVariable("id") Integer id, HttpSession session){
        System.err.print("client"+id);
        // 作用域获取信息
        User user = (User)session.getAttribute("user");
        //Integer userId = user.getUserId();

       // System.err.print("client"+userId+id);

        // 点赞
        bokeService.likenum(id,user.getUserId());

        return "redirect:/boke/findBokesByLikeTitleConming";
    }

    /**
     * 删除博客内容
     * @return String
     * @param id
     *
     * */
    @GetMapping("/deleteThis/{id}")
    public String deleteThis(@PathVariable("id") Integer id,HttpSession session){
        // 作用域获取信息
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();

        // 删除
        bokeService.deleteThis(id,userId);

        return "redirect:/boke/findBokesByLikeTitleConming";
    }

    /**
     * 前往微博发布页面
     * @return  sentBoke
     * */
    @GetMapping("/toSentBokePage")
    public String toSentBokePage(){
        return "sentBoke";
    }

    /**
     * 前往微博发布页面
     * @return  sentBoke
     * */
    @PostMapping("/sendBoke")
    public String sendBoke(Boke boke,HttpSession session){
        // 作用域获取信息
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();
        // 封装信息
        boke.setUserId(userId);

        //删除
        bokeService.sendBoke(boke);

        return "redirect:/boke/findBokesByLikeTitleConming";
    }


    /**
     * 前往boke评论页面
     * @param id
     * @param model
     * @return  String
     * */
    @GetMapping("/toLookOrSentPLPage/{id}")
    public String toLookOrSentPLPage(Model model,@PathVariable("id") Integer id){

        model.addAttribute("id",id);

        return "lookOrSentPL";
    }

    /**
     * 回显评论的文章
     * @return  String
     * @param id
     * */
    @GetMapping("/findBokeById/{id}")
    @ResponseBody
    public BokeVo findBokeById(@PathVariable("id") Integer id){

        BokeVo bokeVo = bokeService.findBokeById(id);

        return bokeVo;
    }


   /**
     * 回显改文章的所有评论
     * @return  String
    * @param id
     * */
    @GetMapping("/findThisBokePLs/{id}")
    @ResponseBody
    public List<PLVo> findThisBokePLs(@PathVariable("id") Integer id){

        List<PLVo> plVos = bokeService.findThisBokePLs(id);

        System.out.println(plVos);

        return plVos;
    }

    /**
     * 回显改文章的所有评论
    * @param pl
     * @param session
     * */
    @PostMapping("/sentPL")
    @ResponseBody
    public Boolean sentPL(PL pl,HttpSession session){
        // 作用域获取信息
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();

        // 封装信息
        pl.setUserId(userId);

        // 发布评论
        bokeService.sentPL(pl);
        return true;
    }

    /**
     * 测试thymeleaf 中的标签复制情况
     * */
    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("content","123456789");
        return "test";
    }


    /**
     *
     * 查询自己的评论
     * */
    @PostMapping("/findAllPLsByMyslef/{id}")
    @ResponseBody
    public List<PLVo> findAllPLsByMyslef(@PathVariable("id") Integer id,HttpSession session){
        // 作用域获取信息
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();

        List<PLVo> plVos = bokeService.findAllPLsByMyslef(userId,id);

        return plVos;
    }


   /**
     * 前往boke修改页面
    *   先判断是否是自己的boke,如果时可以前往修改页面否无法修改
    * @param id
    * @param session
     * */
    @GetMapping("/toUpateBokePage/{id}")
    public String toUpateBokePage(@PathVariable("id") Integer id,Model model,HttpSession session){
        // 作用域获取信息
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();

        Boolean result = bokeService.toUpateBokePage(id,userId);
        // 判断结果：是不是自己的boke
        if(result){
            model.addAttribute("id",id);
            return "updateBoke";
        }

        return "redirect:/boke/findBokesByLikeTitleConming";
    }

    /**
     * 需改该用户的boke信息
    * @param boke
     * */
    @PostMapping("/updateThisBoke")
    public String updateThisBoke(Boke boke){

        bokeService.updateThisBoke(boke);

        return "redirect:/boke/findBokesByLikeTitleConming";
    }







}
