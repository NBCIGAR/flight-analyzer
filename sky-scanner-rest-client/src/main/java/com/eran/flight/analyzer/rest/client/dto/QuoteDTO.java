package com.eran.flight.analyzer.rest.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteDTO {

    @JsonProperty(value = "QuoteId")
    private String quoteId;

    @JsonProperty(value = "MinPrice")
    private String minPrice;

    @JsonProperty(value = "Direct")
    private Boolean direct;

    @JsonProperty(value = "OutboundLeg")
    private BoundLegDTO outboundLeg;

    @JsonProperty(value = "InboundLeg")
    private BoundLegDTO inboundLeg;

    @JsonProperty(value = "QuoteDateTime")
    private String quoteDateTime;
}
