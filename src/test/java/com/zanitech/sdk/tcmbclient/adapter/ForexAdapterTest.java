package com.zanitech.sdk.tcmbclient.adapter;

import com.zanitech.sdk.tcmbclient.ForexAdapter;
import com.zanitech.sdk.tcmbclient.exception.TcmbClientHttpException;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRateOutput;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRateTcmbItem;
import com.zanitech.sdk.tcmbclient.model.forex.ForexRateTcmbOutput;
import com.zanitech.sdk.tcmbclient.net.MockTcmbConnector;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class ForexAdapterTest {


  @Test
  @SneakyThrows
  void getRates_happyPath() {
    var mockTcmbConnector = new MockTcmbConnector<ForexRateTcmbOutput>();
    mockTcmbConnector.setReturnObject(ForexRateTcmbOutput.builder()
        .date("08.04.2024")
        .forexRateTcmbItems(List.of(
            ForexRateTcmbItem.builder()
                .code("USD")
                .tcmbName("Dolar")
                .tcmbNameEn("US Dollar")
                .forexBuying(new BigDecimal("32.040"))
                .forexSelling(new BigDecimal("32.333"))
                .build()
        ))
        .build());

    ForexAdapter forexAdapter = new ForexAdapter(mockTcmbConnector);
    ForexRateOutput output = forexAdapter.getRates();
    Assertions.assertEquals("2024-04-08", output.getDate().toString());
    Assertions.assertEquals(1, output.getForexRates().size());
  }

  @Test
  void getRates_throwsInternalServerError() {
    var mockTcmbConnector = new MockTcmbConnector<ForexRateTcmbOutput>();
    mockTcmbConnector.setSuccess(false);
    TcmbClientHttpException tcmbClientHttpException = new TcmbClientHttpException();
    tcmbClientHttpException.setStatusCode(503);
    mockTcmbConnector.setException(tcmbClientHttpException);
    ForexAdapter forexAdapter = new ForexAdapter(mockTcmbConnector);
    try {
      forexAdapter.getRates();
    }
    catch (TcmbClientHttpException httpException) {
      Assertions.assertEquals(503, httpException.getStatusCode());
    }
  }
}
