import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Create User objects
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        // Prompt for username and password using a scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();
        
        User user3 = new User(usernameInput, passwordInput);

        // Create Client objects
        Client client1 = new Client("client1", "password1", "John", "Doe", "01/01/1990", "123-45-6789", "john.doe@example.com", "123-456-7890");
        Client client2 = new Client("client2", "password2", "Jane", "Smith", "02/02/1992", "987-65-4321", "jane.smith@example.com", "098-765-4321");

        // Prompt for Client details using a scanner
        System.out.print("Enter client username: ");
        String clientUsername = scanner.nextLine();
        
        System.out.print("Enter client password: ");
        String clientPassword = scanner.nextLine();
       
        System.out.print("Enter client first name: ");
        String clientName = scanner.nextLine();
       
        System.out.print("Enter client last name: ");
        String clientSurname = scanner.nextLine();
       
        System.out.print("Enter client DOB (DD/MM/YYYY): ");
        String clientDOB = scanner.nextLine();
       
        System.out.print("Enter client SSN: ");
        String clientSSN = scanner.nextLine();
        
        System.out.print("Enter client email: ");
        String clientEmail = scanner.nextLine();
       
        System.out.print("Enter client phone number: ");
        String clientPhone = scanner.nextLine();

        Client client3 = new Client(clientUsername, clientPassword, clientName, clientSurname, clientDOB, clientSSN, clientEmail, clientPhone);

        // Create Admin objects
        Admin admin1 = new Admin("admin1", "adminpass1", "OPCODE1");
        Admin admin2 = new Admin("admin2", "adminpass2", "OPCODE2");

        // Prompt for Admin details using a scanner
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();

        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        System.out.print("Enter admin opCode: ");
        String adminOpCode = scanner.nextLine();

        Admin admin3 = new Admin(adminUsername, adminPassword, adminOpCode);

        // Create Booking objects
        Booking booking1 = new Booking("BK001", "TKT001", "12A", BookingStatus.CONFIRMED);
        Booking booking2 = new Booking("BK002", "TKT002", "14C", BookingStatus.PENDING);

        // Prompt for Booking details using a scanner
        System.out.print("Enter Booking Code: ");
        String bookingCode = scanner.nextLine();

        System.out.print("Enter Ticket Number: ");
        String ticketNumber = scanner.nextLine();

        System.out.print("Enter Seat Assigned: ");
        String seatAssigned = scanner.nextLine();

        System.out.print("Enter Booking Status (PENDING, CONFIRMED, DELETED): ");
        BookingStatus status = BookingStatus.valueOf(scanner.nextLine().toUpperCase());

        Booking booking3 = new Booking(bookingCode, ticketNumber, seatAssigned, status);
        System.out.println("New Booking Created: " + booking3.getBookingCode() + ", " + booking3.getTicketNumber() + ", " + booking3.getSeatAssigned() + ", " + booking3.getStatus());

        // Create Gate objects
        Gate gate1 = new Gate("G1", "T1");
        Gate gate2 = new Gate("G2", "T2");

        // Prompt for Gate details using a scanner
        System.out.print("Enter Gate Number: ");
        String gateNumber = scanner.nextLine();

        System.out.print("Enter Terminal: ");
        String terminal = scanner.nextLine();

        Gate gate3 = new Gate(gateNumber, terminal);
        System.out.println("New Gate Created: " + gate3.getGateNumber() + ", " + gate3.getTerminal());


        // Create Flight objects
        Flight flight1 = new Flight("FL001", "Airline1", "2023-12-01", "10:00 AM", FlightStatus.SCHEDULED, 0, "JFK", "LAX", "", "", "", "", "", 0);
        Flight flight2 = new Flight("FL002", "Airline2", "2023-12-02", "12:00 PM", FlightStatus.BOARDING, 15, "SFO", "ORD", "", "", "", "", "", 0);

        // Prompt for Flight details using a scanner
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();

        System.out.print("Enter Flight Company: ");
        String flightCompany = scanner.nextLine();

        System.out.print("Enter Flight Date (DD/MM/YY): ");
        String flightDate = scanner.nextLine();

        System.out.print("Enter Departure Time (00:00 - 23-59): ");
        String departureTime = scanner.nextLine();

        System.out.print("Enter Flight Status (SCHEDULED, DEPARTED, CANCELED, etc.): ");
        FlightStatus flightStatus = FlightStatus.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Enter Delay in Minutes: ");
        int delay = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Departure Airport Code: ");
        String departureAirport = scanner.nextLine();

        System.out.print("Enter Destination Airport Code: ");
        String destinationAirport = scanner.nextLine();

        Flight flight3 = new Flight(flightNumber, flightCompany, flightDate, departureTime, flightStatus, delay, departureAirport, destinationAirport, "", "", "", "", "", 0);
        System.out.println("New Flight Created: " + flight3.getFlightNumber() + ", " + flight3.getFlightCompany() + ", " + flight3.getDate() + ", " + flight3.getDepartureTime() + ", " + flight3.getStatus() + ", Delay: " + flight3.getDelayed() + " minutes, From: " + flight3.getDepartureAirport() + ", To: " + flight3.getDestinationAirport());

        // Create Luggage objects
        Luggage luggage1 = new Luggage("LUG001", LuggageStatus.LOST);
        Luggage luggage2 = new Luggage("LUG002", LuggageStatus.FOUND);

        // Prompt for Luggage details using a scanner
        System.out.print("Enter Luggage Number: ");
        String luggageNumber = scanner.nextLine();

        System.out.print("Enter Luggage Status (NOT_INCLUDED, INCLUDED, CHECKED_IN, BOARDED, LOST, FOUND, AVAILABLE_AT_PICKUP): ");
        LuggageStatus luggageStatus = LuggageStatus.valueOf(scanner.nextLine().toUpperCase());

        Luggage luggage3 = new Luggage(luggageNumber, luggageStatus);
        System.out.println("New Luggage Created: " + luggage3.getLuggageNumber() + ", " + luggage3.getLuggageStatus());


        // Demonstrate User methods
        System.out.println("User1 Username: " + user1.getUsername());
        System.out.println("User2 Password: " + user2.getPassword());
        user1.setUsername("newUser1");
        System.out.println("Updated User1 Username: " + user1.getUsername());

        // Demonstrate Client methods
        client1.newBooking();
        client1.updateBooking();
        client1.deleteBooking();
        client1.viewBooked();
        client1.reportLostLuggage();
        
        System.out.println("Client1 Email: " + client1.getEmail());
        client1.setEmail("john.new@example.com");
        System.out.println("Updated Client1 Email: " + client1.getEmail());

        // Demonstrate Admin methods
        admin1.insertFlight();
        admin1.updateFlight();
        admin2.deleteFlight();
        admin2.viewAllFlights();
        admin2.viewLost();
        admin2.updateLostLuggage();
        
        System.out.println("Admin1 OpCode: " + admin1.getOpCode());
        admin1.setOpCode("NEW_OPCODE1");
        System.out.println("Updated Admin1 OpCode: " + admin1.getOpCode());

        // Demonstrate Booking methods
        System.out.println("Booking1 Code: " + booking1.getBookingCode());
        booking1.checkIn();
        booking1.printTicket();
        booking1.setStatus(BookingStatus.PENDING);
        System.out.println("Updated Booking1 Status: " + booking1.getStatus());

        // Demonstrate Gate methods
        System.out.println("Gate1 Terminal: " + gate1.getTerminal());
        gate1.setTerminal("Updated Terminal T5");
        System.out.println("Updated Gate1 Terminal: " + gate1.getTerminal());

        // Demonstrate Flight methods
        System.out.println("Flight1 Status: " + flight1.getStatus());
        flight1.setStatus(FlightStatus.RESCHEDULED);
        System.out.println("Updated Flight1 Status: " + flight1.getStatus());

        // Demonstrate Luggage methods
        System.out.println("Luggage1 Status: " + luggage1.getLuggageStatus());
        luggage1.setLuggageStatus(LuggageStatus.BOARDED);
        System.out.println("Updated Luggage1 Status: " + luggage1.getLuggageStatus());


    }
}