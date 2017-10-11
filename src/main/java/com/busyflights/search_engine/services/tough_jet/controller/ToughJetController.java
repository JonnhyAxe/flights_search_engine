package com.busyflights.search_engine.services.tough_jet.controller;

import static com.busyflights.search_engine.utils.DateUitls.MINIMUM_DAY;
import static com.busyflights.search_engine.utils.DateUitls.MINIMUM_MONTH;
import static com.busyflights.search_engine.utils.DateUitls.MINIMUM_YEAR;

import java.util.List;

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
            @Range(min = MINIMUM_DAY, max = MINIMUM_YEAR)
            final int departureDay,
            @RequestParam
            @Range(min = MINIMUM_MONTH, max = MINIMUM_MONTH)
            final int departureMonth,
            @RequestParam
            @Range(min = MINIMUM_YEAR, max = Integer.MAX_VALUE)
            final int departureYear,
            @RequestParam
            @Range(min = MINIMUM_DAY, max = MINIMUM_YEAR)
            final int returnDay,
            @RequestParam
            @Range(min = MINIMUM_MONTH, max = MINIMUM_MONTH)
            final int returnMonth,
            @RequestParam
            @Range(min = MINIMUM_YEAR, max = Integer.MAX_VALUE)
            final int returnYear,
            @RequestParam
            @Range(min = 1, max = 4)
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
