package com.app.ipo.dto;

import java.sql.Date;

import com.app.ipo.model.MerchantEntity;
import javax.validation.constraints.*;

public class MerchantDto {
    private Long userId;
    private String name;
    private String marketingName;
    private String address;
    private String city;
    private String state;
    
    @Size(min=10, max=10, message="Mobile number must be 10 digits")
    private String mobileNo;

    @Pattern(regexp="\\d{10}", message="Landline number must be 10 digits")
    private String landlineNo;

    @Pattern(regexp="[A-Z]{5}\\d{4}[A-Z]{1}", message="Invalid PAN number")
    private String pan;

    @Pattern(regexp="\\d{6}", message="Pincode must be 6 digits")
    private String pincode;
    
    private String director;
    private String category;
    private String mcc;
    private String mccDesc;
    private String typeOfIntegration;
    private String vpa;
    private String gstNumber;
    //private String pan;
    private String merchantOfficialId;
    private String merchantWebsite;
    private String bankName;
    private String ifscCode;
    private String nodalAccountNo;
    private String poolAccountNo;
    private String poolIfscCode;
    private String sym;
    private String status;

    private Date recordedDate;
	private Boolean recordStatus;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }


    public MerchantEntity toEntity() {
        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setUserId(this.userId);
        merchantEntity.setName(this.name);
        merchantEntity.setMarketingName(this.marketingName);
        merchantEntity.setAddress(this.address);
        merchantEntity.setCity(this.city);
        merchantEntity.setState(this.state);
        merchantEntity.setPincode(this.pincode);
        merchantEntity.setMobileNo(this.mobileNo);
        merchantEntity.setLandlineNo(this.landlineNo);
        merchantEntity.setDirector(this.director);
        merchantEntity.setCategory(this.category);
        merchantEntity.setMcc(this.mcc);
        merchantEntity.setMccDesc(this.mccDesc);
        merchantEntity.setTypeOfIntegration(this.typeOfIntegration);
        merchantEntity.setVpa(this.vpa);
        merchantEntity.setGstNumber(this.gstNumber);
        merchantEntity.setPan(this.pan);
        merchantEntity.setMerchantOfficialId(this.merchantOfficialId);
        merchantEntity.setMerchantWebsite(this.merchantWebsite);
        merchantEntity.setBankName(this.bankName);
        merchantEntity.setIfscCode(this.ifscCode);
        merchantEntity.setNodalAccountNo(this.nodalAccountNo);
        merchantEntity.setPoolAccountNo(this.poolAccountNo);
        merchantEntity.setPoolIfscCode(this.poolIfscCode);
        merchantEntity.setSym(this.sym);
        merchantEntity.setStatus(this.status);
        merchantEntity.setRecordedDate(this.recordedDate);

        return merchantEntity;
    }

}
