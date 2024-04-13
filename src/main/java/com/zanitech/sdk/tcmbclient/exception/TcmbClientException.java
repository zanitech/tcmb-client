package com.zanitech.sdk.tcmbclient.exception;

public class TcmbClientException extends RuntimeException {

  public TcmbClientException() {
    super("TcmbClient Exception");
  }

  public TcmbClientException(String message) {
    super(message);
  }

  public TcmbClientException(String message, Throwable cause) {
    super(message, cause);
  }

  public TcmbClientException(Throwable cause) {
    super(cause);
  }

  public TcmbClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
