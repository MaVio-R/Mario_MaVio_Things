package Gui;

import javax.swing.*;
import java.awt.*;

public class Window {
    public void GuiCreation() {

        JFrame frame = new JFrame("Aeroporto di Napoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panelContainer = new JPanel(new CardLayout());

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel mainTitle = new JLabel("Desidera fare il login o registrarsi?", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(mainTitle, BorderLayout.NORTH);

        JButton mainLoginButton = new JButton("Login");
        JButton mainRegistrationButton = new JButton("Registration");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mainLoginButton);
        buttonPanel.add(mainRegistrationButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Login panel
        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField loginUsernameField = new JTextField();
        JPasswordField loginPasswordField = new JPasswordField();
        JButton loginConfirmButton = new JButton("Login");

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(loginUsernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(loginPasswordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginConfirmButton);

        // Registration panel
        JPanel registrationPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField regUsernameField = new JTextField();
        JPasswordField regPasswordField = new JPasswordField();
        JPasswordField regRepeatPasswordField = new JPasswordField();
        JButton registrationConfirmButton = new JButton("Registrati");

        registrationPanel.add(new JLabel("Username:"));
        registrationPanel.add(regUsernameField);
        registrationPanel.add(new JLabel("Password:"));
        registrationPanel.add(regPasswordField);
        registrationPanel.add(new JLabel("Repeat Password:"));
        registrationPanel.add(regRepeatPasswordField);
        registrationPanel.add(new JLabel());
        registrationPanel.add(registrationConfirmButton);

        // Dashboard panel
        JPanel dashboardPanel = new JPanel(new BorderLayout());
        JLabel dashboardLabel = new JLabel("Dashboard", SwingConstants.CENTER);
        dashboardLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea dashboardText = new JTextArea("Benvenuto nel sistema di gestione aeroportuale.");
        dashboardText.setEditable(false);
        JButton logoutButton = new JButton("Logout");

        dashboardPanel.add(dashboardLabel, BorderLayout.NORTH);
        dashboardPanel.add(dashboardText, BorderLayout.CENTER);
        dashboardPanel.add(logoutButton, BorderLayout.SOUTH);

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