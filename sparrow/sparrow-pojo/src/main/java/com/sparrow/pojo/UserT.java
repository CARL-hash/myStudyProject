package com.sparrow.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 落叶尘纷
 * @Date 2020/2/21 15:32
 * @Version 1.0
 */
@Data
public class UserT implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "UserT{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
