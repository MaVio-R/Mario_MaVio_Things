/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;


import Gui.*;
import Gui.client.*;
import Gui.admin.*;
import java.awt.CardLayout;
import javax.swing.*;
import model.User;

/**
 *
 * @author mlaur
 */
public class AeroportoNapoli {
    
    public static User LoggedUser = new User();

    public static void main(String[] args){        
        JFrame frame = new JFrame("Aeroporto di Napoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(true);

        JPanel panelContainer = new JPanel(new CardLayout());
        PanelController panelManager = new PanelController(panelContainer);

        // Mostra solo la home page iniziale
        panelManager.showPanel("main");
                    frame.add(panelContainer);
                    frame.setVisible(true);

    }
}
