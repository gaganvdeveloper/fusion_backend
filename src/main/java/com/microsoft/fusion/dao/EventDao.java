package com.microsoft.fusion.dao;

import java.util.List;
import com.microsoft.fusion.entity.Event;
import java.util.Optional;
import com.microsoft.fusion.entity.User;

public interface EventDao {
  
  List<Event> findAllOngoingEvents();

	Event saveEvent(Event event);

	Optional<Event> findEventById(int eid);

}
