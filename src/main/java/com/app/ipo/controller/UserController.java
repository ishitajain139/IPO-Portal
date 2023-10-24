package com.app.ipo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.ipo.dto.UserDto;
import com.app.ipo.service.UserService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public String addNewUser(@RequestBody UserDto userDto) {
        return userService.addNewUser(userDto);
    }

    @PostMapping(path = "/login")
    public String loginUser(@RequestBody UserDto userDto) {
        return userService.loginUser(userDto);
    }
    
    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") Long id, @RequestParam("role") String role) {
        return userService.viewUser(id, role);
    }

    @GetMapping("/available/{id}")
    public String available(@PathVariable("id") Long id) {
        return userService.available(id);
    }

    @GetMapping("/showPassword/{id}")
    public String showPassword(@PathVariable("id") Long id) {
        return userService.showPassword(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return userService.delete(id);
    }
}