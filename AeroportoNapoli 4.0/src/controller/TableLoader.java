package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TableLoader {

    /**
     * Metodo generico per caricare dati in una JTable
     */
    public static void loadData(JTable table, String query, int columnCount, Object... params) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Pulisce la tabella

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta i parametri nella query (opzionale)
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

    // === TABELLE GENERALI ===

    /**
     * Carica tutti i dati dei voli per la visualizzazione generale
     */
    public static void loadFlightData(JTable flighttable) {
        String query = "SELECT flight_number, flight_status, departure_airport, arrival_airport, planned_time, delay_time, assigned_gate FROM flight";
        loadData(flighttable, query, 7);
    }

    // === TABELLE ADMIN ===

    /**
     * Carica i dati dei voli per l'aggiornamento da parte dell'admin
     */
    public static void loadFlightDataForAdminUpdate(JTable flighttable) {
        String query = "SELECT flight_number, departure_airport, arrival_airport, flight_status FROM flight";
        loadData(flighttable, query, 4);
    }

    // === TABELLE CLIENT ===

    /**
     * Carica i voli prenotabili (solo quelli con status SCHEDULED)
     */
    public static void loadBookableFlights(JTable bookedtable) {
        String query = "SELECT flight_number, scheduled_date, planned_time, departure_airport, arrival_airport, flight_company FROM flight WHERE flight_status = 'SCHEDULED'";
        loadData(bookedtable, query, 6);
    }

    /**
     * Carica le prenotazioni dell'utente corrente
     */
    public static void loadBookingsForCurrentUser(JTable table) {
        // Recuperiamo l'id dell'utente collegato dall'oggetto AeroportoNapoli.LoggedUser
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

        // Caricare i dati nella tabella
        loadData(table, query, 5, currentUserId);
    }

    /**
     * Carica le prenotazioni dell'utente corrente filtrate per nome
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

    // === METODI DI UTILITÀ ===

    /**
     * Carica dati in una tabella con una query personalizzata
     */
    public static void loadCustomQuery(JTable table, String query, Object... params) {
        // Conta automaticamente le colonne dalla query (metodo semplificato)
        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta i parametri
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = pst.executeQuery()) {
                // Ottieni il numero di colonne dal ResultSet
                int columnCount = rs.getMetaData().getColumnCount();
                loadData(table, query, columnCount, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Errore durante il caricamento dei dati personalizzati: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Svuota una tabella
     */
    public static void clearTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    /**
     * Ricarica una tabella mantenendo la stessa query
     */
    public static void refreshTable(JTable table, String query, int columnCount, Object... params) {
        loadData(table, query, columnCount, params);
    }
}