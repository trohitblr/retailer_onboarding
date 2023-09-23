package com.jio.bahubali.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxSlabes {

  Double igstAmount = 0.0;
  Double cgstAmount = 0.0;
  Double sgstAmount = 0.0;
  Double cessAmount = 0.0;
}
