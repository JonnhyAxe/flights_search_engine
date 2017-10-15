package com.busyflights.search_engine.web.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;

import com.busyflights.search_engine.config.BusyFlightsWebConfig;
import com.busyflights.search_engine.services.enums.AirLines;
import com.busyflights.search_engine.services.enums.Airports;
import com.busyflights.search_engine.web.domain.BusyFlightsResponse;
import com.busyflights.search_engine.web.domain.enums.Suppliers;

/**
 * Busy Flight Controller
 *
 */
@SpringBootTest
@ContextConfiguration(classes = { BusyFlightsWebConfig.class }, loader = AnnotationConfigContextLoader.class)
public class BusyFlightServiceTest {

    /**
     *
     */
    private static final String CRAZY_FLIGHT_IRL_FORMAT = "http://localhost:8080/busy-flights/flights?origin=%s&destination=%s&departureDate=%s&returnDate=%s&numberOfPassengers=%s";
    @Autowired
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {

        template = new RestTemplate();
    }

    @Test
    public void crazyFlightRestTest() throws InterruptedException, ExecutionException {


        String origin = "OPO";
        String destination = "LIS";
        String departureDate = "2017-10-14";
        String returnDate = "2017-10-15";
        String numberOfPassengers = "3";

        final String marvelCaractersUrl = String.format(CRAZY_FLIGHT_IRL_FORMAT, origin, destination, departureDate, returnDate, numberOfPassengers);

        BusyFlightsResponse[] crazyAirResponse = template.getForObject(marvelCaractersUrl, BusyFlightsResponse[].class);

        assertThat(crazyAirResponse, notNullValue());
        assertThat(crazyAirResponse.length, equalTo(2));

        BusyFlightsResponse crazyAirResponse1 = crazyAirResponse[0];
        assertThat(crazyAirResponse1, notNullValue());
        assertThat(crazyAirResponse1.getSupplier(), equalTo(Suppliers.TOUGH_JET.name()));
        assertThat(crazyAirResponse1.getAirline(), equalTo(AirLines.TAP.name()));
        assertThat(crazyAirResponse1.getDepartureAirportCode(), equalTo(Airports.OPO.name()));
        assertThat(crazyAirResponse1.getDestinationAirportCode(), equalTo(Airports.LIS.name()));
        assertTrue(crazyAirResponse1.getDepartureDate().contains(departureDate)); // "10-14-2017
                                                                                  // 12:00:00"
        assertTrue(crazyAirResponse1.getArrivalDate().contains(returnDate));

        BusyFlightsResponse crazyAirResponse2 = crazyAirResponse[1];
        assertThat(crazyAirResponse2, notNullValue());
        assertThat(crazyAirResponse2.getSupplier(), equalTo(Suppliers.CRAZY_AIR.name()));
        assertThat(crazyAirResponse2.getAirline(), equalTo(AirLines.TAP.name()));
        assertThat(crazyAirResponse2.getDepartureAirportCode(), equalTo(Airports.OPO.name()));
        assertThat(crazyAirResponse2.getDestinationAirportCode(), equalTo(Airports.LIS.name()));
        assertTrue(crazyAirResponse2.getDepartureDate().contains(departureDate));
        assertTrue(crazyAirResponse2.getArrivalDate().contains(returnDate));

        assertTrue(crazyAirResponse2.getFare() >= crazyAirResponse1.getFare());

    }

}
