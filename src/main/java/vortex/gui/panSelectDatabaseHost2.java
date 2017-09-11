/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vortex.gui;

import java.awt.GridBagLayout;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import vortex.util.Config;
import vortex.util.ConnectionManager;

/**
 *
 * @author Nikolay Samusik
 */
public class panSelectDatabaseHost2 extends javax.swing.JPanel {

    /**
     * Creates new form panSelectDatabaseHost2
     */
    public panSelectDatabaseHost2() {
        initComponents();
        DefaultComboBoxModel cm = getCBMwithDBHosts();
        cmbConnection.setModel(cm);
        cmbConnection.setSelectedItem(Config.getDefaultDatabaseHost());
        this.setLayout(new GridBagLayout());
        this.invalidate();
        this.validate();
    }

    private DefaultComboBoxModel getCBMwithDBHosts() {
        ConnectionManager.DatabaseHost[] h = Config.getAvailableDatabaseHosts();
        DefaultComboBoxModel cm = new DefaultComboBoxModel();
        cm.addElement("--New host connection--");
        for (ConnectionManager.DatabaseHost databaseHost : h) {
            cm.addElement(databaseHost);
        }
        return cm;
    }

    public JPanel getContentPane() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        cmbConnection = new samusik.glasscmp.GlassComboBox();
        cmdDelete1 = new samusik.glasscmp.GlassButton();
        cmdBrowseFile = new samusik.glasscmp.GlassButton();
        txtHSQLDB_FilePath = new samusik.glasscmp.GlassEdit();
        jLabel7 = new javax.swing.JLabel();
        txtInstanceName = new samusik.glasscmp.GlassEdit();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Select database server connection:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(84, 327, 0, 0);
        add(jLabel1, gridBagConstraints);

        cmbConnection.setMaximumSize(new java.awt.Dimension(32767, 28));
        cmbConnection.setMinimumSize(new java.awt.Dimension(62, 28));
        cmbConnection.setPreferredSize(new java.awt.Dimension(62, 28));
        cmbConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConnectionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 757;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        add(cmbConnection, gridBagConstraints);

        cmdDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close.png"))); // NOI18N
        cmdDelete1.setToolTipText("Delete connection");
        cmdDelete1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdDelete1.setIconTextGap(0);
        cmdDelete1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cmdDelete1.setMaximumSize(new java.awt.Dimension(36, 32));
        cmdDelete1.setMinimumSize(new java.awt.Dimension(36, 32));
        cmdDelete1.setPreferredSize(new java.awt.Dimension(36, 32));
        cmdDelete1.setVerifyInputWhenFocusTarget(false);
        cmdDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDelete1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        add(cmdDelete1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(cmdBrowseFile, "Browse");
        cmdBrowseFile.setToolTipText("New dataset");
        cmdBrowseFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdBrowseFile.setIconTextGap(0);
        cmdBrowseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cmdBrowseFile.setMaximumSize(new java.awt.Dimension(60, 29));
        cmdBrowseFile.setMinimumSize(new java.awt.Dimension(60, 29));
        cmdBrowseFile.setPreferredSize(new java.awt.Dimension(60, 29));
        cmdBrowseFile.setVerifyInputWhenFocusTarget(false);
        cmdBrowseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBrowseFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(cmdBrowseFile, gridBagConstraints);

        txtHSQLDB_FilePath.setMinimumSize(new java.awt.Dimension(62, 29));
        txtHSQLDB_FilePath.setPreferredSize(new java.awt.Dimension(62, 29));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 757;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtHSQLDB_FilePath, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, "Path to the local directory where the database is (will be) stored:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 256, 0, 0);
        add(jLabel7, gridBagConstraints);

        txtInstanceName.setMinimumSize(new java.awt.Dimension(62, 28));
        txtInstanceName.setPreferredSize(new java.awt.Dimension(62, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 757;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 85, 0);
        add(txtInstanceName, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, "Database name (cannot be empty)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 329, 0, 0);
        add(jLabel9, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbConnectionActionPerformed
        if (cmbConnection.getSelectedItem() instanceof ConnectionManager.DatabaseHost) {
            ConnectionManager.DatabaseHost host = (ConnectionManager.DatabaseHost) cmbConnection.getSelectedItem();
            txtHSQLDB_FilePath.setText(host.address);
            txtInstanceName.setText(host.instanceName);
            if (host.instanceName.equals("local file")) {
                txtInstanceName.setText(host.address.substring(host.address.lastIndexOf(File.separator) + 1, host.address.length()));
                txtHSQLDB_FilePath.setText(host.address.substring(0, host.address.lastIndexOf(File.separator)));
            }

        } else {
            cmbConnection.setSelectedIndex(-1);
            txtHSQLDB_FilePath.setText(null);
            txtInstanceName.setText(null);
        }
    }//GEN-LAST:event_cmbConnectionActionPerformed

    private void cmdDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDelete1ActionPerformed
        if (cmbConnection.getSelectedItem() instanceof ConnectionManager.DatabaseHost) {
            Config.removeDatabaseHost((ConnectionManager.DatabaseHost) cmbConnection.getSelectedItem());
            cmbConnection.removeItem(cmbConnection.getSelectedItem());
        }
    }//GEN-LAST:event_cmdDelete1ActionPerformed

    private void cmdBrowseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBrowseFileActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            if (f != null) {
                txtHSQLDB_FilePath.setText(f.getPath());
            }
        }
    }//GEN-LAST:event_cmdBrowseFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private samusik.glasscmp.GlassComboBox cmbConnection;
    private samusik.glasscmp.GlassButton cmdBrowseFile;
    private samusik.glasscmp.GlassButton cmdDelete1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private samusik.glasscmp.GlassEdit txtHSQLDB_FilePath;
    private samusik.glasscmp.GlassEdit txtInstanceName;
    // End of variables declaration//GEN-END:variables
}
