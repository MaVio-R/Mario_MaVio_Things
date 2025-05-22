package Gui;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel{
    public DashboardPanel(){
        JPanel dashboardPanel = new JPanel(new BorderLayout());
        JLabel dashboardLabel = new JLabel("Dashboard", SwingConstants.CENTER);
        dashboardLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea dashboardText = new JTextArea("Benvenuto nel sistema di gestione aeroportuale.");
        dashboardText.setEditable(false);
        JButton logoutButton = new JButton("Logout");

        dashboardPanel.add(dashboardLabel, BorderLayout.NORTH);
        dashboardPanel.add(dashboardText, BorderLayout.CENTER);
        dashboardPanel.add(logoutButton, BorderLayout.SOUTH);

    }

}
