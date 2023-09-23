package com.jio.bahubali.entity.jpa;

import com.jio.bahubali.enums.AddressDetailsType;
import com.jio.bahubali.enums.AddressType;
import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("address_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address extends BaseEntity {

  @Id private UUID id;

  @Column("order_id")
  private String orderId;

  @Column("address_id")
  private String addressId;

  @Column("address_detail_type")
  private AddressDetailsType addressDetailType;

  @Column("flat_no")
  private String flatNo;

  @Column("floor_no")
  private String floorNo;

  @Column("block_no")
  private String blockNo;

  @Column("building_name")
  private String buildingName;

  @Column("society_name")
  private String societyName;

  @Column("plot_no")
  private String plotNo;

  @Column("street")
  private String street;

  @Column("sector")
  private String sector;

  @Column("area")
  private String area;

  @Column("city")
  private String city;

  @Column("state")
  private String state;

  @Column("pincode")
  private Long pincode;

  @Column("country")
  private String country;

  @Column("landmark")
  private String landmark;

  @Column("address_type")
  private AddressType addresstype;

  @Column("apartment_id")
  private String apartmentId;

  @Column("addressee_name")
  private String addresseeName;

  @Column("addressee_mobile_no")
  private String addresseeMobileNo;

  @Column("tower_no")
  private String towerNo;

  @Column("building_type")
  private String buildingType;

  @Column("latitude")
  private String lat;

  @Column("longitude")
  private String lon;

  @Column("is_valid_location")
  private Boolean isValidLocation;

  @Column("state_code")
  private String stateCode;

  @Column("delivery_date")
  private Date deliveryDate;

  @Column("start_hour")
  private String startHour;

  @Column("end_hour")
  private String endHour;
}
