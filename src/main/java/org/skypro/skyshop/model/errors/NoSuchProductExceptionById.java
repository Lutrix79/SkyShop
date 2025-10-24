package org.skypro.skyshop.model.errors;

public class NoSuchProductExceptionById extends RuntimeException {
  public NoSuchProductExceptionById(String message) {
    super(message);
  }
}
