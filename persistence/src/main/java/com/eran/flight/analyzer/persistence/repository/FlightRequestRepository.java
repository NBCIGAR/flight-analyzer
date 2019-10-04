package com.eran.flight.analyzer.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import com.eran.flight.analyzer.persistence.entity.FlightRequestEntity;

@RepositoryRestResource
@Component
public interface FlightRequestRepository extends JpaRepository<FlightRequestEntity, Long> {
}