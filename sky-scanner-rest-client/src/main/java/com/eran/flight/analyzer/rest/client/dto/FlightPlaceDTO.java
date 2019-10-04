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
public class FlightPlaceDTO {

    @JsonProperty(value = "PlaceId")
    private String placeId;

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "Type")
    private String type;

    @JsonProperty(value = "SkyscannerCode")
    private String skyScannerCode;

    @JsonProperty(value = "CityId")
    private String cityId;
    
    @JsonProperty(value = "CityName")
    private String cityName;
    
    @JsonProperty(value = "CountryName")
    private String countryName;
    
    @JsonProperty(value = "IataCode")
    private String iataCode;

   
    
}

