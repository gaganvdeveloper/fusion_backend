package com.microsoft.fusion.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvalidUserIdException extends RuntimeException{
	private String message;
	@Override
	public String getMessage() {
		return this.message;
	}
}
