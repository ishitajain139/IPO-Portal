package com.app.ipo.service;

import com.app.ipo.dto.AdminDto;

public interface AdminService {
    String loginUser(AdminDto adminDto);
    void addAdmin(AdminDto adminDto);
}
