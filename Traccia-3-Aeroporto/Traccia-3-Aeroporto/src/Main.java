import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Flight Management System");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Welcome to Flight Management System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Tabbed Pane for User, Client, and Admin
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add each section (User, Client, Admin) with their respective GUIs
        tabbedPane.addTab("User", createUserPanel());
        tabbedPane.addTab("Client", createClientPanel());
        tabbedPane.addTab("Admin", createAdminPanel());

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Create GUI Panel for User
    private static JPanel createUserPanel() {
        JPanel userPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        userPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton resetUsernameButton = new JButton("Reset Username");
        JButton resetPasswordButton = new JButton("Reset Password");
        JButton deleteUserButton = new JButton("Delete User");

        userPanel.add(usernameLabel);
        userPanel.add(usernameField);
        userPanel.add(passwordLabel);
        userPanel.add(passwordField);
        userPanel.add(resetUsernameButton);
        userPanel.add(resetPasswordButton);
        userPanel.add(deleteUserButton);

        // Add button functionality (logic for User actions)
        resetUsernameButton.addActionListener(e -> JOptionPane.showMessageDialog(userPanel,
                "Username reset to default: guest."));
        resetPasswordButton.addActionListener(e -> JOptionPane.showMessageDialog(userPanel,
                "Password reset successfully."));
        deleteUserButton.addActionListener(e -> JOptionPane.showMessageDialog(userPanel,
                "User deleted successfully."));

        return userPanel;
    }

    // Create GUI Panel for Client
    private static JPanel createClientPanel() {
        JPanel clientPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        clientPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton newBookingButton = new JButton("New Booking");
        JButton updateBookingButton = new JButton("Update Booking");
        JButton deleteBookingButton = new JButton("Delete Booking");
        JButton viewBookedButton = new JButton("View Bookings");
        JButton reportLostLuggageButton = new JButton("Report Lost Luggage");

        clientPanel.add(newBookingButton);
        clientPanel.add(updateBookingButton);
        clientPanel.add(deleteBookingButton);
        clientPanel.add(viewBookedButton);
        clientPanel.add(reportLostLuggageButton);

        // Add button functionality (logic for Client actions)
        newBookingButton.addActionListener(e -> JOptionPane.showMessageDialog(clientPanel,
                "New booking created successfully."));
        updateBookingButton.addActionListener(e -> JOptionPane.showMessageDialog(clientPanel,
                "Booking updated successfully."));
        deleteBookingButton.addActionListener(e -> JOptionPane.showMessageDialog(clientPanel,
                "Booking deleted successfully."));
        viewBookedButton.addActionListener(e -> JOptionPane.showMessageDialog(clientPanel,
                "Displaying all booked flights..."));
        reportLostLuggageButton.addActionListener(e -> JOptionPane.showMessageDialog(clientPanel,
                "Lost luggage reported successfully."));

        return clientPanel;
    }

    // Create GUI Panel for Admin
    private static JPanel createAdminPanel() {
        JPanel adminPanel = new JPanel(new GridLayout(7, 1, 10, 10));
        adminPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton insertFlightButton = new JButton("Insert Flight");
        JButton updateFlightButton = new JButton("Update Flight");
        JButton deleteFlightButton = new JButton("Delete Flight");
        JButton updateGateButton = new JButton("Update Gate");
        JButton updateLuggageButton = new JButton("Update Luggage");
        JButton viewLostButton = new JButton("View Lost Luggage");
        JButton updateLostButton = new JButton("Update Lost Luggage");

        adminPanel.add(insertFlightButton);
        adminPanel.add(updateFlightButton);
        adminPanel.add(deleteFlightButton);
        adminPanel.add(updateGateButton);
        adminPanel.add(updateLuggageButton);
        adminPanel.add(viewLostButton);
        adminPanel.add(updateLostButton);

        // Add button functionality (logic for Admin actions)
        insertFlightButton.addActionListener(e -> JOptionPane.showMessageDialog(adminPanel,
                "Flight inserted successfully."));
        updateFlightButton.addActionListener(e -> JOptionPane.showMessageDialog(adminPanel,
                "Flight details updated successfully."));
        deleteFlightButton.addActionListener(e -> JOptionPane.showMessageDialog(adminPanel,
                "Flight deleted successfully."));
        updateGateButton.addActionListener(e -> JOptionPane.showMessageDialog(adminPanel,
                "Gate information updated successfully."));
        updateLuggageButton.addActionListener(e -> JOptionPane.showMessageDialog(adminPanel,
                "Luggage details updated successfully."));
        viewLostButton.addActionListener(e -> JOptionPane.showMessageDialog(adminPanel,
                "Displaying all lost luggage..."));
        updateLostButton.addActionListener(e -> JOptionPane.showMessageDialog(adminPanel,
                "Lost luggage details updated successfully."));

        return adminPanel;
    }


}