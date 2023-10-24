package com.app.ipo;

import com.app.ipo.controller.UserController;
import com.app.ipo.dto.UserDto;
import com.app.ipo.model.UserEntity;
import com.app.ipo.repository.UserRepository;
import com.app.ipo.service.UserService;
import com.app.ipo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddNewUser() {
        UserDto userDto = new UserDto();
        userDto.setName("Ishita Jain");
        userDto.setUserPhoneno(9876543210L);
        userDto.setUserEmailId("ishita123@gmail.com");
        userDto.setUserAddress("123 Main Street");
        userDto.setUserName("ishita123");
        userDto.setUserPassword("ishita123");
        userDto.setRecordedDate(new Date(System.currentTimeMillis()));
        userDto.setRole("MANAGER");

        when(userService.addNewUser(any(UserDto.class))).thenReturn("User added successfully");
        String result = userController.addNewUser(userDto);
        assertEquals("User added successfully", result);
    }

    @Test
    public void testLoginUser() {
        UserDto userDto = new UserDto();
        userDto.setUserEmailId("ishita123@gmail.com");
        userDto.setUserPassword("ishita123");

        when(userService.loginUser(any(UserDto.class))).thenReturn("Login successful");
        String result = userController.loginUser(userDto);

        assertEquals("Login successful", result);
    }

    @Test
    public void testGetAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        userDtoList.add(new UserDto());

        when(userService.getAllUsers()).thenReturn(userDtoList);

        List<UserDto> result = userController.getAllUsers();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testViewUser() {
        Long id = 1L;
        String role = "MANAGER";

        when(userService.viewUser(id, role)).thenReturn("{\"userId\":1,\"name\":\"Ishita Jain\",\"userPhoneno\":9876543210,\"userEmailId\":\"ishita123@gmail.com\",\"userAddress\":\"123 Main Street\",\"userName\":\"ishita123\",\"userPassword\":\"ishita123\",\"recordedDate\":\"2023-10-15\",\"role\":\"MANAGER\"}");

        String result = userController.viewUser(id, role);
        assertNotNull(result);
        assertTrue(result.contains("ishita123@gmail.com"));
    }

    @Test
    public void testAvailable() {
        Long id = 1L;

        when(userService.available(id)).thenReturn("User is available");
        String result = userController.available(id);
        assertEquals("User is available", result);
    }

    @Test
    public void testShowPassword() {
        Long id = 1L;

        when(userService.showPassword(id)).thenReturn("hashed_password_123");
        String result = userController.showPassword(id);
        assertEquals("hashed_password_123", result);
    }

    @Test
    public void testDelete() {
        long id = 1L;
        
        when(userService.delete(id)).thenReturn("User deleted successfully");
        String result = userController.delete(id);
        assertEquals("User deleted successfully", result);
    }
}
