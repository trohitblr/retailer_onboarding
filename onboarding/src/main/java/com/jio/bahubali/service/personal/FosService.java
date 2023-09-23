package com.jio.bahubali.service.personal;

import com.jio.bahubali.entity.personal.FosEntity;
import com.jio.bahubali.mapper.entity.personal.FosMapper;
import com.jio.bahubali.model.persoanal.Fos;
import com.jio.bahubali.model.persoanal.FosLoginForm;
import com.jio.bahubali.repository.repository.FosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FosService {

  @Autowired FosRepository fosRepository;

  @Autowired FosMapper fosMapper;

  public Mono<FosEntity> saveFosDetails(Fos fos) {
    FosEntity fosEntity = fosMapper.toEntity(fos);
    return fosRepository.save(fosEntity);
  }

  public Mono<Boolean> validateFos(FosLoginForm fosLoginForm) {

    Mono<FosEntity> fosEntityMono =
        fosRepository.validateFos(fosLoginForm.getFosId(), fosLoginForm.getPassword());

    Mono<Boolean> resultMono = fosEntityMono.hasElement().map(hasValue -> hasValue ? true : false);

    return resultMono;
  }
}
