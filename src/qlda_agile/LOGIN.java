/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlda_agile;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author nguye
 */
public class LOGIN extends javax.swing.JFrame {

    private Connection conn;

    /**
     * Creates new form LOGIN
     *
     */
    public LOGIN() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Login");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        conn = KETNOISQL.getConnection("sa", "nguyentuakina", "QLDA_SINHVIEN");
    }

    public void login() throws SQLException {
        String sql = "Select * from USERS";
        if (checkNull()) {
            return;
        }
//        tao statement
        Statement st = conn.createStatement();
        //duyet
        try (//thuc hien
                ResultSet rs = st.executeQuery(sql)) {
            //duyet
            boolean user = true;
            boolean passTF = true;
            String pass = String.valueOf(txtPassword.getPassword());
            while (rs.next()) {//con phan tu ke tiep
                if (rs.getString("USERNAME").equalsIgnoreCase(txtUsername.getText())) {
                    user = false;
                    if (rs.getString("PASSWORD").
                            equalsIgnoreCase(pass)) {
                        passTF = false;
                        if (rs.getString("ROLE").equals("admin")) {
                            QUANLYSINHVIEN qlsv = new QUANLYSINHVIEN();
                            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                            qlsv.setVisible(true);
                            setVisible(false);
                        }
                        if (rs.getString("ROLE").equals("gv")) {
                            QUANLYDIEM qld = new QUANLYDIEM();
                            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                            qld.setVisible(true);
                            setVisible(false);
                        }
                        if (rs.getString("ROLE").equals("sv")) {
                            if (pass.equalsIgnoreCase("123456")) {
                                String passW = JOptionPane.showInputDialog(this, "Nhập mật khẩu mới!");
                                if (passW == null) {
                                    return;
                                } else if (passW.equals("")) {
                                    JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu");
                                    return;
                                } else {
                                    if (passW.equalsIgnoreCase("123456")) {
                                        JOptionPane.showMessageDialog(this, "Bạn nhập mật khẩu bị trùng mới mặc định!");
                                        return;
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
                                    }
                                }
                                st = conn.createStatement();
                                String updateSQL = "update USERS set PASSWORD = '" + passW + "'"
                                        + " where USERNAME = '" + txtUsername.getText() + "'";
                                st.executeUpdate(updateSQL);
                                txtUsername.setText("");
                                txtPassword.setText("");
                            } else {
                                XEMDIEMSINHVIEN xdsv = new XEMDIEMSINHVIEN();
                                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                                xdsv.setVisible(true);
                                setVisible(false);
                            }
                        }
                    }
                }
            }
            if (user) {
                JOptionPane.showMessageDialog(this, "USERNAME Không tồn tại");
            } else if (passTF) {
                JOptionPane.showMessageDialog(this, "PASSWORD Không tồn tại");
            }
            rs.close();
        }
    }

    public boolean checkNull() {
        String pass = String.valueOf(txtPassword.getPassword());
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập USERNAME");
            return true;
        } else if (pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập PASSWORD");
            return true;
        }
        return false;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnCamcel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblQuenmk = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 204), java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel2.setText("USERNAME:");

        jLabel3.setText("PASSWORD");

        btnCamcel.setText("Cancel");
        btnCamcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamcelActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblQuenmk.setText("Quên mật khẩu?");
        lblQuenmk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenmkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenmkMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblQuenmkMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCamcel))
                    .addComponent(lblQuenmk, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPassword))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuenmk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCamcel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCamcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamcelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCamcelActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            login();
        } catch (SQLException ex) {
            Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblQuenmkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenmkMouseEntered
        lblQuenmk.setForeground(Color.red);
    }//GEN-LAST:event_lblQuenmkMouseEntered

    private void lblQuenmkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenmkMouseExited
        lblQuenmk.setForeground(Color.black);
    }//GEN-LAST:event_lblQuenmkMouseExited

    private void lblQuenmkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenmkMousePressed
        RESET rs = new RESET();
        rs.setVisible(true);
        setVisible(false);
//        String sql = "Select * from USERS";
//        Statement st;
//        try {
//            st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                String passW = JOptionPane.showInputDialog(this, "Nhập mật khẩu mới!");
//                if (passW == null) {
//                    return;
//                } else if (passW.equals("")) {
//                    JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu");
//                    return;
//                } else {
//                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
//                }
//                st = conn.createStatement();
//                String updateSQL = "update USERS set PASSWORD = '" + passW + "'"
//                        + " where USERNAME = '" + txtUsername.getText() + "'";
//                st.executeUpdate(updateSQL);
//                txtUsername.setText("");
//                txtPassword.setText("");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
    }//GEN-LAST:event_lblQuenmkMousePressed

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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new LOGIN().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamcel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblQuenmk;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
