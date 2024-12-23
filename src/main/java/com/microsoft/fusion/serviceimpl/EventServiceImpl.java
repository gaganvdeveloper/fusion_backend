package com.microsoft.fusion.serviceimpl;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microsoft.fusion.dao.EventDao;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.exceptionclasses.NoCompletedEventsFoundException;
import com.microsoft.fusion.exceptionclasses.NoEventsFoundException;
import com.microsoft.fusion.dto.EventDto;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.exceptionclasses.InvalidEventIdException;
import com.microsoft.fusion.dao.UserDao;
import com.microsoft.fusion.entity.User;
import com.microsoft.fusion.exceptionclasses.InvalidUserIdException;
import com.microsoft.fusion.responsestructure.ResponseStructure;
import com.microsoft.fusion.service.EventService;
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public ResponseEntity<?> findCompletedEvents() {
		List<Event> eventList = eventDao.findCompletedEvents();
		 if(eventList.isEmpty()) {
			 throw NoCompletedEventsFoundException.builder().message("No Completed  events Found").build();
		 }
		
		return   ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Completed events found sucessfully").body(eventList).build());
	}
  
  @Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<?> findAllEvents() {
		List<Event> events=eventDao.findAllEvents();
		if(events.isEmpty()) {
			throw NoEventsFoundException.builder().message("no events ara available").build();
		}
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all events found sucessfully").body(events).build());
	}
  
  @Override
	public ResponseEntity<?> findOngoingEvents() {
		List<Event> events = eventDao.findAllOngoingEvents();
		List<EventDto> onGoingList = new ArrayList<>();
		for(Event e : events ) {
			onGoingList.add(new EventDto(e.getName(), e.getFromDateTime(), e.getToDateTime(), e.getCity(), e.getGuest(), e.getPhoto()));
		}
		if(onGoingList.isEmpty())
			throw new InvalidEventIdException("No OnGoing Event Found...");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Ongoing Events Found Successfully").body(onGoingList).build());
	}
	
	@Override
	public ResponseEntity<?> saveEvent(Event event) {
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Event Saved Successfully").body(eventDao.saveEvent(event)).build());
	}

	@Override
	public ResponseEntity<?> assignUserToEvent(int eid, int uid) {
		Optional<User> optionalU = userDao.findUserById(uid);
		Optional<Event> optionalE = eventDao.findEventById(eid);
		if(optionalE.isEmpty())
			throw InvalidEventIdException.builder().message("Invalid Event ID Unable to Assigin the user to event").build();
		if(optionalU.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User ID Unable to Assign the user to event").build();
		User user = optionalU.get();
		Event event = optionalE.get();
		List<User> users = event.getUsers();
		users.add(user);
		event.setUsers(users);
		event = eventDao.saveEvent(event);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Registerd Successfully to the Event").body(event).build());
	}
	

}