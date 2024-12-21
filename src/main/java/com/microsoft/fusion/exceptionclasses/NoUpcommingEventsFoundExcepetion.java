package com.microsoft.fusion.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoUpcommingEventsFoundExcepetion extends RuntimeException {
	private String message;
	public String getMessage() {
		return this.message;
	}
}
