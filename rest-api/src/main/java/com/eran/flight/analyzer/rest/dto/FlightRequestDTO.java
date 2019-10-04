package com.eran.flight.analyzer.rest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightRequestDTO {

    private Long id;

    private String country;

    private String currency;

    private String destination;

    private String originPlace;

    private LocalDate outboundPartialDate;

    private LocalDate inboundPartialDate;
}
