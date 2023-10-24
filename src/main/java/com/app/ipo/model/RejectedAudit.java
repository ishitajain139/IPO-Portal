package com.app.ipo.model;

import javax.persistence.*;
import com.app.ipo.enums.ApprovalStatus;

import java.util.Date;

@Entity
@Table(name = "rejected_audit_history")
public class RejectedAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rejected_audit_id")
    private Integer rejectedAuditId;


    public Integer getRejectedAuditId() {
		return rejectedAuditId;
	}

	public void setRejectedAuditId(Integer rejectedAuditId) {
		this.rejectedAuditId = rejectedAuditId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMccDesc() {
		return mccDesc;
	}

	public void setMccDesc(String mccDesc) {
		this.mccDesc = mccDesc;
	}

	public String getTypeOfIntegration() {
		return typeOfIntegration;
	}

	public void setTypeOfIntegration(String typeOfIntegration) {
		this.typeOfIntegration = typeOfIntegration;
	}

	public String getVpa() {
		return vpa;
	}

	public void setVpa(String vpa) {
		this.vpa = vpa;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getMerchantOfficialId() {
		return merchantOfficialId;
	}

	public void setMerchantOfficialId(String merchantOfficialId) {
		this.merchantOfficialId = merchantOfficialId;
	}

	public String getMerchantWebsite() {
		return merchantWebsite;
	}

	public void setMerchantWebsite(String merchantWebsite) {
		this.merchantWebsite = merchantWebsite;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getNodalAccountNo() {
		return nodalAccountNo;
	}

	public void setNodalAccountNo(String nodalAccountNo) {
		this.nodalAccountNo = nodalAccountNo;
	}

	public String getPoolAccountNo() {
		return poolAccountNo;
	}

	public void setPoolAccountNo(String poolAccountNo) {
		this.poolAccountNo = poolAccountNo;
	}

	public String getPoolIfscCode() {
		return poolIfscCode;
	}

	public void setPoolIfscCode(String poolIfscCode) {
		this.poolIfscCode = poolIfscCode;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "approval_date")
    private Date approvalDate;

    @Column(name = "rejected_by")
    private String rejectedBy;

    @Column(name = "remark")
    private String remark;

    @Column(name = "name")
    private String name;

    @Column(name = "marketing_name")
    private String marketingName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "landline_no")
    private String landlineNo;

    @Column(name = "director")
    private String director;

    @Column(name = "category")
    private String category;

    @Column(name = "mcc")
    private String mcc;

    @Column(name = "mcc_desc")
    private String mccDesc;

    @Column(name = "type_of_integration")
    private String typeOfIntegration;

    @Column(name = "vpa")
    private String vpa;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "pan")
    private String pan;

    @Column(name = "merchant_official_id")
    private String merchantOfficialId;

    @Column(name = "merchant_website")
    private String merchantWebsite;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "nodal_account_no")
    private String nodalAccountNo;

    @Column(name = "pool_account_no")
    private String poolAccountNo;

    @Column(name = "pool_ifsc_code")
    private String poolIfscCode;

    @Column(name = "sym")
    private String sym;

    @Column(name = "status")
    private String status = "rejected";
    }
