package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

//This class can have more than one exception handler
@ControllerAdvice
public class ApiExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiRequestException.class);

    //Handler for the ApiRequestException class
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException( ApiRequestException e){
        //Builds the payload for our client
        ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now());

        //Sends the response using the response entity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException( NotFoundException e){
        //Builds the payload for our client
        ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.NOT_FOUND, ZonedDateTime.now());

        //Sends the response using the response entity
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
