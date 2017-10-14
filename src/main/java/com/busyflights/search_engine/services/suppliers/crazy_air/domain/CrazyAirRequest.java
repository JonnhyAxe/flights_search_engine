package com.busyflights.search_engine.services.suppliers.crazy_air.domain;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * Crazy Air Request Domain Model
 */
public class CrazyAirRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8936106907424932133L;

    public static final class Builder {

        private String origin;

        private String destination;

        private String departureDate;

        private String returnDate;

        private Integer numberOfPassengers;

        public Builder() {
        }

        public CrazyAirRequest build() {

            return new CrazyAirRequest(this);
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

    @Size(min=3, max=3)
    private String origin;

    @Size(min=3, max=3)
    private String destination;

    // @Pattern(regexp =
    // "/^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/")
    @Pattern(regexp = "^(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])-([0-9][0-9])?[0-9][0-9]$")
    private String departureDate;

    @Pattern(regexp = "^(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])-([0-9][0-9])?[0-9][0-9]$")
    private String returnDate;

    @Range(min = 1, max = 4)
    private Integer numberOfPassengers;

    public CrazyAirRequest() {
    }

    private CrazyAirRequest(Builder builder) {
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.departureDate = builder.departureDate;
        this.returnDate = builder.returnDate;
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    public static Builder newCrazyAirRequestDTO() {
        return new Builder();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

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
        CrazyAirRequest other = (CrazyAirRequest) obj;
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("From [").append(this.origin) .append("]")
        .append("Destination [").append(this.destination) .append("]")
                .append("Departure Date [").append(this.departureDate).append("]")
                .append("Return Date [").append(this.returnDate).append("]")
                .append("Return Date [").append(this.numberOfPassengers).append("]");

        return str.toString();
    }

}
