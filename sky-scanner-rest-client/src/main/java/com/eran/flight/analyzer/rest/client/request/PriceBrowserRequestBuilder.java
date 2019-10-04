package com.eran.flight.analyzer.rest.client.request;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.eran.flight.analyzer.common.FlightRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PriceBrowserRequestBuilder {

    private static final String LOCALE = "fr-FR";

    private static final String API_SCHEME = "https";

    private static final String API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    private static final String PRICE_BROWSER_ROOT_PATH = "/apiservices";

    private static final String API_VERSION = "v1.0";

    private static final String ROUTES_ENDPOINT = "browseroutes";

    private static final String DATES_ENDPOINT = "browsedates";

    private static final String QUOTES_ENDPOINT = "browsequotes";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private UriComponents uriBuilder;

    @Autowired
    public PriceBrowserRequestBuilder() {
        uriBuilder = UriComponentsBuilder.newInstance().scheme(API_SCHEME).host(API_HOST)
                .path(PRICE_BROWSER_ROOT_PATH + "/{endPoint}/" + API_VERSION + "/{country}/{currency}/" + LOCALE
                        + "/{originPlace}/{destination}/{outboundPartialDate}")
                .queryParam("inboundpartialdate", "{inboundpartialdate}").build();

    }

    public URI getRouteRequest(FlightRequest flightRequest) {
        log.info("Building getRouteRequest ... ");
        Map<String, String> params = mapRequestParameters(flightRequest, ROUTES_ENDPOINT);
        return uriBuilder.expand(params).toUri();

    }

    public URI getDatesRequest(FlightRequest flightRequest) {
        log.info("Building getDatesRequest ... ");
        Map<String, String> params = mapRequestParameters(flightRequest, DATES_ENDPOINT);
        return uriBuilder.expand(params).toUri();

    }

    public URI getQuoteRequest(FlightRequest flightRequest) {
        log.info("Building getQuoteRequest ... ");
        Map<String, String> params = mapRequestParameters(flightRequest, QUOTES_ENDPOINT);
        return uriBuilder.expand(params).toUri();

    }

    private Map<String, String> mapRequestParameters(FlightRequest flightRequest, String quotesEndpoint) {
        Map<String, String> params = new HashMap<>();
        params.put("endPoint", quotesEndpoint);
        params.put("country", flightRequest.getCountry());
        params.put("currency", flightRequest.getCurrency());
        params.put("originPlace", flightRequest.getOriginPlace());
        params.put("destination", flightRequest.getDestination());
        params.put("outboundPartialDate", flightRequest.getOutboundPartialDate().format(FORMATTER));
        params.put("inboundpartialdate", flightRequest.getInboundPartialDate().format(FORMATTER));
        return params;
    }

}
