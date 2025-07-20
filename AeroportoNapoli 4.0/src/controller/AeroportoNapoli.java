package controller;

import java.awt.CardLayout;
import javax.swing.*;
import model.User;

public class AeroportoNapoli {

    public static User LoggedUser = null;

    public static void main(String[] args){

        JFrame frame = new JFrame("Aeroporto di Napoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Controller.closeConnection();
        }));

        JPanel panelContainer = new JPanel(new CardLayout());
        PanelController panelManager = new PanelController(panelContainer);

        // Mostra solo la home page iniziale
        panelManager.showPanel("main");
                    frame.add(panelContainer);
                    frame.setVisible(true);
    }
}
