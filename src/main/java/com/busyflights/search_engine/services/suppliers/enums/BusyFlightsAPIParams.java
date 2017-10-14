package com.busyflights.search_engine.services.suppliers.enums;


/**
 * Enums to used by REQUEST for suppliers
 *
 */
public enum BusyFlightsAPIParams {

    FROM("from"), TO("to"), ORIGIN("origin"), DESTINATION("destination"), DEPARTURE_DATE("departureDate"), RETURN_DATE("returnDate"), RETURN_DAY(
            "returnDay"), RETURN_MONTH("returnMonth"), RETURN_YEAR("returnYear"), DEPARTURE_DAY("departureDay"), DEPARTURE_MONTH(
                    "departureMonth"), DEPARTURE_YEAR("departureYear"), NUMBER_OF_PASSENGERS("numberOfPassengers"), NUMBER_OF_ADULTS("numberOfAdults");

    private BusyFlightsAPIParams(String name){
        this.name = name;

    }
    private String name;

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }
}
