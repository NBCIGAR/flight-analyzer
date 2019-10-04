package com.eran.flight.analyzer.common;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightRequest {

    private String country;

    private String currency;

    private String destination;

    private String originPlace;

    private LocalDate outboundPartialDate;

    private LocalDate inboundPartialDate;
}
