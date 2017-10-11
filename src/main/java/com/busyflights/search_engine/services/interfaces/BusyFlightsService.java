package com.busyflights.search_engine.services.interfaces;

import java.util.List;

import com.busyflights.search_engine.web.domain.BusyFlightsRequest;
import com.busyflights.search_engine.web.domain.BusyFlightsResponse;

/**
 * Busy Flights Service with Search Criterias
 *
 */
public interface BusyFlightsService {

    /**
     * @param searchRequest
     *            with search criteria
     * @return List<BusyFlightsResponse> with result ordered by fare
     */
    List<BusyFlightsResponse> searchBusyFlights(BusyFlightsRequest searchRequest);

}
