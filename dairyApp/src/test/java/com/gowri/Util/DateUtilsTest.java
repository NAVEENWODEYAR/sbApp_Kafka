package com.gowri.Util;
/*
 * @author NaveenWodeyar
 * @date 18-10-2024
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class DateUtilsTest {
    private final DateUtils dateUtils = new DateUtils();

    @Test
    public void testGetCurrentDateTime() {
        String currentDateTime = dateUtils.getCurrentDateTime();
        Assertions.assertNotNull(currentDateTime);
    }

    @Test
    public void testDaysBetweenWithValidDates() {
        Optional<LocalDate> startDate = Optional.of(LocalDate.of(2024, 1, 1));
        Optional<LocalDate> endDate = Optional.of(LocalDate.of(2024, 10, 18));
        long days = dateUtils.daysBetween(startDate, endDate);
        Assertions.assertEquals(290, days); // Adjust based on actual calculation
    }

    @Test
    public void testDaysBetweenWithNullStart() {
        Optional<LocalDate> startDate = Optional.empty();
        Optional<LocalDate> endDate = Optional.of(LocalDate.of(2024, 10, 18));
        long days = dateUtils.daysBetween(startDate, endDate);
        Assertions.assertEquals(0, days);
    }

    @Test
    public void testDaysBetweenWithNullEnd() {
        Optional<LocalDate> startDate = Optional.of(LocalDate.of(2024, 1, 1));
        Optional<LocalDate> endDate = Optional.empty();
        long days = dateUtils.daysBetween(startDate, endDate);
        Assertions.assertEquals(0, days);
    }

    @Test
    public void testDaysBetweenWithBothNull() {
        Optional<LocalDate> startDate = Optional.empty();
        Optional<LocalDate> endDate = Optional.empty();
        long days = dateUtils.daysBetween(startDate, endDate);
        Assertions.assertEquals(0, days);
    }

    @Test
    public void testFormatDateWithValidDate() {
        Optional<LocalDate> date = Optional.of(LocalDate.of(2024, 10, 18));
        String formattedDate = dateUtils.formatDate(date);
        Assertions.assertEquals("2024-10-18 00:00:00", formattedDate);
    }

    @Test
    public void testFormatDateWithNull() {
        Optional<LocalDate> date = Optional.empty();
        String formattedDate = dateUtils.formatDate(date);
        Assertions.assertEquals("No date provided", formattedDate);
    }

    @Test
    public void testParseDateWithValidString() {
        String dateString = "2024-10-18 00:00:00";
        Optional<LocalDate> parsedDate = dateUtils.parseDate(dateString);
        Assertions.assertTrue(parsedDate.isPresent());
        Assertions.assertEquals(LocalDate.of(2024, 10, 18), parsedDate.get());
    }

    @Test
    public void testParseDateWithNullString() {
        String dateString = null;
        Optional<LocalDate> parsedDate = dateUtils.parseDate(dateString);
        Assertions.assertFalse(parsedDate.isPresent());
    }

    @Test
    public void testParseDateWithInvalidString() {
        String dateString = "invalid-date";
        Assertions.assertThrows(DateTimeParseException.class, () -> {
            dateUtils.parseDate(dateString);
        });
    }
}
