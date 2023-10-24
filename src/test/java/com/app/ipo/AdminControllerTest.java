package com.app.ipo;

import com.app.ipo.controller.AdminController;
import com.app.ipo.dto.AdminDto;
import com.app.ipo.model.AdminEntity;
import com.app.ipo.repository.AdminRepository;
import com.app.ipo.service.AdminService;
import com.app.ipo.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginAdmin() {
        AdminDto adminDto = new AdminDto();
        adminDto.setAdminEmail("ishita139j@gmail.com");
        adminDto.setAdminPassword("ishita123");

        String message = "Login successful";
        when(adminService.loginUser(adminDto)).thenReturn(message);

        Map<String, Object> result = adminController.loginAdmin(adminDto);

        assertNotNull(result);
        assertEquals(message, result.get("message"));
    }
}
