package model;

import controller.*;

import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * The type Booking.
 */
public class Booking {

    /**
     * Create booking boolean.
     *
     * @param flightNumber the flight number
     * @param firstName    the first name
     * @param lastName     the last name
     * @return the boolean
     */
    public static boolean createBooking(String flightNumber, String firstName, String lastName) {
        try {
            // Recupera l'ID del volo dal numero
            int flightId = getFlightIdByNumber(flightNumber);
            if (flightId == -1) {
                JOptionPane.showMessageDialog(null,
                        "Volo non trovato: " + flightNumber,
                        "Errore",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Crea la prenotazione
            String queryPrenotazione = """
                INSERT INTO booking (user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status)
                VALUES (?, ?, ?, ?, ?, ?, 'PENDING')
                """;

            try (Connection con = Controller.getConnection();
                 PreparedStatement pst = con.prepareStatement(queryPrenotazione)) {

                int loggedUserId = AeroportoNapoli.LoggedUser.getUserId();
                int bookingNumber = generateBookingNumber();
                String seatNumber = generateRandomSeat();

                pst.setInt(1, loggedUserId);
                pst.setInt(2, flightId);
                pst.setInt(3, bookingNumber);
                pst.setString(4, firstName);
                pst.setString(5, lastName);
                pst.setString(6, seatNumber);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Prenotazione effettuata con successo!\nNumero prenotazione: " + bookingNumber,
                            "Successo",
                            JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la prenotazione: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Get booking details by number string [ ].
     *
     * @param bookingNumber the booking number
     * @return the string [ ]
     */
    public static String[] getBookingDetailsByNumber(int bookingNumber) {
        String query = "SELECT first_name, last_name FROM booking WHERE booking_number = ?";
        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, bookingNumber);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    return new String[]{firstName, lastName};
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nessuna prenotazione trovata per il numero: " + bookingNumber,
                            "Errore", JOptionPane.WARNING_MESSAGE);
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il recupero dei dettagli della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
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
        String query = "UPDATE booking SET first_name = ?, last_name = ? WHERE booking_number = ?";
        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setInt(3, bookingNumber);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Update booking status boolean.
     *
     * @param bookingNumber the booking number
     * @param newStatus     the new status
     * @return the boolean
     */
    public static boolean updateBookingStatus(int bookingNumber, String newStatus) {
        String query = "UPDATE booking SET booking_status = ? WHERE booking_number = ?";
        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newStatus);
            pst.setInt(2, bookingNumber);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento dello stato della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    private static int getFlightIdByNumber(String flightNumber) {
        String query = "SELECT id FROM flight WHERE flight_number = ?";
        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

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

    private static int generateBookingNumber() {
        return new Random().nextInt(99999) + 1;
    }

    private static String generateRandomSeat() {
        Random rand = new Random();
        char row = (char) ('A' + rand.nextInt(26)); // A-Z
        int number = rand.nextInt(99) + 1; // 1-99
        return row + String.valueOf(number);
    }
}