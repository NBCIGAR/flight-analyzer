package com.eran.flight.analyzer.rest.scheduler.mapper.impl;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.persistence.entity.Country;
import com.eran.flight.analyzer.rest.client.dto.CountryDTO;
import com.eran.flight.analyzer.rest.scheduler.mapper.api.CountryMapper;

@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Set<Country> countriesDtoListToCountriesSet(List<CountryDTO> countries) {
        return countries.stream().map(countryDtoToCountryFunction()).collect(Collectors.toSet());
    }

    @Override
    public Function<CountryDTO, Country> countryDtoToCountryFunction() {
        return countryDTO -> Country.builder().code(countryDTO.getCode()).name(countryDTO.getName()).build();
    }
}
