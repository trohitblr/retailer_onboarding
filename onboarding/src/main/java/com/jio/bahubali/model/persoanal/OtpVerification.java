package com.jio.bahubali.model.persoanal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpVerification {

  private String reference;

  private String otp;
}
