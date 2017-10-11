package com.busyflights.search_engine.web.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Busy Flight Request Domain Model
 *
 */
public class BusyFlightRequest {

    public static final class Builder {

        private String origin;

        private String destination;

        private String departureDate;

        private String returnDate;

        private Integer numberOfPassengers;

        private Builder() {
        }

        public BusyFlightRequest build() {

            return new BusyFlightRequest(this);
        }

        public Builder origin(String origin) {

            this.origin = origin;
            return this;
        }

        public Builder destination(String destination) {

            this.destination = destination;
            return this;
        }

        public Builder departureDate(String departureDate) {

            this.departureDate = departureDate;
            return this;
        }

        public Builder returnDate(String returnDate) {

            this.returnDate = returnDate;
            return this;
        }

        public Builder numberOfPassengers(Integer numberOfPassengers) {

            this.numberOfPassengers = numberOfPassengers;
            return this;
        }
    }

    @Size(min = 3, max = 3)
    private String origin;

    @Size(min = 3, max = 3)
    private String destination;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private String departureDate;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.NONE)
    private String returnDate;

    @Range(min = 1, max = 4)
    private Integer numberOfPassengers;

    public BusyFlightRequest() {
    }

    private BusyFlightRequest(Builder builder) {
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.departureDate = builder.departureDate;
        this.returnDate = builder.returnDate;
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {

        return origin;
    }

    /**
     * @param origin
     *            the origin to set
     */
    public void setOrigin(String origin) {

        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public String getDestination() {

        return destination;
    }

    /**
     * @param destination
     *            the destination to set
     */
    public void setDestination(String destination) {

        this.destination = destination;
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
     * @return the returnDate
     */
    public String getReturnDate() {

        return returnDate;
    }

    /**
     * @param returnDate
     *            the returnDate to set
     */
    public void setReturnDate(String returnDate) {

        this.returnDate = returnDate;
    }

    /**
     * @return the numberOfPassengers
     */
    public Integer getNumberOfPassengers() {

        return numberOfPassengers;
    }

    /**
     * @param numberOfPassengers
     *            the numberOfPassengers to set
     */
    public void setNumberOfPassengers(Integer numberOfPassengers) {

        this.numberOfPassengers = numberOfPassengers;
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
        result = prime * result + (departureDate == null ? 0 : departureDate.hashCode());
        result = prime * result + (destination == null ? 0 : destination.hashCode());
        result = prime * result + (numberOfPassengers == null ? 0 : numberOfPassengers.hashCode());
        result = prime * result + (origin == null ? 0 : origin.hashCode());
        result = prime * result + (returnDate == null ? 0 : returnDate.hashCode());
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
        BusyFlightRequest other = (BusyFlightRequest) obj;
        if (departureDate == null) {
            if (other.departureDate != null) {
                return false;
            }
        }
        else if (!departureDate.equals(other.departureDate)) {
            return false;
        }
        if (destination == null) {
            if (other.destination != null) {
                return false;
            }
        }
        else if (!destination.equals(other.destination)) {
            return false;
        }
        if (numberOfPassengers == null) {
            if (other.numberOfPassengers != null) {
                return false;
            }
        }
        else if (!numberOfPassengers.equals(other.numberOfPassengers)) {
            return false;
        }
        if (origin == null) {
            if (other.origin != null) {
                return false;
            }
        }
        else if (!origin.equals(other.origin)) {
            return false;
        }
        if (returnDate == null) {
            if (other.returnDate != null) {
                return false;
            }
        }
        else if (!returnDate.equals(other.returnDate)) {
            return false;
        }
        return true;
    }

}
