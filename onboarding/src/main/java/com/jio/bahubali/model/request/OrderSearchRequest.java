package com.jio.bahubali.model.request;

import static com.jio.bahubali.constants.CommonConstants.ORDER_SEARCH_DATE_FORMAT;

import com.jio.bahubali.enums.ChannelType;
import com.jio.bahubali.enums.ErrorCode;
import com.jio.bahubali.enums.OrderSearchType;
import com.jio.bahubali.exception.OnboardingException;
import jakarta.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderSearchRequest {

  @NotNull OrderSearchType searchType;

  String orderId;

  DateRangeDto dateRange;

  ChannelType channelType;

  public void validate() {
    if (searchType.equals(OrderSearchType.ORDER_ID) && Objects.isNull(orderId)) {
      throw new OnboardingException(
          "Order ID can't be null/empty when search type is ORDER_ID", ErrorCode.BAD_REQUEST);
    }

    if (searchType.equals(OrderSearchType.DATE_RANGE)
        && (Objects.isNull(dateRange) || Objects.isNull(channelType))) {
      throw new OnboardingException(
          "Date range and channel type can't be null/empty when search type is DATE_RANGE",
          ErrorCode.BAD_REQUEST);
    }

    if (searchType.equals(OrderSearchType.DATE_RANGE)) {
      Date startDate;
      Date endDate;
      try {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ORDER_SEARCH_DATE_FORMAT);
        startDate = simpleDateFormat.parse(dateRange.getStartDate());
        endDate = simpleDateFormat.parse(dateRange.getEndDate());
      } catch (ParseException e) {
        throw new OnboardingException(
            "Dates should be in " + ORDER_SEARCH_DATE_FORMAT + " format", ErrorCode.BAD_REQUEST);
      }

      if (startDate.after(endDate)) {
        throw new OnboardingException("End date can't be before start date", ErrorCode.BAD_REQUEST);
      }
    }
  }
}
