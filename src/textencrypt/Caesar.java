/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textencrypt;
import java.io.InputStream; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.HeadlessException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Caesar extends javax.swing.JFrame {

    /**
     * Creates new form Caesar
     */
    //public Caesar() {
    //    initComponents();
    //}
    private String table = "abcdefghijklmnopqrstuvwxyzáéíóúABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ1234567890.,;_:+-*/ @$#¿?!¡=()[]{}\\\'\"";
   
    public Caesar() {
        
       initComponents();
        
       setLocationRelativeTo(this);
    }
        private String Clean_text(String text)
     {
        text = text.replaceAll("\n", "");  
         
        for(int x = 0; x < text.length(); x++)
        {
            int position = table.indexOf(text.charAt(x));
            
            if (position == -1)
            {
                text = text.replace(text.charAt(x), ' ');
            }
        }        
        return text;
    }        
    public String Encrypt(String text, int key) throws SQLException, FileNotFoundException
        {       
        String cleaned_text = Clean_text(text);
        
        String encrypted = "";  
        
     for(int i = 0; i < cleaned_text.length();i++)
        {
           int position = table.indexOf(cleaned_text.charAt(i));
           
           if ((position + key) < table.length())
            {
                encrypted += table.charAt(position + key);
            }
            else
            {
                encrypted +=  table.charAt((position + key) - table.length());
            }         
        } 
     //JOptionPane.showMessageDialog(null, encrypted);
     try {
			File file = new File("file.txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(encrypted);
                fileWriter.flush();
            }
		} catch (IOException e) {
		}
    

           //database code goes here
          String filePath = "C:/Users/Dell/Documents/NetBeansProjects/JavaApplication4/file.txt";
InputStream inputStream = new FileInputStream(new File(filePath));
 
              try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/textencrypt","root","");
                   String sql = "INSERT into storage VALUES(ID,'"+inputStream+"')";
                    Statement pst=con.createStatement();
                    //PreparedStatement pst = con.prepareStatement(sql);
                    //pst.setBlob(2,inputStream);
                    pst.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Data Submitted Sucessfully.....");   
                      }   
catch(        HeadlessException | ClassNotFoundException  e){
    JOptionPane.showMessageDialog(null, e);
}
   
    return encrypted;
    }
    
    public String Decrypt(String text, int key)
    {        
        String cleaned_text = Clean_text(text);
        
        String decrypted = "";   
        
        for(int x = 0; x < cleaned_text.length(); x++)
        {            
            int position = table.indexOf(cleaned_text.charAt(x)); 
            
            if ((position - key) < 0)
            {
                decrypted += table.charAt((position - key) + table.length());
            }
            else
            {
                decrypted += table.charAt(position - key );
            }         
        }        
        return decrypted;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jColorChooser1 = new javax.swing.JColorChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        input_area = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        output_area = new javax.swing.JTextArea();
        encrypt_button_ = new javax.swing.JButton();
        decrypt_button_ = new javax.swing.JButton();
        key_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel2.setIcon(new javax.swing.ImageIcon("F:\\login-form-background-10.jpg")); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        input_area.setColumns(20);
        input_area.setRows(5);
        jScrollPane1.setViewportView(input_area);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(27, 26, 545, 140);

        output_area.setColumns(20);
        output_area.setRows(5);
        jScrollPane3.setViewportView(output_area);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(30, 270, 545, 150);

        encrypt_button_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        encrypt_button_.setText("Encrypt");
        encrypt_button_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        encrypt_button_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encrypt_button_ActionPerformed(evt);
            }
        });
        getContentPane().add(encrypt_button_);
        encrypt_button_.setBounds(40, 210, 90, 19);

        decrypt_button_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        decrypt_button_.setText("Decrypt");
        decrypt_button_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        decrypt_button_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrypt_button_ActionPerformed(evt);
            }
        });
        getContentPane().add(decrypt_button_);
        decrypt_button_.setBounds(160, 210, 80, 20);

        key_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(key_field);
        key_field.setBounds(500, 210, 52, 18);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Key :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 210, 50, 20);

        Exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Exit.setText("Exit");
        Exit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit);
        Exit.setBounds(300, 210, 80, 19);

        jLabel3.setIcon(new javax.swing.ImageIcon("F:\\login-form-background-10.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 600, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encrypt_button_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encrypt_button_ActionPerformed
        // TODO add your handling code here:
        
         String input = input_area.getText();
        
        int key = Integer.parseInt(key_field.getText());
        
        if (key <= 10)
        {
             try {
                 output_area.setText(Encrypt(input, key));
             } catch (SQLException | FileNotFoundException ex) {
                 Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else if((key<= 0)||(key>10))
        {
            JOptionPane.showMessageDialog(null, "Enter a valid key");
        }
    }//GEN-LAST:event_encrypt_button_ActionPerformed

    private void decrypt_button_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrypt_button_ActionPerformed
        // TODO add your handling code here:
        String input = input_area.getText();
        
        int key= Integer.parseInt(key_field.getText());
        
        if (key <= 10)
        {
            output_area.setText(Decrypt(input, key ));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter a valid key");
        }
    }//GEN-LAST:event_decrypt_button_ActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

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
            java.util.logging.Logger.getLogger(Caesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caesar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton decrypt_button_;
    private javax.swing.JButton encrypt_button_;
    private javax.swing.JTextArea input_area;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField key_field;
    private javax.swing.JTextArea output_area;
    // End of variables declaration//GEN-END:variables
}
