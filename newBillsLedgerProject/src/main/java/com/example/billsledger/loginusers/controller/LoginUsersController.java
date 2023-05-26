package com.example.billsledger.loginusers.controller;

import com.example.billsledger.loginusers.model.dto.LoginUsersDto;
import com.example.billsledger.loginusers.service.LoginUsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class LoginUsersController {
    private final LoginUsersService service;

    @PostMapping("/login")
    private LoginUsersDto login(@RequestBody LoginUsersDto loginUsersDto) {
        return service.login(loginUsersDto);
    }

    @PostMapping("/add-user")
    private ResponseEntity<LoginUsersDto> adduser(@RequestBody LoginUsersDto loginUserDto) {
        return service.addUser(loginUserDto);
    }

    @GetMapping("/get-user")
    private List<LoginUsersDto> getUsers() {
        return service.getUsers();
    }

    @DeleteMapping("/delete-user/{id}")
    private void deleteUser(@PathVariable long id) {
        service.deleteUserById(id);
    }

}


