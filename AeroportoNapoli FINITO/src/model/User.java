package model;

import controller.*;

import java.sql.*;

/**
 * The type User.
 */
public class User {
    private int userId;
    private String username;
    private boolean admin;


    /**
     * Instantiates a new User.
     *
     * @param userId   the user id
     * @param username the username
     * @param admin    the admin
     */
    public User(int userId, String username, boolean admin) {
        this.userId = userId;
        this.username = username;
        this.admin = admin;
    }

    /**
     * Authenticate user.
     *
     * @param username the username
     * @param password the password
     * @return the user
     * @throws SQLException the sql exception
     */
    public static User authenticate(String username, String password) throws SQLException {
        validateInput(username, password);

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    boolean isAdmin = rs.getBoolean("admin");

                    User authenticatedUser = new User(id, username, isAdmin);
                    AeroportoNapoli.LoggedUser = authenticatedUser;

                    return authenticatedUser;
                }
            }
        }
        return null;
    }

    /**
     * Register boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean register(String username, String password) throws SQLException {
        validateInput(username, password);

        String query = "INSERT INTO user (username, password, admin) VALUES (?, ?, false)";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            pst.setString(2, password);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
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
     * Authenticate user boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public static boolean authenticateUser(String username, String password) {
        try {
            User loggedUser = User.authenticate(username, password);

            if (loggedUser != null) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Errore del database: " + e.getMessage(),
                    "Errore",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Register user boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public static boolean registerUser(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        try {
            boolean isRegistered = User.register(username, password);

            if (isRegistered) {
                User.authenticate(username, password);
            }

            return isRegistered;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Admin new flight boolean.
     *
     * @param departureAirport the departure airport
     * @param arrivalAirport   the arrival airport
     * @param flightCompany    the flight company
     * @param scheduledDate    the scheduled date
     * @param plannedTime      the planned time
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean adminNewFlight(String departureAirport, String arrivalAirport, String flightCompany, String scheduledDate, String plannedTime) throws SQLException {
        validateInput(departureAirport, arrivalAirport, flightCompany);

        String flightNumber = String.format("%s%d%s",
                departureAirport.charAt(0),
                System.currentTimeMillis() % 1000,
                arrivalAirport.charAt(0));

        String sql = "INSERT INTO flight (flight_number, flight_company, scheduled_date, planned_time, delay_time, departure_airport, arrival_airport, assigned_gate, flight_status) " +
                "VALUES (?, ?, ?, ?, NULL, ?, ?, NULL, 'SCHEDULED')";
        return executeUpdate(sql, pst -> {
            pst.setString(1, flightNumber);
            pst.setString(2, flightCompany);
            pst.setString(3, scheduledDate);
            pst.setString(4, plannedTime);
            pst.setString(5, departureAirport);
            pst.setString(6, arrivalAirport);
        });
    }

    private static void validateInput(String... args) {
        for (String arg : args) {
            if (arg == null || arg.trim().isEmpty()) {
                throw new IllegalArgumentException("Input non valido: " + arg);
            }
        }
    }

    private static boolean executeUpdate(String sql, QueryPreparer preparer) throws SQLException {
        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            preparer.prepare(pst);
            return pst.executeUpdate() > 0;
        }
    }

    @FunctionalInterface
    private interface QueryPreparer {
        /**
         * Prepare.
         *
         * @param pst the pst
         * @throws SQLException the sql exception
         */
        void prepare(PreparedStatement pst) throws SQLException;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets admin.
     *
     * @return the admin
     */
    public boolean getAdmin() {
        return admin;
    }

}