package com.microsoft.fusion.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
     
	
	private String name;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private String city;
	private String guest;
	private String photo;
}
