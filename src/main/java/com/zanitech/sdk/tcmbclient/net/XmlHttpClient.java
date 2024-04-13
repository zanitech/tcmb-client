package com.zanitech.sdk.tcmbclient.net;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.zanitech.sdk.tcmbclient.exception.TcmbClientException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class XmlHttpClient {

  private static final XmlMapper xmlMapper = (XmlMapper) (new XmlMapper())
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, false);

  public static <T> T get(String uri, Class<T> clazz) {
    var httpClient = HttpClient.newBuilder().build();
    HttpRequest httpRequest = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .GET()
        .build();
    try {
      HttpResponse<String> httpResponse = httpClient.send(
          httpRequest, HttpResponse.BodyHandlers.ofString());
      if (httpResponse.statusCode() != 200) {
        // FIXME: handle unsuccessful scenarios
        throw new RuntimeException("Http request fail!");
      }
      final String responseXml = httpResponse.body();
      return xmlMapper.readValue(responseXml, clazz);
    } catch (IOException e) {
      e.printStackTrace();
      throw new TcmbClientException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new TcmbClientException(e);
    }
  }
}
