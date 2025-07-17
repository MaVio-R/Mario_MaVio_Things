package model;

import controller.*;

import java.sql.*;

public class User {
    private int userId;
    private String username;
    private boolean admin;

    public User() {
    }
    public boolean setUserData(String username, String password) throws SQLException {
        String sql = "SELECT id, admin FROM user WHERE username = ? AND password = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    this.userId = rs.getInt("id");           // Aggiorna l'ID dell'utente
                    this.username = username;               // Aggiorna il nome utente
                    this.admin = rs.getBoolean("admin");    // Aggiorna il ruolo di amministrazione
                    return true;                            // Operazione riuscita
                }
            }
        }

        return false; // Operazione fallita: username/password errati
    }


    public User(int userId, String username, boolean admin) {
        this.userId = userId;
        this.username = username;
        this.admin = admin;
    }

    // Metodo per autenticare l'utente
    // Rimuovi il metodo setUserData() - è ridondante
// public boolean setUserData(String username, String password) { ... }

    // Metodo per autenticare l'utente
    public static User authenticate(String username, String password) throws SQLException {
        validateInput(username, password);

        // Correggi il nome della tabella (scegli uno: user o users)
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    boolean isAdmin = rs.getBoolean("admin");

                    // Crea un nuovo oggetto User
                    User authenticatedUser = new User(id, username, isAdmin);

                    // Salva l'utente autenticato in AeroportoNapoli.LoggedUser
                    AeroportoNapoli.LoggedUser = authenticatedUser;

                    return authenticatedUser;
                }
            }
        }
        return null;
    }

    // Correzione del metodo register per usare la stessa tabella
    public static boolean register(String username, String password) throws SQLException {
        // Usa lo stesso nome tabella di authenticate
        String query = "INSERT INTO user (username, password, admin) VALUES (?, ?, false)";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            pst.setString(2, password);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public static int adminUpdateFlight(String date, String time, String gate, String status, String delay, String flightNum) throws SQLException {
        // Validazione dei parametri obbligatori
        validateInput(date, time, status, flightNum);

        String sql = "UPDATE flight SET scheduled_date = ?, planned_time = ?, delay_time = ?, assigned_gate = ?, flight_status = ? WHERE flight_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Parametri obbligatori
            pst.setString(1, date);  // Data programmata del volo
            pst.setString(2, time);  // Orario programmato

            // Parametri opzionali: delay (ritardo) e gate (cancello)
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

            // Stato del volo
            pst.setString(5, status);

            // Identificativo del volo
            pst.setString(6, flightNum);

            // Esegui l'aggiornamento
            return pst.executeUpdate(); // Ritorna il numero di righe aggiornate (di solito 1)
        }
    }

    // Metodo per creare un nuovo volo (da parte dell'admin)
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

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void UserDrop() {
        this.userId = 0;
        this.username = null;
        this.admin = false;
    }
}