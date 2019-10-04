package com.eran.flight.analyzer.rest.client.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.eran.flight.analyzer.rest.client.api.PlaceAutoCompleteClient;
import com.eran.flight.analyzer.rest.client.dto.PlaceDTO;
import com.eran.flight.analyzer.rest.client.helper.HttpRestClient;
import com.eran.flight.analyzer.rest.client.request.PlaceRequestBuilder;
import com.eran.flight.analyzer.rest.client.response.GetPlacesResponse;

@Component
public class PlaceAutoCompleteClientImpl implements PlaceAutoCompleteClient {


    private PlaceRequestBuilder placeRequestBuilder;

    private HttpRestClient restClient;

    @Autowired
    public PlaceAutoCompleteClientImpl(PlaceRequestBuilder placeRequestBuilder,
            HttpRestClient restClient) {
      

        this.placeRequestBuilder = placeRequestBuilder;

        this.restClient = restClient;
    }

    @Override
    public List<PlaceDTO> getPlaces(String query, String country, String currency) {
        // TODO : max quota is 400 query by minute...
        Either<Failure, GetPlacesResponse> failureOrPlacesResponse = restClient
                .sendGetRequest(placeRequestBuilder.getPlaceRequest(query, country, currency), GetPlacesResponse.class);
        if (failureOrPlacesResponse.isRight()) {
            return failureOrPlacesResponse.right().getPlaces();
        }
        return Collections.emptyList();

    }

}
