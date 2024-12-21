package com.microsoft.fusion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microsoft.fusion.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

	@Query("select e from Event e where e.status ='COMPLETED'")
	List<Event> findCompletedEvents();

  @Query("select e from Event e where e.status ='ON_GOING'")
	List<Event> findAllOngoingEvents();

}
