package com.eran.flight.analyzer.rest.scheduler.mapper.api;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import com.eran.flight.analyzer.persistence.entity.Country;
import com.eran.flight.analyzer.rest.client.dto.CountryDTO;

public interface CountryMapper {
    Set<Country> countriesDtoListToCountriesSet(List<CountryDTO> countries);

    Function<CountryDTO, Country> countryDtoToCountryFunction();
}
