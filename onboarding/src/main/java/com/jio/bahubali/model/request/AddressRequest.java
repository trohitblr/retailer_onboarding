package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jio.bahubali.enums.AddressType;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequest implements Serializable {

  @JsonAlias({"billing_address_id", "shipping_address_id"})
  private String addressId;

  @JsonProperty("flat_no")
  private String flatNo;

  @JsonProperty("floor_no")
  private String floorNo;

  @JsonProperty("block_no")
  private String blockNo;

  @JsonProperty("building_name")
  private String buildingName;

  @JsonProperty("society_name")
  private String societyName;

  @JsonProperty("plot_no")
  private String plotNo;

  private String street;

  private String sector;

  private String area;

  private String city;

  private String state;

  private Long pincode;

  private String country;

  private String landmark;

  @JsonProperty("addresstype")
  private AddressType addressType;

  @JsonProperty("apartment_id")
  private String apartmentId;

  @JsonProperty("addressee_name")
  private String addresseeName;

  @JsonProperty("addressee_mobile_no")
  private String addresseeMobileNo;

  @JsonProperty("tower_no")
  private String towerNo;

  @JsonProperty("building_type")
  private String buildingType;

  private String lat;

  private String lon;

  @JsonProperty("is_valid_location")
  private Boolean isValidLocation;

  @JsonProperty("state_code")
  private String stateCode;
}
