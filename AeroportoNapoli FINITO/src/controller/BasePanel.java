package controller;

import javax.swing.*;

/**
 * The type Base panel.
 */
public abstract class BasePanel extends JPanel {
    /**
     * The Panel controller.
     */
    protected final PanelController panelController;
    /**
     * The Container.
     */
    protected final JPanel container;

    /**
     * Instantiates a new Base panel.
     *
     * @param container       the container
     * @param panelController the panel controller
     */
    public BasePanel(JPanel container, PanelController panelController) {
        this.container = container;
        this.panelController = panelController;
    }
}