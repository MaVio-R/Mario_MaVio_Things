package Gui;

import javax.swing.*;
import java.awt.*;

public class RegistrationPanel extends JPanel{
    public RegistrationPanel(JPanel container){
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField repeatPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Registrati");

        registerButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) container.getLayout();
            cl.show(container, "dashboard");
        });

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Repeat Password:"));
        add(repeatPasswordField);
        add(new JLabel());
        add(registerButton);
    }
}
