package com.zanitech.sdk.tcmbclient.exception;

public class TcmbClientHttpException extends Exception {

  private int statusCode;
  private Object responseBody;

  public TcmbClientHttpException() {
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public Object getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(Object responseBody) {
    this.responseBody = responseBody;
  }
}
