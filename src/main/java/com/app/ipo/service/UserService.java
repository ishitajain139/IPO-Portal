package com.app.ipo.service;

import java.util.List;

import com.app.ipo.dto.UserDto;

public interface UserService {
    String addNewUser(UserDto userDto);
    String loginUser(UserDto userDto);
    String viewUser(Long id, String role);
    String available(Long id);
    String delete(long id);
    String showPassword(Long id);
	List<UserDto> getAllUsers();
}