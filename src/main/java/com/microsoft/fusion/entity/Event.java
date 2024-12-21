package com.microsoft.fusion.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.microsoft.fusion.util.EventStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private String city;
	private String guest;
	private String photo;
	private EventStatus status;
	@ManyToMany
	private List<User> users;
}
