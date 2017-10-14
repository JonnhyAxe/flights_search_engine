package com.busyflights.search_engine.services.suppliers.crazy_air.controller;


import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirRequest;
import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirResponse;
import com.busyflights.search_engine.services.suppliers.crazy_air.service.CrazyAirService;

@RestController
@RequestMapping("/crazy-air") // hyphens are OK
public class CrazyAirController {

    /**
     *
     */
    private static final String DATA_PATTERN = "^(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])-([0-9][0-9])?[0-9][0-9]$";

    @Autowired
    private CrazyAirService crazyAirService;

    @RequestMapping(value = "/flights", method = RequestMethod.GET, params = {"origin", "destination", "departureDate", "returnDate", "numberOfPassengers" })
    @ResponseBody
    public List<CrazyAirResponse> searchCrazyFlights(@RequestParam
            @Size(min = 3, max = 3)
            final String origin,
            @RequestParam
            @Size(min = 3, max = 3)
            final String destination,
            @RequestParam
            @Pattern(regexp = DATA_PATTERN)
            final String departureDate,
            @RequestParam
            @Pattern(regexp = DATA_PATTERN)
            final String returnDate,
            @RequestParam @Range(min = 1, max = 4) int numberOfPassengers) {

        CrazyAirRequest.Builder crazyAirRequestBuilder = new CrazyAirRequest.Builder()
                .origin(origin)
                .destination(destination)
                .departureDate(departureDate) // mm-dd-yyyy
                .returnDate(returnDate) // mm-dd-yyyy
                .numberOfPassengers(numberOfPassengers);
        return crazyAirService.searchCrazyFlights(crazyAirRequestBuilder.build());
    }

}
