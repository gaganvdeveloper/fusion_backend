package com.microsoft.fusion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsoft.fusion.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
