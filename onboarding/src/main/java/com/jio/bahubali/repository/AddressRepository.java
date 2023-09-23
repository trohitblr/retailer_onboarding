package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.Address;
import com.jio.bahubali.mapper.entity.InvoiceAddress;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AddressRepository extends R2dbcRepository<Address, UUID> {

  @Query(
      "SELECT address_detail_type, CONCAT_WS(', ', apartment_id, area, block_no, building_name, "
          + "building_type, flat_no, floor_no, plot_no, "
          + "sector, society_name, street, landmark, pincode, "
          + "city, state, state_code, country) "
          + "AS address\n"
          + "FROM address_details \n"
          + "WHERE order_id = :orderId AND (address_detail_type = 'BILLING' \n"
          + "   OR address_detail_type = 'SHIPPING'); ")
  Flux<InvoiceAddress> findByOrderId(@Param("orderId") String orderId);
}
