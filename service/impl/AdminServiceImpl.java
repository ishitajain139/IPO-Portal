package com.app.ipo.service.impl;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.app.ipo.dto.AdminDto;
import com.app.ipo.model.AdminEntity;
import com.app.ipo.repository.AdminRepository;
import com.app.ipo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	public AdminRepository adminRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public String loginUser(AdminDto adminDto, BindingResult result, Model model, HttpSession session) 
	{
	    if (null != adminDto 
	            && (null != adminDto.getAdminName() && !adminDto.getAdminName().trim().isEmpty())
	            && (null != adminDto.getAdminPassword() && !adminDto.getAdminPassword().trim().isEmpty())) 
	    {
	        AdminEntity adminEntity = adminRepository.loginUser(adminDto.getAdminName(), adminDto.getAdminPassword());
	        
	        if (null == adminEntity || 
	            !adminEntity.getAdminName().equals(adminDto.getAdminName()) || 
	            !adminEntity.getAdminPassword().equals(adminDto.getAdminPassword())) 
	        {
	            ObjectError error = new ObjectError("globalError", "Incorrect username or password!");
	            result.addError(error);
	        }
	        else
	        {
	            session.setAttribute("x", null != adminEntity && null != adminEntity.getAdminName() ? adminEntity.getAdminName() : "-");
	            session.setAttribute("y", null != adminEntity && null != adminEntity.getAdminId() ? adminEntity.getAdminId() : "-");

	            return "redirect:/user/view"; // Redirect to adminDashboard page
	        }
	    }
	    else
	    {
	        ObjectError error = new ObjectError("globalError", "Kindly fill both username and password!");
	        result.addError(error);
	    }

	    model.addAttribute("adminDto", adminDto); // To retain the form data for redisplay
	    return "admin"; // Return to the same "admin" page to display error messages
	}




}
