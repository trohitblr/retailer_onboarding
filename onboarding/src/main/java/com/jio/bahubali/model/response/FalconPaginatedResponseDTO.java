package com.jio.bahubali.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FalconPaginatedResponseDTO<T> {

  Integer size;

  Integer page;

  Integer totalElements;

  T data;
}
