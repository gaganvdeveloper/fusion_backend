package com.microsoft.fusion.service;

import org.springframework.http.ResponseEntity;

public interface EventService {

	

	ResponseEntity<?> findAllEvents();

	

}
