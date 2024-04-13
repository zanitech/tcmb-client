package com.zanitech.sdk.tcmbclient.adapter;

import com.zanitech.sdk.tcmbclient.model.forex.ForexRate;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRateOutput;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ExhangeRateFakeAdapter implements ForexAdapter {

  @Override
  public ForexRateOutput getRates() {

    List<ForexRate> forexRates = List.of(
        ForexRate.builder()
            .code("USD")
            .currencyName("USD Dollar")
            .forexBuying(new BigDecimal("23.445"))
            .forexSelling(new BigDecimal("23.545"))
            .crossRateUsd(BigDecimal.ONE)
            .build()
    );
    return ForexRateOutput.builder()
        .date(LocalDate.of(2022, 2, 15))
        .forexRates(forexRates)
        .build();
  }
}
