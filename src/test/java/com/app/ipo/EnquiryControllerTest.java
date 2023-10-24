package com.app.ipo;

import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import com.app.ipo.controller.EnquiryController;
import com.app.ipo.model.MerchantDetailsEntity;
import com.app.ipo.model.RejectedAudit;
import com.app.ipo.service.EnquiryService;
import com.app.ipo.service.MerchantService;
import com.app.ipo.service.RejectedAuditService;

public class EnquiryControllerTest {

    @Test
    public void testGetMerchantDetailsByVpa() {
        MerchantService merchantService = mock(MerchantService.class);
        when(merchantService.getMerchantDetailsByVpa("ishitanse@axis"))
            .thenReturn(Arrays.asList(new MerchantDetailsEntity()));

        EnquiryController enquiryController = new EnquiryController(
                merchantService, 
                mock(RejectedAuditService.class), 
                mock(EnquiryService.class));

        ResponseEntity<List<MerchantDetailsEntity>> response = enquiryController.getMerchantDetailsByVpa("ishitanse@axis");

        assert(response.getStatusCodeValue() == 200);
        assert(response.getBody() != null);
    }

    @Test
    public void testGetRejectedAuditByVpa() {
        RejectedAuditService rejectedAuditService = mock(RejectedAuditService.class);
        when(rejectedAuditService.getRejectedAuditByVpa("ishitanse@axis"))
            .thenReturn(Arrays.asList(new RejectedAudit()));

        EnquiryController enquiryController = new EnquiryController(
                mock(MerchantService.class), 
                rejectedAuditService, 
                mock(EnquiryService.class));

        ResponseEntity<List<RejectedAudit>> response = enquiryController.getRejectedAuditByVpa("ishitanse@axis");

        assert(response.getStatusCodeValue() == 200);
        assert(response.getBody() != null);
    }
}

