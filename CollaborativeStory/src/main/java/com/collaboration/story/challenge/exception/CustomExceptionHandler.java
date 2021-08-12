package com.collaboration.story.challenge.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.collaboration.story.challenge.model.ErrorResponse;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	
    @Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
    	ErrorResponse eRsp= new ErrorResponse();
    	eRsp.setError("Request body is mandatory !");
		return new ResponseEntity<>(eRsp, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param ex
	 * @param request
	 * @return response entity
	 */
	@ExceptionHandler(value = { GeneralException.class })
	public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) {
		ErrorResponse eRsp= new ErrorResponse();
		if (ex instanceof MultipleWordException) {
			eRsp.setError(ex.getMessage());
		}else if(ex instanceof InvalidRequestException) {
			eRsp.setError(ex.getMessage());
		}else if (ex instanceof  StoryNotPresentException) {
			eRsp.setError(ex.getMessage());
		}
		return new ResponseEntity<>(eRsp,HttpStatus.BAD_REQUEST);
	}

}
