package com.zanitech.sdk.tcmbclient.model.currency;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ForexRateOutput {

  private LocalDate date;
  private List<ForexRate> forexRates;
}
