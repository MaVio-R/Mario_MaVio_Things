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

    private static void loadData(JTable table, String query, int columnCount, Object... params) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Pulisce la tabella

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta i parametri nella query (opzionale)
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1); // Indici 1-based
                    }
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento dei dati: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static String[] getBookingDetailsByNumber(int bookingNumber) {
        String query = "SELECT first_name, last_name FROM booking WHERE booking_number = ?";
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, bookingNumber); // Inseriamo il numero di prenotazione nella query

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    return new String[]{firstName, lastName};
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nessuna prenotazione trovata per il numero: " + bookingNumber,
                            "Errore", JOptionPane.WARNING_MESSAGE);
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il recupero dei dettagli della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static boolean updateBookingDetails(int bookingNumber, String firstName, String lastName) {
        String query = "UPDATE booking SET first_name = ?, last_name = ? WHERE booking_number = ?";
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta i parametri
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setInt(3, bookingNumber);

            // Esegue l'update
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Ritorna true se sono state effettuate modifiche

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }



    public static boolean updateBookingStatus(int bookingNumber, String newStatus) {
        String query = "UPDATE booking SET booking_status = ? WHERE booking_number = ?";
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta i parametri
            pst.setString(1, newStatus);
            pst.setInt(2, bookingNumber);

            // Esegui l'update
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Ritorna true se una riga è stata aggiornata

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento dello stato della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
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

    public static void loadBookingsForCurrentUser(JTable table) {
        // Recuperiamo l'id dell'utente collegato dall'oggetto AeroportoNapoli.LoggedUser
        int currentUserId = AeroportoNapoli.LoggedUser.getUserId();

        String query = """
    SELECT 
        b.booking_number AS 'BOOK COD',
        b.first_name AS 'NOME',
        f.flight_number AS 'FLIGHT COD',
        b.booking_status AS 'STATUS', -- Modificato qui
        b.seat_number AS 'SEAT NUM'
    FROM 
        booking b
    JOIN 
        flight f ON b.flight_id = f.id
    WHERE 
        b.user_id = ?
    """;

        // Caricare i dati nella tabella
        loadData(table, query, 5, currentUserId);
    }
    public static void loadBookingsByName(JTable table, String name) {
        int currentUserId = AeroportoNapoli.LoggedUser.getUserId();

        String query = """
    SELECT 
        b.booking_number AS 'BOOK COD',
        b.first_name AS 'NOME',
        f.flight_number AS 'FLIGHT COD',
        b.booking_status AS 'STATUS', -- Modificato qui
        b.seat_number AS 'SEAT NUM'
    FROM 
        booking b
    JOIN 
        flight f ON b.flight_id = f.id
    WHERE 
        b.user_id = ? AND b.first_name LIKE ?
    """;

        String nameFilter = "%" + name.trim() + "%";
        loadData(table, query, 5, currentUserId, nameFilter);
    }
}