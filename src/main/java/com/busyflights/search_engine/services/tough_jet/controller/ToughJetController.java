package com.busyflights.search_engine.services.tough_jet.controller;

import java.util.List;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlighTimeInterval;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightRequest;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightResponse;
import com.busyflights.search_engine.services.tough_jet.service.ToughJetService;
import com.busyflights.search_engine.utils.DateUtils;


@RequestMapping("/tough-jet") // hyphens are OK
@RestController
public class ToughJetController {



    @Autowired
    private ToughJetService toughJetService;

    @RequestMapping(value = "/flights", method = RequestMethod.GET, params = { "from", "to", "departureDay", "departureMonth", "departureYear", "returnDay", "returnMonth", "returnYear", "numberOfAdults" })
    @ResponseBody
    public List<ToughJetFlightResponse> searchToughJetFlights(@RequestParam
            @Size(min = 3, max = 3)
            final String from,
            @RequestParam
            @Size(min = 3, max = 3)
            final String to,
            @RequestParam
            @Range(min = DateUtils.MINIMUM_DAY, max = DateUtils.MAX_DAY)
            final int departureDay,
            @RequestParam
            @Range(min = DateUtils.MINIMUM_MONTH, max = DateUtils.MAX_MONTH)
            final int departureMonth,
            @RequestParam
            @Range(min = DateUtils.MINIMUM_YEAR, max = Integer.MAX_VALUE)
            final int departureYear,
            @RequestParam
            @Range(min = DateUtils.MINIMUM_DAY, max = DateUtils.MAX_DAY)
            @Null
            final int returnDay,
            @RequestParam
            @Range(min = DateUtils.MINIMUM_MONTH, max = DateUtils.MINIMUM_MONTH)
            @Null
            final int returnMonth,
            @RequestParam
            @Range(min = DateUtils.MINIMUM_YEAR, max = Integer.MAX_VALUE)
            @Null
            final int returnYear,
            @RequestParam
            @Range(min = 1, max = Integer.MAX_VALUE)
            final int numberOfAdults) {


        ToughJetFlighTimeInterval.Builder timeBuilder = new ToughJetFlighTimeInterval.Builder()
                .departureDay(departureDay)
                .departureMonth(departureMonth)
                .departureYear(departureYear)
                .returnDay(returnDay)
                .returnMonth(returnMonth)
                .returnYear(returnYear);

        ToughJetFlightRequest.Builder requestBuilder = new ToughJetFlightRequest.Builder()
                .fromVenue(from)
                .toVenue(to)
                .numberOfAdults(numberOfAdults);

        return toughJetService.searchToughJetFlights(requestBuilder.build(timeBuilder));
    }

}
