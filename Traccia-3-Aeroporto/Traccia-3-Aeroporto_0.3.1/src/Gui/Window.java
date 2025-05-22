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
        RegistrationPanel registrationPanel = new RegistrationPanel(panelContainer, frame);
        DashboardPanel dashboardPanel = new DashboardPanel(panelContainer);

        // Add panels to card layout
        panelContainer.add(mainPanel, "main");
        panelContainer.add(loginPanel, "login");
        panelContainer.add(registrationPanel, "registration");
        panelContainer.add(dashboardPanel, "dashboard");





        // Gestione pulsanti
        mainLoginButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) panelContainer.getLayout();
            cl.show(panelContainer, "login");
        });

        mainRegistrationButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) panelContainer.getLayout();
            cl.show(panelContainer, "registration");
        });

        loginConfirmButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) panelContainer.getLayout();
            cl.show(panelContainer, "dashboard");
        });

        registrationConfirmButton.addActionListener(e -> {
            String pwd1 = new String(regPasswordField.getPassword());
            String pwd2 = new String(regRepeatPasswordField.getPassword());
            if (!pwd1.equals(pwd2)) {
                JOptionPane.showMessageDialog(frame, "Le password non corrispondono!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                CardLayout cl = (CardLayout) panelContainer.getLayout();
                cl.show(panelContainer, "dashboard");
            }
        });

        logoutButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) panelContainer.getLayout();
            cl.show(panelContainer, "main");
        });

        frame.add(panelContainer);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}