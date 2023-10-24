package com.app.ipo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ipo.model.MerchantDetailsEntity;
import com.app.ipo.model.MerchantEntity;
import com.app.ipo.model.RejectedAudit;
import com.app.ipo.service.EnquiryService;
import com.app.ipo.repository.MerchantDetailsRepository;
import com.app.ipo.repository.MerchantRepository;
import com.app.ipo.repository.RejectedAuditRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private MerchantDetailsRepository merchantDetailsRepository;
    
    @Autowired
    private MerchantRepository merchantRepository;
    
    @Autowired
    private RejectedAuditRepository rejectedAuditRepository;

    @Override
    public List<?> searchAllTablesByPan(String searchTerm) {
        List<Object> searchResults = new ArrayList<>();
        boolean foundInDetails = false;
        boolean foundInStaging = false;
        boolean foundInRejected = false;

        List<MerchantDetailsEntity> merchantDetailsResults = merchantDetailsRepository.findByPan(searchTerm);
        if (!merchantDetailsResults.isEmpty()) {
            searchResults.addAll(merchantDetailsResults);
            foundInDetails = true;
        }

        List<MerchantEntity> merchantStagingResults = merchantRepository.findByPan(searchTerm);
        if (!merchantStagingResults.isEmpty()) {
            searchResults.addAll(merchantStagingResults);
            foundInStaging = true;
        }

        List<RejectedAudit> rejectedAuditResults = rejectedAuditRepository.findByPan(searchTerm);
        if (!rejectedAuditResults.isEmpty()) {
            searchResults.addAll(rejectedAuditResults);
            foundInRejected = true;
        }

        if (foundInDetails || foundInStaging || foundInRejected) {
            return searchResults;
        }
        
        return Collections.emptyList();
    }

    @Override
    public List<?> searchAllTablesByVpa(String searchTerm) {
        List<Object> searchResults = new ArrayList<>();

        List<MerchantDetailsEntity> merchantDetailsResults = merchantDetailsRepository.findByVpa(searchTerm);
        searchResults.addAll(merchantDetailsResults);

        List<MerchantEntity> merchantStagingResults = merchantRepository.findByVpa(searchTerm);
        searchResults.addAll(merchantStagingResults);

        List<RejectedAudit> rejectedAuditResults = rejectedAuditRepository.findByVpa(searchTerm);
        searchResults.addAll(rejectedAuditResults);

        return searchResults;
    }

    @Override
    public List<?> searchAllTablesBySym(String searchTerm) {
        List<Object> searchResults = new ArrayList<>();

        List<MerchantDetailsEntity> merchantDetailsResults = merchantDetailsRepository.findBySym(searchTerm);
        searchResults.addAll(merchantDetailsResults);

        List<MerchantEntity> merchantStagingResults = merchantRepository.findBySym(searchTerm);
        searchResults.addAll(merchantStagingResults);

        List<RejectedAudit> rejectedAuditResults = rejectedAuditRepository.findBySym(searchTerm);
        searchResults.addAll(rejectedAuditResults);

        return searchResults;
    }
}
