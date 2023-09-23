package com.jio.bahubali.controller.personal;

import com.jio.bahubali.model.persoanal.OtpResponse;
import com.jio.bahubali.model.persoanal.OtpVerification;
import com.jio.bahubali.service.personal.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class OtpController {

  @Autowired OTPService otpService;

  @GetMapping(value = "/otp", produces = "application/json")
  public Mono<OtpResponse> getOtp(String mobNo) {
    return otpService.triggerRetailerOtp(mobNo);
  }

  @PostMapping(value = "/verify-user", produces = "application/json")
  public Mono<Boolean> verifyOtp(@RequestBody OtpVerification otpVerification) {
    return otpService.verifyOtp(otpVerification);
  }
}
