// BookingDAO.java
package dao;

import controller.Controller;
import model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * The type Booking dao.
 */
public class BookingDAO {

    /**
     * Find by id booking.
     *
     * @param id the id
     * @return the booking
     * @throws SQLException the sql exception
     */
    public static Booking findById(int id) throws SQLException {
        String sql = "SELECT id, user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status FROM booking WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBooking(rs);
                }
            }
        }
        return null;
    }

    /**
     * Find by booking number booking.
     *
     * @param bookingNumber the booking number
     * @return the booking
     * @throws SQLException the sql exception
     */
    public static Booking findByBookingNumber(int bookingNumber) throws SQLException {
        String sql = "SELECT id, user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status FROM booking WHERE booking_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, bookingNumber);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBooking(rs);
                }
            }
        }
        return null;
    }

    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws SQLException the sql exception
     */
    public static List<Booking> findByUserId(int userId) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT id, user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status FROM booking WHERE user_id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, userId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    bookings.add(mapResultSetToBooking(rs));
                }
            }
        }
        return bookings;
    }

    /**
     * Find by name list.
     *
     * @param firstName the first name
     * @return the list
     * @throws SQLException the sql exception
     */
    public static List<Booking> findByName(String firstName) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT id, user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status FROM booking WHERE first_name = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, firstName);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    bookings.add(mapResultSetToBooking(rs));
                }
            }
        }
        return bookings;
    }

    /**
     * Find all list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
    public static List<Booking> findAll() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT id, user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status FROM booking";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                bookings.add(mapResultSetToBooking(rs));
            }
        }
        return bookings;
    }

    /**
     * Insert boolean.
     *
     * @param booking the booking
     * @return the boolean
     */
    public static boolean insert(Booking booking) {
        String sql = """
            INSERT INTO booking (user_id, flight_id, booking_number, first_name, last_name, seat_number, booking_status)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, booking.getUserId());
            pst.setInt(2, booking.getFlightId());
            pst.setInt(3, booking.getBookingNumber());
            pst.setString(4, booking.getFirstName());
            pst.setString(5, booking.getLastName());
            pst.setString(6, booking.getSeatNumber());
            pst.setString(7, booking.getBookingStatus());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'inserimento della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Update boolean.
     *
     * @param booking the booking
     * @return the boolean
     */
    public static boolean update(Booking booking) {
        String sql = "UPDATE booking SET user_id = ?, flight_id = ?, booking_number = ?, first_name = ?, last_name = ?, seat_number = ?, booking_status = ? WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, booking.getUserId());
            pst.setInt(2, booking.getFlightId());
            pst.setInt(3, booking.getBookingNumber());
            pst.setString(4, booking.getFirstName());
            pst.setString(5, booking.getLastName());
            pst.setString(6, booking.getSeatNumber());
            pst.setString(7, booking.getBookingStatus());
            pst.setInt(8, booking.getId());

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
     * Update details boolean.
     *
     * @param bookingNumber the booking number
     * @param firstName     the first name
     * @param lastName      the last name
     * @return the boolean
     */
    public static boolean updateDetails(int bookingNumber, String firstName, String lastName) {
        String sql = "UPDATE booking SET first_name = ?, last_name = ? WHERE booking_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setInt(3, bookingNumber);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'aggiornamento dei dettagli della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Update status boolean.
     *
     * @param bookingNumber the booking number
     * @param newStatus     the new status
     * @return the boolean
     */
    public static boolean updateStatus(int bookingNumber, String newStatus) {
        String sql = "UPDATE booking SET booking_status = ? WHERE booking_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

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

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean delete(int id) {
        String sql = "DELETE FROM booking WHERE id = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante l'eliminazione della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Get booking details by number string [ ].
     *
     * @param bookingNumber the booking number
     * @return the string [ ]
     */
    public static String[] getBookingDetailsByNumber(int bookingNumber) {
        String sql = "SELECT first_name, last_name FROM booking WHERE booking_number = ?";

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, bookingNumber);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    return new String[]{firstName, lastName};
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il recupero dei dettagli della prenotazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private static Booking mapResultSetToBooking(ResultSet rs) throws SQLException {
        return new Booking(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getInt("flight_id"),
                rs.getInt("booking_number"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("seat_number"),
                rs.getString("booking_status")
        );
    }
}