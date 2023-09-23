package com.jio.bahubali.service;

import com.jio.bahubali.model.request.RetailerCreditBalance;
import com.jio.bahubali.model.request.RetailerOnboard;
import com.jio.bahubali.model.response.GenericResponse;
import com.jio.bahubali.model.response.RetailerAccountInfo;
import reactor.core.publisher.Mono;

public interface RetailerAccountService {

  Mono<GenericResponse> saveOrUpdateRetailer(RetailerOnboard retailerOnboard);

  Mono<RetailerAccountInfo> fetchRetailerInfo(String prmId);

  Mono<RetailerAccountInfo> fetchRetailerCreditInfo(String prmId);

  Mono<GenericResponse> saveOrUpdateRetailerAccount(
      com.jio.bahubali.model.request.RetailerAccount retailerAccount);

  Mono<GenericResponse> saveOrUpdateRetailerCreditBalance(
      RetailerCreditBalance retailerCreditBalance);
}
