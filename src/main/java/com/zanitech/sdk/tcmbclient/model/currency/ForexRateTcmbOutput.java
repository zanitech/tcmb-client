package com.zanitech.sdk.tcmbclient.model.currency;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "Tarih_Date")
public class ForexRateTcmbOutput {

  @JacksonXmlProperty(isAttribute = true, localName = "Tarih")
  private String date;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "Currency")
  private List<ForexRateTcmbItem> forexRateTcmbItems;
}
