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
public class CountryDTO {

    @JsonProperty(value = "Code")
    private String code;
    
    @JsonProperty(value = "Name")
    private String name;
    
}
