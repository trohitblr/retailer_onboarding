package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Invoice;
import com.jio.bahubali.entity.jpa.InvoiceData;
import com.jio.bahubali.enums.PDFType;
import com.jio.bahubali.model.request.DmsInvoiceResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvoiceService {

  Flux<Invoice> generateInvoice(String orderId);

  Mono<InvoiceData> getInvoice(String orderId);

  void generateInvoiceThroughKafka(DmsInvoiceResponse dmsInvoiceResponse);

  void pushDataIntoKafka(DmsInvoiceResponse dmsInvoiceResponse);

  Mono<Invoice> getInvoiceContent(String orderId);

  byte[] convertHtmlToPdf(String htmlTemplate);

  Mono<Invoice> getPickListContent(String orderId);

  Mono<InvoiceData> reGenerateInvoice(String orderId);

  Mono<byte[]> getBulkInvoice(String fromDate, String toDate, PDFType pdfType, String prmId);
}
