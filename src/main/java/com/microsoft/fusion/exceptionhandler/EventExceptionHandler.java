package com.microsoft.fusion.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microsoft.fusion.exceptionclasses.NoCompletedEventsFoundException;
import com.microsoft.fusion.responsestructure.ResponseStructure;

@RestControllerAdvice
public class EventExceptionHandler {

	
	@ExceptionHandler(NoCompletedEventsFoundException.class)
	public ResponseEntity<?> noCompletedEventsFoundException(NoCompletedEventsFoundException e){
		
		
		return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("NO Completed events found ").body(e.getMessage()).build());

	}
}
