package com.eran.flight.analyzer.rest.client.api;

import java.util.List;

import com.eran.flight.analyzer.rest.client.dto.PlaceDTO;

public interface PlaceAutoCompleteClient {
    List<PlaceDTO> getPlaces(String query, String country, String currency);
}
