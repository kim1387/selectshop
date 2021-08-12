package com.example.selectshop.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}