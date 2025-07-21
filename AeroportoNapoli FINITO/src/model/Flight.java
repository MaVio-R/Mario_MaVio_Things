package model;

import dao.FlightDAO;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * The type Flight.
 */
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

    /**
     * Instantiates a new Flight.
     *
     * @param id               the id
     * @param flightNumber     the flight number
     * @param flightCompany    the flight company
     * @param scheduledDate    the scheduled date
     * @param plannedTime      the planned time
     * @param delayTime        the delay time
     * @param departureAirport the departure airport
     * @param arrivalAirport   the arrival airport
     * @param assignedGate     the assigned gate
     * @param flightStatus     the flight status
     */
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
     * Find by flight number flight.
     *
     * @param flightNumber the flight number
     * @return the flight
     * @throws SQLException the sql exception
     */
    public static Flight findByFlightNumber(String flightNumber) throws SQLException {
        return FlightDAO.findByFlightNumber(flightNumber);
    }

    /**
     * Update flight details boolean.
     *
     * @param date         the date
     * @param time         the time
     * @param gate         the gate
     * @param status       the status
     * @param delay        the delay
     * @param flightNumber the flight number
     * @return the boolean
     */
    public static boolean updateFlightDetails(String date, String time, String gate, String status, String delay, String flightNumber) {
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

        boolean updated = FlightDAO.updateDetails(flightNumber, scheduledDate, plannedTime, gate, status, delayTime);

        if (updated) {
            JOptionPane.showMessageDialog(null,
                    "Volo aggiornato con successo!",
                    "Successo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Nessun volo trovato con il numero: " + flightNumber,
                    "Errore", JOptionPane.WARNING_MESSAGE);
        }

        return updated;
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

        // Creazione oggetto Flight
        Flight newFlight = new Flight(0, flightNumber, flightCompany, scheduledDate, plannedTime,
                "00:00:00", departureAirport, arrivalAirport, assignedGate,
                FlightStatus.valueOf(flightStatus.toUpperCase()));

        boolean created = FlightDAO.insert(newFlight);

        if (created) {
            JOptionPane.showMessageDialog(null,
                    "Nuovo volo creato con successo!",
                    "Successo", JOptionPane.INFORMATION_MESSAGE);
        }

        return created;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
// Getters
    public int getId() {
        return this.id;
    }

    /**
     * Gets flight number.
     *
     * @return the flight number
     */
    public String getFlightNumber() {
        return this.flightNumber;
    }

    /**
     * Gets flight company.
     *
     * @return the flight company
     */
    public String getFlightCompany() {
        return this.flightCompany;
    }

    /**
     * Gets departure airport.
     *
     * @return the departure airport
     */
    public String getDepartureAirport() {
        return this.departureAirport;
    }

    /**
     * Gets arrival airport.
     *
     * @return the arrival airport
     */
    public String getArrivalAirport() {
        return this.arrivalAirport;
    }

    /**
     * Gets scheduled date.
     *
     * @return the scheduled date
     */
    public Date getScheduledDate() {
        return this.scheduledDate;
    }

    /**
     * Gets planned time.
     *
     * @return the planned time
     */
    public Time getPlannedTime() {
        return this.plannedTime;
    }

    /**
     * Gets delay time.
     *
     * @return the delay time
     */
    public Time getDelayTime() {
        return this.delayTime;
    }

    /**
     * Gets assigned gate.
     *
     * @return the assigned gate
     */
    public String getAssignedGate() {
        return this.assignedGate;
    }

    /**
     * Gets flight status.
     *
     * @return the flight status
     */
    public FlightStatus getFlightStatus() {
        return this.flightStatus;
    }
}