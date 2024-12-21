package com.microsoft.fusion.daoimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.microsoft.fusion.dao.EventDao;
import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.entity.User;
import com.microsoft.fusion.repository.EventRepository;
@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private EventRepository repository;

	@Override
	public List<Event> findAllOngoingEvents() {
		return repository.findAllOngoingEvents();
  }
  
  @Override
  public Event saveEvent(Event event) {
		return repository.save(event);
	}

	@Override
	public Optional<Event> findEventById(int eid) {
		return repository.findById(eid);
	}
}
