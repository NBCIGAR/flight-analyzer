package com.eran.flight.analyzer.rest.client.impl;

import java.io.IOException;

import org.junit.Test;

import com.eran.flight.analyzer.rest.client.response.GetBrowseDatesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlaceAutoCompleteClientImplTest {

    String messgae="{\"Dates\":{\"OutboundDates\":[{\"PartialDate\":\"2019-09-30\",\"QuoteIds\":[1],\"Price\":210.0,\"QuoteDateTime\":\"2019-09-23T12:21:00\"}]},\"Quotes\":[{\"QuoteId\":1,\"MinPrice\":210.0,\"Direct\":true,\"OutboundLeg\":{\"CarrierIds\":[851],\"OriginId\":81727,\"DestinationId\":60987,\"DepartureDate\":\"2019-09-30T00:00:00\"},\"QuoteDateTime\":\"2019-09-23T12:21:00\"}],\"Places\":[{\"PlaceId\":60987,\"IataCode\":\"JFK\",\"Name\":\"New York John F Kennedy\",\"Type\":\"Station\",\"SkyscannerCode\":\"JFK\",\"CityName\":\"New York\",\"CityId\":\"NYCA\",\"CountryName\":\"États-Unis\"},{\"PlaceId\":81727,\"IataCode\":\"SFO\",\"Name\":\"San Francisco International\",\"Type\":\"Station\",\"SkyscannerCode\":\"SFO\",\"CityName\":\"San Francisco\",\"CityId\":\"SFOA\",\"CountryName\":\"États-Unis\"}],\"Carriers\":[{\"CarrierId\":851,\"Name\":\"Alaska Airlines\"}],\"Currencies\":[{\"Code\":\"USD\",\"Symbol\":\"$\",\"ThousandsSeparator\":\",\",\"DecimalSeparator\":\".\",\"SymbolOnLeft\":true,\"SpaceBetweenAmountAndSymbol\":false,\"RoundingCoefficient\":0,\"DecimalDigits\":2}]}";
    
    ObjectMapper objectMapper=new ObjectMapper();
    
    @Test
    public void getPlaces() throws IOException {
        
        GetBrowseDatesResponse getBrowseDatesResponse = objectMapper.readValue(messgae, GetBrowseDatesResponse.class);
    }
}