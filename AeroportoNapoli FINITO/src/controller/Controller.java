package controller;

import model.*;
import dao.*;
import java.sql.*;
import java.util.List;
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

    // Metodi di autenticazione e registrazione utilizzando UserDAO

    /**
     * Authenticate boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public static boolean Authenticate(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            return false;
        }

        try {
            User loggedUser = UserDAO.findByCredentials(username, password);

            if (loggedUser != null) {
                AeroportoNapoli.LoggedUser = loggedUser;
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore del database durante l'autenticazione: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Is current user admin boolean.
     *
     * @return the boolean
     */
    public static boolean isCurrentUserAdmin() {
        return AeroportoNapoli.LoggedUser != null && AeroportoNapoli.LoggedUser.getAdmin();
    }

    /**
     * Register user boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public static boolean registerUser(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Username e password sono obbligatori",
                    "Errore di validazione",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            // Verifica se l'username esiste già utilizzando UserDAO
            if (UserDAO.usernameExists(username)) {
                JOptionPane.showMessageDialog(null,
                        "Username già esistente. Sceglierne un altro.",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Inserisce il nuovo utente utilizzando UserDAO
            boolean isRegistered = UserDAO.insert(username, password);

            if (isRegistered) {
                // Autentica automaticamente l'utente dopo la registrazione
                User newUser = UserDAO.findByCredentials(username, password);
                if (newUser != null) {
                    AeroportoNapoli.LoggedUser = newUser;
                }

                JOptionPane.showMessageDialog(null,
                        "Registrazione completata con successo!",
                        "Successo",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            return isRegistered;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore del database durante la registrazione: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Gets current user.
     *
     * @return the current user
     */
    public static User getCurrentUser() {
        return AeroportoNapoli.LoggedUser;
    }

    /**
     * Logout.
     */
    public static void logout() {
        AeroportoNapoli.LoggedUser = null;
    }

    /**
     * Find user by username user.
     *
     * @param username the username
     * @return the user
     */
    public static User findUserByUsername(String username) {
        try {
            return UserDAO.findByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca dell'utente: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Find user by id user.
     *
     * @param userId the user id
     * @return the user
     */
    public static User findUserById(int userId) {
        try {
            return UserDAO.findById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca dell'utente: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Update user password boolean.
     *
     * @param userId      the user id
     * @param newPassword the new password
     * @return the boolean
     */
    public static boolean updateUserPassword(int userId, String newPassword) {
        if (newPassword == null || newPassword.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "La nuova password non può essere vuota",
                    "Errore di validazione",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            boolean updated = UserDAO.updatePassword(userId, newPassword);
            if (updated) {
                JOptionPane.showMessageDialog(null,
                        "Password aggiornata con successo!",
                        "Successo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            return updated;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento della password: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
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
        try {
            List<Flight> flights = FlightDAO.findAll();
            DefaultTableModel model = (DefaultTableModel) flighttable.getModel();
            model.setRowCount(0);

            for (Flight flight : flights) {
                Object[] row = {
                        flight.getFlightNumber(),
                        flight.getFlightStatus().toString(),
                        flight.getDepartureAirport(),
                        flight.getArrivalAirport(),
                        flight.getPlannedTime(),
                        flight.getDelayTime(),
                        flight.getAssignedGate()
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento dei voli: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    //tabelle admin

    /**
     * Load flight data for admin update.
     *
     * @param flighttable the flighttable
     */
    public static void loadFlightDataForAdminUpdate(JTable flighttable) {
        try {
            List<Flight> flights = FlightDAO.findAll();
            DefaultTableModel model = (DefaultTableModel) flighttable.getModel();
            model.setRowCount(0);

            for (Flight flight : flights) {
                Object[] row = {
                        flight.getFlightNumber(),
                        flight.getDepartureAirport(),
                        flight.getArrivalAirport(),
                        flight.getFlightStatus().toString()
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento dei voli per admin: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    //tabelle client

    /**
     * Load bookable flights.
     *
     * @param bookedtable the bookedtable
     */
    public static void loadBookableFlights(JTable bookedtable) {
        try {
            List<Flight> flights = FlightDAO.findByStatus("SCHEDULED");
            DefaultTableModel model = (DefaultTableModel) bookedtable.getModel();
            model.setRowCount(0);

            for (Flight flight : flights) {
                Object[] row = {
                        flight.getFlightNumber(),
                        flight.getScheduledDate(),
                        flight.getPlannedTime(),
                        flight.getDepartureAirport(),
                        flight.getArrivalAirport(),
                        flight.getFlightCompany()
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento dei voli prenotabili: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Load bookings for current user.
     *
     * @param table the table
     */
    public static void loadBookingsForCurrentUser(JTable table) {
        try {
            if (AeroportoNapoli.LoggedUser == null) {
                JOptionPane.showMessageDialog(null,
                        "Nessun utente loggato",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            java.util.List<Booking> bookings = BookingDAO.findByUserId(AeroportoNapoli.LoggedUser.getUserId());
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Booking booking : bookings) {
                Object[] row = {
                        booking.getBookingNumber(),
                        booking.getFirstName(),
                        booking.getLastName(),
                        booking.getSeatNumber(),
                        booking.getBookingStatus()
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento delle prenotazioni: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Load bookings by name.
     *
     * @param table the table
     * @param name  the name
     */
    public static void loadBookingsByName(JTable table, String name) {
        try {

            String firstName = name;


            java.util.List<Booking> bookings = BookingDAO.findByName(firstName);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Booking booking : bookings) {
                Object[] row = {
                        booking.getBookingNumber(),
                        booking.getFirstName(),
                        booking.getLastName(),
                        booking.getSeatNumber(),
                        booking.getBookingStatus()
                };
                model.addRow(row);
            }

            if (bookings.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Nessuna prenotazione trovata per: " + firstName ,
                        "Nessun risultato",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca delle prenotazioni: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
        }
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
            return FlightDAO.findByFlightNumber(flightNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Find flight by id flight.
     *
     * @param id the id
     * @return the flight
     */
    public static Flight findFlightById(int id) {
        try {
            return FlightDAO.findById(id);
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

    /**
     * Create flight boolean.
     *
     * @param flightNumber     the flight number
     * @param flightCompany    the flight company
     * @param departureAirport the departure airport
     * @param arrivalAirport   the arrival airport
     * @param scheduledDate    the scheduled date
     * @param plannedTime      the planned time
     * @param assignedGate     the assigned gate
     * @param flightStatus     the flight status
     * @return the boolean
     */
    public static boolean createFlight(String flightNumber, String flightCompany, String departureAirport,
                                       String arrivalAirport, String scheduledDate, String plannedTime,
                                       String assignedGate, String flightStatus) {
        return Flight.createFlight(flightNumber, flightCompany, departureAirport, arrivalAirport,
                scheduledDate, plannedTime, assignedGate, flightStatus);
    }

    /**
     * Delete flight boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean deleteFlight(int id) {
        return FlightDAO.delete(id);
    }

    /**
     * Gets all flights.
     *
     * @return the all flights
     */
    public static List<Flight> getAllFlights() {
        try {
            return FlightDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il recupero dei voli: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Gets flights by status.
     *
     * @param status the status
     * @return the flights by status
     */
    public static List<Flight> getFlightsByStatus(String status) {
        try {
            return FlightDAO.findByStatus(status);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il recupero dei voli per stato: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Gets flight id by number.
     *
     * @param flightNumber the flight number
     * @return the flight id by number
     */
    public static int getFlightIdByNumber(String flightNumber) {
        return FlightDAO.getFlightIdByNumber(flightNumber);
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
        return BookingDAO.getBookingDetailsByNumber(bookingNumber);
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
        return BookingDAO.updateDetails(bookingNumber, firstName, lastName);
    }

    /**
     * Update booking status boolean.
     *
     * @param bookingNumber the booking number
     * @param newStatus     the new status
     * @return the boolean
     */
    public static boolean updateBookingStatus(int bookingNumber, String newStatus) {
        return BookingDAO.updateStatus(bookingNumber, newStatus);
    }

    //metodi di supporto per le prenotazioni utilizzando BookingDAO

    /**
     * Find booking by id booking.
     *
     * @param id the id
     * @return the booking
     */
    public static Booking findBookingById(int id) {
        try {
            return BookingDAO.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca della prenotazione: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Find booking by booking number booking.
     *
     * @param bookingNumber the booking number
     * @return the booking
     */
    public static Booking findBookingByBookingNumber(int bookingNumber) {
        try {
            return BookingDAO.findByBookingNumber(bookingNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca della prenotazione: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Delete booking boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean deleteBooking(int id) {
        return BookingDAO.delete(id);
    }
}