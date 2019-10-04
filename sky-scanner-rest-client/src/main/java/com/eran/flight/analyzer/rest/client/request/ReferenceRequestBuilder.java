package com.eran.flight.analyzer.rest.client.request;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ReferenceRequestBuilder {

    private static final String LOCALE = "fr-FR";

    private static final String API_SCHEME = "https";

    private static final String API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    private static final String CURRENCIES_END_POINT = "/apiservices/reference/v1.0/currencies";

    private static final String COUNTRIES_END_POINT = "/apiservices/reference/v1.0/countries";

    public URI getCurrenciesRequest() {
        log.info("Building getCurrenciesRequest ...");
        return UriComponentsBuilder.newInstance().scheme(API_SCHEME).host(API_HOST).path(CURRENCIES_END_POINT).build()
                .toUri();

    }

    public URI getCountriesRequest() {
        log.info("Building getCountriesRequest ...");
        return UriComponentsBuilder.newInstance().scheme(API_SCHEME).host(API_HOST)
                .path(COUNTRIES_END_POINT + "/" + LOCALE).build().toUri();

    }

}
