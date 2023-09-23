package com.jio.bahubali.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerInfo {

  String id;
  String name;
  Long phoneNumber;
  String emailId;
  String address;
}
