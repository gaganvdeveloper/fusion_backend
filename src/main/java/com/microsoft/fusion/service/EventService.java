package com.microsoft.fusion.service;

import org.springframework.http.ResponseEntity;

import com.microsoft.fusion.entity.Event;

public interface EventService {

  ResponseEntity<?> findAllEvents();

  ResponseEntity<?> findOngoingEvents();

	ResponseEntity<?> saveEvent(Event event);

	ResponseEntity<?> assignUserToEvent(int eid, int uid);

	ResponseEntity<?> findCompletedEvents();

}
