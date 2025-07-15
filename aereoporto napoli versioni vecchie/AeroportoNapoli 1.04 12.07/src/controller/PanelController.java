/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.*;
import javax.swing.*;

public class PanelController {
    private final JPanel container;

    public PanelController(JPanel container) {
        this.container = container;
    }

    public void switchTo(String name) {
        CardLayout cl = (CardLayout) container.getLayout();
        cl.show(container, name);
    }
}