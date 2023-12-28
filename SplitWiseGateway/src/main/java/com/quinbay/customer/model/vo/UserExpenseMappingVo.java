package com.quinbay.customer.model.vo;

public class UserExpenseMappingVo {
    private long userId;
    private double splitAmount;
    private double splitPercentage;
    private boolean payed;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(double splitAmount) {
        this.splitAmount = splitAmount;
    }

    public double getSplitPercentage() { return splitPercentage; }

    public void setSplitPercentage(double splitPercentage) { this.splitPercentage = splitPercentage; }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
