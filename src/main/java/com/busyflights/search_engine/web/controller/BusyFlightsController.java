package com.busyflights.search_engine.web.controller;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyflights.search_engine.services.interfaces.OrderedBusyFlightsService;
import com.busyflights.search_engine.web.domain.BusyFlightsRequest;
import com.busyflights.search_engine.web.domain.BusyFlightsResponse;

/**
 * Busy Flights Controller
 *
 * https://en.wikipedia.org/wiki/ISO_8601 -> YYYY-MM-DD
 *
 */
@RestController
@RequestMapping("/busy-flights")
public class BusyFlightsController {

    @Autowired
    private OrderedBusyFlightsService busyFlightsService;

    @RequestMapping(value = "/flights", method = RequestMethod.GET, params = { "origin", "destination", "departureDate", "returnDate", "numberOfPassengers" })
    @ResponseBody
    public List<BusyFlightsResponse> searchCrazyFlights(@RequestParam
            @Size(min = 3, max = 3)
            final String origin,
            @RequestParam
            @Size(min = 3, max = 3)
            final String destination,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            // @Pattern(regexp = DATA_PATTERN)
            final String departureDate,
            @RequestParam
            // @Pattern(regexp = DATA_PATTERN)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            final String returnDate,
            @RequestParam @Range(min = 1, max = 4) int numberOfPassengers) {

        BusyFlightsRequest.Builder busyFlightsRequest = new BusyFlightsRequest.Builder()
                .origin(origin)
                .destination(destination)
                .departureDate(departureDate)
                .returnDate(returnDate)
                .numberOfPassengers(numberOfPassengers);

        return busyFlightsService.orderedSearchByFare(busyFlightsRequest.build());
    }

}
