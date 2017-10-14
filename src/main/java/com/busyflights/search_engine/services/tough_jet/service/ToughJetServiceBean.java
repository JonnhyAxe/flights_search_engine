package com.busyflights.search_engine.services.tough_jet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.busyflights.search_engine.services.enums.Airports;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlighTimeInterval;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightRequest;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightResponse;
import com.busyflights.search_engine.utils.DateUitls;

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



        Predicate<ToughJetFlightResponse> destinationAirport = flight -> flight.getArrivalAirportName().equals(toughJetRequest.getTo());
        Predicate<ToughJetFlightResponse> originAirport = flight -> flight.getDepartureAirportName().equals(toughJetRequest.getFrom());
        Predicate<ToughJetFlightResponse> departureDate = flight -> getDepartureDateStr(toughJetRequest).equals(getDepartureDateStr(flight));
        Predicate<ToughJetFlightResponse> returnDate = flight -> getReturnDateStr(toughJetRequest).equals(getReturnDateStr(flight));

        return mockedData.stream()
                .filter(destinationAirport.and(originAirport.and(departureDate.and(returnDate))))
                .collect(Collectors.toList());

    }

    /**
     * @param flight
     * @return
     */
    private String getReturnDateStr(ToughJetFlightResponse flight) {

        // TODO : change to getStringDateISOFormat(... DateUitls.ISO8601))
        return DateUitls.getStringDateMmDdYyyy(flight.getReturnYear(), flight.getReturnMonth(), flight.getReturnDay());
    }

    /**
     * @param toughJetRequest
     * @return
     */
    private Object getReturnDateStr(ToughJetFlightRequest toughJetRequest) {

        // TODO : change to getStringDateISOFormat(... DateUitls.ISO8601))
        return DateUitls.getStringDateMmDdYyyy(toughJetRequest.getReturnYear(), toughJetRequest.getReturnMonth(),
                toughJetRequest.getReturnDay());
    }

    /**
     * @param toughJetRequest
     */
    private String getDepartureDateStr(ToughJetFlightRequest toughJetRequest) {

        // TODO : change to getStringDateISOFormat(... DateUitls.ISO8601))
        return DateUitls.getStringDateMmDdYyyy(toughJetRequest.getDepartureYear(), toughJetRequest.getDepartureMonth(),
                toughJetRequest.getDepartureYear());
    }

    /**
     * @param toughJetRequest
     */
    private String getDepartureDateStr(ToughJetFlightResponse toughJetResponse) {

        // TODO : change to getStringDateISOFormat(... DateUitls.ISO8601))
        return DateUitls.getStringDateMmDdYyyy(toughJetResponse.getDepartureYear(), toughJetResponse.getDepartureMonth(),
                toughJetResponse.getDepartureYear());
    }

}
