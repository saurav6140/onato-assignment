package com.onato.assignment.controller;

import com.onato.assignment.exception.ResourceAlreadyExistsException;
import com.onato.assignment.exception.StudentNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(StudentNotFoundException.class)
  public final ResponseEntity handleStudentNotFoundException(StudentNotFoundException ex,
      WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public final ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException ex,
      WebRequest request) {
    return new ResponseEntity<>("Operation not allowed as it violates a SQL constraint", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public final ResponseEntity handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex,
      WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
  }

}
