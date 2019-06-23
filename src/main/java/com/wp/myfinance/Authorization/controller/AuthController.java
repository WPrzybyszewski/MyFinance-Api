package com.wp.myfinance.Authorization.controller;

import com.wp.myfinance.Authorization.exception.BadRequestException;
import com.wp.myfinance.Authorization.model.AuthProvider;
import com.wp.myfinance.Authorization.model.User;
import com.wp.myfinance.Authorization.payload.ApiResponse;
import com.wp.myfinance.Authorization.payload.AuthResponse;
import com.wp.myfinance.Authorization.payload.LoginRequest;
import com.wp.myfinance.Authorization.payload.SignUpRequest;
import com.wp.myfinance.Authorization.repository.UserRepository;
import com.wp.myfinance.Authorization.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);

        return ResponseEntity.ok(new AuthResponse(token));
        }catch(Exception e)
        {
            e.printStackTrace();
            return (ResponseEntity<?>) ResponseEntity.status(500);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }
        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setProvider(AuthProvider.local);

       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(passwordEncoder.encode("1234"));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

    @GetMapping("/registerTest")
    public  ResponseEntity<SignUpRequest> registerTest()
    {
        SignUpRequest signUpRequest = new SignUpRequest();

        signUpRequest.setName("Jan");
        signUpRequest.setSurname("Pazdziovh");
        signUpRequest.setEmail("wojtasdhw@gmail.com");
        return ResponseEntity.ok(signUpRequest);
    }





}
