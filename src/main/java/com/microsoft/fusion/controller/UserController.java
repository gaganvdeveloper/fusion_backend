package com.microsoft.fusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.fusion.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	
	
}
