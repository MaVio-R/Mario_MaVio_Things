package Model;

public class Client extends User {
    private String name;
    private String surname;
    private String DOB;
    private String SSN;
    private String email;
    private String phoneNumber;

    public Client(String username, String password, String name, String surname, String DOB, String SSN, String email, String phoneNumber) {
        super(username, password);
        this.name = name;
        this.surname = surname;
        this.DOB = DOB;
        this.SSN = SSN;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Create a new booking (Placeholder implementation)
    public void newBooking() {
        System.out.println("Creating a new booking for the client: " + this.name + " " + this.surname);
        // Logic for creating a new booking goes here
    }

    // Update an existing booking (Placeholder implementation)
    public void updateBooking() {
        System.out.println("Updating an existing booking for the client: " + this.name + " " + this.surname);
        // Logic for updating a booking goes here
    }

    // Delete a booking (Placeholder implementation)
    public void deleteBooking() {
        System.out.println("Deleting a booking for the client: " + this.name + " " + this.surname);
        // Logic for deleting a booking goes here
    }

    // View booked flights or bookings (Placeholder implementation)
    public void viewBooked() {
        System.out.println("Viewing all booked flights for the client: " + this.name + " " + this.surname);
        // Logic for viewing booked flights goes here
    }

    // Report lost luggage (Placeholder implementation)
    public void reportLostLuggage() {
        System.out.println("Reported lost luggage for the client: " + this.name + " " + this.surname);
        // Logic for reporting lost luggage goes here
    }

    // Additional optional methods (e.g., getters and setters)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
