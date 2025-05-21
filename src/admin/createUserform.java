/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnector;
import config.passHash;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Administrator
 */
public class createUserform extends javax.swing.JFrame {

    /**
     * Creates new form createUserform
     */
    public createUserform() {
        initComponents();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    //public String answer = "No stored security answers";
   // public String question = "No stored security questions";

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
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static String email, usern;
    
    public boolean duplicateCheck(){
        config.dbConnector db = new config.dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user WHERE u_username = '" + un.getText() + "' OR u_email = '" + em.getText() + "'";
            ResultSet resultSet = db.getData(query);
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                if(email.equals(em.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already used");
                    em.setText("");
                }
                usern = resultSet.getString("u_username");
                if(usern.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already in used");
                    un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    public boolean updateCheck(){
        dbConnector db = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user WHERE (u_username = '"+un.getText()+"' OR u_email = '"+em.getText()+"') AND u_id != '"+uid.getText()+"'";
            ResultSet resultSet = db.getData(query);
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                if(email.equals(em.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already used");
                    em.setText("");
                }
                usern = resultSet.getString("u_username");
                if(usern.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already in used");
                    un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
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
        update = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        role = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        rm = new javax.swing.JButton();
        select = new javax.swing.JButton();
        ln = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        cpass = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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
        uid.setBounds(70, 10, 64, 24);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("User ID:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 10, 51, 24);

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(30, 90, 90, 30);

        update.setText("Update");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(30, 150, 90, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(400, 330, 80, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Upload your Picture");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(700, 70, 110, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 240, 78, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 120, 78, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(190, 180, 78, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(390, 180, 78, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Account:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(180, 330, 80, 30);

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Account Status", "Active", "Pending" }));
        jPanel1.add(status);
        status.setBounds(440, 330, 150, 30);

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Account Type", "Admin", "Applicant" }));
        jPanel1.add(role);
        role.setBounds(230, 330, 140, 30);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(null);

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel);
        cancel.setBounds(30, 210, 90, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 150, 480);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 260, 250));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(620, 100, 280, 270);

        add1.setText("Add");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel1.add(add1);
        add1.setBounds(30, 90, 90, 30);

        rm.setText("REMOVE");
        rm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmActionPerformed(evt);
            }
        });
        jPanel1.add(rm);
        rm.setBounds(773, 390, 90, 23);

        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(660, 390, 90, 23);
        jPanel1.add(ln);
        ln.setBounds(390, 150, 190, 30);
        jPanel1.add(fn);
        fn.setBounds(190, 150, 190, 30);
        jPanel1.add(un);
        un.setBounds(390, 210, 190, 30);
        jPanel1.add(em);
        em.setBounds(190, 210, 190, 30);
        jPanel1.add(pass);
        pass.setBounds(190, 280, 190, 30);
        jPanel1.add(cpass);
        cpass.setBounds(390, 280, 190, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Confirm Password:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(390, 240, 120, 40);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("First Name: ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(190, 120, 78, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
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
    String fistname = fn.getText();
    String lname = ln.getText();
    String email1 = em.getText();
    String username1 = un.getText();
    String password1 = new String(pass.getPassword());
    String cpassword = new String(cpass.getPassword());
    String selectedRole = role.getSelectedItem().toString();

    if (fistname.isEmpty() || lname.isEmpty() || username1.isEmpty() || email1.isEmpty() || password1.isEmpty() || cpassword.isEmpty()){
        JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
    }else if(!isValidEmail(em.getText())){
        JOptionPane.showMessageDialog(null, "Invalid email format!");
        em.setText("");
    }else if(pass.getText().length() < 8){
        JOptionPane.showMessageDialog(null, "Password must be atleast 8 characters long");
         pass.setText(""); 
    }else if(duplicateCheck()){
        System.out.println("Duplicate Exist");
    }else if(!pass.getText().equals(cpass.getText())){
        JOptionPane.showMessageDialog(null, "Password not Matches");
        pass.setText("");
        cpass.setText("");
    }else{
        dbConnector db = new dbConnector();
        
        try{
        String password = passHash.hashPassword(pass.getText());
        String password2 = passHash.hashPassword(cpass.getText());
        String imagePath = "";

                int confirm = JOptionPane.showConfirmDialog(this, "Do you want to upload a user image?", "Image Upload", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    if (selectedFile != null && destination != null && !destination.trim().isEmpty()) {
                        imagePath = destination;
                    } else {
                        JOptionPane.showMessageDialog(this, "No image selected. Proceeding without image.", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            
        if(db.insertData("INSERT INTO tbl_user (u_fname, u_lname, u_username, u_email, u_type, u_status, u_image, u_pass, u_cpass)"  
            + "VALUES ('"+fn.getText()+"', '"+ln.getText()+"', '"+un.getText()+"', '"+em.getText()+"', '"+role.getSelectedItem()+"', '"+status.getSelectedItem()+"', '"+imagePath+"', '"+password+"' ,'"+password2+"')") == 1){
            try {
                if (confirm == JOptionPane.YES_OPTION && selectedFile != null && destination != null && !destination.trim().isEmpty()) {
                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }

                Session sess = Session.getInstance();
                db.logActivity(sess.getUid(), "Create a user: " + un.getText());
                JOptionPane.showMessageDialog(this, "Account Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                user_dashboard lf = new user_dashboard();
                lf.setVisible(true);
                this.dispose();      

            } catch (IOException ex) {
                System.out.println("Insert Image Error: " + ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Connection Error!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NoSuchAlgorithmException ex){
            System.out.println(""+ex);
        }
    }
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        user_dashboard usf = new user_dashboard();
        usf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

     
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    String fistname = fn.getText();
    String lname = ln.getText();
    String email1 = em.getText();
    String username1 = un.getText();
    String password1 = new String(pass.getPassword());
    String cpassword = new String(cpass.getPassword());
    String selectedRole = role.getSelectedItem().toString();

    if (fistname.isEmpty() || lname.isEmpty() || username1.isEmpty() || email1.isEmpty() || password1.isEmpty() || cpassword.isEmpty()){
        JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
    }else if(!isValidEmail(em.getText())){
        JOptionPane.showMessageDialog(null, "Invalid email format!");
        em.setText("");
    }else if(pass.getText().length() < 8){
        JOptionPane.showMessageDialog(null, "Password must be atleast 8 characters long");
         pass.setText(""); 
    }else if(updateCheck()){
        System.out.println("Duplicate Exist");
    }else if(!pass.getText().equals(cpass.getText())){
        JOptionPane.showMessageDialog(null, "Password not Matches");
        pass.setText("");
        cpass.setText("");
    }else{
        dbConnector dbc = new dbConnector();
        String question = "";
        String answer = "";
        
            dbc.updateData("UPDATE tbl_user SET u_fname = '"+fn.getText()+"', u_lname = '"+ln.getText()+"', "
                + "u_email = '"+em.getText()+"', u_username = '"+un.getText()+"', "
                + "u_pass = '"+pass.getText()+"', u_cpass = '"+cpass.getText()+"', u_type='"+role.getSelectedItem()+"', "
                + "u_status = '"+status.getSelectedItem()+"', u_image = '"+destination+"' WHERE u_id = '"+uid.getText()+"'");
            Session sess = Session.getInstance();
            dbc.logActivity(sess.getUid(), "Updated a user: " + un.getText());
            JOptionPane.showMessageDialog(null, "Account Updated Successfully!");            
            if(destination.isEmpty()){
                File existingFile = new File(oldpath);
                if(existingFile.exists()){
                    existingFile.delete();
                }
            }else{
                if(!(oldpath.equals(path))){    
                    imageUpdater(oldpath, path);
                }
            }
            user_dashboard ud = new user_dashboard();
            ud.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_updateActionPerformed

    
    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add1ActionPerformed

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
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JButton add1;
    private javax.swing.JButton cancel;
    public javax.swing.JPasswordField cpass;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    public javax.swing.JTextField ln;
    public javax.swing.JPasswordField pass;
    public javax.swing.JButton rm;
    public javax.swing.JComboBox<String> role;
    public javax.swing.JButton select;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
