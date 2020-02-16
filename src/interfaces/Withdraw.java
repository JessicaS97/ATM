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
public class Withdraw extends javax.swing.JFrame {
    
    final JDialog dialog = new JDialog();
    int balance, id;
    Connect conn = new Connect();
    PreparedStatement st;
    ResultSet rs;

    /**
     * Creates new form Withdraw
     * @param card_number
     */
    public Withdraw(int user_id) {
        initComponents();
        this.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);   
        id = user_id;
    }
    
    private int getBalance(int id) {
        int balance = -1000;
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
            } 
        } catch(SQLException e) {
            System.err.print("There was an error" + e);
        }
        return balance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_withdraw = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Withdraw Money");

        jLabel2.setText("Amount $");

        t_withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_withdrawActionPerformed(evt);
            }
        });

        jButton1.setText("WITHDRAW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(82, 82, 82)
                                .addComponent(t_withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(t_withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_withdrawActionPerformed
        
    }//GEN-LAST:event_t_withdrawActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (t_withdraw.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(dialog, "Please Enter Amount to Withdraw");
        } else {
            int withdraw_money = Integer.parseInt(t_withdraw.getText());
            int balance = getBalance(id);
            if (balance - withdraw_money > -10) {
                balance -= withdraw_money;
                
                // Update balance
                String sql = "UPDATE accounts A, mappings B, users C "
                            + "SET balance = ? "
                            + "WHERE A.account_id = B.account_id "
                            + "AND B.user_id = C.user_id "
                            + "AND C.user_id = ?;";
                try {
                    st = conn.getConnection().prepareStatement(sql);
                    st.setInt(1, balance);
                    st.setInt(2, id);
                    st.executeUpdate();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "Successful Withdrawal");
                } catch (SQLException e) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                JOptionPane.showMessageDialog(dialog, "Not Enough Money in Account to Withdraw");
            }
        this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdraw(int id).setVisible(true);
            }
        }); */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField t_withdraw;
    // End of variables declaration//GEN-END:variables
}
