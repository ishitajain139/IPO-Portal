package com.app.ipo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.ipo.dto.AdminDto;
import com.app.ipo.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/admin/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> loginAdmin(@RequestBody AdminDto adminDto) {
        Map<String, Object> response = new HashMap<>();

        String message = adminService.loginUser(adminDto);

        response.put("message", message);

        return response;
    }
}
