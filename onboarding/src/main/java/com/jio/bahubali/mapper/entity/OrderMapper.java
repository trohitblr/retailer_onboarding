package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.model.request.OrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderRequest, Order> {}
