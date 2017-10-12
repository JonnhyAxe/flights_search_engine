package com.busyflights.search_engine.services.tough_jet.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightRequest;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightResponse;

/**
 * <class description>
 *
 */
@Service
public class ToughJetServiceBean implements ToughJetService {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.busyflights.search_engine.services.tough_jet.service.ToughJetService#
     * searchToughJetFlights(com.busyflights.search_engine.services.tough_jet.
     * domain.ToughJetFlightRequest)
     */
    @Override
    public List<ToughJetFlightResponse> searchToughJetFlights(ToughJetFlightRequest toughJetRequest) {

        return Collections.emptyList();
    }

}
