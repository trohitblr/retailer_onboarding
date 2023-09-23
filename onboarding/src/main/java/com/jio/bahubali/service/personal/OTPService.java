package com.jio.bahubali.service.personal;

import com.jio.bahubali.model.persoanal.OtpResponse;
import com.jio.bahubali.model.persoanal.OtpVerification;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OTPService {

  public Mono<OtpResponse> triggerRetailerOtp(String mobNumber) {

    OtpResponse otpResponse = new OtpResponse("1", mobNumber, "OTP has been sent to " + mobNumber);
    return Mono.just(otpResponse);
  }

  public Mono<Boolean> verifyOtp(OtpVerification otpVerification) {

    if (otpVerification.getOtp().equals("test123") && otpVerification.getReference().equals("1")) {
      Mono.just(true);
    }
    return Mono.just(false);
  }
}
