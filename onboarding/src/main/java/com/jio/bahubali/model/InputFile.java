package com.jio.bahubali.model;

import java.time.LocalDateTime;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "input_file")
public class InputFile {

  @Id private String id;
  private String fileName;
  private String fileUrl;
  private String cdnUrl;
  private String generationId;
  private Integer size;
  private LocalDateTime createdTime;
  private LocalDateTime updatedTime;

  public InputFile(String fileName, String fileUrl) {
    this.fileName = fileName;
    this.fileUrl = fileUrl;
  }
}
