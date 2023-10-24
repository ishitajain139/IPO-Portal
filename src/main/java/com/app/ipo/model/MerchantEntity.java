package com.app.ipo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "merchant_staging")
public class MerchantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Staging_ID")
	private Long stagingId;

    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Marketing_Name")
    private String marketingName;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Pincode")
    @Pattern(regexp = "\\d{6}", message = "Invalid pincode format")
    @Size(min = 6, max = 6, message = "Pincode must be 6 digits")
    private String pincode;

    @Column(name = "Mobile_No")
    @Pattern(regexp = "[6-9]\\d{9}", message = "Invalid mobile number format")
    @Size(min = 10, max = 10, message = "Mobile number must be 10 digits")
    private String mobileNo;

    @Column(name = "Landline_No")
    @Pattern(regexp = "[0-9]{10}", message = "Invalid landline number format")
    @Size(min = 10, max = 10, message = "Landline number must be 10 digits")
    private String landlineNo;

    @Column(name = "Director")
    private String director;

    @Column(name = "Category")
    private String category;

    @Column(name = "MCC")
    private String mcc;

    @Column(name = "MCC_Desc")
    private String mccDesc;

    @Column(name = "Type_Of_Integration")
    private String typeOfIntegration;

    @Column(name = "VPA")
    @Pattern(regexp = "^(.*)(bse|nse)@axis$", message = "Invalid VPA format")
    private String vpa;

    @Column(name = "GST_Number")
    @Pattern(regexp = "^\\d{2}[A-Z]{5}\\d{4}[A-Z]{1}\\d[Z]{1}[A-Z\\d]{1}$", message = "Invalid GST Number")
    private String gstNumber;

    @Column(name = "PAN", length = 10)
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Invalid PAN format")
    private String pan;

    @Column(name = "Merchant_Official_Id")
    private String merchantOfficialId;

    @Column(name = "Merchant_Website")
    private String merchantWebsite;

    @Column(name = "Bank_Name")
    private String bankName;

    @Column(name = "IFSC_Code")
    private String ifscCode;

    @Column(name = "Nodal_Account_No")
    private String nodalAccountNo;

    @Column(name = "Pool_Account_No")
    private String poolAccountNo;

    @Column(name = "Pool_IFSC_Code")
    private String poolIfscCode;

    @Column(name = "SYM")
    private String sym;

    @Column(name = "Status", columnDefinition = "VARCHAR(255) DEFAULT 'pending'")
    private String status;

    @CreationTimestamp
    @Column(name = "Recorded_Date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date recordedDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStagingId() {
        return stagingId;
    }

    public void setStagingId(Long stagingId) {
        this.stagingId = stagingId;
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
        if (pan != null && pan.length() > 10) {
            this.pan = pan.substring(0, 10);
        } else {
            this.pan = pan;
        }
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


    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }

}