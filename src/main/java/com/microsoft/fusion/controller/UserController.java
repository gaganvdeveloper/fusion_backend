package com.microsoft.fusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.fusion.entity.User;
import com.microsoft.fusion.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		return service.findAllUsers();
	}
}
