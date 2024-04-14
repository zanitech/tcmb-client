package com.zanitech.sdk.tcmbclient;

import com.zanitech.sdk.tcmbclient.model.forex.ForexRateOutput;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class ForexExamples {

  @Test
  @SneakyThrows
  void getRates() {
    TcmbClient tcmbClient = new TcmbClient();
    ForexRateOutput forexRateOutput = tcmbClient.forex().getRates();
    System.out.println(forexRateOutput.getDate());
    forexRateOutput.getForexRates().stream()
        .forEach(System.out::println);
  }
}
