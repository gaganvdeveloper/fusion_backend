package com.microsoft.fusion.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvalidEventIdException extends RuntimeException {
	private String message;
	@Override
	public String getMessage() {
		return this.message;
	}
}
