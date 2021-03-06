/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamailclient.GmailAPI;
import javamailclient.HomeFrame;
import javamailclient.JavaMailClient;
import javamailclient.LoginFrame;
import javax.swing.JToggleButton;

/**
 *
 * @author user
 */
public class LoginPanel extends javax.swing.JPanel {

    public static String code;
    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
    }
    
    public JToggleButton getSubmitButton() {
        return SubmitButton;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelAtas = new javax.swing.JLabel();
        LinkButton = new javax.swing.JToggleButton();
        PasteLabel = new javax.swing.JLabel();
        KeyField = new javax.swing.JTextField();
        SubmitButton = new javax.swing.JToggleButton();

        LabelAtas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelAtas.setText("Login with your gmail account through this");

        LinkButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LinkButton.setLabel("link");
        LinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinkButtonActionPerformed(evt);
            }
        });

        PasteLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PasteLabel.setText("Paste the generated key :");

        KeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyFieldActionPerformed(evt);
            }
        });

        SubmitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelAtas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 459, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PasteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KeyField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LinkButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KeyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubmitButton)
                .addContainerGap(455, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LinkButtonActionPerformed
        try {
            URL url = new URL(GmailAPI.AUTH_URL);
            JavaMailClient.openWebpage(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LinkButtonActionPerformed

    private void KeyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeyFieldActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed

        code = KeyField.getText();
        /*try {
            code = KeyField.getText();
            //String code = KeyField.getText();
            //GmailAPI.initialize(code);
            HomeFrame hf = new HomeFrame();
            this.setVisible(false);
            hf.setVisible(true);
            //JLabel hellolabel = Awt1.getComponentByName(someOtherFrame, "jButton1");
        } catch (IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_SubmitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField KeyField;
    private javax.swing.JLabel LabelAtas;
    private javax.swing.JToggleButton LinkButton;
    private javax.swing.JLabel PasteLabel;
    private javax.swing.JToggleButton SubmitButton;
    // End of variables declaration//GEN-END:variables
}
