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
}
