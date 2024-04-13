package com.zanitech.sdk.tcmbclient.model.currency;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForexRateTcmbItem {

  @JacksonXmlProperty(isAttribute = true, localName = "CurrencyCode")
  private String code;

  @JacksonXmlProperty(localName = "Isim")
  private String tcmbName;

  @JacksonXmlProperty(localName = "CurrencyName")
  private String tcmbNameEn;

  @JacksonXmlProperty(localName = "ForexBuying")
  private BigDecimal forexBuying;

  @JacksonXmlProperty(localName = "ForexSelling")
  private BigDecimal forexSelling;

  @JacksonXmlProperty(localName = "BanknoteBuying")
  private BigDecimal banknoteBuying;

  @JacksonXmlProperty(localName = "BanknoteSelling")
  private BigDecimal banknoteSelling;

  @JacksonXmlProperty(localName = "CrossRateUSD")
  private BigDecimal crossRateUsd;
}