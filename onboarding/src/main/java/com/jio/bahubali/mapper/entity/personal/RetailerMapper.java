package com.jio.bahubali.mapper.entity.personal;

import com.jio.bahubali.entity.personal.RetailerEntity;
import com.jio.bahubali.mapper.entity.EntityMapper;
import com.jio.bahubali.model.persoanal.Retailer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RetailerMapper extends EntityMapper<Retailer, RetailerEntity> {}
