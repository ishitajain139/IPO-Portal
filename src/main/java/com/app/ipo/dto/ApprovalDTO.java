package com.app.ipo.dto;
public class ApprovalDTO {
    private Long User_Id; // Include the User_Id field
    private String approvedBy;
    private String remark;

    public Long getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(Long User_Id) {
        this.User_Id = User_Id;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
