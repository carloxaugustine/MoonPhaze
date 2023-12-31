package MoonPhaze;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class MainUI {
    private JFrame mainFrame;
    private JLabel moonPhaseLabel;
    private JComboBox<String> timezoneComboBox;
    private boolean useApi; // Field to store the user's choice

    // Constructor to accept the user's choice
    public MainUI(boolean useApi) {
        this.useApi = useApi;
    }

    public void createAndShowGUI() {
        mainFrame = new JFrame("Moon Phase Tracker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        // Dropdown for timezone selection etc...
        String[] timezones = {"Europe/London", "America/New_York", "Asia/Tokyo", /* more timezones */};
        timezoneComboBox = new JComboBox<>(timezones);

        // Label to display a moon phase
        moonPhaseLabel = new JLabel("Moon Phase will be displayed here");

        JButton fetchButton = new JButton("Fetch Moon Phase");
        fetchButton.addActionListener(e -> fetchMoonPhaseData());

        mainFrame.getContentPane().add(timezoneComboBox, BorderLayout.NORTH);
        mainFrame.getContentPane().add(moonPhaseLabel, BorderLayout.CENTER);
        mainFrame.getContentPane().add(fetchButton, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    private void fetchMoonPhaseData() {
        if (useApi) {
            // Fetch moon phase from API
            String timezone = (String) timezoneComboBox.getSelectedItem();
            MoonPhaseData data = new MoonPhaseAPI().getMoonPhaseData(timezone);
            SwingUtilities.invokeLater(() -> {
                if (data != null && data.getPhaseName() != null) {
                    moonPhaseLabel.setText("Moon Phase for " + timezone + ": " + data.getPhaseName());
                } else {
                    moonPhaseLabel.setText("Error fetching moon phase data.");
                }
            });
        } else {
            // Calculate moon phase
            LocalDate date = LocalDate.now(); // Or get the date from user input
            String phase = MoonPhaseCalculator.calculatePhase(date);
            SwingUtilities.invokeLater(() -> {
                moonPhaseLabel.setText("Calculated Moon Phase: " + phase);
            });
        }
    }
}
