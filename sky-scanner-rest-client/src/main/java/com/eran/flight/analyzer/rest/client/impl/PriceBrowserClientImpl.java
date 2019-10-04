package com.eran.flight.analyzer.rest.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.common.FlightRequest;
import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.eran.flight.analyzer.rest.client.api.PriceBrowserClient;
import com.eran.flight.analyzer.rest.client.helper.HttpRestClient;
import com.eran.flight.analyzer.rest.client.request.PriceBrowserRequestBuilder;
import com.eran.flight.analyzer.rest.client.response.GetBrowseDatesResponse;
import com.eran.flight.analyzer.rest.client.response.GetBrowseQuotesResponse;
import com.eran.flight.analyzer.rest.client.response.GetBrowseRoutesResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PriceBrowserClientImpl implements PriceBrowserClient {

    private HttpRestClient client;

    private PriceBrowserRequestBuilder priceBrowserRequestBuilder;

    @Autowired
    public PriceBrowserClientImpl(PriceBrowserRequestBuilder priceBrowserRequestBuilder,
            HttpRestClient wiredHttpRestClient) {
        client = wiredHttpRestClient;
        this.priceBrowserRequestBuilder = priceBrowserRequestBuilder;
    }

    public Either<Failure, GetBrowseDatesResponse> browseDates(FlightRequest flightRequest) {
        log.info("browseDates :: flightRequest {}", flightRequest);
        return client.sendGetRequest(priceBrowserRequestBuilder.getDatesRequest(flightRequest),
                GetBrowseDatesResponse.class);

    }

    @Override
    public Either<Failure, GetBrowseQuotesResponse> browseQuotes(FlightRequest flightRequest) {

        return client.sendGetRequest(priceBrowserRequestBuilder.getQuoteRequest(flightRequest),
                GetBrowseQuotesResponse.class);
    }

    @Override
    public Either<Failure, GetBrowseRoutesResponse> browseRoutes(FlightRequest flightRequest) {

        return client.sendGetRequest(priceBrowserRequestBuilder.getRouteRequest(flightRequest),
                GetBrowseRoutesResponse.class);

    }

    @Override
    public Either<Failure, GetBrowseDatesResponse> browseDatesInbound(FlightRequest flightRequest) {
        return null;
    }

    @Override
    public Either<Failure, GetBrowseQuotesResponse> browseQuotesInbound(FlightRequest flightRequest) {
        return null;
    }

    @Override
    public Either<Failure, GetBrowseRoutesResponse> browseRoutesInbound(FlightRequest flightRequest) {
        return null;
    }

}
