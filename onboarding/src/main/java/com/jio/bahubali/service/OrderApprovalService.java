package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.OrderApproval;
import com.jio.bahubali.model.response.ApprovesDTO;
import java.util.List;
import reactor.core.publisher.Mono;

public interface OrderApprovalService {

  Mono<List<OrderApproval>> updateOrderApproval(
      String orderId, List<ApprovesDTO> approvesListRequest);
}
