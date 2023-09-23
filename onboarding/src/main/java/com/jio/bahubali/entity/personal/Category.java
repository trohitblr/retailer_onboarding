package com.jio.bahubali.entity.personal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column("category_id")
  private int categoryId;

  private String name;
  private int description;

  @Column("created_at")
  private Date createdAt;

  @Column("updated_at")
  private Date updatedAt;
}
