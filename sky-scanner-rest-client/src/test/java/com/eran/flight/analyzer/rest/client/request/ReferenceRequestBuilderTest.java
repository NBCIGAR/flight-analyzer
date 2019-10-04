package com.eran.flight.analyzer.rest.client.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReferenceRequestBuilderTest {

    private ReferenceRequestBuilder referenceRequestBuilder = new ReferenceRequestBuilder();

    @Test
    public void getCurrenciesRequest() {
        String expected =
                "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/currencies";
        URI actual = referenceRequestBuilder.getCurrenciesRequest();
        log.info("URI {} ", actual);
        assertThat(actual.toString()).isEqualTo(expected);

    }

    @Test
    public void getCountriesRequest() {
        String expected =
                "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/fr-FR";
        URI actual = referenceRequestBuilder.getCountriesRequest();
        log.info("URI {} ", actual);
        assertThat(actual.toString()).isEqualTo(expected);

    }
}