package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jio.bahubali.enums.ProductDistributionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DmsEditOrderItemInfo {
  private String orderItemId;

  @NonNull private String sku;

  private String description;

  @NonNull
  @DecimalMin(value = "0.1", inclusive = false, message = "unitMrp price must be greater than 0")
  @Digits(integer = 10, fraction = 2, message = "Invalid float value unitMrp")
  private BigDecimal unitMrp;

  @NonNull
  @Digits(integer = 10, fraction = 2, message = "Invalid float value discountedPrice")
  private BigDecimal discountedPrice;

  private String imageUrl;

  @NonNull private String quantity;

  @NotNull(message = "Invalid unitMargin value")
  private BigDecimal unitMargin;

  @NotNull(message = "Invalid unitSchemeValue value")
  private BigDecimal unitSchemeValue;

  @NonNull
  @DecimalMin(value = "0.1", inclusive = false, message = "Selling price must be greater than 0")
  @Digits(integer = 10, fraction = 2, message = "Invalid float value unitPriceAfterDiscount")
  private BigDecimal processedUnitPrice;

  private ProductDistributionType productDistributionType;
}
