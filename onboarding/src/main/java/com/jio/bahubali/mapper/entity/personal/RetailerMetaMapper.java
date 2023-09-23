package com.jio.bahubali.mapper.entity.personal;

import com.jio.bahubali.entity.personal.RetailerMetaEntity;
import com.jio.bahubali.mapper.entity.EntityMapper;
import com.jio.bahubali.model.persoanal.RetailerMeta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RetailerMetaMapper extends EntityMapper<RetailerMeta, RetailerMetaEntity> {}
