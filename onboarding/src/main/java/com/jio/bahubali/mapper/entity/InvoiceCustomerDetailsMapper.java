package com.jio.bahubali.mapper.entity;

import com.jio.bahubali.entity.jpa.InvoiceCustomerDetails;
import com.jio.bahubali.model.request.DmsInvoiceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceCustomerDetailsMapper
    extends EntityMapper<DmsInvoiceResponse, InvoiceCustomerDetails> {}
