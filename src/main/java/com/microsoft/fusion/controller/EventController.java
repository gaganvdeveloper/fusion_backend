package com.microsoft.fusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.fusion.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService service;
	
	
	
	
	
}
