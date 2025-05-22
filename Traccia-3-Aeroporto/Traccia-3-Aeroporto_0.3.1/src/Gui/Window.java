package Gui;

import javax.swing.*;
import java.awt.*;

public class Window {
    public void GuiCreation(){

        JFrame frame = new JFrame("Aereoporto di Napoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new CardLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3,2,10,10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        // Dashboard Panel con BorderLayout
        JPanel dashboardPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.NORTH);

        JTextArea centerText = new JTextArea("Benvenuto nel sistema di gestione aeroportuale.");
        centerText.setEditable(false);
        dashboardPanel.add(centerText, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Logout");
        dashboardPanel.add(logoutButton, BorderLayout.SOUTH);

        // Aggiungi i pannelli al CardLayout
        mainPanel.add(loginPanel, "login");
        mainPanel.add(dashboardPanel, "dashboard");

        // Gestione login
        loginButton.addActionListener(e -> {
            // In un caso reale, qui faresti il controllo del login
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "dashboard");
        });

        // Gestione logout
        logoutButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "login");
        });

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Centra la finestra
        frame.setVisible(true);
    }
}