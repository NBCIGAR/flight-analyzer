package com.eran.flight.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlightAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightAnalyzerApplication.class, args);
    }

    

}
