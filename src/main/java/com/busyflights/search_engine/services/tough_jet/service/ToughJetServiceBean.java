package com.busyflights.search_engine.services.tough_jet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.busyflights.search_engine.services.enums.Airports;
import com.busyflights.search_engine.services.suppliers.crazy_air.domain.enums.CabinClass;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ToughJetServiceBean.class);

    private static List<ToughJetFlightResponse> mockedData = new ArrayList<>(5);

    static {

        ToughJetFlighTimeInterval.Builder timeBuilder = new ToughJetFlighTimeInterval.Builder()
                .departureDay(14)
                .departureMonth(10)
                .departureYear(2017)
                .returnDay(15)
                .returnMonth(10)
                .returnYear(2017);

        ToughJetFlightResponse.Builder response = new ToughJetFlightResponse.Builder()
                .arrivalAirportName(Airports.LIS.name())
                .departureAirportName(Airports.OPO.name())
                .basePrice(1.00)
                .discount(2.55).tax(0.1)
                .carrier(CabinClass.B.name());


        mockedData.add(response.build(timeBuilder));

        timeBuilder = new ToughJetFlighTimeInterval.Builder()
                .departureDay(14)
                .departureMonth(10)
                .departureYear(2017)
                .returnDay(16)
                .returnMonth(10)
                .returnYear(2017);

        response = new ToughJetFlightResponse.Builder()
                .arrivalAirportName(Airports.LIS.name())
                .departureAirportName(Airports.OPO.name())
                .basePrice(3.00)
                .discount(2.55).tax(0.1).carrier("????");

        mockedData.add(response.build(timeBuilder));

        timeBuilder = new ToughJetFlighTimeInterval.Builder()
                .departureDay(14)
                .departureMonth(10)
                .departureYear(2017)
                .returnDay(17)
                .returnMonth(10)
                .returnYear(2017);

        response = new ToughJetFlightResponse.Builder()
                .arrivalAirportName(Airports.LIS.name())
                .departureAirportName(Airports.OPO.name())
                .basePrice(3.00)
                .discount(2.55).tax(0.1).carrier("????");

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
        Predicate<ToughJetFlightResponse> returnDate = flight -> getReturnDateStr(toughJetRequest).equals(getReturnDateStr(flight));
        Predicate<ToughJetFlightResponse> departureDate = flight -> getDepartureDateStr(toughJetRequest).equals(getDepartureDateStr(flight));

        List<ToughJetFlightResponse> result = mockedData.stream()
                .filter(destinationAirport)
                .peek(flight -> LOGGER.info(" destination Airport {}", flight.getArrivalAirportName()))
                .filter(originAirport)
                .peek(flight -> LOGGER.info(" origin {}", flight.getDepartureAirportName()))
                .filter(departureDate)
                .peek(flight -> LOGGER.info(" Departure {}", flight.getDepartureDay()))
                .filter(returnDate)
                .peek(flight -> LOGGER.info(" Return {}", flight.getReturnDay()))
                .collect(Collectors.toList());
        // .filter(destinationAirport.and(originAirport.and(departureDate.and(returnDate))))
        // .collect(Collectors.toList());

        return result;

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
        return DateUitls.getStringDateMmDdYyyy(toughJetRequest.getReturnYear(), toughJetRequest.getReturnMonth(), toughJetRequest.getReturnDay());
    }

    /**
     * @param toughJetRequest
     */
    private String getDepartureDateStr(ToughJetFlightRequest toughJetRequest) {

        // TODO : change to getStringDateISOFormat(... DateUitls.ISO8601))
        return DateUitls.getStringDateMmDdYyyy(toughJetRequest.getDepartureYear(), toughJetRequest.getDepartureMonth(), toughJetRequest.getDepartureDay());
    }

    /**
     * @param toughJetRequest
     */
    private String getDepartureDateStr(ToughJetFlightResponse toughJetResponse) {

        // TODO : change to getStringDateISOFormat(... DateUitls.ISO8601))
        return DateUitls.getStringDateMmDdYyyy(toughJetResponse.getDepartureYear(), toughJetResponse.getDepartureMonth(), toughJetResponse.getDepartureDay());
    }

}
