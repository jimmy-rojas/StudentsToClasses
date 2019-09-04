package com.organization.students_to_classes.exceptions;

/**
 * NotFoundException is a custom model which stores proper exception messages
 *
 */
public class NotFoundException extends Exception {

  public NotFoundException(String message) {
    super(message);
  }
}
