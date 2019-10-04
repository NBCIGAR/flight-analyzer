package com.eran.flight.analyzer.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class ByDateResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private QuoteEntity quotes;

    @ManyToOne
    private CarrierEntity carrier;

    @ManyToOne
    private Currency currency;

    private LocalDateTime scanDateTime;

}
