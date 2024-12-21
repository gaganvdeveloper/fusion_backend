package com.microsoft.fusion.dao;

import java.util.Optional;

import com.microsoft.fusion.entity.Event;
import com.microsoft.fusion.entity.User;

public interface EventDao {

	Event saveEvent(Event event);

	Optional<Event> findEventById(int eid);

}
