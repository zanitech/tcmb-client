package com.zanitech.sdk.tcmbclient.adapter.impl;

import com.zanitech.sdk.tcmbclient.adapter.ForexAdapter;
import com.zanitech.sdk.tcmbclient.model.currency.ForexRate;
import com.zanitech.sdk.tcmbclient.model.currency.ForexRateTcmbOutput;
import com.zanitech.sdk.tcmbclient.model.currency.ForexRateOutput;
import com.zanitech.sdk.tcmbclient.net.XmlHttpClient;
import com.zanitech.sdk.tcmbclient.util.DateTimeUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ForexAdapterImpl implements ForexAdapter {

  private static final String URI = "https://www.tcmb.gov.tr/kurlar/today.xml";

  @Override
  public ForexRateOutput getRates() {

    ForexRateTcmbOutput tcmbOutput =
        XmlHttpClient.get(URI, ForexRateTcmbOutput.class);

    List<ForexRate> forexRates = tcmbOutput.getForexRateTcmbItems()
        .stream()
        .map(item -> ForexRate.builder()
            .code(item.getCode())
            .currencyName(item.getTcmbNameEn())
            .forexBuying(item.getForexBuying())
            .forexSelling(item.getForexSelling())
            .crossRateUsd(item.getCrossRateUsd())
            .build())
        .collect(Collectors.toList());

    return ForexRateOutput.builder()
        .date(DateTimeUtil.parse(tcmbOutput.getDate(), "dd.MM.yyyy"))
        .forexRates(forexRates)
        .build();
  }
}
