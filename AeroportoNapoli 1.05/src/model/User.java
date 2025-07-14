package model;

import controller.Controller;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class User {
    
    private int userId;
    
    private String username;
    
    private boolean admin;

    public User(){
    }
    public User(int userId, String username, boolean admin){    
        
        //prendo il valore autoincrementato da una variabile contatore statica nel main
        this.userId = userId;
        this.username = username;
        this.admin = admin;
        //va aggiunto l'algoritmo di cifratura
        
    }    
    
    public static User authenticate(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Controller.getConnection();

            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                boolean isAdmin = rs.getBoolean("admin");
                return new User(id, username, isAdmin);
            } else {
                return null;
            }

        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (pst != null) pst.close(); } catch (SQLException ignored) {}
            try { if (con != null) con.close(); } catch (SQLException ignored) {}
        }
    }
    
    public static boolean register(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        
        try{
            con = Controller.getConnection();

            // Verifica se l'username esiste già
            String checkUsernameSQL = "SELECT username FROM user WHERE username = ?";
            pst = con.prepareStatement(checkUsernameSQL);
            pst.setString(1, username);
            rs = pst.executeQuery();
            
            if(rs.next()){
                return false;
            }
            
                    // Inserisci nuovo utente
            String insertSQL = "INSERT INTO user (username, password, admin) VALUES (?, ?, 0)";
            pst = con.prepareStatement(insertSQL);
            pst.setString(1, username);
            pst.setString(2, password); // In futuro: cifrare
            pst.executeUpdate();

            
            return true;
            
    
        }finally{
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (pst != null) pst.close(); } catch (SQLException ignored) {}
            try { if (con != null) con.close(); } catch (SQLException ignored) {}
        }
    }
    
    public static boolean adminNewFlight(String departureAirport,String arrivalAirport,String flightCompany,String scheduledDate,String plannedTime) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;

        Random rand = new Random();
        int code = rand.nextInt(1000);
        String flightNumber = "" + departureAirport.charAt(0) + code + arrivalAirport.charAt(0);

        try {
            con = Controller.getConnection();

            String sql = "INSERT INTO flight (flight_number, flight_company, scheduled_date, planned_time, delay_time, departure_airport, arrival_airport, assigned_gate, flight_status) " +
                         "VALUES (?, ?, ?, ?, NULL, ?, ?, NULL, 'SCHEDULED')";
            pst = con.prepareStatement(sql);
            pst.setString(1, flightNumber);
            pst.setString(2, flightCompany);
            pst.setString(3, scheduledDate);
            pst.setString(4, plannedTime);
            pst.setString(5, departureAirport);
            pst.setString(6, arrivalAirport);

            int rowadded = pst.executeUpdate();
            return rowadded > 0;

        } finally {
            try { if (pst != null) pst.close(); } catch (SQLException ignored) {}
            try { if (con != null) con.close(); } catch (SQLException ignored) {}
        }
    }
    
    
    public boolean setUserData(String username, String password) throws SQLException{
    String sql = "SELECT id, admin FROM user WHERE username = ? AND password = ?";

    try (
        Connection con = Controller.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
    ) {
        pst.setString(1, username);
        pst.setString(2, password);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                this.userId = rs.getInt("id");
                this.username = username;
                this.admin = rs.getBoolean("admin"); // se è null in db, ritorna false
                return true; // dati aggiornati correttamente
            }
        }
    }
    return false; // username/password errati
    }
    
    public int getUserId(){
        return this.userId;
    }
    
    public String getUsername(){
        return this.username;
    }    
    
    public boolean getAdmin(){
        return this.admin;
    }
            
    public void setUsername(String username){
        this.username = username;
    }
    
    public void UserDrop(){
        this.userId = 0;
        this.username = null;
        this.admin = false;
    }
}