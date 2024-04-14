package com.zanitech.sdk.tcmbclient.net;

import com.zanitech.sdk.tcmbclient.exception.TcmbClientHttpException;

public class MockTcmbConnector<E> implements TcmbConnector{

  private boolean success;
  private TcmbClientHttpException exception;
  private E returnObject;

  public MockTcmbConnector() {
    this.success = true;
    this.exception = new TcmbClientHttpException();
  }

  @Override
  public <T> T get(String uri, Class<T> clazz) throws TcmbClientHttpException {
    if (success) {
      return (T) returnObject;
    }
    throw exception;
  }

  public void setReturnObject(E returnObject) {
    this.returnObject = returnObject;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public TcmbClientHttpException getException() {
    return exception;
  }

  public void setException(TcmbClientHttpException exception) {
    this.exception = exception;
  }

  public E getReturnObject() {
    return returnObject;
  }
}
