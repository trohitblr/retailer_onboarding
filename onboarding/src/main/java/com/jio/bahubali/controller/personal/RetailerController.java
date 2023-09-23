package com.jio.bahubali.controller.personal;

import com.jio.bahubali.entity.personal.RetailerEntity;
import com.jio.bahubali.model.persoanal.Retailer;
import com.jio.bahubali.model.persoanal.RetailerApproval;
import com.jio.bahubali.service.personal.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RetailerController {

  @Autowired RetailerService retailerService;

  @PostMapping(value = "/onboard", produces = "application/json")
  public Mono<RetailerEntity> onboardRetailer(@RequestBody Retailer retailer) {
    return retailerService.saveRetailerDetails(retailer);
  }

  @PostMapping(value = "/update-retailer", produces = "application/json")
  public Mono<RetailerEntity> updateRetailer(@RequestBody Retailer retailer) {
    return retailerService.updateRetailerDetails(retailer);
  }

  @GetMapping(value = "/retailer-info", produces = "application/json")
  public Mono<Retailer> updateRetailer(@RequestParam String retailerId) {
    return retailerService.getRetailerInfo(retailerId);
  }

  @GetMapping(value = "/fos-onboared-retailer-info", produces = "application/json")
  public Flux<Retailer> fetchFosRetailers(@RequestParam String fosId) {
    return retailerService.getFosOnboardedRetailers(fosId);
  }

  @GetMapping(value = "/location/retailera-info", produces = "application/json")
  public Flux<Retailer> fetchRetailerByLocation(@RequestParam String city) {
    return retailerService.getRetailersByLocation(city);
  }

  @PostMapping(value = "/approve-retailer", produces = "application/json")
  public Mono<Boolean> approveRetailer(@RequestBody RetailerApproval retailerApproval) {
    return retailerService.approveRetailer(retailerApproval);
  }
}
