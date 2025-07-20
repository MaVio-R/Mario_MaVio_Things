package Model;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Reset the username to a default value or prompt user input (example: "guest").
    public void resetUsername() {
        this.username = "guest"; // Example: resetting to default username
        System.out.println("The username has been reset to the default value.");
    }

    // Reset the password to a default or randomly generated value.
    public void resetPassword() {
        this.password = generateRandomPassword(); // Example: resetting to a random password
        System.out.println("The password has been reset successfully.");
    }

    // Delete user details (set username and password to null or blank).
    public void deleteUser() {
        this.username = null;
        this.password = null;
        System.out.println("The user has been deleted.");
    }

    public void viewFlight() {
        System.out.println("Flight details will be displayed here.");
    }

    // Private helper method to generate a random password (often needed for `resetPassword`).
    private String generateRandomPassword() {

        // For example purposes, generate a simple random password
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) { // Generate an 8-character password
            int randomIndex = (int) (Math.random() * chars.length());
            password.append(chars.charAt(randomIndex));
        }
        return password.toString();
    }

    // Optional: Getter methods are often useful in such classes
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Optional: Setter methods (only allow if you want usernames or passwords to be updated)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
