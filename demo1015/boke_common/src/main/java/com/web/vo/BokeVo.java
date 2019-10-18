package com.web.vo;

import com.web.pojo.Boke;

import java.sql.Date;


/**
 * @ClassName BokeVo
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 14:12
 * @Version 1.0
 **/
public class BokeVo extends Boke {

    private Integer number;
    private String realName;
    private String userName;
    private Integer r;

    public BokeVo(Integer id, String title, String content,
                  Date createDate, Integer userId, Integer number) {

        super(id, title, content, createDate, userId);
        this.number = number;
    }

    public BokeVo(Integer number) {
        this.number = number;
    }

    public BokeVo(Integer id, String title, String content, Date createDate,
                  Integer userId, Integer number, String realName, Integer r) {
        super(id, title, content, createDate, userId);
        this.number = number;
        this.realName = realName;
        this.r = r;
    }

    public BokeVo() {
    }

    @Override
    public String toString() {
        return super.toString()+"BokeVo{" +
                "number=" + number +
                ", realName='" + realName + '\'' +
                ", r=" + r +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
