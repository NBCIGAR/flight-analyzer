package com.eran.flight.analyzer.rest.client.response;

import java.util.List;

import com.eran.flight.analyzer.rest.client.dto.CountryDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCountriesResponse {

    @JsonProperty(value = "Countries")
    List<CountryDTO> countries;
}
