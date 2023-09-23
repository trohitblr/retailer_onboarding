package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.DeliverySlot;
import com.jio.bahubali.model.request.DeliverySlotRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {DateMapper.class})
public interface DeliverySlotMapper extends EntityMapper<DeliverySlotRequest, DeliverySlot> {

  @Mapping(target = "deliveryDate", source = "deliverySlotRequest.date", dateFormat = "dd-MM-yyyy")
  DeliverySlot toEntity(DeliverySlotRequest deliverySlotRequest);
}
