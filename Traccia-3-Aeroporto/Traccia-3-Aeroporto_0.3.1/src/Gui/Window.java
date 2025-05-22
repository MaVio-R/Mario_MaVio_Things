package Gui;

import javax.swing.*;
import java.awt.*;

public class Window {
    public void GuiCreation() {

        JFrame frame = new JFrame("Aeroporto di Napoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panelContainer = new JPanel(new CardLayout());


        MainPanel mainPanel = new MainPanel(panelContainer );
        LoginPanel loginPanel = new LoginPanel(panelContainer);
        RegistrationPanel registrationPanel = new RegistrationPanel(panelContainer);
        DashboardPanel dashboardPanel = new DashboardPanel(panelContainer);

        // Add panels to card layout
        panelContainer.add(mainPanel, "main");
        panelContainer.add(loginPanel, "login");
        panelContainer.add(registrationPanel, "registration");
        panelContainer.add(dashboardPanel, "dashboard");


        frame.add(panelContainer);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}