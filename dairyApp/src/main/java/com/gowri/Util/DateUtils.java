package com.gowri.Util;

import org.springframework.stereotype.Component;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/*
 * @author NaveenWodeyar
 * @date 18-10-2024
 */
@Component
public class DateUtils {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // Get the current date and time as a formatted string
    public String getCurrentDateTime() {
        return LocalDateTime.now().format(DEFAULT_FORMATTER);
    }

    // Calculate the number of days between two dates, handle nulls
    public long daysBetween(Optional<LocalDate> start, Optional<LocalDate> end) {
        return start.flatMap(s -> end.map(e -> ChronoUnit.DAYS.between(s, e)))
                .orElse(0L);
    }

    // Format a LocalDate into a string, handle null
    public String formatDate(Optional<LocalDate> date) {
        return date.map(d -> d.format(DEFAULT_FORMATTER))
                .orElse("No date provided");
    }

    // Parse a string into a LocalDate, handle null input
    public Optional<LocalDate> parseDate(String dateString) {
        return Optional.ofNullable(dateString)
                .map(ds -> LocalDate.parse(ds, DEFAULT_FORMATTER));
    }

    public void exampleMethod(String fromInput, String toInput) {
        // Debug: Print input values
        System.out.println("From Input: " + fromInput);
        System.out.println("To Input: " + toInput);

        // Parsing 'from' date to start of the day
        LocalDateTime fromDateTime = LocalDateTime.parse(fromInput, format)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        Date fromDate = Date.from(fromDateTime.toInstant(ZoneOffset.UTC));

        // Parsing 'to' date to end of the day
        LocalDateTime toDateTime = LocalDateTime.parse(toInput, format)
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(0);
        Date toDate = Date.from(toDateTime.toInstant(ZoneOffset.UTC));

        // Debug outputs
        System.out.println("Parsed fromDate (UTC): " + fromDate);
        System.out.println("Parsed toDate (UTC): " + toDate);

    }
}