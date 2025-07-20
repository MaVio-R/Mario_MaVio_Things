package model;

import controller.*;

import java.sql.*;

public class User {
    private int userId;
    private String username;
    private boolean admin;

    public User() {
    }

    public User(int userId, String username, boolean admin) {
        this.userId = userId;
        this.username = username;
        this.admin = admin;
    }

    public boolean setUserData(String username, String password) throws SQLException {
        String sql = "SELECT id, admin FROM user WHERE username = ? AND password = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    this.userId = rs.getInt("id");
                    this.username = username;
                    this.admin = rs.getBoolean("admin");
                    return true;
                }
            }
        }
        return false;
    }

    // Metodo per autenticare l'utente
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

    // Metodo per registrare un nuovo utente
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

    // Metodo per verificare se l'utente corrente è admin (spostato dal Controller)
    public static boolean isCurrentUserAdmin() {
        return AeroportoNapoli.LoggedUser != null && AeroportoNapoli.LoggedUser.getAdmin();
    }

    // Metodo per gestire l'autenticazione completa (spostato dal Controller)
    public static boolean authenticateUser(String username, String password) {
        try {
            User loggedUser = User.authenticate(username, password);

            if (loggedUser != null) {
                return true; // Autenticazione riuscita
            }

            return false; // Autenticazione fallita
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Errore del database: " + e.getMessage(),
                    "Errore",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Metodo per gestire la registrazione completa (spostato dal Controller)
    public static boolean registerUser(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        try {
            boolean isRegistered = User.register(username, password);

            if (isRegistered) {
                // Dopo la registrazione, autentica automaticamente l'utente
                User.authenticate(username, password);
            }

            return isRegistered;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    // Metodo per aggiornare i dettagli del volo (admin)
    public static int adminUpdateFlight(String date, String time, String gate, String status, String delay, String flightNum) throws SQLException {
        validateInput(date, time, status, flightNum);

        String sql = "UPDATE flight SET scheduled_date = ?, planned_time = ?, delay_time = ?, assigned_gate = ?, flight_status = ? WHERE flight_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, date);
            pst.setString(2, time);

            if (delay == null || delay.isEmpty()) {
                pst.setNull(3, Types.TIME);
            } else {
                pst.setString(3, delay);
            }

            if (gate == null || gate.isEmpty()) {
                pst.setNull(4, Types.VARCHAR);
            } else {
                pst.setString(4, gate);
            }

            pst.setString(5, status);
            pst.setString(6, flightNum);

            return pst.executeUpdate();
        }
    }

    // Metodo per creare un nuovo volo (admin)
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

    // Metodo statico comune per validare input
    private static void validateInput(String... args) {
        for (String arg : args) {
            if (arg == null || arg.trim().isEmpty()) {
                throw new IllegalArgumentException("Input non valido: " + arg);
            }
        }
    }

    // Helper per eseguire update
    private static boolean executeUpdate(String sql, QueryPreparer preparer) throws SQLException {
        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            preparer.prepare(pst);
            return pst.executeUpdate() > 0;
        }
    }

    @FunctionalInterface
    private interface QueryPreparer {
        void prepare(PreparedStatement pst) throws SQLException;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean getAdmin() {
        return admin;
    }

    // Metodo per fare il logout
    public void UserDrop() {
        this.userId = 0;
        this.username = null;
        this.admin = false;
    }
}