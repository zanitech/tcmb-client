package com.zanitech.sdk.tcmbclient;

public class TcmbClient {

  private final ForexAdapter forexAdapter = new ForexAdapter();

  /**
   * Foreign exchange related functionalities
   * @return {@link ForexAdapter}
   */
  public ForexAdapter forex() {
    return forexAdapter;
  }
}
