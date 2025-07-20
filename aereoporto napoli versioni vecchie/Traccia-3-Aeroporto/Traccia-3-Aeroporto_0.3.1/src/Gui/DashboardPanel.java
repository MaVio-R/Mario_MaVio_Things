package Gui;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel{
    public DashboardPanel(JPanel container){
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        JTextArea textArea = new JTextArea("Benvenuto nel sistema di gestione aeroportuale.");
        textArea.setEditable(false);
        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) container.getLayout();
            cl.show(container, "main");
        });

        add(title, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(logoutButton, BorderLayout.SOUTH);

    }

}
