package com.eran.flight.analyzer.rest.client.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.eran.flight.analyzer.common.FlightRequest;
import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.eran.flight.analyzer.rest.client.api.LivePriceClient;
import com.eran.flight.analyzer.rest.client.dto.PlaceDTO;
import com.eran.flight.analyzer.rest.client.helper.HttpRestClient;
import com.eran.flight.analyzer.rest.client.request.LivePriceRequestBuilder;
import com.eran.flight.analyzer.rest.client.response.GetLivePriceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class LivePriceClientImpl implements LivePriceClient {

    private HttpRestClient restClient;

    private LivePriceRequestBuilder livePriceRequestBuilder;

    @Autowired
    public LivePriceClientImpl(LivePriceRequestBuilder livePriceRequestBuilder, HttpRestClient restClient) {
        this.livePriceRequestBuilder = livePriceRequestBuilder;
        this.restClient = restClient;

    }

    @Override
    public List<PlaceDTO> getLivePriceClient(FlightRequest flightRequest) {
        try {
            Map data = new HashMap();
            Either<Failure, GetLivePriceResponse> failureGetLivePriceResponseEither = restClient.sendPostFormRequest(
                    livePriceRequestBuilder.getLivePriceRequest(), data, GetLivePriceResponse.class);
            return Collections.emptyList();
        } catch (HttpStatusCodeException e) {

            System.err.println(e.getStatusCode());
            System.err.println(e.getResponseBodyAsString());
            return Collections.emptyList();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
