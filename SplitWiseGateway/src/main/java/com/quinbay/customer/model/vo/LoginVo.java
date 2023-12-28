package com.quinbay.customer.model.vo;

import java.util.Date;

public class LoginVo {
    private long userId;
    private String phoneNumber;
    private String userPassword;
    private boolean validity;
    private long createdBy;
    private long updatedBy;
    private Date createdDate;
    private Date updatedDate;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isValidity() { return validity; }

    public void setValidity(boolean validity) { this.validity = validity; }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public long getUpdatedBy() { return updatedBy; }

    public void setUpdatedBy(long updatedBy) { this.updatedBy = updatedBy; }

    public Date getCreatedDate() { return createdDate; }

    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public Date getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(Date updatedDate) { this.updatedDate = updatedDate; }
}
