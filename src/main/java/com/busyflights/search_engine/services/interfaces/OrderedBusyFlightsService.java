package com.busyflights.search_engine.services.interfaces;

import java.util.List;

import com.busyflights.search_engine.web.domain.BusyFlightsRequest;
import com.busyflights.search_engine.web.domain.BusyFlightsResponse;

/**
 * Ordered Busy Flights Service with Search Criteria
 *
 */
public interface OrderedBusyFlightsService extends BusyFlightsService {

    /**
     * @param searchRequest
     *            with search criteria
     * @return List<BusyFlightsResponse> with result ordered by fare
     */
    List<BusyFlightsResponse> orderedSearchByFare(BusyFlightsRequest searchRequest);

}
