package Model;

import static Model.FlightStatus.*;

public class Flight {
    private String flightNumber;
    private String flightCompany;
    private String date;
    private String departureTime;
    private FlightStatus status;
    private int delayed;
    private String departureAirport;
    private String destinationAirport;

    public Flight(String flightNumber, String flightCompany, String date, String departureTime, FlightStatus status, int delayed, String departureAirport, String destinationAirport) {
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.date = date;
        this.departureTime = departureTime;
        this.status = status;
        this.delayed = delayed;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public int getDelayed() {
        return delayed;
    }

    public void setDelayed(int delayed) {
        this.delayed = delayed;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
}
