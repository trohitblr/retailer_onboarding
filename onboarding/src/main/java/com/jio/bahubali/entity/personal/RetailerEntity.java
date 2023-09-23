package com.jio.bahubali.entity.personal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("retailer")
public class RetailerEntity {

  @Id private UUID id;

  @Column("retailer_id")
  private String retailerId;

  @Column("owner_name")
  private String ownerName;

  @Column("store_name")
  private String storeName;

  @Column("retailer_mob")
  private String retailerMob;

  @Column("mob_verified")
  private boolean mobVerified;

  @Column("retailer_verified")
  private boolean retailerVerified;

  @Column("is_parent")
  private boolean isParent;

  private String parent;

  @Column("fos_id")
  private String fosId;

  @NonNull
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column("created_at")
  private LocalDateTime createdAt = LocalDateTime.now();

  @NonNull
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column("updated_at")
  private LocalDateTime updatedAt = LocalDateTime.now();

  // Constructors, getters, and setters
}
