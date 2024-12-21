package com.microsoft.fusion.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microsoft.fusion.dao.EventDao;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.exceptionclasses.NoUpcommingEventsFoundExcepetion;
import com.microsoft.fusion.responsestructure.ResponseStructure;
import com.microsoft.fusion.service.EventService;
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public ResponseEntity<?> findUpcommingEvents() {
		List<Event>list=eventDao.findUpcommingEvents();
		if(list.isEmpty()) {
			throw NoUpcommingEventsFoundExcepetion.builder().message("No UpCommning Events Found").build();
		}
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message(" Found All UpComming Events").body(list).build());
	}
	
	
	
	
}
