package com.eran.flight.analyzer.rest.impl;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eran.flight.analyzer.persistence.entity.FlightRequestEntity;
import com.eran.flight.analyzer.persistence.repository.FlightRequestRepository;
import com.eran.flight.analyzer.rest.api.FlightApi;
import com.eran.flight.analyzer.rest.dto.FlightRequestDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = FlightApi.API_V_1_FLIGHT, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class FlightController implements FlightApi {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private FlightRequestRepository flightRequestRepository;

    @Autowired
    public FlightController(FlightRequestRepository flightRequestRepository) {
        this.flightRequestRepository = flightRequestRepository;
    }

    @Override
    public ResponseEntity<?> getFlightRequests() {

        List<FlightRequestEntity> allFlightRequest = flightRequestRepository.findAll();
        return ResponseEntity.ok(allFlightRequest);
    }

    @GetMapping(value = "/{flightRequestId}", produces = "application/json")
    @Override
    public ResponseEntity<?> getOneFlightRequests(@PathVariable Long flightRequestId) {
        Optional<FlightRequestEntity> flightRequest = flightRequestRepository.findById(flightRequestId);
        return ResponseEntity.ok(flightRequest);
    }

    @PostMapping(value = "/")
    @Override
    public ResponseEntity<?> addFlightRequests(@RequestBody FlightRequestDTO flightRequestDTO) {
        FlightRequestEntity flightRequest = FlightRequestEntity.builder().country(flightRequestDTO.getCountry())
                .currency(flightRequestDTO.getCurrency()).destination(flightRequestDTO.getDestination())
                .originPlace(flightRequestDTO.getOriginPlace())
                .outboundPartialDate(flightRequestDTO.getOutboundPartialDate())
                .inboundPartialDate(flightRequestDTO.getInboundPartialDate()).build();

        FlightRequestEntity savedFlightRequest = flightRequestRepository.save(flightRequest);
        return ResponseEntity.ok(savedFlightRequest);
    }

}
