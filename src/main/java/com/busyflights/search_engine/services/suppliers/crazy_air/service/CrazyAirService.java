package com.busyflights.search_engine.services.suppliers.crazy_air.service;

import java.util.List;

import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirRequest;
import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirResponse;

/**
 * Crazy Air Service Interface
 *
 */
@FunctionalInterface
public interface CrazyAirService {

    List<CrazyAirResponse> searchCrazyFlights(CrazyAirRequest crazyAirRequest);
}
