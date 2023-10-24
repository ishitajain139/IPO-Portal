package com.app.ipo.service;

import com.app.ipo.dto.MerchantDto;
import com.app.ipo.model.MerchantDetailsEntity;
import com.app.ipo.model.MerchantEntity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public interface MerchantService {


    String manualEntry(MerchantDto merchantDto);
  
    List<MerchantEntity> retrieveStagingData();
    void approveStagingData(Long stagingId, String approvedBy, String remark);

    void rejectStagingData(Long stagingId, String rejectedBy, String remark);
   
    List<MerchantDetailsEntity> getMerchantDetailsByVpa(String vpa);

    List<MerchantDetailsEntity> getMerchantDetailsByPan(String pan);

    List<MerchantDetailsEntity> getMerchantDetailsBySym(String sym);
    
    List<MerchantEntity> getMerchantStagingByVpa(String vpa);
    List<MerchantEntity> getMerchantStagingByPan(String pan);
    List<MerchantEntity> getMerchantStagingBySym(String sym);

}