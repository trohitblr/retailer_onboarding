package com.jio.bahubali.entity.personal;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "sub_category")
public class SubCategory {
  @Id private int id;

  @Column("category_id")
  private int categoryId;

  @Column("sub_category_id")
  private String subCategoryId;

  private int description;

  @Column("created_at")
  private Date createdAt;

  @Column("updated_at")
  private Date updatedAt;
}
