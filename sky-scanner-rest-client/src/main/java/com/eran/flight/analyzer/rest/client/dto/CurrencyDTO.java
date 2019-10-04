package com.eran.flight.analyzer.rest.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyDTO {

    @JsonProperty(value = "Code")
    private String code;

    @JsonProperty(value = "Symbol")
    private String symbol;

    @JsonProperty(value = "ThousandsSeparator")
    private String thousandsSeparator;

    @JsonProperty(value = "DecimalSeparator")
    private String decimalSeparator;

    @JsonProperty(value = "SymbolOnLeft")
    private Boolean symbolOnLeft;

    @JsonProperty(value = "SpaceBetweenAmountAndSymbol")
    private Boolean spaceBetweenAmountAndSymbol;

    @JsonProperty(value = "RoundingCoefficient")
    private Long roundingCoefficient;

    @JsonProperty(value = "DecimalDigits")
    private Long decimalDigits;

}
