package com.app.ipo.service.impl;

import com.app.ipo.dto.MerchantDto;
import com.app.ipo.enums.ApprovalStatus;
import com.app.ipo.model.AuditTrail;
import com.app.ipo.model.MerchantDetailsEntity;
import com.app.ipo.model.MerchantEntity;
import com.app.ipo.model.RejectedAudit;
import com.app.ipo.model.UserEntity;
import com.app.ipo.repository.AuditTrailRepository;
import com.app.ipo.repository.MerchantDetailsRepository;
import com.app.ipo.repository.MerchantRepository;
import com.app.ipo.repository.UserRepository;
import com.app.ipo.repository.RejectedAuditRepository;
import com.app.ipo.service.MerchantService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class MerchantServiceImpl implements MerchantService {

	private final MerchantRepository merchantRepository;
	private final AuditTrailRepository auditTrailRepository;
	private final MerchantDetailsRepository merchantDetailsRepository;
	private final RejectedAuditRepository rejectedAuditRepository;

	@Autowired
	public MerchantServiceImpl(MerchantRepository merchantRepository, AuditTrailRepository auditTrailRepository,
			MerchantDetailsRepository merchantDetailsRepository, RejectedAuditRepository rejectedAuditRepository) {
		this.merchantRepository = merchantRepository;
		this.auditTrailRepository = auditTrailRepository;
		this.merchantDetailsRepository = merchantDetailsRepository;
		this.rejectedAuditRepository = rejectedAuditRepository;
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public String manualEntry(MerchantDto merchantDto) {
		try {
			validateMerchantDto(merchantDto);

			MerchantEntity merchantEntity = merchantDto.toEntity();
			merchantRepository.save(merchantEntity);

			return "Merchant details added manually.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error adding merchant details: " + e.getMessage();
		}
	}
	private void validateMerchantDto(MerchantDto merchantDto) {
	    // Check if a merchant with the same VPA exists in merchantRepository
	    List<MerchantEntity> existingMerchants = merchantRepository.findByVpa(merchantDto.getVpa());
	    if (!existingMerchants.isEmpty()) {
	        throw new IllegalArgumentException(
	                "Error adding merchant details: Merchant with the same VPA already exists.");
	    }
	    
	    // Check if a merchant with the same VPA exists in merchantDetailsRepository
	    List<MerchantDetailsEntity> existingMerchantDetails = merchantDetailsRepository.findByVpa(merchantDto.getVpa());
	    if (!existingMerchantDetails.isEmpty()) {
	        throw new IllegalArgumentException(
	                "Error adding merchant details: Merchant with the same VPA already exists in details.");
	    }
	

		if (!merchantDto.getPincode().matches("^\\d{6}$")) {
			throw new IllegalArgumentException("Pincode must be a 6-digit number.");
		}

		// Validate Mobile Number
		if (!merchantDto.getMobileNo().matches("[6-9]{1}[0-9]{9}")) {
			throw new IllegalArgumentException(
					"Invalid mobile number. Please enter a 10-digit phone number starting with 6-9.");
		}

		// Validate GST Number
		if (!merchantDto.getGstNumber().matches("^\\d{2}[A-Z]{5}\\d{4}[A-Z]\\d{1}[A-Z]\\d{1}$")) {
			throw new IllegalArgumentException("Invalid GST number. Please enter a valid GST number.");
		}

		// Validate PAN Number
		if (!merchantDto.getPan().matches("^[A-Z]{5}[0-9]{4}[A-Z]{1}$")) {
			throw new IllegalArgumentException("Invalid PAN number. Please enter a valid PAN number.");
		}

		// Validate IFSC Code
		if (!merchantDto.getIfscCode().matches("^[A-Z]{4}0[A-Z0-9]{6}$")) {
			throw new IllegalArgumentException("Invalid IFSC code. Please enter a valid IFSC code.");
		}

		// Validate VPA
		if (!merchantDto.getVpa().matches("^.*(?:bse@axis|nse@axis)$")) {
			throw new IllegalArgumentException("Invalid VPA format. Please enter a valid VPA.");
		}
	}
	
	@Override
	public List<MerchantEntity> retrieveStagingData() {
		return merchantRepository.findAll();
	}

	@Override
	public void approveStagingData(Long stagingId, String approvedBy, String remark) {
		try {
			if (stagingId == null) {
				throw new IllegalArgumentException("userId cannot be null");
			}

			Optional<MerchantEntity> stagingDataOptional = merchantRepository.findById(stagingId);

			if (stagingDataOptional.isPresent()) {
				MerchantEntity stagingData = stagingDataOptional.get();

				MerchantDetailsEntity merchantDetails = new MerchantDetailsEntity();

				merchantDetails.setName(stagingData.getName());
				merchantDetails.setMarketingName(stagingData.getMarketingName());
				merchantDetails.setAddress(stagingData.getAddress());
				merchantDetails.setCity(stagingData.getCity());
				merchantDetails.setState(stagingData.getState());
				merchantDetails.setPincode(stagingData.getPincode());
				merchantDetails.setMobileNo(stagingData.getMobileNo());
				merchantDetails.setLandlineNo(stagingData.getLandlineNo());
				merchantDetails.setDirector(stagingData.getDirector());
				merchantDetails.setCategory(stagingData.getCategory());
				merchantDetails.setMcc(stagingData.getMcc());
				merchantDetails.setMccDesc(stagingData.getMccDesc());
				merchantDetails.setTypeOfIntegration(stagingData.getTypeOfIntegration());
				merchantDetails.setVpa(stagingData.getVpa());
				merchantDetails.setGstNumber(stagingData.getGstNumber());
				merchantDetails.setPan(stagingData.getPan());
				merchantDetails.setMerchantOfficialId(stagingData.getMerchantOfficialId());
				merchantDetails.setMerchantWebsite(stagingData.getMerchantWebsite());
				merchantDetails.setBankName(stagingData.getBankName());
				merchantDetails.setIfscCode(stagingData.getIfscCode());
				merchantDetails.setNodalAccountNo(stagingData.getNodalAccountNo());
				merchantDetails.setPoolAccountNo(stagingData.getPoolAccountNo());
				merchantDetails.setPoolIfscCode(stagingData.getPoolIfscCode());
				merchantDetails.setSym(stagingData.getSym());
				merchantDetails.setStatus(stagingData.getStatus());

				merchantDetailsRepository.save(merchantDetails);

				String createdBy = fetchCreatedByFromUserDetails(stagingData.getUserId());

				// Create an audit trail record for approval
				AuditTrail auditTrail = new AuditTrail();
				auditTrail.setMerchant(merchantDetails);
				auditTrail.setCreatedBy(createdBy);
				auditTrail.setApprovedBy(approvedBy);
				auditTrail.setApprovalDate(new Date());
				auditTrail.setApprovalStatus(ApprovalStatus.approved);
				auditTrail.setRemark(remark);

				auditTrailRepository.save(auditTrail);

				merchantRepository.delete(stagingData);
			} else {
				throw new EntityNotFoundException("No staging data found for stagingId: " + stagingId);
			}
		} catch (IllegalArgumentException | EntityNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String fetchCreatedByFromUserDetails(Long userId) {
		UserEntity user = userRepository.findById(userId).orElse(null);

		if (user != null) {
			return user.getUserName();
		} else {
			return "abc";
		}
	}

	@Override
	public void rejectStagingData(Long stagingId, String rejectedBy, String remark) {
		if (stagingId == null) {
			throw new IllegalArgumentException("User ID cannot be null.");
		}

		Optional<MerchantEntity> stagingDataOptional = merchantRepository.findById(stagingId);

		if (stagingDataOptional.isPresent()) {
			MerchantEntity stagingData = stagingDataOptional.get();

			// Fetch createdBy from user_details using userId
			String createdBy = fetchCreatedByFromUserDetails(stagingData.getUserId());

			// Create a rejected audit trail record in rejected_audit_history table
			RejectedAudit rejectedAudit = new RejectedAudit();
			rejectedAudit.setCreatedBy(createdBy);
			rejectedAudit.setApprovalDate(new Date());
			rejectedAudit.setRejectedBy(rejectedBy);
			rejectedAudit.setRemark(remark);
			rejectedAudit.setName(stagingData.getName());
			rejectedAudit.setMarketingName(stagingData.getMarketingName());
			rejectedAudit.setAddress(stagingData.getAddress());
			rejectedAudit.setCity(stagingData.getCity());
			rejectedAudit.setState(stagingData.getState());
			rejectedAudit.setPincode(stagingData.getPincode());
			rejectedAudit.setMobileNo(stagingData.getMobileNo());
			rejectedAudit.setLandlineNo(stagingData.getLandlineNo());
			rejectedAudit.setDirector(stagingData.getDirector());
			rejectedAudit.setCategory(stagingData.getCategory());
			rejectedAudit.setMcc(stagingData.getMcc());
			rejectedAudit.setMccDesc(stagingData.getMccDesc());
			rejectedAudit.setTypeOfIntegration(stagingData.getTypeOfIntegration());
			rejectedAudit.setVpa(stagingData.getVpa());
			rejectedAudit.setGstNumber(stagingData.getGstNumber());
			rejectedAudit.setPan(stagingData.getPan());
			rejectedAudit.setMerchantOfficialId(stagingData.getMerchantOfficialId());
			rejectedAudit.setMerchantWebsite(stagingData.getMerchantWebsite());
			rejectedAudit.setBankName(stagingData.getBankName());
			rejectedAudit.setIfscCode(stagingData.getIfscCode());
			rejectedAudit.setNodalAccountNo(stagingData.getNodalAccountNo());
			rejectedAudit.setPoolAccountNo(stagingData.getPoolAccountNo());
			rejectedAudit.setPoolIfscCode(stagingData.getPoolIfscCode());
			rejectedAudit.setSym(stagingData.getSym());
			rejectedAudit.setStatus("rejected");

			rejectedAuditRepository.save(rejectedAudit);

			Integer rejectedAuditId = rejectedAudit.getRejectedAuditId();

			// Create an audit trail record for rejection
			AuditTrail auditTrail = new AuditTrail();
			auditTrail.setRejectedAuditId(rejectedAuditId);
			auditTrail.setCreatedBy(createdBy);
			auditTrail.setApprovedBy(rejectedBy);
			auditTrail.setApprovalDate(new Date());
			auditTrail.setApprovalStatus(ApprovalStatus.rejected);
			auditTrail.setRemark(remark);

			auditTrailRepository.save(auditTrail);

			merchantRepository.delete(stagingData);
		} else {
			throw new EntityNotFoundException("Merchant data not found for stagingId: " + stagingId);
		}
	}

	@Override
	public List<MerchantDetailsEntity> getMerchantDetailsByVpa(String vpa) {
		return merchantDetailsRepository.findByVpa(vpa);
	}

	@Override
	public List<MerchantDetailsEntity> getMerchantDetailsByPan(String pan) {
		return merchantDetailsRepository.findByPan(pan);
	}

	@Override
	public List<MerchantDetailsEntity> getMerchantDetailsBySym(String sym) {
		return merchantDetailsRepository.findBySym(sym);
	}

	@Override
	public List<MerchantEntity> getMerchantStagingByVpa(String vpa) {
		return merchantRepository.findByVpa(vpa);
	}

	@Override
	public List<MerchantEntity> getMerchantStagingByPan(String pan) {
		return merchantRepository.findByPan(pan);
	}

	@Override
	public List<MerchantEntity> getMerchantStagingBySym(String sym) {
		return merchantRepository.findBySym(sym);
	}
}