package com.jio.bahubali.model.response;

import com.jio.bahubali.constants.OrderGuruConstants;
import com.jio.bahubali.enums.ErrorCode;
import com.jio.bahubali.model.response.wrapper.ResponseWrapper;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseEntity extends ResponseEntity<ResponseWrapper> {

  private CustomResponseEntity(ResponseWrapper body, HttpStatus httpStatus) {
    super(body, httpStatus);
  }

  public static CustomResponseEntity buildSuccessResponse(Object payload) {
    ResponseWrapper responseWrapper = new ResponseWrapper();
    responseWrapper.setData(payload);
    responseWrapper.setTimestamp(new Date().getTime());
    responseWrapper.setStatus(ResponseWrapper.Status.SUCCESS);
    return new CustomResponseEntity(responseWrapper, HttpStatus.OK);
  }

  public static CustomResponseEntity buildErrorResponse(String message, HttpStatus httpStatus) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put(OrderGuruConstants.ERROR_MESSAGE, message);

    ResponseWrapper responseWrapper = new ResponseWrapper();
    responseWrapper.setData(map);
    responseWrapper.setTimestamp(new Date().getTime());
    responseWrapper.setStatus(ResponseWrapper.Status.ERROR);
    return new CustomResponseEntity(responseWrapper, httpStatus);
  }

  public static CustomResponseEntity buildErrorResponse(
      String message, ErrorCode errorCode, HttpStatus httpStatus) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put(OrderGuruConstants.ERROR_MESSAGE, message);
    map.put(OrderGuruConstants.ERROR_CODE, String.valueOf(errorCode.getCode()));
    ResponseWrapper responseWrapper = new ResponseWrapper();
    responseWrapper.setData(map);
    responseWrapper.setTimestamp(new Date().getTime());
    responseWrapper.setStatus(ResponseWrapper.Status.ERROR);
    return new CustomResponseEntity(responseWrapper, httpStatus);
  }
}
