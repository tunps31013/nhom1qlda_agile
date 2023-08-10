/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlda_agile;

import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author nguye
 */
public class RESET extends javax.swing.JFrame {

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private int id = 0;

    /**
     * Creates new form RESET
     */
    public RESET() {
        initComponents();
        setLocationRelativeTo(null);
        conn = KETNOISQL.getConnection("sa", "nguyentuakina", "QLDA_SINHVIEN");
        setTitle("Reset Password");
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
        txtMa = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JTextField();
        btnGoiMa = new javax.swing.JButton();
        btnXacnhan = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnQuaylai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập mã:");

        jLabel3.setText("Xác nhân mật khẩu:");

        jLabel2.setText("Nhập mật khẩu mới:");

        btnGoiMa.setText("Gởi mã");
        btnGoiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoiMaActionPerformed(evt);
            }
        });

        btnXacnhan.setText("Xác nhận");
        btnXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacnhanActionPerformed(evt);
            }
        });

        jLabel4.setText("Email:");

        btnQuaylai.setText("Quay lại");
        btnQuaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaylaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQuaylai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGoiMa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXacnhan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacnhan)
                    .addComponent(btnGoiMa)
                    .addComponent(btnQuaylai))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        int Ma = 0;
        String sql = "select * from USERS";
        boolean check = true;
        String emailFormat = "\\w+@\\w+(\\.\\w+){1,2}";
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Email");
            return;
        } else if (!txtEmail.getText().matches(emailFormat)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return;
        }
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (txtEmail.getText().equalsIgnoreCase(rs.getString("USERNAME"))) {
                    check = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RESET.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check) {
            JOptionPane.showMessageDialog(this, "Email này không tồn tại");
            return;
        }
        if (txtMa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã");
            return;
        }
        try {
            Ma = Integer.parseInt(txtMa.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Mã bạn nhập không phải số");
            return;
        }
        if (Integer.parseInt(txtMa.getText()) != id) {
            JOptionPane.showMessageDialog(this, "Mã bạn nhập sai");
            return;
        } else if (txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu");
            return;
        } else if (txtNewPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa xác nhận mật khẩu");
            return;
        }
        if (Integer.parseInt(txtMa.getText()) == id) {
            try {
                st = conn.createStatement();
                if (txtPass.getText().equals(txtNewPass.getText())) {
                    String updateSQL = "update USERS set PASSWORD = '" + txtPass.getText() + "'"
                            + " where USERNAME = '" + txtEmail.getText() + "'";
                    st.execute(updateSQL);
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
                    setVisible(false);
                    LOGIN lg = new LOGIN();
                    lg.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Mật khẩu bạn nhập không trùng");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btnXacnhanActionPerformed

    private void btnGoiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoiMaActionPerformed
        Random rd = new Random();
        boolean check = true;
        String sql = "Select * from USERS";
        String emailFormat = "\\w+@\\w+(\\.\\w+){1,2}";
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Email");
            return;
        } else if (!txtEmail.getText().matches(emailFormat)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return;
        }
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(txtEmail.getText())) {
                    Properties p = new Properties();
                    p.put("mail.smtp.auth", "true");
                    p.put("mail.smtp.starttls.enable", "true");
                    p.put("mail.smtp.host", "smtp.gmail.com");
                    p.put("mail.smtp.port", 587);

                    String accountName = "tunps31013@gmail.com";
                    String passName = "vpmripruowgycplx";
                    Session s = Session.getInstance(p, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(accountName, passName);
                        }
                    });

                    Message msg = new MimeMessage(s);
                    msg.setFrom(new InternetAddress(accountName));
                    msg.setRecipients(
                            Message.RecipientType.TO.CC,
                            InternetAddress.parse(txtEmail.getText())
                    );
                    msg.setSubject("Mã xác nhận đổi mật khẩu");
                    id = rd.nextInt(900000) + 100000;
                    msg.setText("Mã của bạn là: " + id);

                    Transport.send(msg);

                    JOptionPane.showMessageDialog(this, "Đã gởi mã");

                    check = false;
                }
            }
        } catch (MessagingException e) {
            System.out.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(RESET.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check) {
            JOptionPane.showMessageDialog(this, "Email không tồn tại");
        }
    }//GEN-LAST:event_btnGoiMaActionPerformed

    private void btnQuaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaylaiActionPerformed
        setVisible(false);
        LOGIN lg;
        try {
            lg = new LOGIN();
            lg.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(RESET.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnQuaylaiActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RESET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RESET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RESET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RESET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RESET().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoiMa;
    private javax.swing.JButton btnQuaylai;
    private javax.swing.JButton btnXacnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNewPass;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
