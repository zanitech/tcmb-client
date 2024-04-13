package com.zanitech.sdk.tcmbclient.adapter;

import com.zanitech.sdk.tcmbclient.model.forex.ForexRateOutput;

public interface ForexAdapter {

  /**
   * Instant foreign exchange rates listed by TCMB
   * @return {@link ForexRateOutput}
   */
  ForexRateOutput getRates();
}
