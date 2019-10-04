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
public class DateDTO {

    @JsonProperty(value = "OutboundDates")
    private List<BoundDateDTO> outboundDates;

}
