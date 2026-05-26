package com.ranjankumarmandal.user_service.service;

import com.airbnbclone.user.dto.UpdateUserRequest;
import com.airbnbclone.user.entity.User;
import com.airbnbclone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id) {

        return userRepository.findById(id)
                .orElseThrow();
    }

    public User getByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow();
    }

    public User updateUser(Long id, UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setProfileImageUrl(request.getProfileImageUrl());

        return userRepository.save(user);
    }
}