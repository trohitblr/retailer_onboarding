package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.RetailerCreditAudit;
import com.jio.bahubali.model.request.RetailerCreditBalance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RetailerCreditAuditMapper
    extends EntityMapper<RetailerCreditBalance, RetailerCreditAudit> {}
