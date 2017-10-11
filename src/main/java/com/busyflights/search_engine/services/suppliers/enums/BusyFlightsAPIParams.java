package com.busyflights.search_engine.services.suppliers.enums;


/**
 * Enums to used by REQUEST for suppliers
 *
 */
public enum BusyFlightsAPIParams {

    FROM("origin"), TO("destination"), DEPARTURE_DATE("departureDate"), RETURN_DATE("returnDate"), NUMBER_OF_ADULTS("numberOfPassengers");

    private BusyFlightsAPIParams(String name){
        this.name = name;

    }
    private String name;
}
