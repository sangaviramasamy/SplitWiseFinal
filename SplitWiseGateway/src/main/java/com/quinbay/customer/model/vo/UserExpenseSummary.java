package com.quinbay.customer.model.vo;

public class UserExpenseSummary {
    private double totalToReceive;
    private double totalToPay;
    private String category;
    private String groupId;

    public UserExpenseSummary(){}

    public UserExpenseSummary(double totalToReceive, double totalToPay) {
        this.totalToReceive = totalToReceive;
        this.totalToPay = totalToPay;
    }

    public double getTotalToReceive() {
        return totalToReceive;
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setTotalToReceive(double totalToReceive) {
        this.totalToReceive = totalToReceive;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }
}