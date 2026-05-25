package com.ranjankumarmandal.auth_service.dto;

import com.airbnbclone.auth.entity.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private UserRole role;
}