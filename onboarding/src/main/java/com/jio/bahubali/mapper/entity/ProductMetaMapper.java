package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.ProductMeta;
import com.jio.bahubali.model.request.ProductMetaRequest;
import com.jio.bahubali.model.request.ProductRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMetaMapper extends EntityMapper<ProductRequest, ProductMeta> {

  ProductMeta toEntity(ProductRequest productRequest);

  ProductMeta toEntity(ProductMetaRequest productMetaRequest);

  @Named("partialUpdate")
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void partialUpdate(@MappingTarget ProductMeta entity, ProductMetaRequest dto);
}
