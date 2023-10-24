package com.app.ipo.dto;
public class RejectionDTO {
    private Long User_Id; // Include the User_Id field
    private String rejectedBy;
    private String remark;

    public Long getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(Long User_Id) {
        this.User_Id = User_Id;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
