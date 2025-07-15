package controller;

import model.Flight;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Random;

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

    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadData(JTable table, String query, int columnCount) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Pulisce la tabella

        try {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                // Itera sulle colonne
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1); // Indici 1-based
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento dei dati: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Flight searchFlightByCode(String flightCode) throws SQLException {
        String query = "SELECT * FROM flight WHERE flight_number = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try (Connection con = getConnection()) {
            pst = con.prepareStatement(query);
            pst.setString(1, flightCode);
            rs = pst.executeQuery();

            if (rs.next()) {
                return new Flight(
                        rs.getInt("id"),
                        rs.getString("flight_number"),
                        rs.getString("flight_company"),
                        rs.getString("departure_airport"),
                        rs.getString("arrival_airport"),
                        rs.getDate("scheduled_date"),
                        rs.getTime("planned_time"),
                        rs.getTime("delay_time"),
                        rs.getString("assigned_gate"),
                        rs.getString("flight_status") // Passa come String, sarà convertito nel costruttore
            );
        }
    } finally {
        if (rs != null) rs.close();
        if (pst != null) pst.close();
    }

    return null;
}

    public static boolean bookFlight(int userId, int flightId, String firstName, String lastName) throws SQLException {
        String query = "INSERT INTO booking (user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status) VALUES (?, ?, ?, ?, ?, ?, 'CONFIRMED')";
        
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            
            // Genera un numero di prenotazione casuale
            Random rand = new Random();
            int bookingNumber = rand.nextInt(9999) + 1000;
            
            // Genera un posto casuale
            String seatNumber = generateRandomSeat();
            
            pst.setInt(1, userId);
            pst.setInt(2, flightId);
            pst.setInt(3, bookingNumber);
            pst.setString(4, firstName);
            pst.setString(5, lastName);
            pst.setString(6, seatNumber);
            
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    private static String generateRandomSeat() {
        Random rand = new Random();
        char row = (char) ('A' + rand.nextInt(26)); // A-Z
        int number = rand.nextInt(99) + 1; // 1-99
        return row + String.valueOf(number);
    }

    public static void loadFlightData(JTable flighttable) {
        String query = "SELECT flight_number, flight_status, departure_airport, arrival_airport, planned_time, delay_time, assigned_gate FROM flight";
        loadData(flighttable, query, 7);
    }

    public static void loadFlightDataForAdminUpdate(JTable flighttable) {
        String query = "SELECT flight_number, departure_airport, arrival_airport, flight_status FROM flight";
        loadData(flighttable, query, 4);
    }

    public static void loadBookableFlights(JTable bookedtable) {
        String query = "SELECT flight_number, scheduled_date, planned_time, departure_airport, arrival_airport FROM flight WHERE flight_status = 'SCHEDULED'";
        loadData(bookedtable, query, 5);
    }

    public static boolean updateBookingDetails(int bookingId, String newFirstName, String newLastName) throws SQLException {
        String query = "UPDATE booking SET first_name = ?, last_name = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newFirstName);
            pst.setString(2, newLastName);
            pst.setInt(3, bookingId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Ritorna true se almeno una riga è stata aggiornata
        }
    }
}