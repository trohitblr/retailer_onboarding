package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.Customer;
import com.jio.bahubali.model.request.OrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<OrderRequest, Customer> {}
