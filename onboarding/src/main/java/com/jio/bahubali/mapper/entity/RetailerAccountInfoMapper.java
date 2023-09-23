package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.RetailerAccount;
import com.jio.bahubali.model.response.RetailerAccountInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RetailerAccountInfoMapper
    extends EntityMapper<com.jio.bahubali.entity.jpa.RetailerAccountInfo, RetailerAccountInfo> {

  @Named("toDto")
  RetailerAccountInfo toDto(com.jio.bahubali.entity.jpa.RetailerAccountInfo retailerAccountInfo);

  @Named("toEntity")
  RetailerAccount toEntity(com.jio.bahubali.model.request.RetailerAccount retailerAccountInfo);
  // RetailerAccountInfo toDTO(com.jio.bahubali.entity.jpa.RetailerAccountInfo retailerAccountInfo);

  // RetailerAccountInfo toDTO(com.jio.bahubali.entity.jpa.RetailerAccountInfo retailerAccountInfo);
}
