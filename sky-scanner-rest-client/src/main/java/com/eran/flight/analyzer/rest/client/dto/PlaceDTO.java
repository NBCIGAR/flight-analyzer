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
public class PlaceDTO {

    @JsonProperty(value = "PlaceId")
    private String placeId;

    @JsonProperty(value = "PlaceName")
    private String placeName;

    @JsonProperty(value = "CountryId")
    private String countryId;

    @JsonProperty(value = "RegionId")
    private String regionId;

    @JsonProperty(value = "CityId")
    private String cityId;

    @JsonProperty(value = "CountryName")
    private String countryName;
    
    @JsonProperty(value = "IataCode")
    private String iataCode;

    @JsonProperty(value = "name")
    private String name;
    
}

