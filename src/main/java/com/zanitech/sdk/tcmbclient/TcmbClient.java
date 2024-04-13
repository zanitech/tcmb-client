package com.zanitech.sdk.tcmbclient;

import com.zanitech.sdk.tcmbclient.adapter.ForexAdapter;
import com.zanitech.sdk.tcmbclient.adapter.impl.ForexAdapterImpl;

public class TcmbClient {

  private ForexAdapter forexAdapter = new ForexAdapterImpl();

  public ForexAdapter forex() {
    return forexAdapter;
  }


  public void setForexAdapter(ForexAdapter forexAdapter) {
    this.forexAdapter = forexAdapter;
  }
}
