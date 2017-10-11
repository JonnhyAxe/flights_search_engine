package com.busyflights.search_engine.services.suppliers.crazy_air.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.busyflights.search_engine.services.suppliers.crazy_air.domain.enums.CabinClass;

/**
 * Crazy Air Response Domain Model
 */
public class CrazyAirResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5330373528135783387L;

    public static final class Builder {

        private String airline;

        private Double price;

        private CabinClass cabinclass;

        private String departureAirportCode;

        private String destinationAirportCode;

        // mm-dd-yyyy HH:MM:ss
        private String departureDate;

        private String arrivalDate;

        private Builder() {
        }

        public CrazyAirResponse build() {

            return new CrazyAirResponse(this);
        }

        public Builder airline(String airline) {

            this.airline = airline;
            return this;
        }

        public Builder price(Double price) {

            this.price = price;
            return this;
        }

        public Builder cabinclass(CabinClass cabinclass) {

            this.cabinclass = cabinclass;
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

    @NotNull
    @NotEmpty
    private String airline;

    @NotNull
    @NotEmpty
    private Double price;

    @NotNull
    @NotEmpty
    private String cabinclass;

    @NotNull
    @NotEmpty
    @Size(min=3, max=3)
    private String departureAirportCode;

    @NotNull
    @NotEmpty
    @Size(min=3, max=3)
    private String destinationAirportCode;

    @NotNull
    @NotEmpty
    private String departureDate;

    @NotNull
    @NotEmpty
    private String arrivalDate;

    public CrazyAirResponse() {
    }

    private CrazyAirResponse(Builder builder) {
        this.airline = builder.airline;
        this.price = builder.price;
        this.cabinclass = builder.cabinclass.name();
        this.departureAirportCode = builder.departureAirportCode;
        this.destinationAirportCode = builder.destinationAirportCode;
        this.departureDate = builder.departureDate;
        this.arrivalDate = builder.arrivalDate;
    }

    public static Builder newCrazyAirResponseDTO() {
        return new Builder();
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

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
        result = prime * result + (cabinclass == null ? 0 : cabinclass.hashCode());
        result = prime * result + (departureAirportCode == null ? 0 : departureAirportCode.hashCode());
        result = prime * result + (departureDate == null ? 0 : departureDate.hashCode());
        result = prime * result + (destinationAirportCode == null ? 0 : destinationAirportCode.hashCode());
        result = prime * result + (price == null ? 0 : price.hashCode());
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
        CrazyAirResponse other = (CrazyAirResponse) obj;
        if (airline == null) {
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
        if (cabinclass == null) {
            if (other.cabinclass != null) {
                return false;
            }
        }
        else if (!cabinclass.equals(other.cabinclass)) {
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
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        }
        else if (!price.equals(other.price)) {
            return false;
        }
        return true;
    }

}
