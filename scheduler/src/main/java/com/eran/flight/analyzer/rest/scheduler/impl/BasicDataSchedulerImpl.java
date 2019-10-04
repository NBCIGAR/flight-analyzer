package com.eran.flight.analyzer.rest.scheduler.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eran.flight.analyzer.persistence.entity.Country;
import com.eran.flight.analyzer.persistence.entity.Currency;
import com.eran.flight.analyzer.persistence.repository.CountryRepository;
import com.eran.flight.analyzer.persistence.repository.CurrencyRepository;
import com.eran.flight.analyzer.rest.client.api.ReferenceClient;
import com.eran.flight.analyzer.rest.client.dto.CountryDTO;
import com.eran.flight.analyzer.rest.client.dto.CurrencyDTO;
import com.eran.flight.analyzer.rest.scheduler.api.BasicDataScheduler;
import com.eran.flight.analyzer.rest.scheduler.mapper.api.CountryMapper;
import com.eran.flight.analyzer.rest.scheduler.mapper.api.CurrencyMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicDataSchedulerImpl implements BasicDataScheduler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    private ReferenceClient referenceClient;

    private CountryRepository countryRepository;

    private CurrencyRepository currencyRepository;

    private CurrencyMapper currencyMapper;

    private CountryMapper countryMapper;

    public BasicDataSchedulerImpl(ReferenceClient referenceClient, CountryRepository countryRepository,
            CurrencyRepository currencyRepository, CurrencyMapper currencyMapper, CountryMapper countryMapper) {
        this.referenceClient = referenceClient;
        this.countryRepository = countryRepository;
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
        this.countryMapper = countryMapper;
    }

     @Scheduled(cron = "0 0 7,14 ? * *")
//    @Scheduled(initialDelayString = "0", fixedDelayString = "50000")
    @Override
    public void getCountries() {
        System.out.println("BasicDataSchedulerImpl -- STARTING -- at {} ..." + LocalDateTime.now().format(FORMATTER));
        List<CountryDTO> countries = referenceClient.getCountries();
        Set<Country> countrySet = countryMapper.countriesDtoListToCountriesSet(countries);
        countryRepository.saveAll(countrySet);

        List<CurrencyDTO> currencies = referenceClient.getCurrencies();
        Set<Currency> currencySet = currencyMapper.currenciesDtoListToCurrenciesSet(currencies);
        currencyRepository.saveAll(currencySet);

        System.out.println(" countries {}" + countries);
        System.out.println(" currencies {}" + currencies);
        System.out.println("BasicDataSchedulerImpl -- END -- at {} ..." + LocalDateTime.now().format(FORMATTER));
    }

}
