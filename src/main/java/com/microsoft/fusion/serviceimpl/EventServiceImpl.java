package com.microsoft.fusion.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microsoft.fusion.dao.EventDao;
import com.microsoft.fusion.dto.EventDto;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.exceptionclasses.InvalidEventIdException;
import com.microsoft.fusion.responsestructure.ResponseStructure;
import com.microsoft.fusion.service.EventService;
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public ResponseEntity<?> findOngoingEvents() {
		List<Event> events = eventDao.findAllOngoingEvents();
		List<EventDto> onGoingList = new ArrayList<>();
		for(Event e : events ) {
			onGoingList.add(new EventDto(e.getName(), e.getFromDateTime(), e.getToDateTime(), e.getCity(), e.getGuest(), e.getPhoto()));
		}
		if(onGoingList.isEmpty())
			throw new InvalidEventIdException("No OnGoing Event Found...");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Ongoing Events Found Successfully").body(onGoingList).build());
	}
	}
	
	
	
	

