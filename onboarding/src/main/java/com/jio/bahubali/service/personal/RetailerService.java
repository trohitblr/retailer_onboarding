package com.jio.bahubali.service.personal;

import com.jio.bahubali.entity.personal.RetailerAddressEntity;
import com.jio.bahubali.entity.personal.RetailerEntity;
import com.jio.bahubali.entity.personal.RetailerMetaEntity;
import com.jio.bahubali.mapper.entity.personal.RetailerMapper;
import com.jio.bahubali.model.persoanal.*;
import com.jio.bahubali.repository.repository.RetailerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RetailerService {

  @Autowired RetailerRepository retailerRepository;

  @Autowired RetailerMapper retailerMapper;

  @Autowired RetailerMetaService retailerMetaService;

  @Autowired RetailerAddressService retailerAddressService;

  public Mono<RetailerEntity> saveRetailerDetails(Retailer retailer) {
    RetailerEntity retailerEntity = retailerMapper.toEntity(retailer);
    return retailerRepository
        .save(retailerEntity)
        .flatMap(
            savedRetailer -> {
              return retailerAddressService
                  .saveRetailerAddressDetails(Mono.just(savedRetailer), retailer)
                  .thenReturn(savedRetailer);
            })
        .flatMap(
            savedRetailer -> {
              return retailerMetaService
                  .saveRetailerMetaDetails(Mono.just(savedRetailer), retailer)
                  .thenReturn(savedRetailer);
            });
  }

  /* public Mono<RetailerEntity> updateRetailer(Retailer retailer) {

      Mono<RetailerEntity> retailerEntityMono = retailerRepository.findByRetailerId(retailer.getRetailerId());





      RetailerEntity retailerEntity = retailerMapper.toEntity(retailer);
      return  retailerRepository.save(retailerEntity)
              .flatMap(savedRetailer -> {
                  return retailerAddressService.saveRetailerAddressDetails(Mono.just(savedRetailer),retailer)
                          .thenReturn(savedRetailer);
              })
              .flatMap(savedRetailer -> {
                  return retailerMetaService.saveRetailerMetaDetails(Mono.just(savedRetailer),retailer)
                          .thenReturn(savedRetailer);
              });
  }*/

  public Mono<RetailerEntity> updateRetailerDetails(Retailer retailer) {
    return retailerRepository
        .findByRetailerId(retailer.getRetailerId())
        .flatMap(
            existingRetailer -> {
              if (existingRetailer == null) {
                return saveRetailerDetails(retailer);
              } else {
                RetailerEntity updatedRetailerEntity = retailerMapper.toEntity(retailer);

                existingRetailer.setRetailerId(updatedRetailerEntity.getRetailerId());
                existingRetailer.setFosId(updatedRetailerEntity.getFosId());

                return retailerRepository
                    .save(existingRetailer)
                    .flatMap(
                        updatedOne -> {
                          return retailerAddressService
                              .updateRetailerAddressDetails(Mono.just(updatedOne), retailer)
                              .thenReturn(updatedOne);
                        })
                    .flatMap(
                        updatedOne -> {
                          return retailerMetaService
                              .updateRetailerMetaDetails(Mono.just(updatedOne), retailer)
                              .thenReturn(updatedOne);
                        });
              }
            });
  }

  public Mono<Retailer> getRetailerInfo(String retailerId) {

    Mono<RetailerEntity> retailerDetailMono = retailerRepository.findByRetailerId(retailerId);

    Mono<RetailerMetaEntity> retailerMetaMono = retailerMetaService.getRetailerMetaInfo(retailerId);

    Mono<RetailerAddressEntity> retailerAddMono =
        retailerAddressService.getRetailerAddressInfo(retailerId);

    Mono<Retailer> retailerMono =
        Mono.zip(retailerDetailMono, retailerMetaMono, retailerAddMono)
            .map(
                tuple -> {
                  RetailerEntity retailerEntity = tuple.getT1();
                  RetailerMetaEntity retailerMetaEntity = tuple.getT2();
                  RetailerAddressEntity retailerAddressEntity = tuple.getT3();

                  Retailer retailer = new Retailer();
                  retailer.setRetailerId(retailerEntity.getRetailerId());
                  retailer.setOwnerName(retailerEntity.getOwnerName());
                  retailer.setStoreName(retailerEntity.getStoreName());
                  retailer.setRetailerMob(retailerEntity.getRetailerMob());
                  retailer.setMobVerified(retailerEntity.isMobVerified());
                  retailer.setRetailerVerified(retailerEntity.isRetailerVerified());

                  retailer.setFosId(retailerEntity.getFosId());

                  RetailerMeta retailerMeta = new RetailerMeta();

                  retailerMeta.setGstNumber(retailerMetaEntity.getGstNumber());
                  retailerMeta.setLon(retailerMetaEntity.getLon());
                  retailerMeta.setStoreCategory(retailerMetaEntity.getStoreCategory());
                  retailerMeta.setStoreDescription(retailerMetaEntity.getStoreDescription());
                  retailerMeta.setLat(retailerMetaEntity.getLat());
                  retailerMeta.setStoreDescription(retailerMetaEntity.getStoreDescription());
                  retailerMeta.setStoreSpeciality(retailerMetaEntity.getStoreSpeciality());
                  retailerMeta.setStoreOpeningClosingHours(
                      retailerMetaEntity.getStoreOpeningClosingHours());

                  RetailerAddress retailerAddress = new RetailerAddress();
                  retailerAddress.setArea(retailerAddressEntity.getArea());
                  retailerAddress.setRoad(retailerAddressEntity.getRoad());
                  retailerAddress.setLocality(retailerAddressEntity.getLocality());
                  retailerAddress.setStreet(retailerAddressEntity.getStreet());
                  retailerAddress.setPincode(retailerAddressEntity.getPincode());
                  retailerAddress.setState(retailerAddressEntity.getState());

                  retailer.setRetailerMeta(retailerMeta);
                  retailer.setRetailerAddress(retailerAddress);

                  return retailer;
                });

    return retailerMono;
  }

  public Flux<Retailer> getFosOnboardedRetailers(String fosId) {

    // return retailerRepository.getFosOnboaredRetailers(fosId);
    return null;
  }

  public Flux<Retailer> getRetailersByLocation(String city) {

    // return retailerRepository.getRetailerByLocation(city);
    return null;
  }

  public Mono<Boolean> approveRetailer(RetailerApproval retailerApproval) {

    // return retailerRepository.getRetailerByLOcation(city);

    return Mono.just(true);
  }
}
