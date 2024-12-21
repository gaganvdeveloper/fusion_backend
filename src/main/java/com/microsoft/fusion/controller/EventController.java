package com.microsoft.fusion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.service.EventService;
import com.microsoft.fusion.util.EventStatus;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService service;
	

	@GetMapping("/ongoing")
	public ResponseEntity<?>  findOngoingEvents(){
		return service.findOngoingEvents();
  }
	
	@PostMapping
	public ResponseEntity<?> saveEvent(@RequestBody Event event){
		return service.saveEvent(event);
	}
	
	@PatchMapping("/register/{eid}/{uid}")
	public ResponseEntity<?> assignUserToEvent(@PathVariable int eid,@PathVariable int uid){
		return service.assignUserToEvent(eid,uid);

	}
	
	
	
}
