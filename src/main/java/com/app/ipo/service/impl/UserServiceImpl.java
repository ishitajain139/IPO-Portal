package com.app.ipo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.app.ipo.dto.UserDto;
import com.app.ipo.model.UserEntity;
import com.app.ipo.repository.UserRepository;
import com.app.ipo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String addNewUser(UserDto userDto) {
        String phoneNumber = String.valueOf(userDto.getUserPhoneno());
        if (!phoneNumber.matches("[6-9]\\d{9}")) {
        	 throw new IllegalArgumentException("Invalid phone number format. Please provide a valid phone number.");
        }
        
        Optional<UserEntity> existingUserByEmail = userRepository.findByEmailId(userDto.getUserEmailId());

        if (existingUserByEmail.isPresent()) {
        	 throw new IllegalArgumentException("User with the same email already exists.");
        }
        
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setUserPhoneno(userDto.getUserPhoneno());
        userEntity.setUserEmailId(userDto.getUserEmailId());
        userEntity.setUserAddress(userDto.getUserAddress());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setRecordedDate(new Date(System.currentTimeMillis()));
        userEntity.setRole(userDto.getRole());

        String hashedPassword = passwordEncoder.encode(userDto.getUserPassword());
        userEntity.setUserPassword(hashedPassword);
        
        userRepository.save(userEntity);

        return "User added successfully";
    }

    @Override
    public String loginUser(UserDto userDto) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmailId(
                userDto.getUserEmailId()
        );

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            boolean passwordMatches = passwordEncoder.matches(userDto.getUserPassword(), user.getUserPassword());
            
            if (passwordMatches) {
                return "Login successful";
            }
        }

        return "Invalid credentials";
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (UserEntity userEntity : userEntities) {
            UserDto userDto = new UserDto();
            userDto.setUserId(userEntity.getUserId());
            userDto.setName(userEntity.getName());
            userDto.setUserPhoneno(userEntity.getUserPhoneno());
            userDto.setUserEmailId(userEntity.getUserEmailId());
            userDto.setUserAddress(userEntity.getUserAddress());
            userDto.setUserName(userEntity.getUserName());
            userDto.setUserPassword(null);
            userDto.setRecordedDate(userEntity.getRecordedDate());
            userDto.setRole(userEntity.getRole());
            userDtos.add(userDto);
        }

        return userDtos;
    }

    @Override
    public String viewUser(Long id, String role) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUserId(id);

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();

            if (role.equals(user.getRole())) {
                UserDto userDto = new UserDto();
                userDto.setUserId(user.getUserId());
                userDto.setName(user.getName());
                userDto.setUserPhoneno(user.getUserPhoneno());
                userDto.setUserEmailId(user.getUserEmailId());
                userDto.setUserAddress(user.getUserAddress());
                userDto.setUserName(user.getUserName());
                userDto.setUserPassword(user.getUserPassword());
                userDto.setRecordedDate(user.getRecordedDate());
                userDto.setRole(user.getRole());

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    return objectMapper.writeValueAsString(userDto);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    return "Error converting user to JSON";
                }
            } else {
                return "User not authorized for this role";
            }
        }
        return "User not found";
    }


    @Override
    public String available(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUserId(id);

        if (userEntityOptional.isPresent()) {
            return "User is available";
        }

        return "User not found";
    }

    @Override
    public String delete(long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    @Override
    public String showPassword(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUserId(id);

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            String hashedPassword = user.getUserPassword();

            return hashedPassword;
        }

        return "User not found";
    }

    public boolean comparePasswords(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}
