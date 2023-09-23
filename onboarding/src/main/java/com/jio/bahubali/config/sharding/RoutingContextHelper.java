package com.jio.bahubali.config.sharding;

import com.jio.bahubali.enums.ChannelType;
import com.jio.bahubali.enums.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RoutingContextHelper {

  public static void setContext(ChannelType channelType) {
    if (ChannelType.ASP == channelType) {
      RoutingContextHolder.setRoutingKey("falcon_asp");
      log.info("Db Name :-{} ", DBTypeEnum.SHARD1.name());
    } else if (ChannelType.RCPL == channelType) {
      RoutingContextHolder.setRoutingKey("falcon_rcpl");
      log.info("Db Name :-{} ", DBTypeEnum.SHARD1.name());
    } else if (ChannelType.B2B == channelType) {
      RoutingContextHolder.setRoutingKey(DBTypeEnum.SHARD2.name());
      log.info("Db Name :-{} ", DBTypeEnum.SHARD2.name());
    }
  }
}
