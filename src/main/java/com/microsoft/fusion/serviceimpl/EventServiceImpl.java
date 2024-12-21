package com.microsoft.fusion.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microsoft.fusion.dao.EventDao;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.exceptionclasses.NoEventsFoundException;
import com.microsoft.fusion.responsestructure.ResponseStructure;
import com.microsoft.fusion.service.EventService;
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public ResponseEntity<?> findAllEvents() {
		List<Event> events=eventDao.findAllEvents();
		if(events.isEmpty()) {
			throw NoEventsFoundException.builder().message("no events ara available").build();
		}
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all events found sucessfully").body(events).build());
	}
	
	
	
}
