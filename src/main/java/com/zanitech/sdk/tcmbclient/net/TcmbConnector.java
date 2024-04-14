package com.zanitech.sdk.tcmbclient.net;

import com.zanitech.sdk.tcmbclient.exception.TcmbClientHttpException;

public interface TcmbConnector {

  <T> T get(String uri, Class<T> clazz) throws TcmbClientHttpException;
}
