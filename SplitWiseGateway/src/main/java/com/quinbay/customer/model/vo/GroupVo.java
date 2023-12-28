package com.quinbay.customer.model.vo;

import java.util.Date;
import java.util.List;

public class GroupVo {
    private long groupId;
    private String groupName;
    private long createdBy;
    private List<UserVo> memberPresent;
    private long updatedBy;
    private Date createdDate;
    private Date updatedDate;

    public List<UserVo> getMemberPresent() { return memberPresent; }

    public void setMemberPresent(List<UserVo> memberPresent) { this.memberPresent = memberPresent; }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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
