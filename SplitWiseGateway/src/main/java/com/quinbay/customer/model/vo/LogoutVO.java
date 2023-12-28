package com.quinbay.customer.model.vo;


import lombok.Data;


public class LogoutVO {

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
