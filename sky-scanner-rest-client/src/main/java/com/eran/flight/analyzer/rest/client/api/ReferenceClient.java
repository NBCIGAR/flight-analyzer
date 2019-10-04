package com.eran.flight.analyzer.rest.client.api;

import java.util.List;

import com.eran.flight.analyzer.rest.client.dto.CountryDTO;
import com.eran.flight.analyzer.rest.client.dto.CurrencyDTO;

public interface ReferenceClient {
    
    String LOCALE = "/fr-FR";

    String API_SCHEME = "https";

    String API_HOST = "TEST/apiservices/reference/v1.0";

    List<CurrencyDTO> getCurrencies();

    List<CountryDTO> getCountries();
}
