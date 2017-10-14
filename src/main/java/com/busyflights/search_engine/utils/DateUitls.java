package com.busyflights.search_engine.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <class description>
 *
 */
public final class DateUitls {

    public static final long MINIMUM_DAY = 1;

    public static final long MAX_DAY = 31;

    public static final long MINIMUM_MONTH = 1;

    public static final long MAX_MONTH = 12;

    public static final long MINIMUM_YEAR = 2017;

    public static final String MmddyyyyhhmmssFormat = "MM-dd-yyyy hh:mm:ss";

    public static final String MmDdYyyyFormat = "MM-dd-yyyy";

    public static final String ISO8601 = "yyyy-MM-dd";

    public static String getStringDateISOFormat(Integer year, Integer month, Integer dayOfMonth, String fomat) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fomat);
        String localDateFormatted = getStringDate(year, month, dayOfMonth, formatter);
        return localDateFormatted;
    }

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
