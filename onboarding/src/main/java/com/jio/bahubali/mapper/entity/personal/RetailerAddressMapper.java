package com.jio.bahubali.mapper.entity.personal;

import com.jio.bahubali.entity.personal.RetailerAddressEntity;
import com.jio.bahubali.mapper.entity.EntityMapper;
import com.jio.bahubali.model.persoanal.RetailerAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RetailerAddressMapper
    extends EntityMapper<RetailerAddress, RetailerAddressEntity> {}
