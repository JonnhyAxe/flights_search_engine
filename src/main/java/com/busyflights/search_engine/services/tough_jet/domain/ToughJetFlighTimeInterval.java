package com.busyflights.search_engine.services.tough_jet.domain;


import java.io.Serializable;

import org.hibernate.validator.constraints.Range;

import com.busyflights.search_engine.utils.DateUtils;

/**
 * ToughJetT Time interval
 */
public class ToughJetFlighTimeInterval implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7618097169689263983L;


    public static final class Builder {

        private Integer departureDay;

        private Integer departureMonth;

        private Integer departureYear;

        private Integer returnDay;

        private Integer returnMonth;

        private Integer returnYear;

        public Builder() {
        }

        public ToughJetFlighTimeInterval build() {

            return new ToughJetFlighTimeInterval(this);
        }

        public Builder departureDay(Integer departureDay) {

            this.departureDay = departureDay;
            return this;
        }

        public Builder departureMonth(Integer departureMonth) {

            this.departureMonth = departureMonth;
            return this;
        }

        public Builder departureYear(Integer departureYear) {

            this.departureYear = departureYear;
            return this;
        }

        public Builder returnDay(Integer returnDay) {

            this.returnDay = returnDay;
            return this;
        }

        public Builder returnMonth(Integer returnMonth) {

            this.returnMonth = returnMonth;
            return this;
        }

        public Builder returnYear(Integer returnYear) {

            this.returnYear = returnYear;
            return this;
        }
    }

    @Range(min = DateUtils.MINIMUM_DAY, max = DateUtils.MAX_DAY)
    private Integer departureDay;

    @Range(min = DateUtils.MINIMUM_MONTH, max = DateUtils.MAX_MONTH)
    private Integer departureMonth;

    @Range(min = DateUtils.MINIMUM_YEAR, max = Integer.MAX_VALUE)
    private Integer departureYear;

    @Range(min = DateUtils.MINIMUM_DAY, max = DateUtils.MAX_DAY)
    private Integer returnDay;

    @Range(min = DateUtils.MINIMUM_MONTH, max = DateUtils.MAX_MONTH)
    private Integer returnMonth;

    @Range(min = DateUtils.MINIMUM_YEAR, max = Integer.MAX_VALUE)
    private Integer returnYear;

    public ToughJetFlighTimeInterval() {
        super();
    }

    public ToughJetFlighTimeInterval(ToughJetFlighTimeInterval.Builder timeIntervalbuilder) {

        this.departureDay = timeIntervalbuilder.departureDay;
        this.departureMonth = timeIntervalbuilder.departureMonth;
        this.departureYear = timeIntervalbuilder.departureYear;
        this.returnDay = timeIntervalbuilder.returnDay;
        this.returnMonth = timeIntervalbuilder.returnMonth;
        this.returnYear = timeIntervalbuilder.returnYear;

    }

    public Integer getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Integer departureDay) {
        this.departureDay = departureDay;
    }

    public Integer getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(Integer departureMonth) {
        this.departureMonth = departureMonth;
    }

    public Integer getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(Integer departureYear) {
        this.departureYear = departureYear;
    }

    public Integer getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Integer returnDay) {
        this.returnDay = returnDay;
    }

    public Integer getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(Integer returnMonth) {
        this.returnMonth = returnMonth;
    }

    public Integer getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(Integer returnYear) {
        this.returnYear = returnYear;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (departureDay == null ? 0 : departureDay.hashCode());
        result = prime * result + (departureMonth == null ? 0 : departureMonth.hashCode());
        result = prime * result + (departureYear == null ? 0 : departureYear.hashCode());
        result = prime * result + (returnDay == null ? 0 : returnDay.hashCode());
        result = prime * result + (returnMonth == null ? 0 : returnMonth.hashCode());
        result = prime * result + (returnYear == null ? 0 : returnYear.hashCode());
        return result;
    }

    /* (non-Javadoc)
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
        ToughJetFlighTimeInterval other = (ToughJetFlighTimeInterval) obj;
        if (departureDay == null) {
            if (other.departureDay != null) {
                return false;
            }
        }
        else if (!departureDay.equals(other.departureDay)) {
            return false;
        }
        if (departureMonth == null) {
            if (other.departureMonth != null) {
                return false;
            }
        }
        else if (!departureMonth.equals(other.departureMonth)) {
            return false;
        }
        if (departureYear == null) {
            if (other.departureYear != null) {
                return false;
            }
        }
        else if (!departureYear.equals(other.departureYear)) {
            return false;
        }
        if (returnDay == null) {
            if (other.returnDay != null) {
                return false;
            }
        }
        else if (!returnDay.equals(other.returnDay)) {
            return false;
        }
        if (returnMonth == null) {
            if (other.returnMonth != null) {
                return false;
            }
        }
        else if (!returnMonth.equals(other.returnMonth)) {
            return false;
        }
        if (returnYear == null) {
            if (other.returnYear != null) {
                return false;
            }
        }
        else if (!returnYear.equals(other.returnYear)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();


        str.append("Departure Day [").append(this.departureDay).append("] ")
                .append("Departure Month [").append(this.departureMonth).append("] ")
                .append("Departure Year [").append(this.departureYear).append("] ")
                .append("Return Day [").append(this.returnDay).append("] ")
                .append("Return Month [").append(this.returnMonth).append("] ")
                .append("Return Year [").append(this.returnYear).append("] ");

        return str.toString();
    }

}
