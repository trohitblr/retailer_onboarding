package com.jio.bahubali.mapper.entity.personal;

import com.jio.bahubali.entity.personal.FosEntity;
import com.jio.bahubali.mapper.entity.EntityMapper;
import com.jio.bahubali.model.persoanal.Fos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FosMapper extends EntityMapper<Fos, FosEntity> {}
