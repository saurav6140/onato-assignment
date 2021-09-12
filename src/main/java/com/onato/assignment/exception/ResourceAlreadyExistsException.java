package com.onato.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceAlreadyExistsException extends RuntimeException {

  public ResourceAlreadyExistsException() {super();}

  public ResourceAlreadyExistsException(String message) {
    super(message);
  }


}
