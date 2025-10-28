package com.varsemployeeportal.auth_service.service;

import com.varsemployeeportal.auth_service.entity.User;

public interface AuthService {
    String register(User user);
    String login(User user);
}
