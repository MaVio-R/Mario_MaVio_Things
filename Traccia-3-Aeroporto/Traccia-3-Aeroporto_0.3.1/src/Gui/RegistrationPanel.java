package Gui;

import javax.swing.*;
import java.awt.*;

public class RegistrationPanel extends JPanel{
    public RegistrationPanel(){
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


    }
}
