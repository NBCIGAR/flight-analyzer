package com.eran.flight.analyzer.rest.client.request;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LivePriceRequestBuilder {

    private static final String LOCALE = "fr-FR";

    private static final String API_SCHEME = "https";

    private static final String API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    private static final String LIVE_PRICE_END_POINT = "/apiservices/pricing/v1.0";

    private UriComponents uriBuilder;

    @Autowired
    public LivePriceRequestBuilder() {
        uriBuilder =
                UriComponentsBuilder.newInstance().scheme(API_SCHEME).host(API_HOST).path(LIVE_PRICE_END_POINT).build();

    }

    public URI getLivePriceRequest() {
        return uriBuilder.toUri();
    }

}
