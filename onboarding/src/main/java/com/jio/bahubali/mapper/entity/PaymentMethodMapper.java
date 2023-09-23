package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.PaymentMethod;
import com.jio.bahubali.model.request.PaymentMethodRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper extends EntityMapper<PaymentMethodRequest, PaymentMethod> {}
