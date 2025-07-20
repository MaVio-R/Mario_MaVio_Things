package controller;

import model.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private static Connection con;

    //Gestione di connessione//

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

    // Metodi di autenticazione e registrazione delegati alla classe User
    public static boolean Authenticate(String username, String password) {
        return User.authenticateUser(username, password);
    }

    public static boolean isCurrentUserAdmin() {
        return User.isCurrentUserAdmin();
    }

    public static boolean registerUser(String username, String password) {
        return User.registerUser(username, password);
    }

    //funzioni caricamento tabelle

    // Metodo pubblico per permettere alle altre classi di utilizzare loadData
    public static void loadData(JTable table, String query, int columnCount, Object... params) {
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

    public static void loadFlightData(JTable flighttable) {
        String query = "SELECT flight_number, flight_status, departure_airport, arrival_airport, planned_time, delay_time, assigned_gate FROM flight";
        loadData(flighttable, query, 7);
    }

    //tabelle admin

    public static void loadFlightDataForAdminUpdate(JTable flighttable) {
        String query = "SELECT flight_number, departure_airport, arrival_airport, flight_status FROM flight";
        loadData(flighttable, query, 4);
    }

    //tabelle client

    public static void loadBookableFlights(JTable bookedtable) {
        String query = "SELECT flight_number, scheduled_date, planned_time, departure_airport, arrival_airport, flight_company FROM flight WHERE flight_status = 'SCHEDULED'";
        loadData(bookedtable, query, 6);
    }

    // Metodi delegati alla classe User
    public static void loadBookingsForCurrentUser(JTable table) {
        TableLoader.loadBookingsForCurrentUser(table);
    }

    public static void loadBookingsByName(JTable table, String name) {
        TableLoader.loadBookingsByName(table, name);
    }

    //funzioni admin////////////////////////////////////////////////////////////////////////////////////////////////////

    //flight update////
    public static String[] getFlightStatusValues() {
        FlightStatus[] statuses = FlightStatus.values();
        String[] statusStrings = new String[statuses.length];
        for (int i = 0; i < statuses.length; i++) {
            statusStrings[i] = statuses[i].toString();
        }
        return statusStrings;
    }

    /**
     * Trova un volo tramite numero di volo chiamando il metodo appropriato della classe Flight
     */
    public static Flight findFlightByNumber(String flightNumber) {
        try {
            return Flight.findByFlightNumber(flightNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Aggiorna un volo chiamando il metodo appropriato della classe Flight
     */
    public static boolean updateFlight(String date, String time, String gate, String status, String delay, String flightNumber) {
        return Flight.updateFlightDetails(date, time, gate, status, delay, flightNumber);
    }

    /**
     * Crea un nuovo volo chiamando il metodo appropriato della classe Flight
     */
    public static boolean createFlight(String flightNumber, String flightCompany, String departureAirport,
                                       String arrivalAirport, String scheduledDate, String plannedTime,
                                       String assignedGate, String flightStatus) {
        return Flight.createFlight(flightNumber, flightCompany, departureAirport, arrivalAirport,
                scheduledDate, plannedTime, assignedGate, flightStatus);
    }

    //funzioni client///////////////////////////////////////////////////////////////////////////////////////////////////

    //book page////////

    /**
     * Gestisce la prenotazione di un volo chiamando il metodo appropriato della classe Booking
     */
    public static boolean bookFlight(String flightNumber, String firstName, String lastName) {
        // Validazione input
        if (flightNumber == null || flightNumber.trim().isEmpty() ||
                firstName == null || firstName.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Tutti i campi sono obbligatori.",
                    "Errore di validazione",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Delega la logica di prenotazione alla classe Booking
        return Booking.createBooking(flightNumber, firstName, lastName);
    }

    //client profile///

    /**
     * Recupera i dettagli di una prenotazione chiamando il metodo appropriato della classe Booking
     */
    public static String[] getBookingDetailsByNumber(int bookingNumber) {
        return Booking.getBookingDetailsByNumber(bookingNumber);
    }

    /**
     * Aggiorna i dettagli di una prenotazione chiamando il metodo appropriato della classe Booking
     */
    public static boolean updateBookingDetails(int bookingNumber, String firstName, String lastName) {
        return Booking.updateBookingDetails(bookingNumber, firstName, lastName);
    }

    /**
     * Aggiorna lo stato di una prenotazione chiamando il metodo appropriato della classe Booking
     */
    public static boolean updateBookingStatus(int bookingNumber, String newStatus) {
        return Booking.updateBookingStatus(bookingNumber, newStatus);
    }
}