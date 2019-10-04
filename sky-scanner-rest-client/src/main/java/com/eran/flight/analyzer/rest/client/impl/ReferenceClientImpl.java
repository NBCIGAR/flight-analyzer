package com.eran.flight.analyzer.rest.client.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.eran.flight.analyzer.rest.client.api.ReferenceClient;
import com.eran.flight.analyzer.rest.client.dto.CountryDTO;
import com.eran.flight.analyzer.rest.client.dto.CurrencyDTO;
import com.eran.flight.analyzer.rest.client.helper.HttpRestClient;
import com.eran.flight.analyzer.rest.client.request.ReferenceRequestBuilder;
import com.eran.flight.analyzer.rest.client.response.GetCountriesResponse;
import com.eran.flight.analyzer.rest.client.response.GetCurrenciesResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ReferenceClientImpl implements ReferenceClient {

    private HttpRestClient restClient;

    private ReferenceRequestBuilder requestBuilder;

    @Autowired
    public ReferenceClientImpl(ReferenceRequestBuilder referenceRequestBuilder, HttpRestClient restClient) {
        this.requestBuilder = referenceRequestBuilder;
        this.restClient = restClient;
    }

    @Override
    public List<CurrencyDTO> getCurrencies() {
        Either<Failure, GetCurrenciesResponse> failureOrCurrenciesResponse =
                restClient.sendGetRequest(requestBuilder.getCurrenciesRequest(), GetCurrenciesResponse.class);
        if (failureOrCurrenciesResponse.isRight()) {
            return failureOrCurrenciesResponse.right().getCurrencies();
        } else {
            return Collections.emptyList();
        }

    }

    @Override
    public List<CountryDTO> getCountries() {
        Either<Failure, GetCountriesResponse> failureOrCountriesResponse =
                restClient.sendGetRequest(requestBuilder.getCountriesRequest(), GetCountriesResponse.class);
        if (failureOrCountriesResponse.isRight()) {
            return failureOrCountriesResponse.right().getCountries();
        } else {
            return Collections.emptyList();
        }

    }

}
