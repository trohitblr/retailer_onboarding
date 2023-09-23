package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.config.InvoiceNumberGenerator;
import com.jio.bahubali.entity.jpa.Invoice;
import com.jio.bahubali.entity.jpa.OrderInvoiceData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {InvoiceNumberGenerator.class})
public interface InvoiceMapper extends EntityMapper<OrderInvoiceData, Invoice> {

  @Override
  @Mapping(target = "invoiceDate", expression = "java(LocalDateTime.now())")
  Invoice toEntity(OrderInvoiceData dto);
}
