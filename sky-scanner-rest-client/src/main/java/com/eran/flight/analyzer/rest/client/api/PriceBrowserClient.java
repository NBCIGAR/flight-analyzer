package com.eran.flight.analyzer.rest.client.api;

import com.eran.flight.analyzer.common.FlightRequest;
import com.eran.flight.analyzer.common.either.Either;
import com.eran.flight.analyzer.common.either.Failure;
import com.eran.flight.analyzer.rest.client.response.GetBrowseDatesResponse;
import com.eran.flight.analyzer.rest.client.response.GetBrowseQuotesResponse;
import com.eran.flight.analyzer.rest.client.response.GetBrowseRoutesResponse;

public interface PriceBrowserClient {

    String LOCALE = "/fr-FR";

    String API_SCHEME = "https";

    String API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices";

    String API_VERSION = "v1.0";

    String ROUTES_ENDPOINT = "/browseroutes";

    String DATES_ENDPOINT = "/browsedates";

    String QUOTES_ENDPOINT = "/browsequotes";

    String API_AUTOSUGGEST_PATH = "/apiservices/autosuggest/v1.0";

    Either<Failure, GetBrowseDatesResponse> browseDates(FlightRequest flightRequest);

    Either<Failure, GetBrowseQuotesResponse> browseQuotes(FlightRequest flightRequest);

    Either<Failure, GetBrowseRoutesResponse> browseRoutes(FlightRequest flightRequest);

    Either<Failure, GetBrowseDatesResponse> browseDatesInbound(FlightRequest flightRequest);

    Either<Failure, GetBrowseQuotesResponse> browseQuotesInbound(FlightRequest flightRequest);

    Either<Failure, GetBrowseRoutesResponse> browseRoutesInbound(FlightRequest flightRequest);
}
