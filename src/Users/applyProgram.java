/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import admin.*;
import config.Session;
import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Administrator
 */
public class applyProgram extends javax.swing.JFrame {

    /**
     * Creates new form createUserform
     */
    public applyProgram() {
        initComponents();
        loadProgram();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;

    
    private HashMap<String, Integer> programtMap = new HashMap<>();  
    
    public void loadProgram(){
        dbConnector db = new dbConnector();
        try {
            String query = "SELECT prog_id, prog_name FROM tbl_program ORDER BY prog_name";
            ResultSet rs = db.getData(query);

            progname.removeAllItems();
            programtMap.clear(); 
            boolean hasProgram = false;

            while (rs.next()) {
                    hasProgram = true;
                    int progId = rs.getInt("prog_id");
                    String progName = rs.getString("prog_name");
                    progname.addItem(progName);
                    programtMap.put(progName, progId);
            }

            if (!hasProgram) {
                JOptionPane.showMessageDialog(this,"No program available. Do you want to proceed anyway?", "No Program Found", JOptionPane.INFORMATION_MESSAGE);
                progname.addItem("N/A");
            }

            progname.revalidate();
            progname.repaint();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading program: " + e.getMessage());
        }
    }
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();

        Path filePath = Paths.get("src/userImages", fileName);
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            return 1;
        } else {
            return 0;
        }

    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
    try {
        // Read the image file
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);

        // Get the original width and height of the image
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();

        // Calculate the new height based on the desired width and the aspect ratio
        int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);

        return newHeight;
    } catch (IOException ex) {
        System.out.println("No image found!");
    }

    return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    public void imageUpdater(String existingFilePath, String newFilePath){
    File existingFile = new File(existingFilePath);
    if (existingFile.exists()) {
        String parentDirectory = existingFile.getParent();
        File newFile = new File(newFilePath);
        String newFileName = newFile.getName();
        File updatedFile = new File(parentDirectory, newFileName);
        existingFile.delete();
        try {
            Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image updated successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while updating the image: "+e);
        }
    } else {
        try{
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            System.out.println("Error on update!");
        }
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        uid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        progname = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        rm = new javax.swing.JButton();
        select = new javax.swing.JButton();
        homeadd = new javax.swing.JTextField();
        schoolname = new javax.swing.JTextField();
        famincome = new javax.swing.JTextField();
        edulevel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        schooladd = new javax.swing.JTextField();

        jLabel2.setText("First Name: ");

        jScrollPane5.setViewportView(jTextPane5);

        jScrollPane6.setViewportView(jTextPane6);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(527, 473));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel1.add(uid);
        uid.setBounds(90, 30, 64, 24);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("User ID:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 30, 51, 24);

        add.setText("Apply");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(80, 380, 140, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Upload your Documents Here");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(510, 70, 160, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Home Address:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 240, 100, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("School Address:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 120, 90, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Education Level:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 180, 130, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Family Monthly Income:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(230, 180, 140, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cash Assistance Program:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 320, 140, 30);

        progname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Programt" }));
        progname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prognameActionPerformed(evt);
            }
        });
        jPanel1.add(progname);
        progname.setBounds(180, 320, 140, 30);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 260, 250));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(460, 100, 280, 270);

        rm.setText("REMOVE");
        rm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmActionPerformed(evt);
            }
        });
        jPanel1.add(rm);
        rm.setBounds(610, 390, 90, 23);

        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(500, 390, 90, 23);
        jPanel1.add(homeadd);
        homeadd.setBounds(30, 280, 390, 30);
        jPanel1.add(schoolname);
        schoolname.setBounds(30, 90, 390, 30);
        jPanel1.add(famincome);
        famincome.setBounds(230, 210, 190, 30);
        jPanel1.add(edulevel);
        edulevel.setBounds(30, 210, 190, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("School Name: ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 60, 78, 30);

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel);
        cancel.setBounds(250, 380, 140, 30);
        jPanel1.add(schooladd);
        schooladd.setBounds(30, 150, 390, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
    String schoolName = schoolname.getText();
    String schoolAddress = schooladd.getText();
    String educationLevel = edulevel.getText();
    String familyIncome = famincome.getText();
    String homeAddress = homeadd.getText();
    String selectedProgram = progname.getSelectedItem().toString();

    if (schoolName.isEmpty() || schoolAddress.isEmpty() || educationLevel.isEmpty() || 
        familyIncome.isEmpty() || homeAddress.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("Please Select Program".equals(selectedProgram) || "N/A".equals(selectedProgram)) {
        JOptionPane.showMessageDialog(this, "Please select a valid program", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        dbConnector db = new dbConnector();
        Session sess = Session.getInstance();
        Integer progId = programtMap.get(selectedProgram);

        String imagePath = "";
        int currentUserId = sess.getUid();

        try {
            ResultSet appRs = db.getData("SELECT app_id FROM tbl_applicant WHERE app_uid = '" + currentUserId + "'");

            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to upload an image?", "Image Upload", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                if (selectedFile != null && destination != null && !destination.trim().isEmpty()) {
                    imagePath = destination;
                } else {
                    JOptionPane.showMessageDialog(this, "No image selected. Proceeding without image.", "Notice", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if(db.insertData("INSERT INTO tbl_applicant (app_uid, app_schoolName, app_schoolAddress, app_eduLevel, app_famIncome, app_homeAddress, app_progid, app_progname, app_status, app_docs) " +
                            "VALUES ('"+currentUserId+"', '"+schoolName+"', '"+schoolAddress+"', '"+educationLevel+"', '"+familyIncome+"', '"+homeAddress+"', '"+progId+"', '"+selectedProgram+"', 'Pending', '"+imagePath+"')") == 1) {
                try {
                    if (confirm == JOptionPane.YES_OPTION && selectedFile != null && destination != null && !destination.trim().isEmpty()) {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }

                    db.logActivity2(sess.getUid(), "Applied to Cash Assistance Program: " + selectedProgram);
                    JOptionPane.showMessageDialog(this, "Application Submitted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    applyAssistance aa = new applyAssistance();
                    aa.setVisible(true);
                    this.dispose();
                } catch(IOException ex) {
                    System.out.println("Image Copy Error: "+ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to submit application!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(applyProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        applyAssistance aa = new applyAssistance();
        aa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

     
    
    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userImages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    image.setIcon(ResizeImage(path, null, image));
                    select.setEnabled(true);
                    rm.setEnabled(false);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectActionPerformed

    private void rmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmActionPerformed
        image.setIcon(null);
        destination = "";
        path = "";
        select.setEnabled(true);
        rm.setEnabled(false);        
    }//GEN-LAST:event_rmActionPerformed

    private void prognameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prognameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prognameActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(applyProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(applyProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(applyProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(applyProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new applyProgram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JButton cancel;
    public javax.swing.JTextField edulevel;
    public javax.swing.JTextField famincome;
    public javax.swing.JTextField homeadd;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    public javax.swing.JComboBox<String> progname;
    public javax.swing.JButton rm;
    public javax.swing.JTextField schooladd;
    public javax.swing.JTextField schoolname;
    public javax.swing.JButton select;
    public javax.swing.JTextField uid;
    // End of variables declaration//GEN-END:variables
}
