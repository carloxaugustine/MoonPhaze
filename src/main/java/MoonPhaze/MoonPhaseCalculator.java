package MoonPhaze;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MoonPhaseCalculator {
    private static final double SYNODIC_MONTH = 29.53; // Average length of the synod month in days

    public static String calculatePhase(LocalDate date) {
        // Known new moon date (reference point)
        LocalDate knownNewMoon = LocalDate.of(2000, 1, 6); // Replace with a known new moon date

        // Calculate the number of days since the known new moon
        long daysSinceNewMoon = ChronoUnit.DAYS.between(knownNewMoon, date);

        // Calculate the phase of the moon
        double phase = (daysSinceNewMoon % SYNODIC_MONTH) / SYNODIC_MONTH;

        // Determine the phase name
        return getPhaseName(phase);
    }

    private static String getPhaseName(double phase) {
        if (phase < 0.03 || phase > 0.97) {
            return "New Moon";
        } else if (phase < 0.22) {
            return "Waxing Crescent";
        } else if (phase < 0.28) {
            return "First Quarter";
        } else if (phase < 0.47) {
            return "Waxing Gibbous";
        } else if (phase < 0.53) {
            return "Full Moon";
        } else if (phase < 0.72) {
            return "Waning Gibbous";
        } else if (phase < 0.78) {
            return "Last Quarter";
        } else {
            return "Waning Crescent";
        }
    }
}


