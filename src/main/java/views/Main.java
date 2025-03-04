/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import RSA.EncryptionPrivate;
import RSA.KeyGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import utils.AppColors;
import utils.FontAwesomeIcons;

public class Main extends javax.swing.JFrame {
  private static Main instance;
  private Main() {
    initComponents();
    setLocationRelativeTo(null);
    setLockIcon();
  }
  
  public static Main getInstance() {
    if(instance == null) {
      instance = new Main();
    }
    
    return instance;
  }
  
  private void setLockIcon() {
    this.labelLockIcon.setIcon(FontAwesomeIcons.getLock(labelLockIcon.getWidth()));
    this.BtnGenerateKey.setBackground(AppColors.getSECONDARY_COLOR());
    this.BtnPrivate.setBackground(AppColors.getSECONDARY_COLOR());
    this.BtnPublic.setBackground(AppColors.getSECONDARY_COLOR());
    this.BtnGenerateKey.setForeground(AppColors.getWHITE_COLOR());
    this.BtnPrivate.setForeground(AppColors.getWHITE_COLOR());
    this.BtnPublic.setForeground(AppColors.getWHITE_COLOR());
  }
  
  private void writeMessageOnFile (String fileName, String message) throws IOException {
    File file = new File(fileName);
            
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
      writer.write(message);
      writer.newLine();
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

    PanelMain = new javax.swing.JPanel();
    LabelOption = new javax.swing.JLabel();
    labelLockIcon = new javax.swing.JLabel();
    LabelTitle = new javax.swing.JLabel();
    BtnGenerateKey = new javax.swing.JButton();
    BtnPrivate = new javax.swing.JButton();
    BtnPublic = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    PanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    LabelOption.setBackground(new java.awt.Color(255, 255, 255));
    LabelOption.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
    LabelOption.setForeground(new java.awt.Color(0, 153, 255));
    LabelOption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelOption.setText("Selecciona una opción");
    PanelMain.add(LabelOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 220, 50));
    PanelMain.add(labelLockIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 100, 110));

    LabelTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Cifrado RSA");
    PanelMain.add(LabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 220, 50));

    BtnGenerateKey.setBackground(new java.awt.Color(255, 255, 255));
    BtnGenerateKey.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    BtnGenerateKey.setText("Generar Llaves");
    BtnGenerateKey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    BtnGenerateKey.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BtnGenerateKeyActionPerformed(evt);
      }
    });
    PanelMain.add(BtnGenerateKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 370, 40));

    BtnPrivate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    BtnPrivate.setText("Clave Privada");
    BtnPrivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    BtnPrivate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BtnPrivateActionPerformed(evt);
      }
    });
    PanelMain.add(BtnPrivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 370, 40));

    BtnPublic.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    BtnPublic.setText("Clave Pública");
    BtnPublic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    PanelMain.add(BtnPublic, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 370, 40));

    getContentPane().add(PanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 510, 600));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void BtnGenerateKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerateKeyActionPerformed
    String userInput = JOptionPane.showInputDialog(rootPane, "Ingresar nombre:");
    if(userInput != null && !userInput.trim().isEmpty()) {
      KeyGenerator keyGen = new KeyGenerator();
      try {
        keyGen.generateAndSaveKeys(userInput);
        JOptionPane.showMessageDialog(rootPane, "Llaves generadas correctamente.\n" +
            "Archivos:\n" + userInput.trim() + "_publicKey\n" + userInput.trim() + "_privateKey");
      } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Ocurrió un error al generar las llaves:\n" + e.getMessage(), 
          "Error", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace(); // Para depuración (opcional)
      }
    }
    
    else {
      JOptionPane.showMessageDialog(rootPane, "No se ingresó un nombre válido", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_BtnGenerateKeyActionPerformed

  private void BtnPrivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrivateActionPerformed
    String[] options = {"Cifrar", "Descifrar", "Cancelar"};
    int choice = JOptionPane.showOptionDialog(
      rootPane, 
      "¿Qué desea realizar con la llave privada?", 
      "Seleccione una acción", 
      JOptionPane.DEFAULT_OPTION, 
      JOptionPane.QUESTION_MESSAGE, 
      null, 
      options, 
      options[0]
    );
    
    EncryptionPrivate crypto = new EncryptionPrivate();
    switch (choice) {
      case 0:
        String message = JOptionPane.showInputDialog(rootPane, "Ingresa la palabra que deseas cifrar: ");
        if(message != null && !message.trim().isEmpty()) {
          try {
            String encryptedMessage = crypto.encryptWithPrivateKey(message);
            writeMessageOnFile("mensaje_cifrado_privateKey.txt", encryptedMessage);
            
            JOptionPane.showMessageDialog(rootPane, "Cifrado correctamente y guardado en 'mensaje_cifrado_private'", "Cifrado Exitóso", JOptionPane.INFORMATION_MESSAGE, FontAwesomeIcons.getSuccess(25));
          } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cifrar el mensaje", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
        break;
        
      case 1:
        String encryptedMessage = JOptionPane.showInputDialog(rootPane, "Ingresa el texto cifrado:");
        if(encryptedMessage != null && !encryptedMessage.trim().isEmpty()) {
          try {
            System.out.println(encryptedMessage);
            String decryptedMessage = crypto.decryptWithPublicKey(encryptedMessage);
            String filename = "mensaje_descifrado_privateKey.txt";
            writeMessageOnFile(filename, decryptedMessage);
            JOptionPane.showMessageDialog(rootPane, "Descifrado correctamente y guardado en " + filename, "Cifrado Exitóso", JOptionPane.INFORMATION_MESSAGE, FontAwesomeIcons.getSuccess(25));
          } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al descifrar el mensaje", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
        
        break;
        
      default:
        throw new AssertionError();
    }
  }//GEN-LAST:event_BtnPrivateActionPerformed

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
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton BtnGenerateKey;
  private javax.swing.JButton BtnPrivate;
  private javax.swing.JButton BtnPublic;
  private javax.swing.JLabel LabelOption;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JPanel PanelMain;
  private javax.swing.JLabel labelLockIcon;
  // End of variables declaration//GEN-END:variables
}
