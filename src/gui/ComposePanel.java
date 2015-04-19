/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

/**
 *
 * @author user
 */
public class ComposePanel extends javax.swing.JPanel {

    byte[] key;
    
    /**
     * Creates new form ComposePanel
     */
    public ComposePanel() {
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

        jLabel1 = new javax.swing.JLabel();
        toTextField = new javax.swing.JTextField();
        subjectTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ccTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgTextField = new javax.swing.JTextArea();
        encryptCheckBox = new javax.swing.JCheckBox();
        keyEncryptTextField = new javax.swing.JTextField();
        keyEncryptLabel = new javax.swing.JLabel();
        openEncryptButton = new javax.swing.JButton();
        signCheckBox = new javax.swing.JCheckBox();
        signLabel = new javax.swing.JLabel();
        signTextField = new javax.swing.JTextField();
        openSignButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        encryptFromFileCheckBox = new javax.swing.JCheckBox();
        signFromFileCheckBox = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(675, 515));

        jLabel1.setText("To");

        jLabel2.setText("Subject");

        jLabel3.setText("Cc");

        msgTextField.setColumns(20);
        msgTextField.setRows(5);
        jScrollPane1.setViewportView(msgTextField);

        encryptCheckBox.setText("Encrypt");
        encryptCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptCheckBoxActionPerformed(evt);
            }
        });

        keyEncryptTextField.setEnabled(false);

        keyEncryptLabel.setText("Key");
        keyEncryptLabel.setEnabled(false);

        openEncryptButton.setText("Open");
        openEncryptButton.setEnabled(false);
        openEncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEncryptButtonActionPerformed(evt);
            }
        });

        signCheckBox.setText("Digital Signature");
        signCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signCheckBoxActionPerformed(evt);
            }
        });

        signLabel.setText("Signature");
        signLabel.setEnabled(false);

        signTextField.setEnabled(false);

        openSignButton.setText("Open");
        openSignButton.setEnabled(false);

        jButton4.setText("Send");

        encryptFromFileCheckBox.setText("From File");
        encryptFromFileCheckBox.setEnabled(false);
        encryptFromFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptFromFileCheckBoxActionPerformed(evt);
            }
        });

        signFromFileCheckBox.setText("From File");
        signFromFileCheckBox.setEnabled(false);
        signFromFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signFromFileCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(subjectTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toTextField)
                            .addComponent(ccTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signFromFileCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(openSignButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(encryptFromFileCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openEncryptButton))
                    .addComponent(keyEncryptTextField)
                    .addComponent(signTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signCheckBox)
                            .addComponent(encryptCheckBox)
                            .addComponent(keyEncryptLabel)
                            .addComponent(signLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(encryptCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyEncryptLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyEncryptTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openEncryptButton)
                            .addComponent(encryptFromFileCheckBox))
                        .addGap(48, 48, 48)
                        .addComponent(signCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openSignButton)
                            .addComponent(signFromFileCheckBox))
                        .addGap(0, 132, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openEncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openEncryptButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openEncryptButtonActionPerformed

    private void encryptCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean b = encryptCheckBox.isSelected();
        keyEncryptLabel.setEnabled(b);
        keyEncryptTextField.setEnabled(b);
        encryptFromFileCheckBox.setEnabled(b);
        fromFileEncrypt(encryptFromFileCheckBox.isSelected());
    }//GEN-LAST:event_encryptCheckBoxActionPerformed

    private void signCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean b = signCheckBox.isSelected();
        signLabel.setEnabled(b);
        signTextField.setEnabled(b);
        signFromFileCheckBox.setEnabled(b);
        fromFileSign(signFromFileCheckBox.isSelected());
    }//GEN-LAST:event_signCheckBoxActionPerformed

    private void encryptFromFileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptFromFileCheckBoxActionPerformed
        // TODO add your handling code here:
        fromFileEncrypt(encryptFromFileCheckBox.isSelected());
    }//GEN-LAST:event_encryptFromFileCheckBoxActionPerformed

    private void signFromFileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signFromFileCheckBoxActionPerformed
        // TODO add your handling code here:
        fromFileSign(signFromFileCheckBox.isSelected());
    }//GEN-LAST:event_signFromFileCheckBoxActionPerformed

    private void fromFileEncrypt(boolean b) {
        if (encryptFromFileCheckBox.isEnabled()) {
            keyEncryptTextField.setEnabled(!b);
            openEncryptButton.setEnabled(b);
        } else {
            keyEncryptTextField.setEnabled(false);
            openEncryptButton.setEnabled(false);
        }
    }
    
    private void fromFileSign(boolean b) {
        if (signFromFileCheckBox.isEnabled()) {
            signTextField.setEnabled(!b);
            openSignButton.setEnabled(b);
        } else {
            signTextField.setEnabled(false);
            openSignButton.setEnabled(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ccTextField;
    private javax.swing.JCheckBox encryptCheckBox;
    private javax.swing.JCheckBox encryptFromFileCheckBox;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel keyEncryptLabel;
    private javax.swing.JTextField keyEncryptTextField;
    private javax.swing.JTextArea msgTextField;
    private javax.swing.JButton openEncryptButton;
    private javax.swing.JButton openSignButton;
    private javax.swing.JCheckBox signCheckBox;
    private javax.swing.JCheckBox signFromFileCheckBox;
    private javax.swing.JLabel signLabel;
    private javax.swing.JTextField signTextField;
    private javax.swing.JTextField subjectTextField;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables
}