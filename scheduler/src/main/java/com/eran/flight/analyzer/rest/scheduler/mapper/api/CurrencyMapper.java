package com.eran.flight.analyzer.rest.scheduler.mapper.api;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import com.eran.flight.analyzer.persistence.entity.Currency;
import com.eran.flight.analyzer.rest.client.dto.CurrencyDTO;

public interface CurrencyMapper {
    Set<Currency> currenciesDtoListToCurrenciesSet(List<CurrencyDTO> currencies);

    Function<CurrencyDTO, Currency> currencyDtoToCurrencyFunction();
}
