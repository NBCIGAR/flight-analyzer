package com.eran.flight.analyzer.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface PlacesApi {
  
    
    @GetMapping(value = "/places/{country}/{currency}")
    ResponseEntity<?> getPlaces(@RequestParam String query, @PathVariable String country,
                                @PathVariable String currency);
}
