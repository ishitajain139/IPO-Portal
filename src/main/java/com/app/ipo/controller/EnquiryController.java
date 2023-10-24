package com.app.ipo.controller;

import com.app.ipo.model.MerchantDetailsEntity;
import com.app.ipo.model.MerchantEntity;
import com.app.ipo.model.RejectedAudit;
import com.app.ipo.service.EnquiryService;
import com.app.ipo.service.MerchantService;
import com.app.ipo.service.RejectedAuditService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enquiry")
public class EnquiryController {
    private final MerchantService merchantService;
    private final RejectedAuditService rejectedAuditService;
    private final EnquiryService enquiryService;

    @Autowired
    public EnquiryController(MerchantService merchantService, RejectedAuditService rejectedAuditService, EnquiryService enquiryService) {
        this.merchantService = merchantService;
        this.rejectedAuditService = rejectedAuditService;
        this.enquiryService = enquiryService;
    }

    @GetMapping("/merchantdetails/byVpa/{vpa}")
    public ResponseEntity<List<MerchantDetailsEntity>> getMerchantDetailsByVpa(@PathVariable String vpa) {
        List<MerchantDetailsEntity> merchantDetails = merchantService.getMerchantDetailsByVpa(vpa);
        if (merchantDetails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(merchantDetails);
    }

    @GetMapping("/merchantdetails/byPan/{pan}")
    public ResponseEntity<List<MerchantDetailsEntity>> getMerchantDetailsByPan(@PathVariable String pan) {
        List<MerchantDetailsEntity> merchantDetails = merchantService.getMerchantDetailsByPan(pan);
        if (merchantDetails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(merchantDetails);
    }

    @GetMapping("/merchantdetails/bySym/{sym}")
    public ResponseEntity<List<MerchantDetailsEntity>> getMerchantDetailsBySym(@PathVariable String sym) {
        List<MerchantDetailsEntity> merchantDetails = merchantService.getMerchantDetailsBySym(sym);
        if (merchantDetails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(merchantDetails);
    }

    @GetMapping("rejectedaudit/byVpa/{vpa}")
    public ResponseEntity<List<RejectedAudit>> getRejectedAuditByVpa(@PathVariable String vpa) {
        List<RejectedAudit> rejectedAudits = rejectedAuditService.getRejectedAuditByVpa(vpa);
        if (rejectedAudits.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rejectedAudits);
    }

    @GetMapping("rejectedaudit/byPan/{pan}")
    public ResponseEntity<List<RejectedAudit>> getRejectedAuditByPan(@PathVariable String pan) {
        List<RejectedAudit> rejectedAudits = rejectedAuditService.getRejectedAuditByPan(pan);
        if (rejectedAudits.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rejectedAudits);
    }

    @GetMapping("rejectedaudit/bySym/{sym}")
    public ResponseEntity<List<RejectedAudit>> getRejectedAuditBySym(@PathVariable String sym) {
        List<RejectedAudit> rejectedAudits = rejectedAuditService.getRejectedAuditBySym(sym);
        if (rejectedAudits.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rejectedAudits);
    }

    @GetMapping("/merchantstaging/byVpa/{vpa}")
    public ResponseEntity<List<MerchantEntity>> getMerchantStagingByVpa(@PathVariable String vpa) {
        List<MerchantEntity> merchantStagingList = merchantService.getMerchantStagingByVpa(vpa);
        if (merchantStagingList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(merchantStagingList);
    }

    @GetMapping("/merchantstaging/byPan/{pan}")
    public ResponseEntity<List<MerchantEntity>> getMerchantStagingByPan(@PathVariable String pan) {
        List<MerchantEntity> merchantStagingList = merchantService.getMerchantStagingByPan(pan);
        if (merchantStagingList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(merchantStagingList);
    }

    @GetMapping("/merchantstaging/bySym/{sym}")
    public ResponseEntity<List<MerchantEntity>> getMerchantStagingBySym(@PathVariable String sym) {
        List<MerchantEntity> merchantStagingList = merchantService.getMerchantStagingBySym(sym);
        if (merchantStagingList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(merchantStagingList);
    }

    @GetMapping("/byPan/{pan}")
    public ResponseEntity<List<?>> getMerchantByPan(@PathVariable String pan) {
        List<?> results = enquiryService.searchAllTablesByPan(pan);
        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/byVpa/{vpa}")
    public ResponseEntity<List<?>> getMerchantByVpa(@PathVariable String vpa) {
        List<?> results = enquiryService.searchAllTablesByVpa(vpa);
        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results);
    }
    @GetMapping("/bySym/{sym}")
    public ResponseEntity<List<?>> getMerchantBySym(@PathVariable String sym) {
        List<?> results = enquiryService.searchAllTablesBySym(sym);
        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results);
    }

}
