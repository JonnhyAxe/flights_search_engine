package com.busyflights.search_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.busyflights.search_engine.config.BusyFlightsWebConfig;

@SpringBootApplication
@Import({
        BusyFlightsWebConfig.class
})
public class SearchEngineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchEngineApiApplication.class, args);
	}
}
