package com.znlccy.distribute.model;

import javax.persistence.Id;

/**
 * @CreateTime:2018/3/1 13:56
 * @Author:Administrator
 * @Version:v-1.0.0
 * @Comment: 用户类
 */

public class User {

    /**
     * 声明用户主键
     */
    @Id
    private Long userId;

    /**
     * 声明用户名
     */
    private String userName;

    /**
     * 声明用户年龄
     */
    private int userAge;

    public User(Long userId, String userName, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
