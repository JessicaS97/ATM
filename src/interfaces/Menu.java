/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import atm.simulator.system.classes.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author jessi
 */
public class Menu extends javax.swing.JFrame {
    
    final JDialog dialog = new JDialog();
    Connect conn = new Connect();
    PreparedStatement st;
    ResultSet rs;
    Login login = new Login();
    
    String name, last_name, card_number;
    int id, balance, pin_code;
    /**
     * Creates new form Menu
     * @param user_card_number
     */
    public Menu(String user_card_number) {
        initComponents();
        this.setLocationRelativeTo(null);
        setDetails(user_card_number);
    }
    
    private void setDetails(String user_card_number) {
        String sql = "SELECT * FROM users WHERE user_card_number = ?";
        try {
            st = conn.getConnection().prepareStatement(sql);
            st.setString(1, user_card_number);
            rs = st.executeQuery();
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("user_id"));
                name = rs.getString("user_name");
                last_name = rs.getString("user_lastname");
                pin_code = Integer.parseInt(rs.getString("user_pin_code"));
                card_number = rs.getString("user_card_number");
            }
            
            dialog.setAlwaysOnTop(true);    
            JOptionPane.showMessageDialog(dialog, "Hi, " + name + " " + last_name);
        } catch(SQLException e) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void getBalance(String card_number) {
        try {
            String sql = "SELECT * FROM accounts A, mappings B, users C "
                        + "WHERE A.account_id = B.account_id "
                        + "AND B.user_id = C.user_id "
                        + "AND C.user_id = ?";
            st = conn.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            
            if (rs.next()) {
                balance = rs.getInt("balance");
                dialog.setAlwaysOnTop(true);    
                JOptionPane.showMessageDialog(dialog, "Account balance: " + balance);
            } 
        } catch(SQLException e) {
            System.err.print("There was an error" + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        b_transfer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        b_deposit = new javax.swing.JButton();
        b_balance = new javax.swing.JButton();
        b_withdraw = new javax.swing.JButton();
        b_exit = new javax.swing.JButton();
        b_change_pin = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_transfer.setText("TRANSFER");
        b_transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_transferActionPerformed(evt);
            }
        });

        jLabel1.setText("SELLECT A TRANSACTION");

        b_deposit.setText("DEPOSIT");

        b_balance.setText("VIEW BALANCE");
        b_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_balanceActionPerformed(evt);
            }
        });

        b_withdraw.setText("WITHDRAW");

        b_exit.setText("EXIT");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });

        b_change_pin.setText("CHANGE PIN");
        b_change_pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_change_pinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_change_pin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_deposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(b_balance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_exit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_withdraw, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_transfer)
                    .addComponent(b_balance))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_deposit)
                    .addComponent(b_withdraw))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_exit)
                    .addComponent(b_change_pin))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_transferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_transferActionPerformed

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_exitActionPerformed

    private void b_change_pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_change_pinActionPerformed
        new ChangePin(card_number, pin_code).setVisible(true);
    }//GEN-LAST:event_b_change_pinActionPerformed

    private void b_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_balanceActionPerformed
        getBalance(card_number);
    }//GEN-LAST:event_b_balanceActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        }); */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_balance;
    private javax.swing.JButton b_change_pin;
    private javax.swing.JButton b_deposit;
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_transfer;
    private javax.swing.JButton b_withdraw;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
