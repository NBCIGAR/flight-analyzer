package com.eran.flight.analyzer.rest.client.request;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.net.URI;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaceRequestBuilderTest {

    private PlaceRequestBuilder placeRequestBuilder = new PlaceRequestBuilder();

    @Test
    public void getPlaceRequest() {
        String expected =
                "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/France/EUR/fr-FR/?query=query";
        URI actual = placeRequestBuilder.getPlaceRequest("query", "France", "EUR");
        log.info("URI {} ",actual);
        assertThat(actual.toString()).isEqualTo(expected);
    }
}