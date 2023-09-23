package com.jio.bahubali.entity.personal;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("retailer_media")
public class RetailerMedia {
  @Id private int id;

  @Column("retailer_id")
  private int retailerId;

  @Column("retailer_media_id")
  private int retailerMediaId;

  @Column("retailer_image_url")
  private String retailerImageUrl;

  @Column("retailer_vdo_url")
  private int retailerVideoUrl;

  @Column("created_at")
  private Date createdAt;

  @Column("updated_at")
  private Date updatedAt;

  // Constructors, getters, and setters
}
