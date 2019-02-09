package com.wp.myfinance.Authorization.controller;

import com.wp.myfinance.Authorization.exception.ResourceNotFoundException;
import com.wp.myfinance.Authorization.model.User;
import com.wp.myfinance.Authorization.repository.UserRepository;
import com.wp.myfinance.Authorization.security.CurrentUser;
import com.wp.myfinance.Authorization.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
