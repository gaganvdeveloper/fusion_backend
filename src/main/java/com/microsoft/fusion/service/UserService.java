package com.microsoft.fusion.service;

import org.springframework.http.ResponseEntity;

import com.microsoft.fusion.entity.User;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUsers();

}
