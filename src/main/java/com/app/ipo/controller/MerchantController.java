package com.app.ipo.controller;

import com.app.ipo.dto.MerchantDto;
import com.app.ipo.model.MerchantEntity;
import com.app.ipo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    private static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();
        assert contentType != null;
        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    @PostMapping("/manual-entry")
    public ResponseEntity<String> manualEntry(@RequestBody @Valid MerchantDto merchantDto) {
        try {
            String response = merchantService.manualEntry(merchantDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Manual entry failed: " + e.getMessage());
        }
    }
    
    @GetMapping("/staging")
    public ResponseEntity<Object> getStagingData(@Valid MerchantDto merchantDto) {
        try {
            List<MerchantEntity> stagingData = merchantService.retrieveStagingData();

            if (stagingData.isEmpty()) {
                return ResponseEntity.status(404).body("No staging data available.");
            }

            return ResponseEntity.ok(stagingData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to retrieve staging data: " + e.getMessage());
        }
    }
    
    @PostMapping("/approve")
    public String approveStagingData(@RequestBody Map<String, Object> request) {
        Long stagingId = Long.valueOf(request.get("stagingId").toString());
        String approvedBy = request.get("approvedBy").toString();
        String remark = request.get("remark").toString();

        merchantService.approveStagingData(stagingId, approvedBy, remark);

        return "Staging data approved successfully!";
    }

    @PostMapping("/reject")
    public String rejectStagingData(@RequestBody Map<String, Object> request) {
        Long stagingId = Long.valueOf(request.get("stagingId").toString());
        String rejectedBy = request.get("rejectedBy").toString();
        String remark = request.get("remark").toString();

        merchantService.rejectStagingData(stagingId, rejectedBy, remark);

        return "Staging data rejected successfully!";
    }
}
