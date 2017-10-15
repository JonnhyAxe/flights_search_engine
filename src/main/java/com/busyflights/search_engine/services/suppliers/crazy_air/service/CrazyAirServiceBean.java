package com.busyflights.search_engine.services.suppliers.crazy_air.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.busyflights.search_engine.services.enums.AirLines;
import com.busyflights.search_engine.services.enums.Airports;
import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirRequest;
import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirResponse;
import com.busyflights.search_engine.services.suppliers.crazy_air.domain.enums.CabinClass;
import com.busyflights.search_engine.utils.DateUtils;

/**
 * Crazy Air Service Bean
 *
 */
@Service
public class CrazyAirServiceBean implements CrazyAirService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrazyAirServiceBean.class);

    private static List<CrazyAirResponse> mockedData = new ArrayList<>(5);

    static {

        CrazyAirResponse.Builder crazyAirResponseBuilder = new CrazyAirResponse.Builder()
                .airline(AirLines.TAP.name())
                .departureAirportCode(Airports.OPO.name())
                .destinationAirportCode(Airports.LIS.name())
                .departureDate(DateUtils.getStringDateISOFormat(2017, 10, 14, 0, 0, 0, DateUtils.MM_DD_YYYY_HHMMSS_FORMAT))
                .arrivalDate(DateUtils.getStringDateISOFormat(2017, 10, 15, 0, 0, 0, DateUtils.MM_DD_YYYY_HHMMSS_FORMAT))
                .price(13.66)
                .cabinclass(CabinClass.B);

        mockedData.add(crazyAirResponseBuilder.build());

        crazyAirResponseBuilder = new CrazyAirResponse.Builder()
                .airline(AirLines.TAP.name())
                .departureAirportCode(Airports.OPO.name())
                .destinationAirportCode(Airports.LIS.name())
                .departureDate(DateUtils.getStringDateISOFormat(2017, 10, 14, 0, 0, 0, DateUtils.MM_DD_YYYY_HHMMSS_FORMAT))
                .arrivalDate(DateUtils.getStringDateISOFormat(2017, 10, 16, 0, 0, 0, DateUtils.MM_DD_YYYY_HHMMSS_FORMAT))
                .price(1.66)
                .cabinclass(CabinClass.B);

        mockedData.add(crazyAirResponseBuilder.build());

        crazyAirResponseBuilder = new CrazyAirResponse.Builder()
                .airline(AirLines.TAP.name())
                .departureAirportCode(Airports.OPO.name())
                .destinationAirportCode(Airports.LIS.name())
                .departureDate(DateUtils.getStringDateISOFormat(2017, 10, 14, 0, 0, 0, DateUtils.MM_DD_YYYY_HHMMSS_FORMAT))
                .arrivalDate(DateUtils.getStringDateISOFormat(2017, 10, 17, 0, 0, 0, DateUtils.MM_DD_YYYY_HHMMSS_FORMAT))
                .price(12.66)
                .cabinclass(CabinClass.B);

        mockedData.add(crazyAirResponseBuilder.build());

    }



    /*
     * (non-Javadoc)
     *
     * @see com.busyflights.search_engine.services.suppliers.crazy_air.service.
     * CrazyAirService#searchCrazyFlights(com.busyflights.search_engine.services
     * .suppliers.crazy_air.domain.CrazyAirRequest)
     */
    @Override
    public List<CrazyAirResponse> searchCrazyFlights(CrazyAirRequest crazyAirRequest) {

        Predicate<CrazyAirResponse> destinationAirport = flight -> flight.getDestinationAirportCode().equals(crazyAirRequest.getDestination());
        Predicate<CrazyAirResponse> originAirport = flight -> flight.getDepartureAirportCode().equals(crazyAirRequest.getOrigin());
        Predicate<CrazyAirResponse> departureDate = flight -> flight.getDepartureDate().contains(crazyAirRequest.getDepartureDate());
        Predicate<CrazyAirResponse> arrivalDate = flight -> flight.getArrivalDate().contains(crazyAirRequest.getReturnDate());

        List<CrazyAirResponse> listCrazyAirResponse = mockedData.stream()
                .filter(destinationAirport)
                .peek(flight -> LOGGER.info(" Destination {}", flight.getDestinationAirportCode()))
                .filter(originAirport)
                .peek(flight -> LOGGER.info(" Origin {}", flight.getDepartureAirportCode()))
                .filter(departureDate)
                .peek(flight -> LOGGER.info(" Departure {}", flight.getDepartureDate()))
                .filter(arrivalDate)
                .peek(flight -> LOGGER.info(" Arrival {}", flight.getArrivalDate()))
                .collect(Collectors.toList());

        return listCrazyAirResponse;

    }

}
