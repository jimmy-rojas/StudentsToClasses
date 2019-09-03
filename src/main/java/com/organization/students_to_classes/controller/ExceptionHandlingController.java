package com.organization.students_to_classes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

  @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unknown System Error")
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Exception> unknownException(Exception ex) {
    return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
  }
}
