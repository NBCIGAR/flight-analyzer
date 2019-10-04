package com.eran.flight.analyzer.rest.client.request;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PlaceRequestBuilder {

    private static final String LOCALE = "fr-FR";

    private static final String API_SCHEME = "https";

    private static final String API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    private static final String PLACES_END_POINT = "/apiservices/autosuggest/v1.0";

    private UriComponents uriBuilder;

    @Autowired
    public PlaceRequestBuilder() {
        uriBuilder = UriComponentsBuilder.newInstance().scheme(API_SCHEME).host(API_HOST)
                .path(PLACES_END_POINT + "/{country}/{currency}/" + LOCALE + "/").queryParam("query", "{query}")
                .build();

    }

    public URI getPlaceRequest(String query, String country, String currency) {
        log.info("Building getPlaceRequest ...");
        Map<String, String> params = new HashMap<>();
        params.put("query", query);
        params.put("country", country);
        params.put("currency", currency);
        return uriBuilder.expand(params).toUri();

    }

}
