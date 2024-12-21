package com.microsoft.fusion.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microsoft.fusion.responsestructure.ResponseStructure;

@RestControllerAdvice
public class NoEventsFoundException {
//@ExceptionHandler(NoEventsFoundException.class)
//public ResponseEntity<?>noEventsFoundException(NoEventsFoundException e){
//	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().httpStatus(HttpStatus.BAD_REQUEST.value()).message("check events").body())
//}
}
