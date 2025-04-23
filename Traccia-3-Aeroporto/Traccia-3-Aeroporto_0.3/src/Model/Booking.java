package Model;

import static Model.BookingStatus.*;

public class Booking {
    private String bookingCode;
    private String ticketNumber;
    private String seatAssigned;
    private BookingStatus status;

    public Booking(String bookingCode, String ticketNumber, String seatAssigned, BookingStatus status) {
        this.bookingCode = bookingCode;
        this.ticketNumber = ticketNumber;
        this.seatAssigned = seatAssigned;
        this.status = status;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSeatAssigned() {
        return seatAssigned;
    }

    public void setSeatAssigned(String seatAssigned) {
        this.seatAssigned = seatAssigned;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void checkIn() {
        System.out.println("Metodo per effettuare il check-in.");
    }

    public void printTicket() {
        System.out.println("Metodo per stampare il biglietto.");
    }
}
