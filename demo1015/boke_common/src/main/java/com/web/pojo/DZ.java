package com.web.pojo;

/**
 * @ClassName DZ
 * @Deacription TODO
 * @Author 落叶尘纷
 * @Date 2019/10/15 14:05
 * @Version 1.0
 **/
public class DZ {
    private Integer id;
    private Integer bid;
    private Integer userId;

    public DZ(Integer id, Integer bid, Integer userId) {
        this.id = id;
        this.bid = bid;
        this.userId = userId;
    }

    public DZ() {
    }

    @Override
    public String toString() {
        return "DZ{" +
                "id=" + id +
                ", bid=" + bid +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
