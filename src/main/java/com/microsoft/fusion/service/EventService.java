package com.microsoft.fusion.service;

import org.springframework.http.ResponseEntity;

import com.microsoft.fusion.entity.Event;

public interface EventService {

	ResponseEntity<?> saveEvent(Event event);

	ResponseEntity<?> assignUserToEvent(int eid, int uid);

}
