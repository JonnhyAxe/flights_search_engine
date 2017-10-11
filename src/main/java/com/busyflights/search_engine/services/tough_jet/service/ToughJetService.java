package com.busyflights.search_engine.services.tough_jet.service;

import java.util.List;

import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightRequest;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightResponse;


/**
 * Tough Jet Service Interface
 *
 */
@FunctionalInterface
public interface ToughJetService {

    List<ToughJetFlightResponse> searchToughJetFlights(ToughJetFlightRequest toughJetRequest);
}
