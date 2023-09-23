package com.jio.bahubali.config;

import org.springframework.stereotype.Component;

@Component
public class InvoiceNumberGenerator {
  private static int invoiceCounter = 1;

  public static String generateInvoiceNumber() {
    String prefix = "DMS-";
    String sequentialNumber = String.format("%04d", invoiceCounter);

    invoiceCounter++; // Increment the counter for the next invoice

    return prefix + sequentialNumber;
  }
}

/*  Mono<Long> sequenceNumberMono = invoiceSequenceRepository.getNextSequenceValue();
sequenceNumberMono.subscribe(sequenceNumber -> {
        invoice.setSequenceNumber(sequenceNumber);
        String invoiceNumber = prefix + String.format("%04d", sequenceNumber);
        invoice.setInvoiceNumber(invoiceNumber);
        invoiceRepository.save(invoice).subscribe();
        });*/
