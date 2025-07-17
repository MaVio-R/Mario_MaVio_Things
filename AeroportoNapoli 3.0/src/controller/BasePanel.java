package controller;

import javax.swing.*;

public abstract class BasePanel extends JPanel {
    protected final PanelController panelController;
    protected final JPanel container;

    public BasePanel(JPanel container, PanelController panelController) {
        this.container = container;
        this.panelController = panelController;
    }
}