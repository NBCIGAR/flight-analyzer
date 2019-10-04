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
public class BoundDateDTO {

    @JsonProperty(value = "QuoteIds")
    private List<Long> quoteIds;

    @JsonProperty(value = "PartialDate")
    private String partialDate;

    @JsonProperty(value = "Price")
    private String price;

    @JsonProperty(value = "QuoteDateTime")
    private String quoteDateTime;

}
