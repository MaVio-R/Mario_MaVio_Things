package model;

public class Booking {

    private int bookingId;
    private int userId;
    private int flightId;
    private int luggageId;
    
    private int bookingNumber;     
    private String clientFName;     
    private String clientSName;     
    private String seatNumber;      
    private BookingStatus bookingStatus;   

    public Booking(int bookingId, int userId, int flightId, int luggageId,
            int bookingNumber, String clientFName, String clientSName, String seatNumber,
            BookingStatus bookingStatus) {    

         this.bookingId = bookingId;
         this.userId = userId;
         this.flightId = flightId;
         this.luggageId = luggageId;
         this.bookingNumber = bookingNumber;
         this.clientFName = clientFName;
         this.clientSName = clientSName;
         this.seatNumber = seatNumber;
         this.bookingStatus = bookingStatus;
    }

       
    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return this.flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    
    public int getLuggageId() {
        return this.luggageId;
    }

    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }

    public int getBookingNumber() {
        return this.bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getClientFName() {
        return this.clientFName;
    }

    public void setClientFName(String clientFName) {
        this.clientFName = clientFName;
    }

    public String getClientSName() {
        return this.clientSName;
    }

    public void setClientSName(String clientSName) {
        this.clientSName = clientSName;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BookingStatus getBookingStatus() {
        return this.bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}



