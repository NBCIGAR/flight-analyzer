package com.eran.flight.analyzer.rest.client.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoundLegDTO {

    @JsonProperty(value = "CarrierIds")
    private List<Long> carrierIds;

    @JsonProperty(value = "OriginId")
    private String originId;

    @JsonProperty(value = "DestinationId")
    private Boolean destinationId;

    @JsonProperty(value = "DepartureDate")
    private String departureDate;

}
