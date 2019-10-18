package com.web.pojo;

import lombok.Data;

/**
 * @ClassName User
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 14:07
 * @Version 1.0
 **/
public class User {
    private Integer userId;
    private String userName;
    private String realName;
    private String password;

    public User() {
    }

    public User(Integer userId, String userName, String realName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
