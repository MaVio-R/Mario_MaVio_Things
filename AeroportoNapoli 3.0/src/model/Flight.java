package model;

import controller.*;

import java.sql.*;


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
    private FlightStatus flightStatus; // Cambiato da String a FlightStatus

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