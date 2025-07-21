package controller;

import Gui.*;
import Gui.admin.*;
import Gui.client.*;
import java.awt.CardLayout;
import java.util.*;
import javax.swing.*;

/**
 * The type Panel controller.
 */
public class PanelController {
private final JPanel container;
    private final CardLayout layout;
    private final Map<String, JPanel> loadedPanels = new HashMap<>();

    /**
     * Instantiates a new Panel controller.
     *
     * @param container the container
     */
    public PanelController(JPanel container) {
        this.container = container;
        this.layout = (CardLayout) container.getLayout();
    }

    /**
     * Show panel.
     *
     * @param name the name
     */
    public void showPanel(String name) {
        if (!loadedPanels.containsKey(name)) {
            JPanel panel = createPanel(name);
            if (panel != null) {
                container.add(panel, name);
                loadedPanels.put(name, panel);
            } else {
                System.err.println("Pannello '" + name + "' non trovato.");
                return;
            }
        }
        
        JPanel panel = loadedPanels.get(name);
        
        if (panel instanceof Resettable) {
            ((Resettable) panel).resetPanel();
        }
        layout.show(container, name);
    }

    private JPanel createPanel(String name) {
        switch (name) {
            case "main": return new HomePage(container,this);
            case "login": return new Login(container,this);
            case "signup": return new Signup(container,this);
            case "homepageclient": return new HomePageClient(container,this);
            case "bookpage": return new BookPage(container,this);
            case "clientprofile": return new ClientProfile(container,this);
            case "homepageadmin": return new HomePageAdmin(container,this);
            case "newflightpage": return new NewFlightPage(container,this);
            case "flightupdate": return new FlightUpdate(container,this);
            default: return null;
        }
    }
}