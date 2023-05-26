package com.example.billsledger.loginusers.model.dto;

import lombok.Data;

@Data
public class LoginUsersDto {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String profileName;
    private String role;
    private String message;
}
