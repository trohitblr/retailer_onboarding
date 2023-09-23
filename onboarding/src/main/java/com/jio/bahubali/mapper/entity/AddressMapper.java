package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.Address;
import com.jio.bahubali.model.request.AddressRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressRequest, Address> {}
