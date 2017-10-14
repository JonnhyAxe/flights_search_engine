package com.busyflights.search_engine.services.tough_jet.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * ToughJet Flight Request
 */
public class ToughJetFlightRequest extends ToughJetFlighTimeInterval {

    /**
     * Minimum number of adults
     */
    private static final int MINIMUM_OF_ADULTS = 1;

    /**
     * Minimum number of adults
     */
    private static final int NUMBER_OF_ADULTS = 4;

    /**
     *
     */
    private static final long serialVersionUID = -1712944997662360039L;

    public static final class Builder {

        private String fromVenue;

        private String toVenue;

        private Integer numberOfAdults;

        public Builder() {
        }

        public ToughJetFlightRequest build(ToughJetFlighTimeInterval.Builder timeBuilder) {

            return new ToughJetFlightRequest(timeBuilder, this);
        }

        public Builder fromVenue(String fromVenue) {

            this.fromVenue = fromVenue;
            return this;
        }

        public Builder toVenue(String toVenue) {

            this.toVenue = toVenue;
            return this;
        }

        public Builder numberOfAdults(Integer numberOfAdults) {

            this.numberOfAdults = numberOfAdults;
            return this;
        }

    }

    @Size(min=3, max=3)
    private String fromVenue;

    @Size(min=3, max=3)
    private String toVenue;

    @Range(min = MINIMUM_OF_ADULTS, max = NUMBER_OF_ADULTS)
    private Integer numberOfAdults;

    public ToughJetFlightRequest() {
        super();
    }

    public ToughJetFlightRequest(ToughJetFlighTimeInterval.Builder timeIntervalbuilder, ToughJetFlightRequest.Builder builder) {
        super(timeIntervalbuilder);
        this.fromVenue = builder.fromVenue;
        this.toVenue = builder.toVenue;
        this.numberOfAdults = builder.numberOfAdults;

    }
    public String getFrom() {
        return fromVenue;
    }

    public void setFrom(String from) {
        this.fromVenue = from;
    }

    public String getTo() {
        return toVenue;
    }

    public void setTo(String to) {
        this.toVenue = to;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
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
        result = prime * result + (fromVenue == null ? 0 : fromVenue.hashCode());
        result = prime * result + (numberOfAdults == null ? 0 : numberOfAdults.hashCode());
        result = prime * result + (toVenue == null ? 0 : toVenue.hashCode());
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
        ToughJetFlightRequest other = (ToughJetFlightRequest) obj;
        if (!super.equals(other)) {
            return false;
        }
        else if (fromVenue == null) {
            if (other.fromVenue != null) {
                return false;
            }
        }
        else if (!fromVenue.equals(other.fromVenue)) {
            return false;
        }

        if (numberOfAdults == null) {
            if (other.numberOfAdults != null) {
                return false;
            }
        }
        else if (!numberOfAdults.equals(other.numberOfAdults)) {
            return false;
        }

        if (toVenue == null) {
            if (other.toVenue != null) {
                return false;
            }
        }
        else if (!toVenue.equals(other.toVenue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append(super.toString());

        str.append("From venue [").append(this.fromVenue).append("]")
                .append("To Venue [").append(this.toVenue).append("]")
                .append("Number Of Adults [").append(this.numberOfAdults).append("]");

        return str.toString();
    }

}
