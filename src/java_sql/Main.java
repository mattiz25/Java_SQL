package java_sql;

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;

public class Main extends javax.swing.JFrame {

    int but1count = 0;
    static String username;
    static String password;
    static String url = "jdbc:derby://localhost:1527/GoogleData";
    public static String ActualPermission = "standardowe ustawienia nie zmienione PERMITION";
    public static String ActualUser = "standardowe ustawienia nie zmienione USER";

    final void AdminNamesList() {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/GoogleData", "admin3", "admin3");
            Statement stmt = con.createStatement();

            String Query = "SELECT * FROM ADMINS";
            ResultSet rs = stmt.executeQuery(Query);

            DefaultListModel DLM = new DefaultListModel();

            while (rs.next()) {
                DLM.addElement(rs.getString(1));

            }

            AdminList.setModel(DLM);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    final void AdminPermissionsList(String NAME) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/GoogleData", "admin3", "admin3");
            Statement stmt = con.createStatement();

            String Query = "SELECT * FROM ADMINS WHERE NAME = '" + NAME + "'";
            ResultSet rs = stmt.executeQuery(Query);
            DefaultListModel DLM = new DefaultListModel();

            while (rs.next()) {
                DLM.addElement("Permission number. " + rs.getString(2));
                ActualPermission = "2";
            }

            AdminList.setModel(DLM);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        AdminNamesList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddBtt = new javax.swing.JButton();
        SrcBtt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AdminList = new javax.swing.JList<>();
        passPassword = new javax.swing.JPasswordField();
        butLogon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddBtt.setText("Dodaj Pracownika");
        AddBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBttActionPerformed(evt);
            }
        });

        SrcBtt.setText("Wyszukaj Pracownika");
        SrcBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SrcBttActionPerformed(evt);
            }
        });

        AdminList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                AdminListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(AdminList);

        passPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passPasswordKeyPressed(evt);
            }
        });

        butLogon.setText("Zaloguj");
        butLogon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(AddBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SrcBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(passPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butLogon)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(passPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(butLogon)
                        .addGap(88, 88, 88)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SrcBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBttActionPerformed

        //      AddEmplyee ad = new AddEmplyee();
        //      AddEmplyee ds = new AddEmplyee();
        Programx pr = new Programx();

        // pr.setVisible(true);
    }//GEN-LAST:event_AddBttActionPerformed

    private void SrcBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SrcBttActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, username + " dupa " + password);

        //    Search se = new Search();
        Programx pr = new Programx();

//se.setVisible(true);
    }//GEN-LAST:event_SrcBttActionPerformed

    private void AdminListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AdminListValueChanged
        passPassword.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminListValueChanged

    private void butLogonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogonActionPerformed

        if (but1count == 0) {
            if (AdminList.getSelectedValue() != null) {
                username = AdminList.getSelectedValue();
                password = passPassword.getText();
                passPassword.setVisible(false);
                butLogon.setText("Wyloguj");
                but1count = 1;
                JOptionPane.showMessageDialog(null, "Gratulacje, udało ci się zalogować do Bazy Danych!");
                AdminPermissionsList(AdminList.getSelectedValue());
                ActualUser = username;

                Program ds = new Program();
                setVisible(false);

                if (ActualPermission != "1") {
                    SrcBtt.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Choose Specyfic Admin from List");
            }
        } else {
            SrcBtt.setVisible(true);
            username = null;
            password = null;
            AdminNamesList();
            butLogon.setText("LOGON");
            but1count = 0;
            JOptionPane.showMessageDialog(null, "You Logged Out from DataBase Server");

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_butLogonActionPerformed

    private void passPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butLogon.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_passPasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtt;
    private javax.swing.JList<String> AdminList;
    private javax.swing.JButton SrcBtt;
    private javax.swing.JButton butLogon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField passPassword;
    // End of variables declaration//GEN-END:variables
}
