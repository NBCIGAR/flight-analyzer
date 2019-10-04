package com.eran.flight.analyzer.rest.scheduler.mapper.impl;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.persistence.entity.Currency;
import com.eran.flight.analyzer.rest.client.dto.CurrencyDTO;
import com.eran.flight.analyzer.rest.scheduler.mapper.api.CurrencyMapper;

@Component
public class CurrencyMapperImpl implements CurrencyMapper {

    @Override
    public Set<Currency> currenciesDtoListToCurrenciesSet(List<CurrencyDTO> currencies) {
        return currencies.stream().map(currencyDtoToCurrencyFunction()).collect(Collectors.toSet());
    }

    @Override
    public Function<CurrencyDTO, Currency> currencyDtoToCurrencyFunction() {
        return currencyDTO -> Currency.builder().code(currencyDTO.getCode()).symbol(currencyDTO.getSymbol())
                .thousandsSeparator(currencyDTO.getThousandsSeparator()).symbolOnLeft(currencyDTO.getSymbolOnLeft())
                .spaceBetweenAmountAndSymbol(currencyDTO.getSpaceBetweenAmountAndSymbol())
                .roundingCoefficient(currencyDTO.getRoundingCoefficient())
                .decimalSeparator(currencyDTO.getDecimalSeparator()).decimalDigits(currencyDTO.getDecimalDigits())
                .build();
    }
}
