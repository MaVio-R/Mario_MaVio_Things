package model;

import java.sql.Date;
import java.sql.Time;

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