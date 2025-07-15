package Gui.client;

import controller.*;
import javax.swing.*;
import controller.Controller;
import model.BookingStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ClientProfile extends BasePanel implements Resettable{

    public ClientProfile(JPanel container,PanelController panelController) {
        super(container, panelController);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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
        jPanel16 = new javax.swing.JPanel();
        BookCode = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        BookCodeSearchButton = new javax.swing.JButton();
        CancelBookCodeSearch = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
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

        jButton1.setBackground(new java.awt.Color(224, 230, 237));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Esci");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(224, 230, 237));
        jLabel1.setText("AEROPORTO DI NAPOLI");

        jButton2.setBackground(new java.awt.Color(224, 230, 237));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        SaveChangesButton.addActionListener(this::SaveChangesButtonActionPerformed);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BookCode, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BookCode, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(224, 230, 237));
        jLabel24.setText("Digitando il nome si potranno avere tutti i biglietti sotto il medesimo");

        BookCodeSearchButton.setForeground(new java.awt.Color(0, 0, 0));
        BookCodeSearchButton.setText("CERCA");
        BookCodeSearchButton.addActionListener(this::BookCodeSearchButtonActionPerformed);

        CancelBookCodeSearch.setForeground(new java.awt.Color(0, 0, 0));
        CancelBookCodeSearch.setText("ANNULLA RICERCA");
        CancelBookCodeSearch.addActionListener(this::CancelBookCodeSearchActionPerformed);

        jLabel25.setForeground(new java.awt.Color(224, 230, 237));
        jLabel25.setText("COD BIGLIETTO");

        edit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        edit.setForeground(new java.awt.Color(224, 230, 237));
        edit.setText("Modifica");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(224, 230, 237));
        jLabel26.setText("Digitando il codice biglietto si potrà modificare il proprietario del biglietto");

        CancelNameSearch.setForeground(new java.awt.Color(0, 0, 0));
        CancelNameSearch.setText("ANNULLA RICERCA");
        CancelNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelNameSearchActionPerformed(evt);
            }
        });

        NameSearchButton.setForeground(new java.awt.Color(0, 0, 0));
        NameSearchButton.setText("CERCA");
        NameSearchButton.addActionListener(this::NameSearchButtonActionPerformed);

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
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CancelBookCodeSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BookCodeSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
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
                        .addGap(81, 81, 81))))
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
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(BookCodeSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelBookCodeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BOOK COD", "NOME", "FLIGHT COD", "STATUS", "SEAT NUM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
        CheckInButton.addActionListener(this::CheckInButtonActionPerformed);

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

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panelController.showPanel("main");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        panelController.showPanel("homepageclient");
    }      //GEN-LAST:event_jButton2ActionPerformed

    private void NameSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Ottieni il nome dal campo di testo
        String firstName = FirstName.getText().trim();

        // Verifica che il campo non sia vuoto
        if (firstName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inserisci un nome per effettuare la ricerca.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Carica i dati delle prenotazioni basati sul nome
        loadBookingsByName(firstName);
    }

    private void CancelNameSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // Svuota il campo di testo del nome
        FirstName.setText("");

        // Ripristina i dati originali nella tabella
        loadUserBookings();
    }

    @Override
    public void resetPanel() {
        loadUserBookings();
    }

    // Metodo per caricare le prenotazioni dell'utente
    private void loadUserBookings() {
        int userId = AeroportoNapoli.LoggedUser.getUserId(); // Ottieni l'ID dell'utente loggato
        String query = "SELECT booking_number, first_name, flight_id, booking_status, seat_number "
                     + "FROM booking WHERE user_id = ?";

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Pulisce la tabella

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, userId); // Imposta l'ID dell'utente nella query
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // Aggiunge ogni risultato alla tabella
                model.addRow(new Object[]{
                    rs.getInt("booking_number"),
                    rs.getString("first_name"),
                    rs.getInt("flight_id"),
                    rs.getString("booking_status"),
                    rs.getString("seat_number")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante il caricamento delle prenotazioni: " + e.getMessage(),
                                          "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodo per caricare le prenotazioni in base al nome
    private void loadBookingsByName(String firstName) {
        int userId = AeroportoNapoli.LoggedUser.getUserId(); // Ottieni l'ID dell'utente loggato
        String query = "SELECT booking_number, first_name, flight_id, booking_status, seat_number "
                     + "FROM booking WHERE user_id = ? AND first_name = ?";

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Pulisce la tabella

        try (Connection con = Controller.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, userId); // Imposta l'ID utente
            pst.setString(2, firstName); // Imposta il nome utente
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // Aggiunge ogni risultato alla tabella
                model.addRow(new Object[]{
                    rs.getInt("booking_number"),
                    rs.getString("first_name"),
                    rs.getInt("flight_id"),
                    rs.getString("booking_status"),
                    rs.getString("seat_number")
                });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nessuna prenotazione trovata per il nome specificato.", "Informazione", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante la ricerca: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void BookCodeSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Ottieni la riga selezionata dalla tabella
        int selectedRow = jTable1.getSelectedRow();

        // Controlla se è stata selezionata una riga
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una riga dalla tabella.", "Errore", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Recupera il codice prenotazione dalla colonna corretta (colonna 0 nell'esempio)
        Object bookingCodeObj = jTable1.getValueAt(selectedRow, 0);
        if (bookingCodeObj == null) {
            JOptionPane.showMessageDialog(this, "Codice prenotazione non valido.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String bookCode = bookingCodeObj.toString().trim();

        // Query per cercare nella tabella booking
        String query = "SELECT first_name, last_name FROM booking WHERE booking_number = ?";

        try (Connection con = Controller.getConnection(); // Ottieni connessione al database
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta il codice come parametro nella query
            pst.setString(1, bookCode);

            // Esegui la query
            ResultSet rs = pst.executeQuery();

            // Se è trovata una prenotazione
            if (rs.next()) {
                // Recupera nome e cognome
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // Imposta i valori nei campi di testo (o usali come preferisci)
                FirstNameChanged.setText(firstName);  // Aggiorna campo FirstNameChanged
                LastNameChanged.setText(lastName);    // Aggiorna campo LastNameChanged

            } else {
                // Mostra messaggio se il codice non corrisponde a nessuna prenotazione
                JOptionPane.showMessageDialog(this, "Prenotazione non trovata per il codice selezionato.", "Informazione", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            // Gestione degli errori SQL durante l'esecuzione della query
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante la ricerca: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Ottieni i valori dai campi di input
        String newFirstName = FirstNameChanged.getText().trim();
        String newLastName = LastNameChanged.getText().trim();
        String bookingCode = BookCode.getText().trim();

        // Controlla che i campi non siano vuoti
        if (newFirstName.isEmpty() || newLastName.isEmpty() || bookingCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Assicurarsi che tutti i campi siano compilati.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Query per aggiornare i dati della prenotazione
        String query = "UPDATE booking SET first_name = ?, last_name = ? WHERE booking_number = ?";

        try (Connection con = Controller.getConnection(); // Ottieni connessione al database
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta i valori nella query
            pst.setString(1, newFirstName);
            pst.setString(2, newLastName);
            pst.setString(3, bookingCode);

            // Esegui l'aggiornamento
            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                // Mostra messaggio di successo
                JOptionPane.showMessageDialog(this, "Dati aggiornati con successo!", "Successo", JOptionPane.INFORMATION_MESSAGE);
                resetPanel(); // Aggiorna la tabella
            } else {
                // Mostra messaggio se il codice non corrisponde a nessuna prenotazione
                JOptionPane.showMessageDialog(this, "Nessuna prenotazione trovata per il codice inserito.", "Errore", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Gestione degli errori durante l'esecuzione della query
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante l'aggiornamento: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
    //GODO/////////////////////////////////////////////////////
    private void CheckInButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Ottieni la riga selezionata nella tabella
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una prenotazione dalla tabella.", "Errore", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Recupera il codice della prenotazione dalla tabella
        Object bookingCodeObj = jTable1.getValueAt(selectedRow, 0); // Codice della prenotazione nella colonna 0
        if (bookingCodeObj == null) {
            JOptionPane.showMessageDialog(this, "Codice prenotazione non valido.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String bookingCode = bookingCodeObj.toString();

        // Recupera lo stato attuale
        Object currentStatusObj = jTable1.getValueAt(selectedRow, 3); // Colonna 3: stato della prenotazione
        if (currentStatusObj == null || !currentStatusObj.toString().equalsIgnoreCase(BookingStatus.PENDING.name())) {
            JOptionPane.showMessageDialog(this, "Solo le prenotazioni in stato 'PENDING' possono essere aggiornate a 'CONFIRMED'.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Query per aggiornare lo stato
        String query = "UPDATE booking SET booking_status = ? WHERE booking_number = ?";

        try (Connection con = Controller.getConnection(); // Ottieni connessione al database
             PreparedStatement pst = con.prepareStatement(query)) {

            // Imposta i parametri della query
            pst.setString(1, BookingStatus.CONFIRMED.name()); // Usa l'enum per il nuovo stato
            pst.setString(2, bookingCode);

            // Esegui l'aggiornamento
            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Check-in completato con successo! La prenotazione è ora 'CONFIRMED'.", "Successo", JOptionPane.INFORMATION_MESSAGE);
                resetPanel(); // Aggiorna i dati nella tabella
            } else {
                JOptionPane.showMessageDialog(this, "Errore durante l'aggiornamento. Prenotazione non trovata.", "Errore", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Gestione errori SQL
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante il check-in: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

private void CancelBookCodeSearchActionPerformed(java.awt.event.ActionEvent evt) {
    // Svuota i campi di input
    BookCode.setText("");
    FirstNameChanged.setText("");
    LastNameChanged.setText("");

    // Ripristina i dati originali nella tabella
    resetPanel();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookCode;
    private javax.swing.JButton BookCodeSearchButton;
    private javax.swing.JButton CancelBookCodeSearch;
    private javax.swing.JButton CancelNameSearch;
    private javax.swing.JButton CheckInButton;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField FirstNameChanged;
    private javax.swing.JTextField LastNameChanged;
    private javax.swing.JButton NameSearchButton;
    private javax.swing.JButton SaveChangesButton;
    private javax.swing.JLabel edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
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
    // End of variables declaration//GEN-END:variables
    }