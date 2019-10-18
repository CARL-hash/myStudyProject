package com.web.vo;

import com.web.pojo.PL;

import java.sql.Date;

/**
 * @ClassName PLVo
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/18 10:52
 * @Version 1.0
 **/
public class PLVo extends PL {
    private String realName;

    public PLVo(Integer id, String content,
                Date createDate, Integer userId,
                Integer bid, String realName) {
        super(id, content, createDate, userId, bid);
        this.realName = realName;
    }

    public PLVo(String realName) {
        this.realName = realName;
    }

    public PLVo() {
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
