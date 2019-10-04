package com.eran.flight.analyzer.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eran.flight.analyzer.rest.api.FlightApi;
import com.eran.flight.analyzer.rest.api.PlacesApi;
import com.eran.flight.analyzer.rest.client.api.PlaceAutoCompleteClient;
import com.eran.flight.analyzer.rest.client.dto.PlaceDTO;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = FlightApi.API_V_1_FLIGHT, consumes = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Places", description = "autocomplete places")
@Slf4j
public class PlacesController implements PlacesApi {

    private PlaceAutoCompleteClient skyScannerClient;

    @Autowired
    public PlacesController(PlaceAutoCompleteClient skyScannerClient) {
        this.skyScannerClient = skyScannerClient;
    }

   
    @GetMapping(value = "/{country}/{currency}")
    @Override
    public ResponseEntity<?> getPlaces(@RequestParam String query, @PathVariable String country,
            @PathVariable String currency) {
        System.out.println("Begin");

        List<PlaceDTO> places = skyScannerClient.getPlaces(query, country, currency);

        System.out.println(places);

        return ResponseEntity.ok(places);
    }

}
