package com.eran.flight.analyzer.rest.client.response;

import java.util.List;

import com.eran.flight.analyzer.rest.client.dto.CurrencyDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCurrenciesResponse {

    @JsonProperty(value = "Currencies")
    List<CurrencyDTO> currencies;
}
