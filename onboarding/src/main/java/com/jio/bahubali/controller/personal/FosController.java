package com.jio.bahubali.controller.personal;

import com.jio.bahubali.model.persoanal.Fos;
import com.jio.bahubali.model.persoanal.FosLoginForm;
import com.jio.bahubali.service.personal.FosService;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class FosController {

  @Autowired private FosService fosService;

  @PostMapping(value = "/create")
  public Mono<String> onboardRetailer(@RequestBody Fos fos) {
    return fosService.saveFosDetails(fos).flatMap(success -> Mono.just("Fos Created"));
  }

  @GetMapping(value = "/get-store-details", produces = "application/json")
  public ResponseEntity<Map<String, String>> getStoreDetails(
      @RequestParam Date toDate, @RequestParam Date fromDate, @RequestParam Date fosId) {
    return new ResponseEntity<>(Collections.singletonMap("status", "up"), HttpStatus.OK);
  }

  @PostMapping(value = "/sign-in")
  public Mono<Boolean> validateFos(@RequestBody FosLoginForm fosLoginForm) {
    return fosService.validateFos(fosLoginForm);
  }
}
