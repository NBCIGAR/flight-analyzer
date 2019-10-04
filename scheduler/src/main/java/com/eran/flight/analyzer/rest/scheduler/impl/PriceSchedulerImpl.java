package com.eran.flight.analyzer.rest.scheduler.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eran.flight.analyzer.common.FlightRequest;
import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.eran.flight.analyzer.persistence.entity.FlightRequestEntity;
import com.eran.flight.analyzer.persistence.repository.CurrencyRepository;
import com.eran.flight.analyzer.persistence.repository.FlightRequestRepository;
import com.eran.flight.analyzer.rest.client.api.PriceBrowserClient;
import com.eran.flight.analyzer.rest.client.response.GetBrowseDatesResponse;
import com.eran.flight.analyzer.rest.client.response.GetBrowseQuotesResponse;
import com.eran.flight.analyzer.rest.client.response.GetBrowseRoutesResponse;
import com.eran.flight.analyzer.rest.scheduler.api.PriceScheduler;
import com.eran.flight.analyzer.rest.scheduler.mapper.api.CountryMapper;
import com.eran.flight.analyzer.rest.scheduler.mapper.api.CurrencyMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceSchedulerImpl implements PriceScheduler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    private PriceBrowserClient priceBrowserClient;

    private FlightRequestRepository flightRequestRepository;

    private CurrencyRepository currencyRepository;

    private CurrencyMapper currencyMapper;

    private CountryMapper countryMapper;

    public PriceSchedulerImpl(PriceBrowserClient priceBrowserClient, FlightRequestRepository flightRequestRepository,
            CurrencyRepository currencyRepository, CurrencyMapper currencyMapper, CountryMapper countryMapper) {
        this.priceBrowserClient = priceBrowserClient;
        this.flightRequestRepository = flightRequestRepository;
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
        this.countryMapper = countryMapper;
    }

    // @Scheduled(cron = "0 0 7,14 ? * *")
    @Scheduled(initialDelayString = "0", fixedDelayString = "6000")
    @Override
    public void getFlightPrices() {
        log.info("PriceSchedulerImpl -- STARTING -- at {} ..." + LocalDateTime.now().format(FORMATTER));
        List<FlightRequestEntity> allFlightRequest = flightRequestRepository.findAll();
        Set<Either<Failure, GetBrowseDatesResponse>> collectByDate = allFlightRequest.stream()
                .map(mapFlightRequestEntityToFlightRequestFunction())
                .map(flightRequest -> priceBrowserClient.browseDates(flightRequest)).collect(Collectors.toSet());

//        collectByDate.stream().filter(response -> response.isRight()).map(response -> response.right())
//                .map(mapGetBrowseDatesResponseToByDateResultEntityFunction()
//
//                ).collect(Collectors.toList());

        Set<Either<Failure, GetBrowseQuotesResponse>> collect2 = allFlightRequest.stream()
                .map(mapFlightRequestEntityToFlightRequestFunction())
                .map(flightRequest -> priceBrowserClient.browseQuotes(flightRequest)).collect(Collectors.toSet());

        Set<Either<Failure, GetBrowseRoutesResponse>> collect1 = allFlightRequest.stream()
                .map(mapFlightRequestEntityToFlightRequestFunction())
                .map(flightRequest -> priceBrowserClient.browseRoutes(flightRequest)).collect(Collectors.toSet());

        log.info("PriceSchedulerImpl result {}", collect1);
        log.info("PriceSchedulerImpl -- END -- at {} ..." + LocalDateTime.now().format(FORMATTER));
    }

//    private Function<GetBrowseDatesResponse, ByDateResult> mapGetBrowseDatesResponseToByDateResultEntityFunction() {
//        return response ->
//        {
//            DateDTO dates = response.getDates();
//            List<QuoteDTO> quotes = response.getQuotes();
//            List<FlightPlaceDTO> places = response.getPlaces();
//            List<CarrierDTO> carriers = response.getCarriers();
//            List<CurrencyDTO> currencies = response.getCurrencies();
//            quotes.stream().map(quote->
//                    ByDateResult.builder().carrier(quote.getInboundLeg().getCarrierIds())
//            )
//
//        }
//             
//    }

    private Function<FlightRequestEntity, FlightRequest> mapFlightRequestEntityToFlightRequestFunction() {
        return flightRequestEntity -> FlightRequest.builder().country(flightRequestEntity.getCountry())
                .currency(flightRequestEntity.getCurrency()).destination(flightRequestEntity.getDestination())
                .originPlace(flightRequestEntity.getOriginPlace())
                .outboundPartialDate(flightRequestEntity.getOutboundPartialDate())
                .inboundPartialDate(flightRequestEntity.getInboundPartialDate()).build();
    }

}
