package com.jio.bahubali.exception;

import com.jio.bahubali.model.response.CustomResponseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public @ResponseBody CustomResponseEntity handleArgumentException(
      MethodArgumentNotValidException ex) {
    List<String> errors = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      errors.add(error.getDefaultMessage());
    }
    return CustomResponseEntity.buildErrorResponse(errors.toString(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(OnboardingException.class)
  public @ResponseBody CustomResponseEntity handleException(final OnboardingException e) {
    if (e.getErrorCode().getCode() == 400) {
      return CustomResponseEntity.buildErrorResponse(
          e.getMessage(), e.getErrorCode(), HttpStatus.BAD_REQUEST);
    } else if (e.getErrorCode().getCode() == 404) {
      return CustomResponseEntity.buildErrorResponse(
          e.getMessage(), e.getErrorCode(), HttpStatus.NOT_FOUND);
    } else if (e.getErrorCode().getCode() == 403) {
      return CustomResponseEntity.buildErrorResponse(
          e.getMessage(), e.getErrorCode(), HttpStatus.FORBIDDEN);
    } else {
      return CustomResponseEntity.buildErrorResponse(
          e.getMessage(), e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
