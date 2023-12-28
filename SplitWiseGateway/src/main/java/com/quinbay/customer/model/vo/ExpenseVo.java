package com.quinbay.customer.model.vo;

import java.util.Date;
import java.util.List;

public class ExpenseVo {
    private String expenseId;
    private long groupId;
    private String note;
    private String category;
    private long createdBy;
    private double totalAmount;
    private String currencyType;
    private List<UserExpenseMappingVo> userList;
    private long updatedBy;
    private Date createdDate;
    private Date updatedDate;

    public String getExpenseId() { return expenseId; }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrencyType() { return currencyType; }

    public void setCurrencyType(String currencyType) { this.currencyType = currencyType; }

    public List<UserExpenseMappingVo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserExpenseMappingVo> userList) {
        this.userList = userList;
    }

    public long getUpdatedBy() { return updatedBy; }

    public void setUpdatedBy(long updatedBy) { this.updatedBy = updatedBy; }

    public Date getCreatedDate() { return createdDate; }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
