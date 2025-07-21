package controller;

import java.awt.CardLayout;
import javax.swing.*;
import model.User;

/**
 * The type Aeroporto napoli.
 */
public class AeroportoNapoli {

    /**
     * The constant LoggedUser.
     */
    public static User LoggedUser = null;

    /**
     * Main.
     *
     * @param args the args
     */
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

        panelManager.showPanel("main");
                    frame.add(panelContainer);
                    frame.setVisible(true);
    }
}
