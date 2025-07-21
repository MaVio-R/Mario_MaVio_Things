package controller;

import model.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * The type Controller.
 */
public class Controller {
    private static Connection con;

    //Gestione di connessione//

    /**
     * Gets connection.
     *
     * @return the connection
     * @throws SQLException the sql exception
     */
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

    /**
     * Close connection.
     */
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Authenticate boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
// Metodi di autenticazione e registrazione
    public static boolean Authenticate(String username, String password) {
        return User.authenticateUser(username, password);
    }

    /**
     * Is current user admin boolean.
     *
     * @return the boolean
     */
    public static boolean isCurrentUserAdmin() {
        return User.isCurrentUserAdmin();
    }

    /**
     * Register user boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public static boolean registerUser(String username, String password) {
        return User.registerUser(username, password);
    }

    //funzioni caricamento tabelle

    /**
     * Load data.
     *
     * @param table       the table
     * @param query       the query
     * @param columnCount the column count
     * @param params      the params
     */
    public static void loadData(JTable table, String query, int columnCount, Object... params) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Pulisce la tabella

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

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

    /**
     * Load flight data.
     *
     * @param flighttable the flighttable
     */
    public static void loadFlightData(JTable flighttable) {
        String query = "SELECT flight_number, flight_status, departure_airport, arrival_airport, planned_time, delay_time, assigned_gate FROM flight";
        loadData(flighttable, query, 7);
    }

    //tabelle admin

    /**
     * Load flight data for admin update.
     *
     * @param flighttable the flighttable
     */
    public static void loadFlightDataForAdminUpdate(JTable flighttable) {
        String query = "SELECT flight_number, departure_airport, arrival_airport, flight_status FROM flight";
        loadData(flighttable, query, 4);
    }

    //tabelle client

    /**
     * Load bookable flights.
     *
     * @param bookedtable the bookedtable
     */
    public static void loadBookableFlights(JTable bookedtable) {
        String query = "SELECT flight_number, scheduled_date, planned_time, departure_airport, arrival_airport, flight_company FROM flight WHERE flight_status = 'SCHEDULED'";
        loadData(bookedtable, query, 6);
    }

    /**
     * Load bookings for current user.
     *
     * @param table the table
     */
    public static void loadBookingsForCurrentUser(JTable table) {
        TableLoader.loadBookingsForCurrentUser(table);
    }

    /**
     * Load bookings by name.
     *
     * @param table the table
     * @param name  the name
     */
    public static void loadBookingsByName(JTable table, String name) {
        TableLoader.loadBookingsByName(table, name);
    }

    //funzioni admin////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get flight status values string [ ].
     *
     * @return the string [ ]
     */
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
     * Find flight by number flight.
     *
     * @param flightNumber the flight number
     * @return the flight
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
     * Update flight boolean.
     *
     * @param date         the date
     * @param time         the time
     * @param gate         the gate
     * @param status       the status
     * @param delay        the delay
     * @param flightNumber the flight number
     * @return the boolean
     */
    public static boolean updateFlight(String date, String time, String gate, String status, String delay, String flightNumber) {
        return Flight.updateFlightDetails(date, time, gate, status, delay, flightNumber);
    }



    //funzioni client///////////////////////////////////////////////////////////////////////////////////////////////////

    //book page////////

    /**
     * Book flight boolean.
     *
     * @param flightNumber the flight number
     * @param firstName    the first name
     * @param lastName     the last name
     * @return the boolean
     */
    public static boolean bookFlight(String flightNumber, String firstName, String lastName) {
        if (flightNumber == null || flightNumber.trim().isEmpty() ||
                firstName == null || firstName.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Tutti i campi sono obbligatori.",
                    "Errore di validazione",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return Booking.createBooking(flightNumber, firstName, lastName);
    }

    //client profile///

    /**
     * Get booking details by number string [ ].
     *
     * @param bookingNumber the booking number
     * @return the string [ ]
     */
    public static String[] getBookingDetailsByNumber(int bookingNumber) {
        return Booking.getBookingDetailsByNumber(bookingNumber);
    }

    /**
     * Update booking details boolean.
     *
     * @param bookingNumber the booking number
     * @param firstName     the first name
     * @param lastName      the last name
     * @return the boolean
     */
    public static boolean updateBookingDetails(int bookingNumber, String firstName, String lastName) {
        return Booking.updateBookingDetails(bookingNumber, firstName, lastName);
    }

    /**
     * Update booking status boolean.
     *
     * @param bookingNumber the booking number
     * @param newStatus     the new status
     * @return the boolean
     */
    public static boolean updateBookingStatus(int bookingNumber, String newStatus) {
        return Booking.updateBookingStatus(bookingNumber, newStatus);
    }
}