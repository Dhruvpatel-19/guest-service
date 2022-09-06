package com.example.guestservice.exception.handler;

import com.example.guestservice.exception.PropertyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GuestSericeExceptionHandler {
    @ExceptionHandler(value = PropertyNotFoundException.class)
    public ResponseEntity<Object> propertyNotFoundExceptionHandler(PropertyNotFoundException exception) {
        return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
    }
}
