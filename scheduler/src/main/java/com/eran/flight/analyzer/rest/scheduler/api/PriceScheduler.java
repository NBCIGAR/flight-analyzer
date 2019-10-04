package com.eran.flight.analyzer.rest.scheduler.api;

import org.springframework.scheduling.annotation.Scheduled;

public interface PriceScheduler {
    //     @Scheduled(cron = "0 0 7,14 ? * *")
        @Scheduled(initialDelayString = "0", fixedDelayString = "50000")
        void getFlightPrices();
}
