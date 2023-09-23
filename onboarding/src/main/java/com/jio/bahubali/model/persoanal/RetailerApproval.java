package com.jio.bahubali.model.persoanal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetailerApproval {

  private String retailerId;

  private boolean isVerified;
}
