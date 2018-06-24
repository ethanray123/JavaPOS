/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posinterface;

import java.sql.Connection;
import java.sql.ResultSet;
import Hash.hashPass;
import MySQL.CRUD;
import MySQL.connect;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Log
     */
    public Login() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Lbtn = new javax.swing.JButton();
        UN = new javax.swing.JLabel();
        PW = new javax.swing.JLabel();
        UNinput = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        Rbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POS");
        setMinimumSize(new java.awt.Dimension(860, 530));
        setPreferredSize(new java.awt.Dimension(860, 530));
        getContentPane().setLayout(null);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setLayout(null);

        Lbtn.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        Lbtn.setText("Log In");
        Lbtn.setMaximumSize(new java.awt.Dimension(860, 530));
        Lbtn.setPreferredSize(new java.awt.Dimension(860, 530));
        Lbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Lbtn);
        Lbtn.setBounds(300, 320, 140, 40);

        UN.setFont(new java.awt.Font("Script MT Bold", 0, 24)); // NOI18N
        UN.setForeground(new java.awt.Color(255, 255, 255));
        UN.setText("Username");
        jPanel1.add(UN);
        UN.setBounds(290, 210, 130, 30);

        PW.setFont(new java.awt.Font("Script MT Bold", 0, 24)); // NOI18N
        PW.setForeground(new java.awt.Color(255, 255, 255));
        PW.setText("Password");
        jPanel1.add(PW);
        PW.setBounds(290, 260, 130, 30);

        UNinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNinputActionPerformed(evt);
            }
        });
        jPanel1.add(UNinput);
        UNinput.setBounds(430, 210, 161, 30);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(430, 260, 161, 30);

        Rbtn.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        Rbtn.setText("Register");
        Rbtn.setMaximumSize(new java.awt.Dimension(860, 530));
        Rbtn.setPreferredSize(new java.awt.Dimension(860, 530));
        Rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Rbtn);
        Rbtn.setBounds(450, 320, 140, 40);

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menchie's Munchies");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 80, 310, 100);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posinterface/pie-wallpaper-1.jpg"))); // NOI18N
        BG.setPreferredSize(new java.awt.Dimension(860, 530));
        jPanel1.add(BG);
        BG.setBounds(0, 0, 850, 530);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 860, 530);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UNinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UNinputActionPerformed

    private void LbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LbtnActionPerformed
        String username = UNinput.getText();
        String password = jPasswordField1.getText();
        
        try
        {
            Connection con = connect.getConnection();
            ResultSet rs = CRUD.selectUserPR(con,username);
            rs.next();
            String retrievePassword = rs.getString("password");
            if((hashPass.hashPassword(password)).equals(retrievePassword)){
                if(rs.getString("role").equals("Admin")){
                    admin a = new admin();
                    a.setVisible(true);
                }else{
                    list l= new list();
                    l.setVisible(true);
                }
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        }catch(NoSuchAlgorithmException | SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Username and Password does not match");
        }
    }//GEN-LAST:event_LbtnActionPerformed

    private void RbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnActionPerformed
        Register r = new Register();
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_RbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton Lbtn;
    private javax.swing.JLabel PW;
    private javax.swing.JButton Rbtn;
    private javax.swing.JLabel UN;
    private javax.swing.JTextField UNinput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}