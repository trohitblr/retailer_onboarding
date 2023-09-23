package com.jio.bahubali.model.request;

import static com.jio.bahubali.constants.CommonConstants.ORDER_SEARCH_DATE_FORMAT;

import com.jio.bahubali.enums.ErrorCode;
import com.jio.bahubali.exception.OnboardingException;
import jakarta.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

@Data
public class OrderDownloadRequest {

  @NotNull(message = "PrmId cannot be null")
  private String prmId;

  private String fromDate;

  private String toDate;

  public void validate() {
    Date startDate;
    Date endDate;
    if (toDate != null && fromDate != null) {
      try {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ORDER_SEARCH_DATE_FORMAT);
        startDate = simpleDateFormat.parse(fromDate);
        endDate = simpleDateFormat.parse(toDate);
      } catch (ParseException e) {
        throw new OnboardingException(
            "Dates should be in " + ORDER_SEARCH_DATE_FORMAT + " format", ErrorCode.BAD_REQUEST);
      }

      if (startDate.after(endDate)) {
        throw new OnboardingException("End date can't be before start date", ErrorCode.BAD_REQUEST);
      }
    } else if (toDate != null || fromDate != null) {
      throw new OnboardingException(
          "Either both fromDate and toDate should be provided, or none of them should be provided.",
          ErrorCode.BAD_REQUEST);
    }
  }
}
