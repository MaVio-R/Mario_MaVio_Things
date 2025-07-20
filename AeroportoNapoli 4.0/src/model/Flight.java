package model;

import controller.*;

import java.sql.*;
import javax.swing.JOptionPane;

public class Flight {
    private int id;
    private String flightNumber;
    private String flightCompany;
    private String departureAirport;
    private String arrivalAirport;
    private Date scheduledDate;
    private Time plannedTime;
    private Time delayTime;
    private String assignedGate;
    private FlightStatus flightStatus;

    // Costruttore principale con tipi Date e Time
    public Flight(int id, String flightNumber, String flightCompany, String departureAirport, String arrivalAirport,
                  Date scheduledDate, Time plannedTime, Time delayTime, String assignedGate, String flightStatus) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.scheduledDate = scheduledDate;
        this.plannedTime = plannedTime;
        this.delayTime = delayTime;
        this.assignedGate = assignedGate;
        // Conversione da String a FlightStatus
        try {
            this.flightStatus = FlightStatus.valueOf(flightStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            this.flightStatus = FlightStatus.UNKNOWN;
        }
    }

    // Costruttore alternativo per FlightUpdate
    public Flight(int id, String flightNumber, String flightCompany, String scheduledDate,
                  String plannedTime, String delayTime, String departureAirport,
                  String arrivalAirport, String assignedGate, FlightStatus flightStatus) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.assignedGate = assignedGate;
        this.flightStatus = flightStatus;

        // Conversione da String a Date e Time
        try {
            this.scheduledDate = Date.valueOf(scheduledDate);
            this.plannedTime = Time.valueOf(plannedTime);
            if (delayTime != null && !delayTime.isEmpty()) {
                this.delayTime = Time.valueOf(delayTime);
            }
        } catch (IllegalArgumentException e) {
            // Gestione errore conversione
            this.scheduledDate = null;
            this.plannedTime = null;
            this.delayTime = null;
        }
    }

    /**
     * Trova un volo tramite il numero di volo
     */
    public static Flight findByFlightNumber(String flightNumber) throws SQLException {
        String sql = "SELECT id, flight_number, flight_company, scheduled_date, planned_time, delay_time, departure_airport, arrival_airport, assigned_gate, flight_status FROM flight WHERE LOWER(flight_number) = LOWER(?)";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, flightNumber);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String company = rs.getString("flight_company");
                    String scheduledDate = rs.getDate("scheduled_date").toString();
                    String plannedTime = rs.getTime("planned_time").toString();
                    String delayTime = rs.getTime("delay_time") != null ? rs.getTime("delay_time").toString() : "00:00:00";
                    String departure = rs.getString("departure_airport");
                    String arrival = rs.getString("arrival_airport");
                    String gate = rs.getString("assigned_gate");
                    String statusStr = rs.getString("flight_status");

                    FlightStatus status = FlightStatus.valueOf(statusStr.toUpperCase());

                    return new Flight(id, flightNumber, company, scheduledDate, plannedTime, delayTime, departure, arrival, gate, status);
                }
            }
        }

        return null; // Volo non trovato
    }

    /**
     * Aggiorna i dettagli di un volo (operazione admin)
     */
    public static boolean updateFlightDetails(String date, String time, String gate, String status, String delay, String flightNumber) {
        String query = "UPDATE flight SET scheduled_date = ?, planned_time = ?, assigned_gate = ?, flight_status = ?, delay_time = ? WHERE flight_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Conversione e validazione dei parametri
            Date scheduledDate = null;
            if (date != null && !date.trim().isEmpty()) {
                try {
                    scheduledDate = Date.valueOf(date);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,
                            "Formato data non valido. Usa il formato YYYY-MM-DD",
                            "Errore", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            Time plannedTime = null;
            if (time != null && !time.trim().isEmpty()) {
                try {
                    plannedTime = Time.valueOf(time);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,
                            "Formato orario non valido. Usa il formato HH:MM:SS",
                            "Errore", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            Time delayTime = null;
            if (delay != null && !delay.trim().isEmpty()) {
                try {
                    delayTime = Time.valueOf(delay);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,
                            "Formato ritardo non valido. Usa il formato HH:MM:SS",
                            "Errore", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            // Imposta i parametri
            pst.setDate(1, scheduledDate);
            pst.setTime(2, plannedTime);
            pst.setString(3, gate);
            pst.setString(4, status);
            pst.setTime(5, delayTime);
            pst.setString(6, flightNumber);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null,
                        "Volo aggiornato con successo!",
                        "Successo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Nessun volo trovato con il numero: " + flightNumber,
                        "Errore", JOptionPane.WARNING_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Crea un nuovo volo nel database (operazione admin)
     */
    public static boolean createFlight(String flightNumber, String flightCompany, String departureAirport,
                                       String arrivalAirport, String scheduledDate, String plannedTime,
                                       String assignedGate, String flightStatus) {
        String query = """
            INSERT INTO flight (flight_number, flight_company, departure_airport, arrival_airport, 
                              scheduled_date, planned_time, assigned_gate, flight_status, delay_time)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, '00:00:00')
            """;

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Validazione e conversione parametri
            Date date = null;
            Time time = null;

            try {
                date = Date.valueOf(scheduledDate);
                time = Time.valueOf(plannedTime);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,
                        "Formato data/orario non valido.",
                        "Errore", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            pst.setString(1, flightNumber);
            pst.setString(2, flightCompany);
            pst.setString(3, departureAirport);
            pst.setString(4, arrivalAirport);
            pst.setDate(5, date);
            pst.setTime(6, time);
            pst.setString(7, assignedGate);
            pst.setString(8, flightStatus);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null,
                        "Nuovo volo creato con successo!",
                        "Successo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la creazione del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    // Getter methods
    public int getId() {
        return this.id;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getFlightCompany() {
        return this.flightCompany;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public String getArrivalAirport() {
        return this.arrivalAirport;
    }

    public Date getScheduledDate() {
        return this.scheduledDate;
    }

    public Time getPlannedTime() {
        return this.plannedTime;
    }

    public Time getDelayTime() {
        return this.delayTime;
    }

    public String getAssignedGate() {
        return this.assignedGate;
    }

    public FlightStatus getFlightStatus() {
        return this.flightStatus;
    }

    // Metodo per ottenere lo status come stringa
    public String getFlightStatusString() {
        return this.flightStatus.toString();
    }
}