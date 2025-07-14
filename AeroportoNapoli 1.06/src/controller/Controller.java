/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbaeroportonapoli?useSSL=false&serverTimezone=UTC",
                    "root", "");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("Driver JDBC non trovato", e);
            }
        }
        return con;
    }

    public static void loadFlightData(JTable flighttable) {
        DefaultTableModel model = (DefaultTableModel) flighttable.getModel();
        model.setRowCount(0); // Pulisce la tabella

        String sql = "SELECT flight_number, flight_status, departure_airport, arrival_airport, planned_time, delay_time, assigned_gate FROM flight";

        try {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getString("flight_number");
                row[1] = rs.getString("flight_status");
                row[2] = rs.getString("departure_airport");
                row[3] = rs.getString("arrival_airport");
                row[4] = rs.getString("planned_time");
                row[5] = rs.getString("delay_time");
                row[6] = rs.getString("assigned_gate");

                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Errore durante il caricamento dei voli: " + ex.getMessage(),
                "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void loadFlightDataForAdminUpdate(JTable flighttable) {
        DefaultTableModel model = (DefaultTableModel) flighttable.getModel();
        model.setRowCount(0); // Pulisce la tabella

        String sql = "SELECT flight_number, departure_airport, arrival_airport, flight_status  FROM flight";

        try {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("flight_number");
                row[1] = rs.getString("departure_airport");
                row[2] = rs.getString("arrival_airport");
                row[3] = rs.getString("flight_status");
                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Errore durante il caricamento dei voli: " + ex.getMessage(),
                "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        public static void loadUserBookedFlight(JTable flighttable) {
        DefaultTableModel model = (DefaultTableModel) flighttable.getModel();
        model.setRowCount(0); // Pulisce la tabella
        int i=0;
        String sql = "SELECT booking_number, flight_id, seat_number, booking_status FROM booking WHERE user_id = ?";
        String flightSql ="SELECT flight_number FROM flight WHERE flight_id = ?";
        try {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            
            
            
            
            
            
            
            PreparedStatement flightPst = con.prepareStatement(flightSql);
            flightPst.setInt(1,i);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getString("flight_number");
                row[1] = rs.getString("flight_status");
                row[2] = rs.getString("departure_airport");
                row[3] = rs.getString("arrival_airport");
                row[4] = rs.getString("planned_time");
                row[5] = rs.getString("delay_time");
                row[6] = rs.getString("assigned_gate");

                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Errore durante il caricamento dei voli: " + ex.getMessage(),
                "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public static interface Resettable {
            void resetFields();

    }
}

/*

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String username = user.getText().trim();
        String password = new String(pass.getPassword()).trim();
        String confirmedPassword = new String(newpass.getPassword()).trim();

        // Controllo campi vuoti
        if (username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Tutti i campi devono essere compilati.",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Controllo corrispondenza password
        if (!password.equals(confirmedPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Le due password non coincidono. Riprova.",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        

        try {
            User registredUser = User.registretion(username, password);
            
            if (registredUser != null) {
                JOptionPane.showMessageDialog(this,
                        "L'username \"" + username + "\" è già in uso. Scegli un altro.",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Inserimento nuovo utente
            String insertSQL = "INSERT INTO user ( username, password, admin) VALUES ( ?, ?, '0')";
            pst = con.prepareStatement(insertSQL);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Registrazione avvenuta con successo!",
                    "Successo",
                    JOptionPane.INFORMATION_MESSAGE);

            // Passaggio alla schermata "homepageclient"
            CardLayout cl = (CardLayout) container.getLayout();
            cl.show(container, "homepageclient");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Errore del database: " + ex.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Chiusura risorse
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (pst != null) pst.close(); } catch (SQLException ignored) {}
            try { if (con != null) con.close(); } catch (SQLException ignored) {}
        }
    }       
*/






/*
da mettere menù a tendina er data e ora

*/
