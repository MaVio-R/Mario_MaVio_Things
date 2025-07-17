package model;

import controller.*;
import java.awt.List;
import java.sql.*;



public class Booking {


   private int bookingNumber;
    private int userId;
    private int flightId;
    private int luggageId;
    private String firstName;
    private String lastName;
    private String seatNumber;
    private String bookingStatus;
    
    // getters e setters
    public int getBookingNumber() { return bookingNumber; }
    public void setBookingNumber(int bookingNumber) { this.bookingNumber = bookingNumber; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getFlightId() { return flightId; }
    public void setFlightId(int flightId) { this.flightId = flightId; }

    public int getLuggageId() { return luggageId; }
    public void setLuggageId(int luggageId) { this.luggageId = luggageId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }
}



