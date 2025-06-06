/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Start.loginform;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SCC-COLLEGE
 */
public class userDashboard extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public userDashboard() {
        initComponents();
        updateDashboard();
        displayLogs2();
    }
    
private void updateDashboardCounts(int applicantId) {
    try {
        dbConnector db = new dbConnector();

        int totalApprovedStudents = db.getCountWithCondition("tbl_applicant", 
                "app_uid = '" + applicantId + "' AND app_status = 'Accepted'");

        int pendingApplication = db.getCountWithCondition("tbl_applicant", 
               "app_uid = '" + applicantId + "' AND app_status = 'Pending'");

        totalAccepted.setText(String.valueOf(totalApprovedStudents));
        totalpending.setText(String.valueOf(pendingApplication));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Error loading dashboard data: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void updateDashboard() {
    try {
        dbConnector db = new dbConnector();
        Session sess = Session.getInstance();

        Integer uidValue = sess.getUid();
        String uid = (uidValue != null) ? uidValue.toString() : "0";

        String empQuery = "SELECT app_id FROM tbl_applicant WHERE app_uid = '" + uid + "'";
        ResultSet appRs = db.getData(empQuery);
        
        if (appRs.next()) {  
            int empId = appRs.getInt("app_id");
            updateDashboardCounts(empId);  
        } else {
            totalAccepted.setText("0");
            totalpending.setText("0");
        }
        appRs.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
        JOptionPane.showMessageDialog(null, 
            "Error loading dashboard: " + e.getMessage(), 
            "Database Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    public void displayLogs2() {
        try {
            dbConnector db = new dbConnector();
            ResultSet rs = db.getLogs2();
            tblapp.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error loading logs: "+e.getMessage());
        }
    }
    
        Color navcolor = new Color(255,255,255);  
        Color hovercolor = new Color (0, 255, 255);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        wc = new javax.swing.JLabel();
        user = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dash = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        dash1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        dash2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblapp = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        totalAccepted = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        totalpending = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boy.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 36, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel5.setText("Log Out");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 70, 20));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SCA");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 11, 42, -1));
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 485, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Applicant");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 150, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/door.png"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        wc.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        wc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(wc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, 30));

        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("SETTINGS");

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 170, 50));

        dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashMouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Apply Assistance");

        javax.swing.GroupLayout dashLayout = new javax.swing.GroupLayout(dash);
        dash.setLayout(dashLayout);
        dashLayout.setHorizontalGroup(
            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        dashLayout.setVerticalGroup(
            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        dash1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dash1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash1MouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Dashboard");

        javax.swing.GroupLayout dash1Layout = new javax.swing.GroupLayout(dash1);
        dash1.setLayout(dash1Layout);
        dash1Layout.setHorizontalGroup(
            dash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dash1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        dash1Layout.setVerticalGroup(
            dash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dash1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(dash1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        dash2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dash2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash2MouseExited(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Assistance Results");

        javax.swing.GroupLayout dash2Layout = new javax.swing.GroupLayout(dash2);
        dash2.setLayout(dash2Layout);
        dash2Layout.setHorizontalGroup(
            dash2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dash2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        dash2Layout.setVerticalGroup(
            dash2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dash2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(dash2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 540));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("APPLICANT DASHBOARD");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 45));

        tblapp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblapp);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 580, 330));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalAccepted.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalAccepted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAccepted.setText("0");
        jPanel1.add(totalAccepted, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Total");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, -1));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Accepted Application");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 120, 110));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalpending.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalpending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalpending.setText("0");
        jPanel5.add(totalpending, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Total");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, -1));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Pending Application");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 120, 110));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 620, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       if(sess.getUid() == 0){
            System.out.println("");
       }else{
            wc.setText(""+sess.getLname());
       } 
    }//GEN-LAST:event_formWindowActivated

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        accountDetails ad = new accountDetails();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userMouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        user.setBackground(hovercolor);
    }//GEN-LAST:event_userMouseEntered

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        user.setBackground(navcolor);
    }//GEN-LAST:event_userMouseExited

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
        applyAssistance ad = new applyAssistance();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashMouseClicked

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered
        dash.setBackground(hovercolor);
    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited
        dash.setBackground(navcolor);
    }//GEN-LAST:event_dashMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    loginform lf = new loginform();
    JOptionPane.showMessageDialog(null,"User Logout Successfully!");
    dbConnector dbc = new dbConnector();
    Session sess = Session.getInstance();
    dbc.logActivity2(sess.getUid(), "User Logout:" +sess.getLname());
    lf.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void dash1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash1MouseClicked
    userDashboard ad = new userDashboard();
    ad.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_dash1MouseClicked

    private void dash1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_dash1MouseEntered

    private void dash1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_dash1MouseExited

    private void dash2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash2MouseClicked
    assistanceResults ar = new assistanceResults();
    ar.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_dash2MouseClicked

    private void dash2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_dash2MouseEntered

    private void dash2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dash2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_dash2MouseExited

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
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dash;
    private javax.swing.JPanel dash1;
    private javax.swing.JPanel dash2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblapp;
    private javax.swing.JLabel totalAccepted;
    private javax.swing.JLabel totalpending;
    private javax.swing.JPanel user;
    private javax.swing.JLabel wc;
    // End of variables declaration//GEN-END:variables
}
