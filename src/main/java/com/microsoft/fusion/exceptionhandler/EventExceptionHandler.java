package com.microsoft.fusion.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microsoft.fusion.exceptionclasses.NoUpComingEventFoundException;
import com.microsoft.fusion.responsestructure.ResponseStructure;

@RestControllerAdvice
public class EventExceptionHandler {
	@ExceptionHandler(NoUpComingEventFoundException.class)
	public ResponseEntity<?> NoUpComingEventFoundException(NoUpComingEventFoundException e){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).
				body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).
						message("No UpComing Events Found").body(e.getMessage()).build());
	}

}
