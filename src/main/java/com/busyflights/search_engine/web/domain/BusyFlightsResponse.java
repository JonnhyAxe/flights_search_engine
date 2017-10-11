package com.busyflights.search_engine.web.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Busy Flights API Response Model
 *
 */
public class BusyFlightsResponse implements Comparable<BusyFlightsResponse> {


    public static final class Builder {

        private String airline;

        private String supplier;

        private Double fare;

        private String departureAirportCode;

        private String destinationAirportCode;

        private String departureDate;

        private String arrivalDate;

        public Builder() {
        }

        public BusyFlightsResponse build() {

            return new BusyFlightsResponse(this);
        }

        public Builder airline(String airline) {

            this.airline = airline;
            return this;
        }

        public Builder supplier(String supplier) {

            this.supplier = supplier;
            return this;
        }

        public Builder fare(Double fare) {

            this.fare = fare;
            return this;
        }

        public Builder departureAirportCode(String departureAirportCode) {

            this.departureAirportCode = departureAirportCode;
            return this;
        }

        public Builder destinationAirportCode(String destinationAirportCode) {

            this.destinationAirportCode = destinationAirportCode;
            return this;
        }

        public Builder departureDate(String departureDate) {

            this.departureDate = departureDate;
            return this;
        }

        public Builder arrivalDate(String arrivalDate) {

            this.arrivalDate = arrivalDate;
            return this;
        }
    }

    @NotEmpty
    @NotNull
    private String airline;

    @NotEmpty
    @NotNull
    private String supplier;

    @NotNull
    private Double fare;

    @NotEmpty
    @NotNull
    @Size(min = 3, max = 3)
    private String departureAirportCode;

    @NotEmpty
    @NotNull
    @Size(min = 3, max = 3)
    private String destinationAirportCode;

    @NotEmpty
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private String departureDate;

    @NotEmpty
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private String arrivalDate;

    public BusyFlightsResponse() {
    }

    private BusyFlightsResponse(Builder builder) {
        this.airline = builder.airline;
        this.supplier = builder.supplier;
        this.fare = builder.fare;
        this.departureAirportCode = builder.departureAirportCode;
        this.destinationAirportCode = builder.destinationAirportCode;
        this.departureDate = builder.departureDate;
        this.arrivalDate = builder.arrivalDate;
    }

    /**
     * @return the airline
     */
    public String getAirline() {

        return airline;
    }

    /**
     * @param airline
     *            the airline to set
     */
    public void setAirline(String airline) {

        this.airline = airline;
    }

    /**
     * @return the supplier
     */
    public String getSupplier() {

        return supplier;
    }

    /**
     * @param supplier
     *            the supplier to set
     */
    public void setSupplier(String supplier) {

        this.supplier = supplier;
    }

    /**
     * @return the fare
     */
    public Double getFare() {

        return fare;
    }

    /**
     * @param fare
     *            the fare to set
     */
    public void setFare(Double fare) {

        this.fare = fare;
    }

    /**
     * @return the departureAirportCode
     */
    public String getDepartureAirportCode() {

        return departureAirportCode;
    }

    /**
     * @param departureAirportCode
     *            the departureAirportCode to set
     */
    public void setDepartureAirportCode(String departureAirportCode) {

        this.departureAirportCode = departureAirportCode;
    }

    /**
     * @return the destinationAirportCode
     */
    public String getDestinationAirportCode() {

        return destinationAirportCode;
    }

    /**
     * @param destinationAirportCode
     *            the destinationAirportCode to set
     */
    public void setDestinationAirportCode(String destinationAirportCode) {

        this.destinationAirportCode = destinationAirportCode;
    }

    /**
     * @return the departureDate
     */
    public String getDepartureDate() {

        return departureDate;
    }

    /**
     * @param departureDate
     *            the departureDate to set
     */
    public void setDepartureDate(String departureDate) {

        this.departureDate = departureDate;
    }

    /**
     * @return the arrivalDate
     */
    public String getArrivalDate() {

        return arrivalDate;
    }

    /**
     * @param arrivalDate
     *            the arrivalDate to set
     */
    public void setArrivalDate(String arrivalDate) {

        this.arrivalDate = arrivalDate;
    }



    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (airline == null ? 0 : airline.hashCode());
        result = prime * result + (arrivalDate == null ? 0 : arrivalDate.hashCode());
        result = prime * result + (departureAirportCode == null ? 0 : departureAirportCode.hashCode());
        result = prime * result + (departureDate == null ? 0 : departureDate.hashCode());
        result = prime * result + (destinationAirportCode == null ? 0 : destinationAirportCode.hashCode());
        result = prime * result + (fare == null ? 0 : fare.hashCode());
        result = prime * result + (supplier == null ? 0 : supplier.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BusyFlightsResponse other = (BusyFlightsResponse) obj;

        if (!super.equals(other)) {
            return false;
        }
        else if (airline == null) {
            if (other.airline != null) {
                return false;
            }
        }
        else if (!airline.equals(other.airline)) {
            return false;
        }
        if (arrivalDate == null) {
            if (other.arrivalDate != null) {
                return false;
            }
        }
        else if (!arrivalDate.equals(other.arrivalDate)) {
            return false;
        }
        if (departureAirportCode == null) {
            if (other.departureAirportCode != null) {
                return false;
            }
        }
        else if (!departureAirportCode.equals(other.departureAirportCode)) {
            return false;
        }
        if (departureDate == null) {
            if (other.departureDate != null) {
                return false;
            }
        }
        else if (!departureDate.equals(other.departureDate)) {
            return false;
        }
        if (destinationAirportCode == null) {
            if (other.destinationAirportCode != null) {
                return false;
            }
        }
        else if (!destinationAirportCode.equals(other.destinationAirportCode)) {
            return false;
        }
        if (fare == null) {
            if (other.fare != null) {
                return false;
            }
        }
        else if (!fare.equals(other.fare)) {
            return false;
        }
        if (supplier == null) {
            if (other.supplier != null) {
                return false;
            }
        }
        else if (!supplier.equals(other.supplier)) {
            return false;
        }
        return true;
    }

    // https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    public static double round(double value, int places) {

        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(BusyFlightsResponse o) {

        return this.fare.compareTo(o.getFare());
    }


}
