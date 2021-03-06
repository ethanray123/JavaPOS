/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package posinterface;

import java.sql.Connection;
import java.sql.ResultSet;
import Hash.hashPass;
import MySQL.connect;
import MySQL.CRUD;
/**
 *
 * @author student
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
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

        Uname = new javax.swing.JTextField();
        Pword = new javax.swing.JTextField();
        Reg = new javax.swing.JLabel();
        UN = new javax.swing.JLabel();
        PW = new javax.swing.JLabel();
        R = new javax.swing.JLabel();
        Sbtn = new javax.swing.JButton();
        RolePick = new javax.swing.JComboBox();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setMinimumSize(new java.awt.Dimension(860, 530));
        setResizable(false);
        getContentPane().setLayout(null);

        Uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnameActionPerformed(evt);
            }
        });
        getContentPane().add(Uname);
        Uname.setBounds(250, 120, 161, 30);
        getContentPane().add(Pword);
        Pword.setBounds(250, 170, 161, 30);

        Reg.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        Reg.setForeground(new java.awt.Color(255, 255, 255));
        Reg.setText("Register");
        getContentPane().add(Reg);
        Reg.setBounds(60, 40, 170, 70);

        UN.setFont(new java.awt.Font("Script MT Bold", 1, 24)); // NOI18N
        UN.setForeground(new java.awt.Color(255, 255, 255));
        UN.setText("Username");
        getContentPane().add(UN);
        UN.setBounds(120, 120, 110, 20);

        PW.setFont(new java.awt.Font("Script MT Bold", 1, 24)); // NOI18N
        PW.setForeground(new java.awt.Color(255, 255, 255));
        PW.setText("Password");
        getContentPane().add(PW);
        PW.setBounds(120, 170, 110, 29);

        R.setFont(new java.awt.Font("Script MT Bold", 1, 24)); // NOI18N
        R.setForeground(new java.awt.Color(255, 255, 255));
        R.setText("Role");
        getContentPane().add(R);
        R.setBounds(120, 220, 100, 29);

        Sbtn.setFont(new java.awt.Font("Script MT Bold", 1, 18)); // NOI18N
        Sbtn.setText("Submit");
        Sbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Sbtn);
        Sbtn.setBounds(120, 270, 120, 31);

        RolePick.setFont(new java.awt.Font("Script MT Bold", 1, 18)); // NOI18N
        RolePick.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Cashier" }));
        RolePick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolePickActionPerformed(evt);
            }
        });
        getContentPane().add(RolePick);
        RolePick.setBounds(250, 220, 110, 29);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posinterface/pie-wallpaper-1.jpg"))); // NOI18N
        BG.setMaximumSize(new java.awt.Dimension(860, 530));
        BG.setMinimumSize(new java.awt.Dimension(860, 530));
        BG.setPreferredSize(new java.awt.Dimension(860, 530));
        getContentPane().add(BG);
        BG.setBounds(0, 0, 860, 530);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UnameActionPerformed

    private void SbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SbtnActionPerformed
        String username = Uname.getText();
        String password = Pword.getText();
        String role = ""+RolePick.getSelectedItem();
        try
        {
            Connection con = connect.getConnection();
            password=hashPass.hashPassword(password);
            CRUD.insertUser(con,username,password,role);
            ResultSet rs = CRUD.selectUserPR(con,username);
            
            rs.next();
                if(rs.getString("role").equals("Admin")){
                    admin a = new admin();
                    a.setVisible(true);
                }else{
                    list l= new list();
                    l.setVisible(true);
                }
                dispose();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_SbtnActionPerformed

    private void RolePickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolePickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RolePickActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel PW;
    private javax.swing.JTextField Pword;
    private javax.swing.JLabel R;
    private javax.swing.JLabel Reg;
    private javax.swing.JComboBox RolePick;
    private javax.swing.JButton Sbtn;
    private javax.swing.JLabel UN;
    private javax.swing.JTextField Uname;
    // End of variables declaration//GEN-END:variables
}
