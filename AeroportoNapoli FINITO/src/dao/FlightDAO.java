// FlightDAO.java
package dao;

import controller.Controller;
import model.Flight;
import model.FlightStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * The type Flight dao.
 */
public class FlightDAO {

    /**
     * Find by id flight.
     *
     * @param id the id
     * @return the flight
     * @throws SQLException the sql exception
     */
    public static Flight findById(int id) throws SQLException {
        String sql = "SELECT id, flight_number, flight_company, scheduled_date, planned_time, delay_time, departure_airport, arrival_airport, assigned_gate, flight_status FROM flight WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToFlight(rs);
                }
            }
        }
        return null;
    }

    /**
     * Find by flight number flight.
     *
     * @param flightNumber the flight number
     * @return the flight
     * @throws SQLException the sql exception
     */
    public static Flight findByFlightNumber(String flightNumber) throws SQLException {
        String sql = "SELECT id, flight_number, flight_company, scheduled_date, planned_time, delay_time, departure_airport, arrival_airport, assigned_gate, flight_status FROM flight WHERE LOWER(flight_number) = LOWER(?)";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, flightNumber);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToFlight(rs);
                }
            }
        }
        return null;
    }

    /**
     * Find all list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
    public static List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT id, flight_number, flight_company, scheduled_date, planned_time, delay_time, departure_airport, arrival_airport, assigned_gate, flight_status FROM flight";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                flights.add(mapResultSetToFlight(rs));
            }
        }
        return flights;
    }

    /**
     * Find by status list.
     *
     * @param status the status
     * @return the list
     * @throws SQLException the sql exception
     */
    public static List<Flight> findByStatus(String status) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT id, flight_number, flight_company, scheduled_date, planned_time, delay_time, departure_airport, arrival_airport, assigned_gate, flight_status FROM flight WHERE flight_status = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, status);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    flights.add(mapResultSetToFlight(rs));
                }
            }
        }
        return flights;
    }

    /**
     * Insert boolean.
     *
     * @param flight the flight
     * @return the boolean
     */
    public static boolean insert(Flight flight) {
        String sql = """
            INSERT INTO flight (flight_number, flight_company, departure_airport, arrival_airport, 
                              scheduled_date, planned_time, assigned_gate, flight_status, delay_time)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, flight.getFlightNumber());
            pst.setString(2, flight.getFlightCompany());
            pst.setString(3, flight.getDepartureAirport());
            pst.setString(4, flight.getArrivalAirport());
            pst.setDate(5, flight.getScheduledDate());
            pst.setTime(6, flight.getPlannedTime());
            pst.setString(7, flight.getAssignedGate());
            pst.setString(8, flight.getFlightStatus().toString());
            pst.setTime(9, flight.getDelayTime());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'inserimento del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Update boolean.
     *
     * @param flight the flight
     * @return the boolean
     */
    public static boolean update(Flight flight) {
        String sql = "UPDATE flight SET flight_company = ?, departure_airport = ?, arrival_airport = ?, scheduled_date = ?, planned_time = ?, assigned_gate = ?, flight_status = ?, delay_time = ? WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, flight.getFlightCompany());
            pst.setString(2, flight.getDepartureAirport());
            pst.setString(3, flight.getArrivalAirport());
            pst.setDate(4, flight.getScheduledDate());
            pst.setTime(5, flight.getPlannedTime());
            pst.setString(6, flight.getAssignedGate());
            pst.setString(7, flight.getFlightStatus().toString());
            pst.setTime(8, flight.getDelayTime());
            pst.setInt(9, flight.getId());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Update details boolean.
     *
     * @param flightNumber  the flight number
     * @param scheduledDate the scheduled date
     * @param plannedTime   the planned time
     * @param assignedGate  the assigned gate
     * @param flightStatus  the flight status
     * @param delayTime     the delay time
     * @return the boolean
     */
    public static boolean updateDetails(String flightNumber, Date scheduledDate, Time plannedTime,
                                        String assignedGate, String flightStatus, Time delayTime) {
        String sql = "UPDATE flight SET scheduled_date = ?, planned_time = ?, assigned_gate = ?, flight_status = ?, delay_time = ? WHERE flight_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setDate(1, scheduledDate);
            pst.setTime(2, plannedTime);
            pst.setString(3, assignedGate);
            pst.setString(4, flightStatus);
            pst.setTime(5, delayTime);
            pst.setString(6, flightNumber);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento dei dettagli del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean delete(int id) {
        String sql = "DELETE FROM flight WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'eliminazione del volo: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Gets flight id by number.
     *
     * @param flightNumber the flight number
     * @return the flight id by number
     */
    public static int getFlightIdByNumber(String flightNumber) {
        String sql = "SELECT id FROM flight WHERE flight_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, flightNumber);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static Flight mapResultSetToFlight(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String flightNumber = rs.getString("flight_number");
        String company = rs.getString("flight_company");
        String scheduledDate = rs.getDate("scheduled_date").toString();
        String plannedTime = rs.getTime("planned_time").toString();
        String delayTime = rs.getTime("delay_time") != null ? rs.getTime("delay_time").toString() : "00:00:00";
        String departure = rs.getString("departure_airport");
        String arrival = rs.getString("arrival_airport");
        String gate = rs.getString("assigned_gate");
        String statusStr = rs.getString("flight_status");

        FlightStatus status = FlightStatus.valueOf(statusStr.toUpperCase());

        return new Flight(id, flightNumber, company, scheduledDate, plannedTime,
                delayTime, departure, arrival, gate, status);
    }
}