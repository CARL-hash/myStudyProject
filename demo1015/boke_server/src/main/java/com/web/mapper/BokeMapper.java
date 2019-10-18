package com.web.mapper;

import com.web.pojo.Boke;
import com.web.pojo.PL;
import com.web.pojo.User;
import com.web.util.PageUtil;
import com.web.vo.BokeVo;
import com.web.vo.PLVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName BokeMapper
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 20:24
 * @Version 1.0
 **/
public interface BokeMapper {

    /**
     * 模糊记录数据
     *
     * @param title
     * @return integer
     */
    Integer countBokesByLikeTitle(@Param("title") String title);

    /**
     * 模糊分页查询
     *
     * @return List<Boke>
     */
    List<BokeVo> findBokesByLikeTitleConmingt(PageUtil pageUtil);

    /**
     * 查询是否有这条信息
     *
     * @param id
     * @param userId
     * @return PL
     */
    PL likenum(@Param("id") Integer id, @Param("userId") Integer userId);

    /**
     * 删除该记录条数
     *
     * @param id
     * @param userId
     */
    void deleteThisPL(@Param("id") Integer id, @Param("userId") Integer userId);


    /**
     * 增加点赞量
     *
     * @param userId
     * @param id
     */
    void addThisPL(@Param("id") Integer id, @Param("userId") Integer userId);

    /**
     * 查询是否是自己的Boke
     *
     * @return Boke
     */
    Boke findThisBokeByMyslef(@Param("id") Integer id, @Param("userId") Integer userId);

    /**
     * 删除该boke的内容信息
     * @param id
     * */
    void deleteThisBoke(@Param("id") Integer id);

    /**
     * 删除该博客的所有评论
     * @param id Integer
     * */
    void deleteThisBokePL(@Param("id") Integer id);

    /**
     * 删除该boke点赞信息
     * @param id  Integer
     * */
    void deleteThisBokeDZ(Integer id);

    /**
     * @param boke
     *
     * */
    void sendBoke(Boke boke);


    /**
     * 查询回显的boke信息
     * @param id
     * @return BokeVo
     */
    BokeVo findBokeById(@Param("id") Integer id);

    /**
     * 查询该博客所有评论
     * @param id
     * */
    List<PLVo> findThisBokePLs(@Param("id") Integer id);

    /**
     * 发布评论
     * @param pl
     *
     * */
    void sendPL(PL pl);

    /**
     * 查询所有自己有关的评论
     * @param userId
     * @return List
     *
     * */
    List<PLVo> findAllPLsByMyslef(@Param("userId") Integer userId,@Param("id") Integer id);


    void updateThisBoke(Boke boke);
}
