package com.busyflights.search_engine.services.tough_jet.domain;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * ToughJet Flight Response
 */
public class ToughJetFlightResponse extends ToughJetFlighTimeInterval implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4825746715130880364L;

    public static final class Builder {

        private String carrier;

        private Double basePrice;

        private Double tax;

        private Double discount;

        private String departureAirportName;

        private String arrivalAirportName;

        private Builder() {
        }

        public ToughJetFlightResponse build(ToughJetFlighTimeInterval.Builder timeBuilder) {

            return new ToughJetFlightResponse(timeBuilder, this);
        }

        public Builder carrier(String carrier) {

            this.carrier = carrier;
            return this;
        }

        public Builder basePrice(Double basePrice) {

            this.basePrice = basePrice;
            return this;
        }

        public Builder tax(Double tax) {

            this.tax = tax;
            return this;
        }

        public Builder discount(Double discount) {

            this.discount = discount;
            return this;
        }

        public Builder departureAirportName(String departureAirportName) {

            this.departureAirportName = departureAirportName;
            return this;
        }

        public Builder arrivalAirportName(String arrivalAirportName) {

            this.arrivalAirportName = arrivalAirportName;
            return this;
        }

    }

    @NotBlank // not null
    private String carrier;

    @Range(min = 0, max = 100)
    private Double basePrice;

    @Range(min = 0, max = 100)
    private Double tax;

    @Range(min = 0, max = 100)
    private Double discount;

    @Size(min=3, max=3)
    private String departureAirportName;

    @Size(min=3, max=3)
    private String arrivalAirportName;



    public ToughJetFlightResponse(ToughJetFlighTimeInterval.Builder timeIntervalbuilder, ToughJetFlightResponse.Builder builder) {
        super(timeIntervalbuilder);
        this.carrier = builder.carrier;
        this.basePrice = builder.basePrice;
        this.tax = builder.tax;
        this.discount = builder.discount;
        this.departureAirportName = builder.departureAirportName;
        this.arrivalAirportName = builder.arrivalAirportName;

    }

    public static Builder newToughJetResponseDTO() {
        return new Builder();
    }


    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (arrivalAirportName == null ? 0 : arrivalAirportName.hashCode());
        result = prime * result + (basePrice == null ? 0 : basePrice.hashCode());
        result = prime * result + (carrier == null ? 0 : carrier.hashCode());
        result = prime * result + (departureAirportName == null ? 0 : departureAirportName.hashCode());
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + (tax == null ? 0 : tax.hashCode());
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
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ToughJetFlightResponse other = (ToughJetFlightResponse) obj;

        if (!super.equals(other)) {
            return false;
        }
        else if (arrivalAirportName == null) {
            if (other.arrivalAirportName != null) {
                return false;
            }
        }
        else if (!arrivalAirportName.equals(other.arrivalAirportName)) {
            return false;
        }
        if (basePrice == null) {
            if (other.basePrice != null) {
                return false;
            }
        }
        else if (!basePrice.equals(other.basePrice)) {
            return false;
        }
        if (carrier == null) {
            if (other.carrier != null) {
                return false;
            }
        }
        else if (!carrier.equals(other.carrier)) {
            return false;
        }
        if (departureAirportName == null) {
            if (other.departureAirportName != null) {
                return false;
            }
        }
        else if (!departureAirportName.equals(other.departureAirportName)) {
            return false;
        }
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        }
        else if (!discount.equals(other.discount)) {
            return false;
        }
        if (tax == null) {
            if (other.tax != null) {
                return false;
            }
        }
        else if (!tax.equals(other.tax)) {
            return false;
        }
        return true;
    }



}
