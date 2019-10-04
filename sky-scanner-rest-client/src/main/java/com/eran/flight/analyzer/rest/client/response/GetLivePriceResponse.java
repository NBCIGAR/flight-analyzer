package com.eran.flight.analyzer.rest.client.response;

import java.util.List;

import com.eran.flight.analyzer.rest.client.dto.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetLivePriceResponse {

    @JsonProperty(value = "Dates")
    List<DateDTO> dates;

    @JsonProperty(value = "Quotes")
    List<QuoteDTO> quotes;

    @JsonProperty(value = "Places")
    List<PlaceDTO> places;

    @JsonProperty(value = "Carriers")
    List<CarrierDTO> carriers;

    @JsonProperty(value = "Currencies")
    List<CurrencyDTO> currencies;

}
