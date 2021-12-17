package com.atguigu.spring.entity;

public class Book {
    private String userId;
    private String userName;
    private String uStatus;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getUserId(){
        return this.userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getuStatus() {
        return uStatus;
    }
}
