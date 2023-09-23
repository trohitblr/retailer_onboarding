package com.jio.bahubali.model.persoanal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpResponse {

  private String requestId;

  private String mobNo;

  private String msg;
}
