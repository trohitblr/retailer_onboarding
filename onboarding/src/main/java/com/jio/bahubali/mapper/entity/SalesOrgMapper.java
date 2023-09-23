package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.SalesOrgInfo;
import com.jio.bahubali.model.request.ProductRequest;
import com.jio.bahubali.model.request.SalesOrgCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalesOrgMapper extends EntityMapper<SalesOrgCreateRequest, SalesOrgInfo> {

  SalesOrgInfo toEntity(ProductRequest productRequest);
}
