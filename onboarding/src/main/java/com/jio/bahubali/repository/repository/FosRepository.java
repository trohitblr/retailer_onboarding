package com.jio.bahubali.repository.repository;

import com.jio.bahubali.entity.personal.FosEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FosRepository extends R2dbcRepository<FosEntity, UUID> {
  @Query(
      " select "
          + " f.fos_id,"
          + " f.name "
          + " from fos f "
          + " where f.fos_id = (:userName) AND f.password = (:password)")
  Mono<FosEntity> validateFos(
      @Param("userName") String userName, @Param("password") String password);
}
