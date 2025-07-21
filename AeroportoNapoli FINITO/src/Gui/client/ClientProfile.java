package Gui.client;

import controller.*;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

/**
 * The type Client profile.
 */
public class ClientProfile extends BasePanel implements Resettable{

    private String savedBookingCode;

    /**
     * Instantiates a new Client profile.
     *
     * @param container       the container
     * @param panelController the panel controller
     */
    public ClientProfile(JPanel container,PanelController panelController) {
        super(container, panelController);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LogoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        HomeButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        FirstNameChanged = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        LastNameChanged = new javax.swing.JTextField();
        SaveChangesButton = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        BookCodeSearchButton = new javax.swing.JButton();
        CancelBookCodeSearch = new javax.swing.JButton();
        edit = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        CancelNameSearch = new javax.swing.JButton();
        NameSearchButton = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        FirstName = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CheckInButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(51, 76, 105));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jPanel2.setBackground(new java.awt.Color(30, 40, 69));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 70));

        LogoutButton.setBackground(new java.awt.Color(224, 230, 237));
        LogoutButton.setForeground(new java.awt.Color(0, 0, 0));
        LogoutButton.setText("Esci");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(224, 230, 237));
        jLabel1.setText("AEROPORTO DI NAPOLI");

        HomeButton.setBackground(new java.awt.Color(224, 230, 237));
        HomeButton.setForeground(new java.awt.Color(0, 0, 0));
        HomeButton.setText("Home");
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(46, 67, 96));

        jPanel8.setBackground(new java.awt.Color(40, 58, 87));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(224, 230, 237));
        jLabel2.setText(" AREA PERSONALE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel3.setForeground(new java.awt.Color(224, 230, 237));
        jLabel3.setText("NOME");

        jLabel4.setForeground(new java.awt.Color(224, 230, 237));
        jLabel4.setText("COGNOME");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FirstNameChanged, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FirstNameChanged, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LastNameChanged, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LastNameChanged, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        SaveChangesButton.setForeground(new java.awt.Color(0, 0, 0));
        SaveChangesButton.setText("SALVA MODIFICA");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(224, 230, 237));
        jLabel24.setText("Digiti il nominativo dei biglietti da visualizzare");

        BookCodeSearchButton.setForeground(new java.awt.Color(0, 0, 0));
        BookCodeSearchButton.setText("CERCA");

        CancelBookCodeSearch.setForeground(new java.awt.Color(0, 0, 0));
        CancelBookCodeSearch.setText("ANNULLA RICERCA");

        edit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        edit.setForeground(new java.awt.Color(224, 230, 237));
        edit.setText("Modifica");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(224, 230, 237));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Selezioni sulla tabella la riga del biglietto da modificare o confermare");

        CancelNameSearch.setForeground(new java.awt.Color(0, 0, 0));
        CancelNameSearch.setText("ANNULLA RICERCA");

        NameSearchButton.setForeground(new java.awt.Color(0, 0, 0));
        NameSearchButton.setText("CERCA");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel27.setForeground(new java.awt.Color(224, 230, 237));
        jLabel27.setText("NOME PASSEGGERO");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(SaveChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CancelNameSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BookCodeSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelBookCodeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookCodeSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBookCodeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addComponent(SaveChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(46, 67, 96));

        jPanel9.setBackground(new java.awt.Color(40, 58, 87));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(224, 230, 237));
        jLabel14.setText(" LE TUE PRENOTAZIONI");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jTable1.setModel(new DefaultTableModel(
                new Object [][] {}, // La tabella parte vuota
                new String [] {      // Intestazioni di colonna
                        "BOOK COD", "NOME", "FLIGHT COD", "STATUS", "SEAT NUM"
                }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false, false };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        CheckInButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        CheckInButton.setForeground(new java.awt.Color(0, 0, 0));
        CheckInButton.setText("CHECK IN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(CheckInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
            // ... (altri componenti inizializzati)

            LogoutButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LogoutButtonActionPerformed(evt);
                }
            });

            HomeButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    HomeButtonActionPerformed(evt);
                }
            });

            NameSearchButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    NameSearchButtonActionPerformed(evt);
                }
            });

            CancelNameSearch.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CancelNameSearchActionPerformed(evt);
                }
            });

            BookCodeSearchButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BookCodeSearchButtonActionPerformed(evt);
                }
            });

            CancelBookCodeSearch.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CancelBookCodeSearchActionPerformed(evt);
                }
            });

            SaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SaveChangesButtonActionPerformed(evt);
                }
            });

            CheckInButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CheckInButtonActionPerformed(evt);
                }
            });

            // ... (restanti inizializzazioni)
        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        panelController.showPanel("main");
    }

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        panelController.showPanel("homepageclient");
    }

    private void NameSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameSearchButtonActionPerformed
        // Recupera il testo dalla casella "FirstName"
        String name = FirstName.getText().trim();

        // Controlla che il nome non sia vuoto
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Per favore, inserisci un nome nel campo di ricerca.",
                    "Campo vuoto", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Utilizza il metodo del controller per caricare i risultati nella tabella
        Controller.loadBookingsByName(jTable1, name);

        // Messaggio di feedback (opzionale)
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Nessuna prenotazione trovata per il nome \"" + name + "\".",
                    "Risultato della ricerca", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void CancelNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelNameSearchActionPerformed
        // Riporta la tabella al suo stato originale caricando tutte le prenotazioni dell'utente loggato
        Controller.loadBookingsForCurrentUser(jTable1);

        // Svuota il campo di testo FirstName
        FirstName.setText("");

    }

    private void BookCodeSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookCodeSearchButtonActionPerformed
        // Ottenere il modello della tabella
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Controllare se è stata selezionata una riga
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            // Mostra un messaggio di errore se nessuna riga è selezionata
            JOptionPane.showMessageDialog(this,
                    "Selezionare una prenotazione dalla tabella.",
                    "Errore", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Recupera il valore del numero di prenotazione dalla colonna "BOOK COD" (assumendo che sia nella prima colonna)
        String bookingNumberStr = model.getValueAt(selectedRow, 0).toString();

        try {
            int bookingNumber = Integer.parseInt(bookingNumberStr); // Converte l'input in un numero
            savedBookingCode = bookingNumberStr; // Salva il codice localmente

            // Chiamata al Controller per recuperare i dettagli della prenotazione
            String[] bookingDetails = Controller.getBookingDetailsByNumber(bookingNumber);

            if (bookingDetails != null) {
                // Imposta i valori delle caselle di testo
                FirstNameChanged.setText(bookingDetails[0]); // Nome
                LastNameChanged.setText(bookingDetails[1]);  // Cognome
                // Messaggio di feedback opzionale
                JOptionPane.showMessageDialog(this,
                        "Prenotazione selezionata: " + bookingNumber,
                        "Successo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Errore: il numero di prenotazione deve essere un numero valido.",
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CancelBookCodeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // Svuota i campi FirstNameChanged e LastNameChanged
        FirstNameChanged.setText("");
        LastNameChanged.setText("");

        // Svuota il valore di savedbookingcode
        this.savedBookingCode = "";
    }

    private void SaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveChangesButtonActionPerformed
        if (savedBookingCode == null) {
            JOptionPane.showMessageDialog(this,
                    "Nessuna prenotazione selezionata. Eseguire la ricerca e selezionare una prenotazione prima di salvare.",
                    "Errore", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Recupera il numero della prenotazione salvato localmente
            int bookingNumber = Integer.parseInt(savedBookingCode);

            // Recupera i dati modificati dalle caselle di testo
            String updatedFirstName = FirstNameChanged.getText().trim();
            String updatedLastName = LastNameChanged.getText().trim();

            // Controlla se i campi sono vuoti
            if (updatedFirstName.isEmpty() || updatedLastName.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "I campi Nome e Cognome non possono essere vuoti.",
                        "Errore di validazione", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Verifica se ci sono modifiche effettive
            String[] currentDetails = Controller.getBookingDetailsByNumber(bookingNumber);
            if (currentDetails != null &&
                    updatedFirstName.equals(currentDetails[0]) &&
                    updatedLastName.equals(currentDetails[1])) {
                JOptionPane.showMessageDialog(this,
                        "Non ci sono modifiche da salvare.",
                        "Messaggio", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Effettua l'update nel database
            boolean success = Controller.updateBookingDetails(bookingNumber, updatedFirstName, updatedLastName);

            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Modifiche salvate con successo!",
                        "Successo", JOptionPane.INFORMATION_MESSAGE);

                // Aggiorna la tabella con i dati aggiornati
                Controller.loadBookingsForCurrentUser(jTable1);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Errore durante il salvataggio delle modifiche.",
                        "Errore", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Errore: il numero di prenotazione salvato non è valido.",
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CheckInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInButtonActionPerformed
        try {
            // Controlla che savedBookingCode non sia null o vuoto
            if (savedBookingCode != null && !savedBookingCode.isEmpty()) {
                // Converte savedBookingCode in int
                int bookingNumber;
                try {
                    bookingNumber = Integer.parseInt(savedBookingCode);
                } catch (NumberFormatException ex) {
                    // Gestisce errori nella conversione
                    JOptionPane.showMessageDialog(this,
                            "Il codice della prenotazione non è valido.",
                            "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Chiama il metodo del controller per aggiornare lo stato
                boolean isUpdated = Controller.updateBookingStatus(bookingNumber, "CONFIRMED");

                if (isUpdated) {
                    // Conferma l'aggiornamento all'utente
                    Controller.loadBookingsForCurrentUser(jTable1);

                    JOptionPane.showMessageDialog(this,
                            "Stato della prenotazione aggiornato a 'CONFIRMED' con successo!",
                            "Successo", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    // Mostra un errore in caso di fallimento
                    JOptionPane.showMessageDialog(this,
                            "Errore durante l'aggiornamento dello stato della prenotazione.",
                            "Errore", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Mostra un avviso se il codice non è stato salvato
                JOptionPane.showMessageDialog(this,
                        "Errore: nessun codice di prenotazione trovato.",
                        "Errore", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            // Gestisce errori generici
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Si è verificato un errore: " + ex.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CheckInButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookCodeSearchButton;
    private javax.swing.JButton CancelBookCodeSearch;
    private javax.swing.JButton CancelNameSearch;
    private javax.swing.JButton CheckInButton;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField FirstNameChanged;
    private javax.swing.JButton HomeButton;
    private javax.swing.JTextField LastNameChanged;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton NameSearchButton;
    private javax.swing.JButton SaveChangesButton;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;



    @Override
    public void resetPanel() {
        Controller.loadBookingsForCurrentUser(jTable1);
        FirstName.setText("");
        FirstNameChanged.setText("");
        LastNameChanged.setText("");

        savedBookingCode = null;


    }
    // End of variables declaration//GEN-END:variables
    }