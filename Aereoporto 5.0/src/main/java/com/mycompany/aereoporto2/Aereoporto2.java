/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aereoporto2;

import Gui.client.BookPage;
import Gui.client.ClientProfile;
import Gui.client.ClientProfileUpdate;
import Gui.HomePage;
import Gui.client.HomePageClient;
import Gui.Login;
import Gui.client.LostReport;
import Gui.Signup;
import Gui.admin.FlightUpdate;
import Gui.admin.HomePageAdmin;
import Gui.admin.LostUpdate;
import Gui.admin.NewFlightPage;
import java.awt.CardLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mlaur
 */
public class Aereoporto2 {
    public static void main(String[] args){        
        JFrame frame = new JFrame("Aeroporto di Napoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(true);
        JPanel panelContainer = new JPanel(new CardLayout());

        
        
        

        HomePage homepage = new HomePage(panelContainer);
        Login loginpage = new Login(panelContainer);
        Signup signuppage = new Signup(panelContainer);
        HomePageClient homepageclient = new HomePageClient(panelContainer);
        BookPage bookpage = new BookPage(panelContainer);
        LostReport lostreport = new LostReport(panelContainer);
        ClientProfile clientprofile = new ClientProfile(panelContainer);
        ClientProfileUpdate clientprofileupdate = new ClientProfileUpdate(panelContainer);
        HomePageAdmin homepageadmin = new HomePageAdmin(panelContainer);
        NewFlightPage newflightpage = new NewFlightPage(panelContainer);
        FlightUpdate flightupdate = new FlightUpdate(panelContainer);
        LostUpdate lostupdate = new LostUpdate(panelContainer);

        
        
        /*
        RegistrationPanel registrationPanel = new RegistrationPanel(panelContainer, frame);
        DashboardPanel dashboardPanel = new DashboardPanel(panelContainer);
*/
        // Add panels to card layout
        
        
        
        
        panelContainer.add(homepage, "main");
        panelContainer.add(loginpage, "login");
        panelContainer.add(signuppage, "signup");
        panelContainer.add(homepageclient, "homepageclient");
        panelContainer.add(bookpage, "bookpage");
        panelContainer.add(lostreport, "lostreport");
        panelContainer.add(clientprofile, "clientprofile");
        panelContainer.add(clientprofileupdate, "clientprofileupdate");
        panelContainer.add(homepageadmin, "homepageadmin");
        panelContainer.add(newflightpage, "newflightpage");
        panelContainer.add(flightupdate, "flightupdate");
        panelContainer.add(lostupdate, "lostupdate");


        /*
        panelContainer.add(registrationPanel, "registration");
        panelContainer.add(dashboardPanel, "dashboard");
        */
                frame.add(panelContainer);
                frame.setVisible(true);

    }
}
