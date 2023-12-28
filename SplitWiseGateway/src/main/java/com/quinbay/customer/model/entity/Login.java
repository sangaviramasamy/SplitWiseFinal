package com.quinbay.customer.model.entity;



import com.quinbay.customer.model.constant.FieldNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = FieldNames.LOGIN_T)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @Column(name = FieldNames.USER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = FieldNames.PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = FieldNames.PASSWORD)
    private String userPassword;

    @Column(name = FieldNames.VALIDITY)
    private boolean validity;

    @Column(name = FieldNames.TOKEN)
    private String token;

    @Column(name = FieldNames.CREATED_BY)
    private long createdBy;

    @Column(name = FieldNames.UPDATED_BY)
    private long updatedBy;

    @Column(name = FieldNames.CREATED_DATE)
    private Date createdDate;

    @Column(name = FieldNames.UPDATED_DATE)
    private Date updatedDate;

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
