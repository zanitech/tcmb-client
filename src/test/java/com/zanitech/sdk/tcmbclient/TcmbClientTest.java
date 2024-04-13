package com.zanitech.sdk.tcmbclient;

import com.zanitech.sdk.tcmbclient.adapter.ExhangeRateFakeAdapter;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRateOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TcmbClientTest {

  @Test
  void getRates() {
    TcmbClient tcmbClient = new TcmbClient();
    tcmbClient.setForexAdapter(new ExhangeRateFakeAdapter());
    ForexRateOutput forexRateOutput = tcmbClient.forex().getRates();
    Assertions.assertEquals(1, forexRateOutput.getForexRates().size());
    Assertions.assertEquals("USD", forexRateOutput.getForexRates().get(0).getCode());
  }
}
