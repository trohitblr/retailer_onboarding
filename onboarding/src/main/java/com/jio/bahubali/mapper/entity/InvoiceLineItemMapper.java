package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.InvoiceLineItem;
import com.jio.bahubali.entity.jpa.InvoiceProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceLineItemMapper extends EntityMapper<InvoiceProduct, InvoiceLineItem> {}
