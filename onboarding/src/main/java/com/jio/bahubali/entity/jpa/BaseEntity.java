package com.jio.bahubali.entity.jpa;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.relational.core.mapping.Column;

@Data
public abstract class BaseEntity implements Serializable {

  @Column("created_by")
  private String createdBy;

  @Column("updated_by")
  private String updatedBy;

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
}
