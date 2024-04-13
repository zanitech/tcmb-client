package com.zanitech.sdk.tcmbclient.model.forex;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ForexRate {

  private String code;
  private String currencyName;
  private BigDecimal forexBuying;
  private BigDecimal forexSelling;
  private BigDecimal crossRateUsd;
}