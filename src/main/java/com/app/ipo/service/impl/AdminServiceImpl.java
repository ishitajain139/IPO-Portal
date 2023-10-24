package com.app.ipo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.ipo.dto.AdminDto;
import com.app.ipo.model.AdminEntity;
import com.app.ipo.repository.AdminRepository;
import com.app.ipo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String loginUser(AdminDto adminDto) {
        String adminEmail = adminDto.getAdminEmail();
        String adminPassword = adminDto.getAdminPassword();

        Optional<AdminEntity> adminEntity = adminRepository.findByAdminEmailAndAdminPassword(adminEmail, adminPassword);

        if (adminEntity.isPresent()) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @Override
    public void addAdmin(AdminDto adminDto) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setAdminEmail(adminDto.getAdminEmail());
        adminRepository.save(adminEntity);
    }
}
