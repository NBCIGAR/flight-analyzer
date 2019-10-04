package com.eran.flight.analyzer.rest;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.persistence.entity.Country;
import com.eran.flight.analyzer.persistence.entity.Currency;

@Component
public class RestRepositoryConfigurator implements RepositoryRestConfigurer {
    
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(Currency.class);
    }
}