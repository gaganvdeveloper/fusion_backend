package com.microsoft.fusion.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microsoft.fusion.exceptionclasses.NoUpcommingEventsFoundExcepetion;
import com.microsoft.fusion.responsestructure.ResponseStructure;

@RestControllerAdvice
public class EventExceptionHandler {
	@ExceptionHandler(NoUpcommingEventsFoundExcepetion.class)
		public ResponseEntity<?> NoUpcommingEventsFoundExcepetion(NoUpcommingEventsFoundExcepetion e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("Not Found UpComming Events").body("Invalid event").build());
	}
}
