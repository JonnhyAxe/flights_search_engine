package com.busyflights.search_engine.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyflights.search_engine.services.BusyFlightsService;
import com.busyflights.search_engine.web.domain.BusyFlightsRequest;
import com.busyflights.search_engine.web.domain.BusyFlightsResponse;

/**
 * Busy Flights Controller
 *
 */
@RestController
@RequestMapping("/busyflights")
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService busyFlightsService;

    @RequestMapping(value = "/flights", method = RequestMethod.POST)
    @ResponseBody
    public List<BusyFlightsResponse> search(@Valid
    @RequestBody
    final BusyFlightsRequest searchRequest) {

        return busyFlightsService.orderedSearchByFare(searchRequest);
    }

}
