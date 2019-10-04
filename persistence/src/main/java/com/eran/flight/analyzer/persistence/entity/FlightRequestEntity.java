package com.eran.flight.analyzer.persistence.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flight_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String currency;

    private String destination;

    private String originPlace;

    private LocalDate outboundPartialDate;

    private LocalDate inboundPartialDate;


}
