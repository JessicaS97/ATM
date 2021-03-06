package interfaces;

import atm.simulator.system.classes.Connect;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jessi
 */
public class Register extends javax.swing.JFrame {

    Connect conn;
    PreparedStatement st;
    ResultSet rs;
    final JDialog dialog = new JDialog();
    
    /**
     * Creates new form test
     */
    public Register() {
        initComponents();
        this.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true); 
        groupButton();
        clean();
        block();
    }
    
    void clean() {
        t_name.setText("");
        t_lastname.setText("");
        t_address.setText("");
        t_city.setText("");
        t_email.setText("");
        t_phone.setText("");
        t_pin_code.setText("");
    }
    
    void block() {
        t_name.setEnabled(false);
        t_lastname.setEnabled(false);
        b_female.setEnabled(false);
        b_male.setEnabled(false);
        b_other.setEnabled(false);
        t_city.setEnabled(false);
        t_email.setEnabled(false);
        t_address.setEnabled(false);
        t_pin_code.setEnabled(false);
        t_phone.setEnabled(false);
        jButton3.setEnabled(true);  // only enable NEW button
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
    }
    
    void unblock() {
        t_name.setEnabled(true);
        t_lastname.setEnabled(true);
        b_female.setEnabled(true);
        b_male.setEnabled(true);
        b_other.setEnabled(true);
        t_city.setEnabled(true);
        t_email.setEnabled(true);
        t_address.setEnabled(true);
        t_pin_code.setEnabled(true);
        t_phone.setEnabled(true);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
    }
    
    private void groupButton() {
        ButtonGroup bg1 = new ButtonGroup();
        
        bg1.add(b_female);
        bg1.add(b_male);
        bg1.add(b_other);
    }
    
    private boolean verifyFields() {
        String name = t_name.getText();
        String last_name = t_lastname.getText();
        String address = t_address.getText();
        String city = t_city.getText();
        String phone = t_phone.getText();
        String email = t_email.getText();
        String password = String.valueOf(t_pin_code.getPassword());
        
        if (name.trim().equals("") || last_name.trim().equals("") ||
                    password.trim().equals("") || email.trim().equals("") ||
                    address.trim().equals("") || city.trim().equals("") ||
                    phone.trim().equals("") ||
                    (!b_female.isSelected() && !b_male.isSelected() && !b_other.isSelected())) {
            JOptionPane.showMessageDialog(dialog, "Please Fill All Fields");
            return false;
        }
        
        return true;
    } 
    
    private boolean checkEmail(String email) {
        boolean email_exits = false;
        
        String sql = "SELECT user_email FROM `users` WHERE user_email = ?";
        
        try {
            st = conn.getConnection().prepareStatement(sql);
            st.setString(1, email);
            rs = st.executeQuery();
            
            if (rs.next()) {
                email_exits = true;
                JOptionPane.showMessageDialog(null, "Email has already been registered");
            } 
        } catch(SQLException e) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return email_exits;
    }
    
    private boolean checkCardNumber(String card_number) {
        boolean card_exits = false;
        
        String sql = "SELECT user_name FROM `users` WHERE user_name = ?";
        
        try {
            st = conn.getConnection().prepareStatement(sql);
            st.setString(1, card_number);
            rs = st.executeQuery();
            
            if (rs.next()) {
                card_exits = true;
            } 
        } catch(SQLException e) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return card_exits;
    }
    
    private String generateRandomCardNumber() {
        final long MAX_NUMBER = 9999999999999999L;
        final long MIN_NUMBER = 1000000000000000L;
        Long actual = Long.valueOf(Math.abs(Float.valueOf(new Random().nextFloat() * (MAX_NUMBER - MIN_NUMBER)).longValue()));
        String card_number = String.valueOf(actual);
        while (checkCardNumber(card_number)) {
            actual = Long.valueOf(Math.abs(Float.valueOf(new Random().nextFloat() * (MAX_NUMBER - MIN_NUMBER)).longValue()));
            card_number = String.valueOf(actual);
        }
        return card_number;
    }
    
    private String generateAccountNumber() {
        final long MAX_NUMBER = 999999999L;
        final long MIN_NUMBER = 100000000L;
        Long actual = Long.valueOf(Math.abs(Float.valueOf(new Random().nextFloat() * (MAX_NUMBER - MIN_NUMBER)).longValue()));
        String account_number = String.valueOf(actual);
        while (checkCardNumber(account_number)) {
            actual = Long.valueOf(Math.abs(Float.valueOf(new Random().nextFloat() * (MAX_NUMBER - MIN_NUMBER)).longValue()));
            account_number = String.valueOf(actual);
        }
        return account_number;
    }
    
    private String generateBSB() {
        final long MAX_NUMBER = 99999L;
        final long MIN_NUMBER = 10000L;
        Long actual = Long.valueOf(Math.abs(Float.valueOf(new Random().nextFloat() * (MAX_NUMBER - MIN_NUMBER)).longValue()));
        String BSB = String.valueOf(actual);
        while (checkCardNumber(BSB)) {
            actual = Long.valueOf(Math.abs(Float.valueOf(new Random().nextFloat() * (MAX_NUMBER - MIN_NUMBER)).longValue()));
            BSB = String.valueOf(actual);
        }
        return BSB;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t_name = new javax.swing.JTextField();
        t_lastname = new javax.swing.JTextField();
        t_email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_phone = new javax.swing.JTextField();
        t_address = new javax.swing.JTextField();
        t_city = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        b_female = new javax.swing.JRadioButton();
        b_male = new javax.swing.JRadioButton();
        b_other = new javax.swing.JRadioButton();
        t_pin_code = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        t_name.setText("jTextField1");
        t_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nameActionPerformed(evt);
            }
        });

        t_lastname.setText("jTextField2");
        t_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_lastnameActionPerformed(evt);
            }
        });

        t_email.setText("jTextField4");
        t_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_emailActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Last Name");

        jLabel3.setText("Gender");

        jLabel4.setText("Phone");

        jButton3.setText("NEW");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SAVE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CANCEL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("LOGIN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("REGISTER FORM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jLabel6.setText("Address");

        jLabel7.setText("Pin Code");

        t_phone.setText("jTextField1");
        t_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_phoneActionPerformed(evt);
            }
        });

        t_address.setText("jTextField2");
        t_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_addressActionPerformed(evt);
            }
        });

        t_city.setText("jTextField3");
        t_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cityActionPerformed(evt);
            }
        });

        jLabel8.setText("Email");

        jLabel9.setText("City");

        b_female.setText("Female");
        b_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_femaleActionPerformed(evt);
            }
        });

        b_male.setText("Male");

        b_other.setText("Other");

        t_pin_code.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_phone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(t_address, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_city, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_lastname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_email)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_pin_code, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b_female)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b_male)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b_other)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(46, 46, 46)
                        .addComponent(jButton4)
                        .addGap(62, 62, 62)
                        .addComponent(jButton5)
                        .addGap(49, 49, 49)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(b_female)
                    .addComponent(b_male)
                    .addComponent(b_other))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(t_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(t_pin_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        unblock();
        t_name.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        block();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void t_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nameActionPerformed
        t_name.transferFocus();
    }//GEN-LAST:event_t_nameActionPerformed

    private void t_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_lastnameActionPerformed
        t_lastname.transferFocus();
    }//GEN-LAST:event_t_lastnameActionPerformed

    private void t_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_emailActionPerformed
        t_email.transferFocus();
    }//GEN-LAST:event_t_emailActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        conn = new Connect();
        Connection cn = conn.getConnection();
        String name, lastname, email, address, city, card_number;
        int phone, password, user_id = 0, account_id = 0;
        String user_sql = "INSERT INTO users (user_name, user_lastname, user_gender, "
                    + "user_email, user_phone, user_address, user_city, user_pin_code, user_card_number) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String account_sql = "INSERT INTO accounts (balance, account_no, bsb) VALUES (?, ? ,?)";
        name = t_name.getText();
        lastname = t_lastname.getText();
        email = t_email.getText();
        address = t_address.getText();
        city = t_city.getText();
        phone = Integer.parseInt(t_phone.getText());
        password = Integer.parseInt(String.valueOf(t_pin_code.getPassword()));
        card_number = generateRandomCardNumber();
        
        String gender = "Other";
        if (b_female.isSelected()) {
            gender = "F";
        } else if (b_male.isSelected()) {
            gender = "M";
        } 
        
        if (verifyFields()) {
            if (!checkEmail(email)) {
                try {
                    PreparedStatement user_st = cn.prepareStatement(user_sql, Statement.RETURN_GENERATED_KEYS);
                    
                    user_st.setString(1, name);
                    user_st.setString(2, lastname);
                    user_st.setString(3, gender);
                    user_st.setString(4, email);
                    user_st.setInt(5, phone);
                    user_st.setString(6, address);
                    user_st.setString(7, city);
                    user_st.setInt(8, password);
                    user_st.setString(9, card_number);
                    user_st.executeUpdate();
                    ResultSet addUser = user_st.getGeneratedKeys();
                    
                    if (addUser.next()) {
                        user_id = addUser.getInt(1);
                    }
                    
                    PreparedStatement account_st = cn.prepareStatement(account_sql, Statement.RETURN_GENERATED_KEYS);
                    int bsb = Integer.parseInt(generateBSB());
                    int account_number = Integer.parseInt(generateAccountNumber());
                    account_st.setInt(1, 0);
                    account_st.setInt(2, account_number);
                    account_st.setInt(3, bsb);
                    account_st.executeUpdate();
                    ResultSet addAccount = account_st.getGeneratedKeys();
                    if (addAccount.next()) {
                        account_id = addAccount.getInt(1);
                    }
                    
                    if (user_id != 0 && account_id != 0) {
                        String linkAccount_sql = "INSERT INTO mappings (user_id, account_id)"
                                    + "VALUES (?, ?)";
                        PreparedStatement link_st = cn.prepareStatement(linkAccount_sql);
                        link_st.setInt(1, user_id);
                        link_st.setInt(2, account_id);
                        link_st.executeUpdate();
                        JOptionPane.showMessageDialog(dialog, "Data Saved");
                        JOptionPane.showMessageDialog(dialog, "Card Number: " + card_number + 
                                    "\nAccount Number: " + account_number + "\nBSB: " + bsb);
                        block();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_phoneActionPerformed

    private void t_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_addressActionPerformed

    private void t_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cityActionPerformed

    private void b_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_femaleActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(false);
            }
        });
        */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton b_female;
    private javax.swing.JRadioButton b_male;
    private javax.swing.JRadioButton b_other;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField t_address;
    private javax.swing.JTextField t_city;
    private javax.swing.JTextField t_email;
    private javax.swing.JTextField t_lastname;
    private javax.swing.JTextField t_name;
    private javax.swing.JTextField t_phone;
    private javax.swing.JPasswordField t_pin_code;
    // End of variables declaration//GEN-END:variables
}
