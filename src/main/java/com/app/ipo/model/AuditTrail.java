package com.app.ipo.model;

import javax.persistence.*;
import com.app.ipo.enums.ApprovalStatus;

import java.util.Date;

@Entity
@Table(name = "audit_history")
public class AuditTrail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Integer auditId;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private MerchantDetailsEntity merchant;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "approval_date")
    private Date approvalDate;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "approval_status")
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    public Integer getRejectedAuditId() {
		return rejectedAuditId;
	}

	public void setRejectedAuditId(Integer rejectedAuditId) {
		this.rejectedAuditId = rejectedAuditId;
	}

	@Column(name = "remark")
    private String remark;
    
    @Column(name = "rejected_audit_id")
    private Integer rejectedAuditId;


    // Constructors
    public AuditTrail() {
        // Default constructor
    }

    public AuditTrail(MerchantDetailsEntity merchant, String createdBy, String approvedBy, ApprovalStatus approvalStatus, String remark) {
        this.merchant = merchant;
        this.createdBy = createdBy;
        this.approvalDate = new Date();
        this.approvedBy = approvedBy;
        this.approvalStatus = approvalStatus;
        this.remark = remark;
        this.creationDate = new Date();
    }

    // Getters and setters
    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public MerchantDetailsEntity getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDetailsEntity merchant) {
        this.merchant = merchant;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
