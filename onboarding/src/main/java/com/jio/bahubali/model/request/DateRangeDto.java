package com.jio.bahubali.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DateRangeDto {

  @NotBlank(message = "Start date can't be null/empty")
  String startDate;

  @NotBlank(message = "End date can't be null/empty")
  String endDate;
}
