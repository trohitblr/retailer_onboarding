package com.jio.bahubali.service.personal;

import com.jio.bahubali.entity.personal.RetailerEntity;
import com.jio.bahubali.entity.personal.RetailerMetaEntity;
import com.jio.bahubali.mapper.entity.personal.RetailerMetaMapper;
import com.jio.bahubali.repository.repository.RetailerMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RetailerMetaService {

  @Autowired RetailerMetaRepository retailerMetaRepository;

  @Autowired RetailerMetaMapper retailerMetaMapper;

  public Mono<RetailerMetaEntity> saveRetailerMetaDetails(
      Mono<RetailerEntity> retailerMono,
      com.jio.bahubali.model.persoanal.Retailer retailerRequest) {

    RetailerMetaEntity retailerMetaEntity =
        retailerMetaMapper.toEntity(retailerRequest.getRetailerMeta());

    return retailerMetaRepository.save(retailerMetaEntity);
  }

  public Mono<RetailerMetaEntity> updateRetailerMetaDetails(
      Mono<RetailerEntity> retailerMono,
      com.jio.bahubali.model.persoanal.Retailer retailerRequest) {
    return retailerMetaRepository
        .findByRetailerId(retailerRequest.getRetailerId())
        .flatMap(
            existingRetailersMeta -> {
              if (existingRetailersMeta == null) {
                RetailerMetaEntity newRetailerMetaEntity =
                    retailerMetaMapper.toEntity(retailerRequest.getRetailerMeta());
                return retailerMetaRepository.save(newRetailerMetaEntity);
              } else {
                RetailerMetaEntity updatedRetailerMeta =
                    retailerMetaMapper.toEntity(retailerRequest.getRetailerMeta());

                existingRetailersMeta.setRetailerId(updatedRetailerMeta.getRetailerId());
                existingRetailersMeta.setGstNumber(updatedRetailerMeta.getGstNumber());
                existingRetailersMeta.setLon(updatedRetailerMeta.getLon());
                existingRetailersMeta.setLat(updatedRetailerMeta.getLat());
                existingRetailersMeta.setStoreCategory(updatedRetailerMeta.getStoreCategory());
                existingRetailersMeta.setStoreDescription(
                    updatedRetailerMeta.getStoreDescription());
                existingRetailersMeta.setStoreOpeningClosingHours(
                    updatedRetailerMeta.getStoreOpeningClosingHours());
                existingRetailersMeta.setStoreSubCategory(
                    updatedRetailerMeta.getStoreSubCategory());
                return retailerMetaRepository.save(existingRetailersMeta);
              }
            });
  }

  public Mono<RetailerMetaEntity> getRetailerMetaInfo(String retailerId) {
    return retailerMetaRepository.findByRetailerId(retailerId);
  }
}
