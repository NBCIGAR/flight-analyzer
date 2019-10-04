package com.eran.flight.analyzer.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.persistence.entity.Country;

@RepositoryRestResource
@Component
public interface CountryRepository extends JpaRepository<Country, Long> {
}