package com.microsoft.fusion.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microsoft.fusion.dao.EventDao;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.repository.EventRepository;
@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private EventRepository repository;

	@Override
	public List<Event> findUpcomingEvents() {
		return repository.findUpcominEvents();
	}
	
	
	
}
