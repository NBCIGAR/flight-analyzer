package com.eran.flight.analyzer.rest.client.response;

import java.util.List;

import com.eran.flight.analyzer.rest.client.dto.CarrierDTO;
import com.eran.flight.analyzer.rest.client.dto.CurrencyDTO;
import com.eran.flight.analyzer.rest.client.dto.FlightPlaceDTO;
import com.eran.flight.analyzer.rest.client.dto.QuoteDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetBrowseQuotesResponse {

    @JsonProperty(value = "Quotes")
    List<QuoteDTO> quotes;

    @JsonProperty(value = "Places")
    List<FlightPlaceDTO> places;

    @JsonProperty(value = "Carriers")
    List<CarrierDTO> carriers;

    @JsonProperty(value = "Currencies")
    List<CurrencyDTO> currencies;

}
