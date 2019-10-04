package com.eran.flight.analyzer.rest.client.request;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.eran.flight.analyzer.common.FlightRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PriceBrowserRequestBuilderTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private PriceBrowserRequestBuilder priceBrowserRequestBuilder = new PriceBrowserRequestBuilder();

    @Test
    public void getRouteRequest() {
        String expected =
                "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browseroutes/v1.0/US/USD/fr-FR/SFO-sky/ORD-sky/2019-09-01?inboundpartialdate=2019-12-01";

        FlightRequest flightRequest = FlightRequest.builder().country("US").currency("USD").originPlace("SFO-sky")
                .destination("ORD-sky").outboundPartialDate(LocalDate.parse("2019-09-01", FORMATTER))
                .inboundPartialDate(LocalDate.parse("2019-12-01", FORMATTER)).build();
        URI actual = priceBrowserRequestBuilder.getRouteRequest(flightRequest);
        log.info("URI {} ",actual);
        assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    public void getDatesRequest() {
        String expected =
                "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsedates/v1.0/US/USD/fr-FR/SFO-sky/LAX-sky/2019-09-01?inboundpartialdate=2019-12-01";
        FlightRequest flightRequest = FlightRequest.builder().country("US").currency("USD").originPlace("SFO-sky")
                .destination("LAX-sky").outboundPartialDate(LocalDate.parse("2019-09-01", FORMATTER))
                .inboundPartialDate(LocalDate.parse("2019-12-01", FORMATTER)).build();

        URI actual = priceBrowserRequestBuilder.getDatesRequest(flightRequest);
        log.info("URI {} ",actual);
        assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    public void getQuoteRequest() {
        String expected =
                "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/fr-FR/SFO-sky/JFK-sky/2019-09-01?inboundpartialdate=2019-12-01";

        FlightRequest flightRequest = FlightRequest.builder().country("US").currency("USD").originPlace("SFO-sky")
                .destination("JFK-sky").outboundPartialDate(LocalDate.parse("2019-09-01", FORMATTER))
                .inboundPartialDate(LocalDate.parse("2019-12-01", FORMATTER)).build();

        URI actual = priceBrowserRequestBuilder.getQuoteRequest(flightRequest);
        log.info("URI {} ",actual);
        assertThat(actual.toString()).isEqualTo(expected);
    }
}