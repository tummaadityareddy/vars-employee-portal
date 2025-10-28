package com.varsemployeeportal.auth_service.service.impl;

import com.varsemployeeportal.auth_service.entity.User;
import com.varsemployeeportal.auth_service.repository.UserRepository;
import com.varsemployeeportal.auth_service.service.AuthService;
import com.varsemployeeportal.auth_service.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String login(User user) {
        return userRepository.findByUsername(user.getUsername())
                .map(u -> {
                    if (passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                        return jwtUtil.generateToken(u.getUsername(), Map.of("role", u.getRole()));
                    } else {
                        throw new RuntimeException("Invalid credentials");
                    }
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
