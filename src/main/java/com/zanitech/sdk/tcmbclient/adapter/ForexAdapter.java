package com.zanitech.sdk.tcmbclient.adapter;

import com.zanitech.sdk.tcmbclient.exception.TcmbClientHttpException;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRate;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRateTcmbOutput;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRateOutput;
import com.zanitech.sdk.tcmbclient.net.TcmbConnector;
import com.zanitech.sdk.tcmbclient.net.XmlTcmbConnector;
import com.zanitech.sdk.tcmbclient.util.DateTimeUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ForexAdapter {

  private static final String URI = "https://www.tcmb.gov.tr/kurlar/today.xml";
  private final TcmbConnector tcmbConnector;

  public ForexAdapter() {
    this.tcmbConnector = new XmlTcmbConnector();
  }

  public ForexAdapter(TcmbConnector tcmbConnector) {
    this.tcmbConnector = tcmbConnector;
  }

  public ForexRateOutput getRates() throws TcmbClientHttpException {

    ForexRateTcmbOutput tcmbOutput =
        tcmbConnector.get(URI, ForexRateTcmbOutput.class);

    List<ForexRate> forexRates = tcmbOutput.getForexRateTcmbItems()
        .stream()
        .map(item -> ForexRate.builder()
            .code(item.getCode().strip())
            .currencyName(item.getTcmbNameEn().strip())
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
