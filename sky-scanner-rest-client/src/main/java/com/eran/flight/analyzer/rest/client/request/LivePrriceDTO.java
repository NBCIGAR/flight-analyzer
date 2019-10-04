package com.eran.flight.analyzer.rest.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivePrriceDTO {

    @JsonProperty(value = "inboundDate")
    private String inboundDate;

    @JsonProperty(value = "cabinClass")
    private String cabinClass;

    @JsonProperty(value = "children")
    private String children;

    @JsonProperty(value = "infants")
    private Long infants;

    @JsonProperty(value = "includeCarriers")
    private String includeCarriers;

    @JsonProperty(value = "excludeCarriers")
    private String excludeCarriers;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "locale")
    private String locale;

    @JsonProperty(value = "originPlace")
    private String originPlace;

    @JsonProperty(value = "destinationPlace")
    private String destinationPlace;

    @JsonProperty(value = "outboundDate")
    private String outboundDate;

    @JsonProperty(value = "adults")
    private Long adults;
}
