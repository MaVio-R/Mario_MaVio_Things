package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * The type Table loader.
 */
public class TableLoader {

    /**
     * Load data.
     *
     * @param table       the table
     * @param query       the query
     * @param columnCount the column count
     * @param params      the params
     */
    public static void loadData(JTable table, String query, int columnCount, Object... params) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1); // Indici 1-based
                    }
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento dei dati: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * Load bookings for current user.
     *
     * @param table the table
     */
    public static void loadBookingsForCurrentUser(JTable table) {
        int currentUserId = AeroportoNapoli.LoggedUser.getUserId();

        String query = """
    SELECT 
        b.booking_number AS 'BOOK COD',
        b.first_name AS 'NOME',
        f.flight_number AS 'FLIGHT COD',
        b.booking_status AS 'STATUS',
        b.seat_number AS 'SEAT NUM'
    FROM 
        booking b
    JOIN 
        flight f ON b.flight_id = f.id
    WHERE 
        b.user_id = ?
    """;

        loadData(table, query, 5, currentUserId);
    }

    /**
     * Load bookings by name.
     *
     * @param table the table
     * @param name  the name
     */
    public static void loadBookingsByName(JTable table, String name) {
        int currentUserId = AeroportoNapoli.LoggedUser.getUserId();

        String query = """
    SELECT 
        b.booking_number AS 'BOOK COD',
        b.first_name AS 'NOME',
        f.flight_number AS 'FLIGHT COD',
        b.booking_status AS 'STATUS',
        b.seat_number AS 'SEAT NUM'
    FROM 
        booking b
    JOIN 
        flight f ON b.flight_id = f.id
    WHERE 
        b.user_id = ? AND b.first_name LIKE ?
    """;

        String nameFilter = "%" + name.trim() + "%";
        loadData(table, query, 5, currentUserId, nameFilter);
    }
}