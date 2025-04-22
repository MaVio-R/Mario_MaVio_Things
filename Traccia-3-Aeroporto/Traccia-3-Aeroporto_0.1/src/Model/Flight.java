package Model;

import static Model.FlightStatus.*;

public class Flight {
    private String flightCode;
    private String flightCompany;
    private String date;
    private String departureTime;
    private FlightStatus status;
    private boolean delayed;
    private String destinationAirport;
    private String departureAirport;
}
