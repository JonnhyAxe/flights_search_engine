package com.busyflights.search_engine.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Date Contants
 *
 */
public final class DateUitls {

    public final static int MINIMUM_YEAR = 2017;

    public final static int MINIMUM_DAY = 1;

    public final static int MAX_DAY = 31;

    public final static int MINIMUM_MONTH = 1;

    public final static int MAX_MONTH = 31;

    public final static String MmddyyyyhhmmssFormat = "MM-dd-yyyy hh:mm:ss";

    public final static String MmDdYyyyFormat = "MM-dd-yyyy";

    public final static String ISO8601 = "yyyy-MM-dd";

    public static String getStringDateISO8601(Integer year, Integer month, Integer dayOfMonth) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ISO8601);
        String localDateFormatted = getStringDate(year, month, dayOfMonth, formatter);
        return localDateFormatted;
    }

    public static String getStringDateMmDdYyyy(Integer year, Integer month, Integer dayOfMonth) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MmDdYyyyFormat);
        String localDateFormatted = getStringDate(year, month, dayOfMonth, formatter);
        return localDateFormatted;
    }

    public static String getStringDateMmDdYyyyHhMmSs(Integer year, Integer month, Integer dayOfMonth) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MmddyyyyhhmmssFormat);
        String localDateFormatted = getStringDate(year, month, dayOfMonth, formatter);
        return localDateFormatted;
    }

    public static LocalDate getLocalDateFromStringInISO8601(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ISO8601);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public static LocalDate getLocalDateFromStringInMmDdYyyy(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MmDdYyyyFormat);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public static LocalDate getLocalDateFromStringInMmDdYyyyHhMmSs(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MmddyyyyhhmmssFormat);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    private static String getStringDate(Integer year, Integer month, Integer dayOfMonth, DateTimeFormatter formatter) {

        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        return formatter.format(localDate);
    }

}
