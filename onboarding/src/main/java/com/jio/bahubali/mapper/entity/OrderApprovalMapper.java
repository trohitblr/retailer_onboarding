package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.OrderApproval;
import com.jio.bahubali.model.response.ApprovesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderApprovalMapper extends EntityMapper<ApprovesDTO, OrderApproval> {

  @Mapping(source = "level", target = "approvalLevel")
  OrderApproval toEntity(ApprovesDTO approvesDTO);
}
