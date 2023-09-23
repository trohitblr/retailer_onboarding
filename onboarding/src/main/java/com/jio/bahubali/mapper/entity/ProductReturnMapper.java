package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.Product;
import com.jio.bahubali.entity.jpa.ProductReturns;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductReturnMapper extends EntityMapper<Product, ProductReturns> {

  @Mapping(source = "id", target = "productId")
  ProductReturns toEntity(Product dto);
}
