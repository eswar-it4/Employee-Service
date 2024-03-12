package com.example.employee.Advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class EmployeeBusinessExceptionHandler extends ResponseEntityExceptionHandler {

		
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String,String> hm=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->hm.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hm);
	}
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String,String> catchGenericException(MethodArgumentNotValidException ex){
//		Map<String,String> hm=new HashMap<>();
//		ex.getBindingResult().getFieldErrors().forEach(error->hm.put(error.getField(), error.getDefaultMessage()));
//		return hm;
//	}
}
