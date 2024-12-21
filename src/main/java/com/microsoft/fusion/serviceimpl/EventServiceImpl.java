package com.microsoft.fusion.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microsoft.fusion.dao.EventDao;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.exceptionclasses.NoCompletedEventsFoundException;
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
	
	
	
	
	
}
