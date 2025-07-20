package Gui;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
    public MainPanel(JPanel container){
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Desidera fare il login o registrarsi?", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JButton loginButton = new JButton("Login");
        JButton registrationButton = new JButton("Registration");

        loginButton.addActionListener(e ->{
            CardLayout cl = (CardLayout) container.getLayout();
            cl.show(container, "login");
        });

        registrationButton.addActionListener(e ->{
            CardLayout cl = (CardLayout) container.getLayout();
            cl.show(container, "registration");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(registrationButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
}
