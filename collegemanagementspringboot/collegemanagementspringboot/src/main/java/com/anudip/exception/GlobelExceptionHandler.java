package com.anudip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobelExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TeacherIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handelTeacherException(TeacherIdNotFoundException tx, WebRequest request) {
		
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}
}
