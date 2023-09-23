package com.jio.bahubali.entity.personal;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "retailer_meta")
public class RetailerMetaEntity {
  @Id private int id;

  @Column("retailer_id")
  private String retailerId;

  @Column("gst_number")
  private String gstNumber;

  @Column("store_category")
  private String storeCategory;

  @Column("store_sub_category")
  private String storeSubCategory;

  private float lat;
  private float lon;

  @Column("store_start_date")
  private LocalDateTime storeStartDate;

  @Column("store_opening_start_hours")
  private LocalDateTime storeOpeningStartHours;

  @Column("store_opening_closing_hours")
  private LocalDateTime storeOpeningClosingHours;

  @Column("store_description")
  private String storeDescription;

  @Column("store_speciality")
  private String storeSpeciality;

  // Constructors, getters, and setters
}
