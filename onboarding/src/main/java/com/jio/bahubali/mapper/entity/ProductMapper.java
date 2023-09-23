package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.Product;
import com.jio.bahubali.model.request.OrderItemProductDTO;
import com.jio.bahubali.model.request.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductRequest, Product> {

  Product toEntity(ProductRequest productRequest);

  Product toEntity(OrderItemProductDTO orderItemProductDTO);
}
