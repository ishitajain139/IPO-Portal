package com.app.ipo;

import com.app.ipo.controller.MerchantController;
import com.app.ipo.dto.MerchantDto;
import com.app.ipo.model.MerchantEntity;
import com.app.ipo.service.MerchantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class MerchantControllerTest {

    @Mock
    private MerchantService merchantService;

    @InjectMocks
    private MerchantController merchantController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testManualEntry() {
    	MerchantDto merchantDto = new MerchantDto();
        merchantDto.setName("ishii jain");
        merchantDto.setMarketingName("ishita's Mart");
        merchantDto.setAddress("123 Main Street");
        merchantDto.setCity("mumbai City");
        merchantDto.setState("mambai State");
        merchantDto.setPincode("123456");
        merchantDto.setMobileNo("6812767655");
        merchantDto.setLandlineNo("5555555556");
        merchantDto.setDirector("Tanya rawat");
        merchantDto.setCategory("Retail");
        merchantDto.setMcc("1234");
        merchantDto.setMccDesc("Retail Store");
        merchantDto.setTypeOfIntegration("Online");
        merchantDto.setVpa("johndoe@upi");
        merchantDto.setGstNumber("ABCD1234E");
        merchantDto.setPan("ABCDE1234F");
        merchantDto.setMerchantOfficialId("ishita123");
        merchantDto.setMerchantWebsite("http://www.example.com");
        merchantDto.setBankName("Example Bank");
        merchantDto.setIfscCode("EXMP1234567");
        merchantDto.setNodalAccountNo("NODAL1234567");
        merchantDto.setPoolAccountNo("POOL1234567");
        merchantDto.setPoolIfscCode("POOLIFSC1234");
        merchantDto.setSym("SYM123");

        when(merchantService.manualEntry(any(MerchantDto.class))).thenReturn("Merchant details added manually.");
        ResponseEntity<String> responseEntity = merchantController.manualEntry(merchantDto);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Merchant details added manually.", responseEntity.getBody());
        
        verify(merchantService, times(1)).manualEntry(eq(merchantDto));
    }

    @Test
    public void testGetStagingData() {
        List<MerchantEntity> stagingData = new ArrayList<>();
        stagingData.add(new MerchantEntity());
        stagingData.add(new MerchantEntity());

        when(merchantService.retrieveStagingData()).thenReturn(stagingData);

        ResponseEntity<Object> responseEntity = merchantController.getStagingData(new MerchantDto());
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(stagingData, responseEntity.getBody());
    }

    @Test
    public void testApproveStagingData() {
        Long stagingId = 1L;
        String approvedBy = "admin";
        String remark = "Approved";

        String expectedResponse = "Staging data approved successfully!";

        doNothing().when(merchantService).approveStagingData(stagingId, approvedBy, remark);

        String result = merchantController.approveStagingData(Map.of(
                "stagingId", stagingId,
                "approvedBy", approvedBy,
                "remark", remark
        ));

        assertEquals(expectedResponse, result);
    }

    @Test
    public void testRejectStagingData() {
        Long stagingId = 1L;
        String rejectedBy = "admin";
        String remark = "Rejected";

        String expectedResponse = "Staging data rejected successfully!";

        doNothing().when(merchantService).rejectStagingData(stagingId, rejectedBy, remark);

        String result = merchantController.rejectStagingData(Map.of(
                "stagingId", stagingId,
                "rejectedBy", rejectedBy,
                "remark", remark
        ));

        assertEquals(expectedResponse, result);
    }
}
