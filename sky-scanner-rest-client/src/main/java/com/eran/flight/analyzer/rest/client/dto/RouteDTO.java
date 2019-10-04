package com.eran.flight.analyzer.rest.client.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteDTO {

    @JsonProperty(value = "CarrierId")
    private LocalDate carrierId;

    @JsonProperty(value = "Name")
    private String name;

}
