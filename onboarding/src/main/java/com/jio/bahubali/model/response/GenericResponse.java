package com.jio.bahubali.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jio.bahubali.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponse {

  private Status status;

  private String msg;
}
