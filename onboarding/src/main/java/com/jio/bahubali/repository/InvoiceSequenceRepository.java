package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.InvoiceSequence;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface InvoiceSequenceRepository extends ReactiveCrudRepository<InvoiceSequence, String> {
  // @Query("UPDATE invoice_sequence SET next_value = next_value + 1 WHERE sequence_name =
  // 'invoice_sequence'")

  @Query("SELECT next_value FROM invoice_sequence WHERE sequence_name = 'invoice_sequence';")
  Mono<Long> getNextSequenceValue();

  @Query(
      "UPDATE invoice_sequence SET next_value = next_value + 1 WHERE sequence_name = 'invoice_sequence'")
  Mono<Long> updateNextSequenceValue();
}
