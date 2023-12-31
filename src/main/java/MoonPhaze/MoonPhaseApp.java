package MoonPhaze;

import javax.swing.*;

public class MoonPhaseApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Prompt the user to choose between API and Calculator
            String[] options = {"Use API", "Use Calculator"};
            int selection = JOptionPane.showOptionDialog(null,
                    "Choose the method to fetch moon phase data:",
                    "Select Method",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            boolean useApi = (selection == 0);

            // Initialize the main UI with the user's choice
            MainUI mainUI = new MainUI(useApi);
            mainUI.createAndShowGUI();
        });
    }
}



