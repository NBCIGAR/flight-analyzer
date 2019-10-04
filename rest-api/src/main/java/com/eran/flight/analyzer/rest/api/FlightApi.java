package com.eran.flight.analyzer.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eran.flight.analyzer.rest.dto.FlightRequestDTO;

public interface FlightApi {

    String API_V_1_FLIGHT = "/api/v1/Flight";

 
    @GetMapping(value = "/")
    ResponseEntity<?> getFlightRequests();

    @GetMapping(value = "/{flightRequestId}", produces = "application/json")
    ResponseEntity<?> getOneFlightRequests(@PathVariable Long flightRequestId);


    @PostMapping(value = "/")
    ResponseEntity<?> addFlightRequests(@RequestBody FlightRequestDTO flightRequestDTO);
}
