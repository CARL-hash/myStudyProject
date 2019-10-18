package com.web.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * @ClassName PL
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 14:02
 * @Version 1.0
 **/
public class PL {
    private Integer id;
    private String content;
    private Date createDate;
    private Integer userId;
    private Integer bid;

    public PL(Integer id, String content, Date createDate,
              Integer userId, Integer bid) {
        this.id = id;
        this.content = content;
        this.createDate = createDate;
        this.userId = userId;
        this.bid = bid;
    }

    public PL() {
    }

    @Override
    public String toString() {
        return "PL{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", userId=" + userId +
                ", bid=" + bid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}
