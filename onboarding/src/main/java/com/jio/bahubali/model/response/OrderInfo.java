package com.jio.bahubali.model.response;

import com.jio.bahubali.enums.ChannelType;
import com.jio.bahubali.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderInfo {

  String id;

  String creationDate;

  String status;

  ChannelType channelType;

  Float amount;

  OrderType type;
}
