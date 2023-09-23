package com.jio.bahubali.model.persoanal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

  private int id;
  private int categoryId;
  private String name;
  private int description;
  private Date createdAt;
  private Date updatedAt;
}
