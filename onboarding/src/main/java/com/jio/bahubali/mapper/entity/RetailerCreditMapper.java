package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.RetailerCredit;
import com.jio.bahubali.model.request.RetailerCreditBalance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RetailerCreditMapper extends EntityMapper<RetailerCreditBalance, RetailerCredit> {}
