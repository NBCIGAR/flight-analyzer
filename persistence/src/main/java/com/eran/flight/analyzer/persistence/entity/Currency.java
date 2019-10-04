package com.eran.flight.analyzer.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currency")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {

    @Id
    private String code;

    private String symbol;

    private String thousandsSeparator;

    private String decimalSeparator;

    private Boolean symbolOnLeft;

    private Boolean spaceBetweenAmountAndSymbol;

    private Long roundingCoefficient;

    private Long decimalDigits;
}
