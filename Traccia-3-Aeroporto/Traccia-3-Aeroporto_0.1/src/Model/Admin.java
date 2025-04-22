package Model;

public class Admin extends User {

    private String opCode;

    public Admin(String username, String password, String opCode) {
        super(username, password);
        this.opCode = opCode;
    }

    // Insert a new flight (Placeholder implementation)
    public void insertFlight() {
        System.out.println("Admin " + this.getUsername() + " is inserting a new flight...");
        // Logic for inserting a new flight goes here
    }

    // Update existing flight details (Placeholder implementation)
    public void updateFlight() {
        System.out.println("Admin " + this.getUsername() + " is updating flight details...");
        // Logic for updating an existing flight goes here
    }

    // Delete a flight (Placeholder implementation)
    public void deleteFlight() {
        System.out.println("Admin " + this.getUsername() + " is deleting a flight...");
        // Logic for deleting a flight goes here
    }

    // Update the gate for a flight (Placeholder implementation)
    public void updateGate() {
        System.out.println("Admin " + this.getUsername() + " is updating the gate information...");
        // Logic for updating the gate details goes here
    }

    // Update lost luggage status (Placeholder implementation)
    public void updateLuggage() {
        System.out.println("Admin " + this.getUsername() + " is updating luggage information...");
        // Logic for updating luggage details goes here
    }

    // View lost luggage information (Placeholder implementation)
    public void viewLost() {
        System.out.println("Admin " + this.getUsername() + " is viewing all lost luggage...");
        // Logic for viewing lost luggage goes here
    }

    // Update information about lost luggage (Placeholder implementation)
    public void updateLost() {
        System.out.println("Admin " + this.getUsername() + " is updating lost luggage details...");
        // Logic for updating lost luggage status or details goes here
    }

    // Optional getter and setter for opCode
    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

}
