package com.jio.bahubali.controller.personal;

import java.util.Collections;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageProcessingController {

  @PostMapping(value = "/upload-images", produces = "application/json")
  @ResponseBody
  public ResponseEntity<Map<String, String>> onboardRetailer(String retailerId) {
    return new ResponseEntity<>(Collections.singletonMap("status", "up"), HttpStatus.OK);
  }
}
