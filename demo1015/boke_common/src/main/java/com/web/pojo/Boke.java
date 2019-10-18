package com.web.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * @ClassName Boke
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 14:13
 * @Version 1.0
 *
 **/
public class Boke {
    private Integer id;
    private String title;
    private String content;
    private Date createDate;
    private Integer userId;


    public Boke(Integer id, String title, String content,
                Date createDate, Integer userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.userId = userId;
    }

    public Boke() {
    }

    @Override
    public String toString() {
        return "Boke{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
