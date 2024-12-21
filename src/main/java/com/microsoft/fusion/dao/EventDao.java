package com.microsoft.fusion.dao;

import java.util.List;

import com.microsoft.fusion.entity.Event;

public interface EventDao {

	List<Event> findUpcommingEvents();

}
