package com.busyflights.search_engine.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Date Utils for validation and convertion
 *
 */
public final class DateUtils {

    public static final long MINIMUM_DAY = 1;

    public static final long MAX_DAY = 31;

    public static final long MINIMUM_MONTH = 1;

    public static final long MAX_MONTH = 12;

    public static final long MINIMUM_YEAR = 2017;

    public static final String MM_DD_YYYY_HHMMSS_FORMAT = "MM-dd-yyyy hh:mm:ss";

    public static final String MM_DD_YYYY_Format = "MM-dd-yyyy";

    public static final String ISO8601_FORMAT = "yyyy-MM-dd";


    public static String getStringDateISOFormat(Integer year, Integer month, Integer dayOfMonth, String fomat) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fomat);
        String localDateFormatted = getStringDate(year, month, dayOfMonth, formatter);
        return localDateFormatted;
    }

    public static String getStringDateISOFormat(Integer year, Integer month, Integer dayOfMonth, Integer hour, Integer min, Integer sec, String format) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime time = LocalDateTime.of(year, month, dayOfMonth, hour, min, sec);
        return formatter.format(time);

    }

    // public static String getStringDateISO8601(Integer year, Integer month,
    // Integer dayOfMonth) {
    //
    // DateTimeFormatter formatter =
    // DateTimeFormatter.ofPattern(ISO8601_FORMAT);
    // String localDateFormatted = getStringDate(year, month, dayOfMonth,
    // formatter);
    // return localDateFormatted;
    // }

//    public static String getStringDateMmDdYyyy(Integer year, Integer month, Integer dayOfMonth) {
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MM_DD_YYYY_Format);
//        String localDateFormatted = getStringDate(year, month, dayOfMonth,  formatter);
//        return localDateFormatted;
//    }



    // public static LocalDate getLocalDateFromStringInISO8601(String date) {
    //
    // DateTimeFormatter formatter =
    // DateTimeFormatter.ofPattern(ISO8601_FORMAT);
    // LocalDate localDate = LocalDate.parse(date, formatter);
    // return localDate;
    // }


    public static LocalDate getLocalDateFromStringInMmDdYyyy(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MM_DD_YYYY_Format);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public static LocalDate getLocalDateFromStringInMmDdYyyyHhMmSs(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MM_DD_YYYY_HHMMSS_FORMAT);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public static LocalDate getLocalDateFromStringDateFormat(String date, String format) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }


    private static String getStringDate(Integer year, Integer month, Integer dayOfMonth, DateTimeFormatter formatter) {

        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        return formatter.format(localDate);
    }



}
