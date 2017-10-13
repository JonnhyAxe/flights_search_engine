package com.busyflights.search_engine.services.tough_jet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.busyflights.search_engine.services.enums.Airports;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlighTimeInterval;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightRequest;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightResponse;

/**
 * Tough Jet Service Bean implementation
 *
 */
@Service
public class ToughJetServiceBean implements ToughJetService {

    private static List<ToughJetFlightResponse> mockedData = new ArrayList<>(5);

    static {

        ToughJetFlighTimeInterval.Builder timeBuilder = new ToughJetFlighTimeInterval.Builder()
                .departureDay(13)
                .departureMonth(10)
                .departureYear(2017)
                .returnDay(15)
                .returnMonth(10)
                .returnYear(2017);

        ToughJetFlightResponse.Builder response = new ToughJetFlightResponse.Builder()
                .arrivalAirportName(Airports.APO.name())
                .departureAirportName(Airports.LIS.name())
                .basePrice(12.34)
                .discount(2.55).tax(0.1).carrier("?????");


        mockedData.add(response.build(timeBuilder));

    }

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

        return mockedData;
    }

}
