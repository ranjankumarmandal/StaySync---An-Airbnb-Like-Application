package com.ranjankumarmandal.user_service.controller;

import com.airbnbclone.user.dto.UpdateUserRequest;
import com.airbnbclone.user.entity.User;
import com.airbnbclone.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUser(id);
    }

    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email) {

        return userService.getByEmail(email);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request
    ) {

        return userService.updateUser(id, request);
    }
}