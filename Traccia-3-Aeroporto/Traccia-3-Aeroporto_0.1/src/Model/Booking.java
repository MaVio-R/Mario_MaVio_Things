package Model;

import static Model.BookingStatus.*;

public class Booking {
    private String bookingCode;
    private String ticketNum;
    private String seatAssigned;
    private BookingStatus status;

    /**
     * Marks the booking as checked in by setting its status to CONFIRMED.
     * This updates the booking state and ensures the booking is ready for the flight.
     */
    public void checkIn() {
        if (status == BookingStatus.PENDING) {
            status = BookingStatus.CONFIRMED;
            System.out.println("Booking " + bookingCode + " has been successfully checked in.");
        } else {
            System.out.println("Booking " + bookingCode + " cannot be checked in. Current status: " + status);
        }
    }

    /**
     * Prints the details of the booking, including booking code,
     * ticket number, seat assignment, and current status.
     */
    public void printBooking() {
        System.out.println("Booking Details:");
        System.out.println("Booking Code: " + bookingCode);
        System.out.println("Ticket Number: " + ticketNum);
        System.out.println("Seat Assigned: " + seatAssigned);
        System.out.println("Status: " + status);
    }
}
