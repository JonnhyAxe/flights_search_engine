package com.busyflights.search_engine.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Date Utils for validation and conversions
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
        return getStringDate(year, month, dayOfMonth, formatter);
    }

    public static String getStringDateISOFormat(Integer year, Integer month, Integer dayOfMonth, Integer hour, Integer min, Integer sec, String format) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(LocalDateTime.of(year, month, dayOfMonth, hour, min, sec));

    }

    public static LocalDate getLocalDateFromStringDateFormat(String date, String format) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formatter);
    }


    private static String getStringDate(Integer year, Integer month, Integer dayOfMonth, DateTimeFormatter formatter) {

        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        return formatter.format(localDate);
    }



}
