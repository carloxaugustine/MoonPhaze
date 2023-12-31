package MoonPhaze;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.DayOfWeek;

public class DateUtils {

    /**
     * Parses a string date in the specified format.
     *
     * @param dateString The date string to parse.
     * @param format The format of the date string.
     * @return The LocalDate object or null if parsing fails.
     */
    public static LocalDate parseDate(String dateString, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            return null;
        }
    }

    /**
     * Extracts the day of the month from a LocalDate.
     *
     * @param date The LocalDate object.
     * @return The day of the month.
     */
    public static int getDayOfMonth(LocalDate date) {
        return date.getDayOfMonth();
    }

    /**
     * Determines the day of the week for a given date.
     *
     * @param date The LocalDate object.
     * @return The day of the week.
     */
    public static DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

    // Additional methods as required for your application
}
