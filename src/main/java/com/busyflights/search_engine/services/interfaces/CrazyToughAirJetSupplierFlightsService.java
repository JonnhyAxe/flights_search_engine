package com.busyflights.search_engine.services.interfaces;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirResponse;
import com.busyflights.search_engine.services.suppliers.enums.BusyFlightsAPIParams;
import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightResponse;
import com.busyflights.search_engine.services.utils.DateHelpers;
import com.busyflights.search_engine.web.domain.BusyFlightsRequest;
import com.busyflights.search_engine.web.domain.BusyFlightsResponse;
import com.busyflights.search_engine.web.domain.enums.Suppliers;

/**
 * Ordered Busy Flights Service Implementation for Crazy-Air Tough-Jet Suppliers
 *
 */

@Service
public class CrazyToughAirJetSupplierFlightsService implements OrderedBusyFlightsService {


    /**
     *
     */
    private static final String HYPHEN = "-";

    /**
     *
     */
    private static final String SIGN_PARAM = "=";

    /**
     *
     */
    private static final String QUERY_PARAM = "?";

    /**
    *
    */
    private static final String AND_PARAM = "&";

    @Value("${crazyair.url}")
    private String crazyairUrl;

    @Value("${toughjet.url}")
    private String toughjetUrl;

    @Value("${providers.timeout}")
    private long providersTimeout;

    BiFunction<BusyFlightsRequest, String, String> appendReqParamsToCrazyAirURL = (busyFlightsReq, urlStr) -> {

        // considering that the url is correct
        StringBuilder urlEntity = new StringBuilder(urlStr);
        urlEntity.append(QUERY_PARAM)
                .append(BusyFlightsAPIParams.ORIGIN.getName()).append(SIGN_PARAM).append(busyFlightsReq.getOrigin()).append(AND_PARAM)
                .append(BusyFlightsAPIParams.DESTINATION.getName()).append(SIGN_PARAM).append(busyFlightsReq.getDestination()).append(AND_PARAM)
                .append(BusyFlightsAPIParams.DEPARTURE_DATE.getName()).append(SIGN_PARAM).append(busyFlightsReq.getDepartureDate()).append(AND_PARAM)
                .append(BusyFlightsAPIParams.RETURN_DATE.getName()).append(SIGN_PARAM).append(busyFlightsReq.getReturnDate()).append(AND_PARAM)
                .append(BusyFlightsAPIParams.NUMBER_OF_PASSENGERS.getName()).append(SIGN_PARAM).append(busyFlightsReq.getNumberOfPassengers());
        return urlEntity.toString();
    };

    BiFunction<BusyFlightsRequest, String, String> appendReqParamsToToughJetURL = (busyFlightsReq, urlStr) -> {

        // considering that the url is correct

        StringBuilder urlEntity = new StringBuilder(urlStr);

        LocalDate departureLocalDate = DateHelpers.getLocalDateFromStringInISO8601(busyFlightsReq.getDepartureDate());
        LocalDate returnLocalDate = DateHelpers.getLocalDateFromStringInISO8601(busyFlightsReq.getReturnDate());


        Integer departureDay = departureLocalDate.getDayOfMonth();
        Integer departureMonth = departureLocalDate.getMonthValue();
        Integer departureYear = departureLocalDate.getYear();
        Integer returnedDay = returnLocalDate.getDayOfMonth();
        Integer returnedMonth = returnLocalDate.getMonthValue();
        Integer returnedYear = returnLocalDate.getYear();

        urlEntity.append(QUERY_PARAM)
                .append(BusyFlightsAPIParams.FROM.getName()).append(SIGN_PARAM).append(busyFlightsReq.getOrigin()).append(AND_PARAM)
                .append(BusyFlightsAPIParams.TO.getName()).append(SIGN_PARAM).append(busyFlightsReq.getDestination()).append(AND_PARAM)
                .append(BusyFlightsAPIParams.DEPARTURE_DAY.getName()).append(SIGN_PARAM).append(departureDay).append(AND_PARAM)
                .append(BusyFlightsAPIParams.DEPARTURE_MONTH.getName()).append(SIGN_PARAM).append(departureMonth).append(AND_PARAM)
                .append(BusyFlightsAPIParams.DEPARTURE_YEAR.getName()).append(SIGN_PARAM).append(departureYear).append(AND_PARAM)
                .append(BusyFlightsAPIParams.RETURN_DAY.getName()).append(SIGN_PARAM).append(returnedDay).append(AND_PARAM)
                .append(BusyFlightsAPIParams.RETURN_MONTH.getName()).append(SIGN_PARAM).append(returnedMonth).append(AND_PARAM)
                .append(BusyFlightsAPIParams.RETURN_YEAR.getName()).append(SIGN_PARAM).append(returnedYear).append(AND_PARAM)
                .append(BusyFlightsAPIParams.NUMBER_OF_ADULTS.getName()).append(SIGN_PARAM).append(busyFlightsReq.getNumberOfPassengers());
        return urlEntity.toString();
    };


    Function<CrazyAirResponse, BusyFlightsResponse> convertCrazyAirToBusyFlights = (crazy) -> {

        return new BusyFlightsResponse.Builder()
                .airline(crazy.getAirline())
                .supplier(Suppliers.CRAZY_AIR.name())
                .fare(crazy.getPrice())
                .arrivalDate(crazy.getArrivalDate())
                .departureAirportCode(crazy.getDepartureAirportCode())
                .destinationAirportCode(crazy.getDestinationAirportCode())
                .destinationAirportCode(crazy.getDestinationAirportCode())
                .departureDate(crazy.getDepartureDate())
                .arrivalDate(crazy.getArrivalDate())
                .build();
    };

    Function<ToughJetFlightResponse, BusyFlightsResponse> convertToughJetToBusyFlights = (tough) -> {

        StringBuilder date = new StringBuilder().append(tough.getDepartureMonth()).append(HYPHEN)
                .append(tough.getDepartureDay()).append(HYPHEN)
                .append(tough.getDepartureYear());

        return new BusyFlightsResponse.Builder()
                .airline(tough.getCarrier())
                .supplier(Suppliers.TOUGH_JET.name())
                .fare(tough.getBasePrice())
                // .arrivalDate(tough.get())
                .departureAirportCode(tough.getDepartureAirportName())
                .destinationAirportCode(tough.getDepartureAirportName())
                .departureDate(date.toString())
                .build();
    };

    /*
     * (non-Javadoc)
     *
     * @see
     * com.busyflights.search_engine.services.interfaces.BusyFlightsService#
     * searchBusyFlights(com.busyflights.search_engine.web.domain.
     * BusyFlightsRequest)
     */
    @Override
    public List<BusyFlightsResponse> searchBusyFlights(BusyFlightsRequest searchRequest) {

        List<BusyFlightsResponse> result = Collections.emptyList();

        try {
            CompletableFuture<List<CrazyAirResponse>> crazyAirResponse = getAsyncCrazyAirFlights(searchRequest);

            CompletableFuture<List<ToughJetFlightResponse>> toughJetAirResponse = getAsyncToughJetFlights(searchRequest);

            CompletableFuture.allOf(crazyAirResponse, toughJetAirResponse).join();

            List<BusyFlightsResponse> busyFlightsResponseFromAirResponse = crazyAirResponse.get().stream()
                    .map(convertCrazyAirToBusyFlights).collect(Collectors.toList());


            List<BusyFlightsResponse> busyFlightsResponseFromToughResponse = toughJetAirResponse.get().stream()
                    .map(convertToughJetToBusyFlights)
                    .collect(Collectors.toList());

            result = new ArrayList<>(crazyAirResponse.get().size() + toughJetAirResponse.get().size());

            result.addAll(busyFlightsResponseFromAirResponse);
            result.addAll(busyFlightsResponseFromToughResponse);
            Collections.sort(result);
        }
        catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.busyflights.search_engine.services.interfaces.
     * OrderedBusyFlightsService#orderedSearchByFare(com.busyflights.
     * search_engine.web.domain.BusyFlightsRequest)
     */
    @Override
    public List<BusyFlightsResponse> orderedSearchByFare(BusyFlightsRequest searchRequest) {

        List<BusyFlightsResponse> allFlights = searchBusyFlights(searchRequest);
        Collections.sort(allFlights, (f1, f2) -> f1.getFare().compareTo(f2.getFare()));
        return allFlights;
    }

    @Async
    public CompletableFuture<List<CrazyAirResponse>> getAsyncCrazyAirFlights(BusyFlightsRequest searchRequest) throws InterruptedException {

        return CompletableFuture.completedFuture(getCrazyAirFlights(searchRequest));
    }

    private List<CrazyAirResponse> getCrazyAirFlights(BusyFlightsRequest searchRequest) {

        List<CrazyAirResponse> result = null;
        ResponseEntity<List<CrazyAirResponse>> rateResponse = null;
        String getUrlEntityWithParameters = appendReqParamsToCrazyAirURL.apply(searchRequest, this.crazyairUrl);
        try {
            URLEncoder.encode(getUrlEntityWithParameters, "UTF-8");
            rateResponse = new RestTemplate().exchange(getUrlEntityWithParameters,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<CrazyAirResponse>>() {
                    });

            result = rateResponse.getBody();

        }
        catch (UnsupportedEncodingException | org.springframework.web.client.HttpClientErrorException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            result = Collections.emptyList();
        }

        return result;
    }

    @Async
    public CompletableFuture<List<ToughJetFlightResponse>> getAsyncToughJetFlights(BusyFlightsRequest searchRequest) throws InterruptedException {

        return CompletableFuture.completedFuture(getToughJetFlights(searchRequest));
    }

    private List<ToughJetFlightResponse> getToughJetFlights(BusyFlightsRequest searchRequest) {

        String getUrlEntityWithParameters = appendReqParamsToToughJetURL.apply(searchRequest, this.toughjetUrl);

        ResponseEntity<List<ToughJetFlightResponse>> rateResponse = new RestTemplate().exchange(getUrlEntityWithParameters,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<ToughJetFlightResponse>>() {
                });

        return rateResponse.getBody();
    }
}
