package com.microsoft.fusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.fusion.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService service;
	
	@GetMapping("/events")
	public ResponseEntity<?> findAllEvents(){
		return service.findAllEvents();
	}
	
	
	
}
