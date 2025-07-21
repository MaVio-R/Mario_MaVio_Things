package model;

import controller.*;
import dao.BookingDAO;

import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * The type Booking.
 */
public class Booking {
    private int id;
    private int userId;
    private int flightId;
    private int bookingNumber;
    private String firstName;
    private String lastName;
    private String seatNumber;
    private String bookingStatus;

    /**
     * Instantiates a new Booking.
     */
// Costruttori
    public Booking() {}

    /**
     * Instantiates a new Booking.
     *
     * @param id            the id
     * @param userId        the user id
     * @param flightId      the flight id
     * @param bookingNumber the booking number
     * @param firstName     the first name
     * @param lastName      the last name
     * @param seatNumber    the seat number
     * @param bookingStatus the booking status
     */
    public Booking(int id, int userId, int flightId, int bookingNumber,
                   String firstName, String lastName, String seatNumber, String bookingStatus) {
        this.id = id;
        this.userId = userId;
        this.flightId = flightId;
        this.bookingNumber = bookingNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.seatNumber = seatNumber;
        this.bookingStatus = bookingStatus;
    }

    /**
     * Instantiates a new Booking.
     *
     * @param userId        the user id
     * @param flightId      the flight id
     * @param bookingNumber the booking number
     * @param firstName     the first name
     * @param lastName      the last name
     * @param seatNumber    the seat number
     * @param bookingStatus the booking status
     */
    public Booking(int userId, int flightId, int bookingNumber,
                   String firstName, String lastName, String seatNumber, String bookingStatus) {
        this.userId = userId;
        this.flightId = flightId;
        this.bookingNumber = bookingNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.seatNumber = seatNumber;
        this.bookingStatus = bookingStatus;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
// Getters e Setters
    public int getId() { return id; }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) { this.id = id; }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() { return userId; }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) { this.userId = userId; }

    /**
     * Gets flight id.
     *
     * @return the flight id
     */
    public int getFlightId() { return flightId; }

    /**
     * Sets flight id.
     *
     * @param flightId the flight id
     */
    public void setFlightId(int flightId) { this.flightId = flightId; }

    /**
     * Gets booking number.
     *
     * @return the booking number
     */
    public int getBookingNumber() { return bookingNumber; }

    /**
     * Sets booking number.
     *
     * @param bookingNumber the booking number
     */
    public void setBookingNumber(int bookingNumber) { this.bookingNumber = bookingNumber; }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() { return firstName; }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() { return lastName; }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Gets seat number.
     *
     * @return the seat number
     */
    public String getSeatNumber() { return seatNumber; }

    /**
     * Sets seat number.
     *
     * @param seatNumber the seat number
     */
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    /**
     * Gets booking status.
     *
     * @return the booking status
     */
    public String getBookingStatus() { return bookingStatus; }

    /**
     * Sets booking status.
     *
     * @param bookingStatus the booking status
     */
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }

    /**
     * Create booking boolean.
     *
     * @param flightNumber the flight number
     * @param firstName    the first name
     * @param lastName     the last name
     * @return the boolean
     */
// Metodi statici per la logica di business
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

            // Crea l'oggetto Booking
            int loggedUserId = AeroportoNapoli.LoggedUser.getUserId();
            int bookingNumber = generateBookingNumber();
            String seatNumber = generateRandomSeat();

            Booking newBooking = new Booking(
                    loggedUserId,
                    flightId,
                    bookingNumber,
                    firstName,
                    lastName,
                    seatNumber,
                    "PENDING"
            );

            // Inserisce utilizzando BookingDAO
            boolean success = BookingDAO.insert(newBooking);

            if (success) {
                JOptionPane.showMessageDialog(null,
                        "Prenotazione effettuata con successo!\nNumero prenotazione: " + bookingNumber,
                        "Successo",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (Exception e) {
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
        return BookingDAO.getBookingDetailsByNumber(bookingNumber);
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
        return BookingDAO.updateDetails(bookingNumber, firstName, lastName);
    }

    /**
     * Update booking status boolean.
     *
     * @param bookingNumber the booking number
     * @param newStatus     the new status
     * @return the boolean
     */
    public static boolean updateBookingStatus(int bookingNumber, String newStatus) {
        return BookingDAO.updateStatus(bookingNumber, newStatus);
    }

    /**
     * Find by id booking.
     *
     * @param id the id
     * @return the booking
     */
// Metodi di ricerca utilizzando BookingDAO
    public static Booking findById(int id) {
        try {
            return BookingDAO.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca della prenotazione: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Find by booking number booking.
     *
     * @param bookingNumber the booking number
     * @return the booking
     */
    public static Booking findByBookingNumber(int bookingNumber) {
        try {
            return BookingDAO.findByBookingNumber(bookingNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante la ricerca della prenotazione: " + e.getMessage(),
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Metodi privati di utilità
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