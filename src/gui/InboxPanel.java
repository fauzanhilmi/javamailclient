/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import com.google.api.services.gmail.model.Message;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamailclient.GmailAPI;
import javax.mail.MessagingException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class InboxPanel extends javax.swing.JPanel {

    /**
     * Creates new form InboxPanel
     */
    public InboxPanel() {
        initComponents();
    }

    public void generate() {
        Message[] arrMsg = GmailAPI.Inbox.toArray(new Message[GmailAPI.Inbox.size()]);
        InboxList = new JList(arrMsg);
        InboxList.setCellRenderer(new DefaultListCellRenderer() { // Setting the DefaultListCellRenderer
           public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                Message message = ( Message )value;  // Using value we are getting the object in JList
                Map<String,String> map = null;
                try {
                    map = GmailAPI.getMessageDetails(message.getId());
                } catch (MessagingException ex) {
                    Logger.getLogger(InboxPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InboxPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                String sub = map.get("subject");
                if(map.get("subject").length()>22) {
                    sub = map.get("subject").substring(0,20)+"...";
                }
                setText( sub );  // Setting the text
                //setIcon( shape.getImage() ); // Setting the Image Icon
                return this;
            }
        });
        InboxList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        InboxList.setLayoutOrientation(JList.VERTICAL);
        InboxList.setVisibleRowCount(-1);
        jScrollPane1.setViewportView(InboxList);
        
        InboxList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                try {
                    JList list = (JList)evt.getSource();
                    int index = list.locationToIndex(evt.getPoint());
                    String id = arrMsg[index].getId();
                    Map<String,String> map = GmailAPI.getMessageDetails(id);
                    jTextField1.setText(map.get("from"));
                    jTextField2.setText(map.get("subject"));
                    dateTextField.setText(map.get("senddate"));
                    BodyTextPane.setText(map.get("body"));
                    BodyTextPane.setContentType("text/html");
                    //BodyTextArea.setCo
                } catch (IOException ex) {
                    Logger.getLogger(InboxPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(InboxPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        InboxList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        decryptCheckBox = new javax.swing.JCheckBox();
        keyDecryptLabel = new javax.swing.JLabel();
        keyDecryptTextField = new javax.swing.JTextField();
        decryptFromFileCheckBox = new javax.swing.JCheckBox();
        openDecryptButton = new javax.swing.JButton();
        verifyCheckBox = new javax.swing.JCheckBox();
        verifyLabel = new javax.swing.JLabel();
        verifyTextField = new javax.swing.JTextField();
        verifyFromFileCheckBox = new javax.swing.JCheckBox();
        openVerifyButton = new javax.swing.JButton();
        decyptButton = new javax.swing.JButton();
        verifyButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        BodyTextPane = new javax.swing.JTextPane();

        InboxList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(InboxList);

        jLabel1.setText("From");

        jLabel2.setText("Subject");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("<<");

        jButton2.setText(">>");

        decryptCheckBox.setText("Decrypt");
        decryptCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptCheckBoxActionPerformed(evt);
            }
        });

        keyDecryptLabel.setText("Key");
        keyDecryptLabel.setEnabled(false);

        keyDecryptTextField.setEnabled(false);

        decryptFromFileCheckBox.setText("File");
        decryptFromFileCheckBox.setEnabled(false);
        decryptFromFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptFromFileCheckBoxActionPerformed(evt);
            }
        });

        openDecryptButton.setText("Open");
        openDecryptButton.setEnabled(false);
        openDecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDecryptButtonActionPerformed(evt);
            }
        });

        verifyCheckBox.setText("Verify");
        verifyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyCheckBoxActionPerformed(evt);
            }
        });

        verifyLabel.setText("Key");
        verifyLabel.setEnabled(false);

        verifyTextField.setEnabled(false);

        verifyFromFileCheckBox.setText("File");
        verifyFromFileCheckBox.setEnabled(false);
        verifyFromFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyFromFileCheckBoxActionPerformed(evt);
            }
        });

        openVerifyButton.setText("Open");
        openVerifyButton.setEnabled(false);
        openVerifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openVerifyButtonActionPerformed(evt);
            }
        });

        decyptButton.setText("Decrypt");

        verifyButton.setText("Verify");

        jLabel3.setText("Date");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setViewportView(BodyTextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(keyDecryptTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(verifyFromFileCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(openVerifyButton))
                            .addComponent(verifyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decryptCheckBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keyDecryptLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verifyCheckBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verifyLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decyptButton, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(decryptFromFileCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(openDecryptButton))
                            .addComponent(verifyTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTextField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(decryptCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(keyDecryptLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(keyDecryptTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(openDecryptButton)
                                    .addComponent(decryptFromFileCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(decyptButton)
                                .addGap(14, 14, 14)
                                .addComponent(verifyCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(openVerifyButton)
                                    .addComponent(verifyFromFileCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifyButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void decryptCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean b = decryptCheckBox.isSelected();
        keyDecryptLabel.setEnabled(b);
        keyDecryptTextField.setEnabled(b);
        decryptFromFileCheckBox.setEnabled(b);
        fromFileDecrypt(decryptFromFileCheckBox.isSelected());
    }//GEN-LAST:event_decryptCheckBoxActionPerformed

    private void decryptFromFileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptFromFileCheckBoxActionPerformed
        // TODO add your handling code here:
        fromFileDecrypt(decryptFromFileCheckBox.isSelected());
    }//GEN-LAST:event_decryptFromFileCheckBoxActionPerformed

    private void openDecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDecryptButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openDecryptButtonActionPerformed

    private void verifyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean b = verifyCheckBox.isSelected();
        verifyLabel.setEnabled(b);
        verifyTextField.setEnabled(b);
        verifyFromFileCheckBox.setEnabled(b);
        fromFileVerify(verifyFromFileCheckBox.isSelected());
    }//GEN-LAST:event_verifyCheckBoxActionPerformed

    private void verifyFromFileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyFromFileCheckBoxActionPerformed
        // TODO add your handling code here:
        fromFileVerify(verifyFromFileCheckBox.isSelected());
    }//GEN-LAST:event_verifyFromFileCheckBoxActionPerformed

     private void fromFileDecrypt(boolean b) {
        if (decryptFromFileCheckBox.isEnabled()) {
            keyDecryptTextField.setEnabled(!b);
            openDecryptButton.setEnabled(b);
        } else {
            keyDecryptTextField.setEnabled(false);
            openDecryptButton.setEnabled(false);
        }
    }
    
    private void fromFileVerify(boolean b) {
        if (verifyFromFileCheckBox.isEnabled()) {
            verifyTextField.setEnabled(!b);
            openVerifyButton.setEnabled(b);
        } else {
            verifyTextField.setEnabled(false);
            openVerifyButton.setEnabled(false);
        }
    }
    
    private void openVerifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openVerifyButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int retrieval = chooser.showOpenDialog(null);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Public file", "pub");
        chooser.setFileFilter(filter);
        if (retrieval == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Path path = Paths.get(file.getAbsolutePath());
            try {
                String s = new String(Files.readAllBytes(path));
                verifyTextField.setText(s);
            } catch (IOException ex) {

            }
        }
    }//GEN-LAST:event_openVerifyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane BodyTextPane;
    private javax.swing.JList InboxList;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JCheckBox decryptCheckBox;
    private javax.swing.JCheckBox decryptFromFileCheckBox;
    private javax.swing.JButton decyptButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel keyDecryptLabel;
    private javax.swing.JTextField keyDecryptTextField;
    private javax.swing.JButton openDecryptButton;
    private javax.swing.JButton openVerifyButton;
    private javax.swing.JButton verifyButton;
    private javax.swing.JCheckBox verifyCheckBox;
    private javax.swing.JCheckBox verifyFromFileCheckBox;
    private javax.swing.JLabel verifyLabel;
    private javax.swing.JTextField verifyTextField;
    // End of variables declaration//GEN-END:variables
}
