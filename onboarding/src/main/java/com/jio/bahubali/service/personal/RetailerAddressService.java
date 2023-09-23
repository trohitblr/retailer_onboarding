package com.jio.bahubali.service.personal;

import com.jio.bahubali.entity.personal.RetailerAddressEntity;
import com.jio.bahubali.entity.personal.RetailerEntity;
import com.jio.bahubali.mapper.entity.personal.RetailerAddressMapper;
import com.jio.bahubali.repository.repository.RetailerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RetailerAddressService {

  @Autowired RetailerAddressMapper retailerAddressMapper;

  @Autowired RetailerAddressRepository retailerAddressRepository;

  public Mono<RetailerAddressEntity> saveRetailerAddressDetails(
      Mono<RetailerEntity> retailerMono,
      com.jio.bahubali.model.persoanal.Retailer retailerRequest) {

    RetailerAddressEntity retailerAddressEntity =
        retailerAddressMapper.toEntity(retailerRequest.getRetailerAddress());

    return retailerAddressRepository.save(retailerAddressEntity);
  }

  /* public Mono<RetailerAddressEntity> updateRetailerAddressDetails(Mono<RetailerEntity> retailerMono , com.jio.bahubali.model.persoanal.Retailer retailerRequest){

          return retailerAddressRepository.findByRetailerId(retailerRequest.getRetailerId()).flatMap(
                  existingRetailerAdd -> {
                      existingRetailerAdd =  retailerAddressMapper.toEntity(retailerRequest.getRetailerAddress());
                      return retailerAddressRepository.save(existingRetailerAdd);

                  }
          );
      }
  */
  /* public Mono<RetailerAddressEntity> updateRetailerAddressDetails(Mono<RetailerEntity> retailerMono, com.jio.bahubali.model.persoanal.Retailer retailerRequest) {
          return retailerAddressRepository.findByRetailerId(retailerRequest.getRetailerId()).
                          flatMap(existingRetailerAddress -> {
              // RetailerAddressEntity existingRetailerAddress = existingRetailer.getRetailerAddress();

              if (existingRetailerAddress == null) {
                  // Handle the case where the retailer doesn't have an existing address
                  // You can create a new address entity and set it to the retailer
                  existingRetailerAddress = retailerAddressMapper.toEntity(retailerRequest.getRetailerAddress());
                  // existingRetailer.setRetailerAddress(existingRetailerAddress);
              } else {
                  // Update the existing retailer address with the new data
                  existingRetailerAddress = retailerAddressMapper.toEntity(retailerRequest.getRetailerAddress());
                 // existingRetailerAddress.updateFields(updatedRetailerAddress);
              }

              // Save the updated retailer entity
              return retailerAddressRepository.save(existingRetailerAddress)
                      .thenReturn(existingRetailerAddress);
          });
      }
  */

  public Mono<RetailerAddressEntity> updateRetailerAddressDetails(
      Mono<RetailerEntity> retailerMono,
      com.jio.bahubali.model.persoanal.Retailer retailerRequest) {
    return retailerMono.flatMap(
        existingRetailer -> {
          return retailerAddressRepository
              .findByRetailerId(retailerRequest.getRetailerId())
              .flatMap(
                  existingRetailerAddress -> {
                    if (existingRetailerAddress == null) {
                      // Handle the case where the retailer doesn't have an existing address
                      // You can create a new address entity and set its properties from
                      // retailerRequest
                      RetailerAddressEntity newRetailerAddress =
                          retailerAddressMapper.toEntity(retailerRequest.getRetailerAddress());
                      return retailerAddressRepository.save(newRetailerAddress);
                    } else {
                      // Update the existing retailer address entity's properties with the new data
                      RetailerAddressEntity updatedRetailerAddress =
                          retailerAddressMapper.toEntity(retailerRequest.getRetailerAddress());
                      existingRetailerAddress.setRetailerId(updatedRetailerAddress.getRetailerId());
                      existingRetailerAddress.setArea(updatedRetailerAddress.getArea());
                      existingRetailerAddress.setRoad(updatedRetailerAddress.getRoad());
                      existingRetailerAddress.setPincode(updatedRetailerAddress.getPincode());
                      existingRetailerAddress.setLocality(updatedRetailerAddress.getLocality());
                      // Update other properties as needed

                      // Save the updated retailer address entity
                      return retailerAddressRepository.save(existingRetailerAddress);
                    }
                  });
        });
  }

  public Mono<RetailerAddressEntity> getRetailerAddressInfo(String retailerId) {
    return retailerAddressRepository.findByRetailerId(retailerId);
  }
}
