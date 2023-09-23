package com.jio.bahubali.exception;

import com.jio.bahubali.enums.ErrorCode;
import lombok.Getter;

@Getter
public class OnboardingException extends RuntimeException {

  private ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
  private String message;

  public OnboardingException(Exception exception) {
    super(exception);
    message = exception.getMessage();
  }

  public OnboardingException(Throwable exception, ErrorCode error, String errorMessage) {
    super(exception);
    errorCode = error;
    message = errorMessage;
  }

  public OnboardingException(Throwable exception, ErrorCode error) {
    super(exception);
    errorCode = error;
    message = error.getMessage();
  }

  public OnboardingException(Throwable exception) {
    super(exception);
    message = exception.getMessage();
  }

  public OnboardingException(String message, ErrorCode errorCode) {
    this.message = message;
    this.errorCode = errorCode;
  }

  public OnboardingException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public OnboardingException(Exception exception, String message) {
    this(exception);
    this.message = message;
  }

  public OnboardingException(String message) {
    this.message = message;
  }
}
