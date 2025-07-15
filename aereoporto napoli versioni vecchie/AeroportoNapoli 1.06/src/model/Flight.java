package model;

public class Flight {
    private int flightId;
    private String flightNumber;
    private String flightCompany;
    private String scheduledDate; // Può essere anche LocalDate
    private String plannedTime;
    private String delayTime;
    private String departureAirport;
    private String arrivalAirport;
    private String assignedGate;
    private FlightStatus flightStatus;

    public Flight(int flightId, String flightNumber,
                  String flightCompany, String scheduledDate, String plannedTime,
                  String delayTime, String departureAirport, String arrivalAirport,
                  String assignedGate, FlightStatus flightStatus) {

        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.scheduledDate = scheduledDate;
        this.plannedTime = plannedTime;
        this.delayTime = delayTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.assignedGate = assignedGate;
        this.flightStatus = flightStatus;
    }
    
    public int getFlightId() {
        return this.flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightCompany() {
        return this.flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public String getScheduledDate() {
        return this.scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getPlannedTime() {
        return this.plannedTime;
    }

    public void setPlannedTime(String plannedTime) {
        this.plannedTime = plannedTime;
    }

    public String getDelayTime() {
        return this.delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return this.arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
    
    public String getAssignedGate() {
        return this.assignedGate;
    }

    public void setAssignedGate(String assignedGate) {
        this.assignedGate = assignedGate;
    }

    public FlightStatus getFlightStatus() {
        return this.flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }
    
}
