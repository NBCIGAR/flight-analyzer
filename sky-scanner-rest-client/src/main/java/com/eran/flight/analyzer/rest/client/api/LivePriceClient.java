package com.eran.flight.analyzer.rest.client.api;

import java.util.List;

import com.eran.flight.analyzer.common.FlightRequest;
import com.eran.flight.analyzer.rest.client.dto.PlaceDTO;

public interface LivePriceClient {
    List<PlaceDTO> getLivePriceClient(FlightRequest flightRequest);
}
