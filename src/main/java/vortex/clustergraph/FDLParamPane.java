/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vortex.clustergraph;

import sandbox.annotations.Annotation;
import sandbox.clustering.AngularDistance;
import sandbox.clustering.Dataset;
import sandbox.clustering.DistanceMeasure;
import sandbox.clustering.EuclideanDistance;
import sandbox.clustering.NoiseSuppressingAngularDistance;
import sandbox.clustering.NoiseSuppressingEuclideanDistance;
import java.awt.Component;
import java.util.stream.Stream;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Nikolay Samusik
 */
public class FDLParamPane extends javax.swing.JPanel {

    /**
     * Creates new form FDLParamPane
     */
    String[] getSelectedAnnTerms() {
        if (!chkLimitByAnn.isSelected()) {
            return new String[0];
        }
        String[] out = ((Stream<String>) lst.getSelectedItems().stream().map(c -> c.toString())).toArray(String[]::new);
        return out;
    }

    Annotation getSelectedAnnotation() {
        if (!chkLimitByAnn.isSelected()) {
            return null;
        }
        return (Annotation) cmbLimitByAnn.getSelectedItem();
    }

    public FDLParamPane(Dataset ds) {
        initComponents();
        chkLimitByAnnActionPerformed(null);
        cmbParam.setModel(new DefaultComboBoxModel<>(ds.getFeatureNamesCombined()));
        cmbLimitByAnn.setModel(new DefaultComboBoxModel<>(ds.getAnnotations()));
    }

    public DistanceMeasure getDM() {
        switch (cmbDM.getSelectedItem().toString()) {
            case "Angular Distance":
                return new AngularDistance();
            case "Euclidean Distance":
                return new EuclideanDistance();
            case "Noise Suppressing Euclidean Distance":
                return new NoiseSuppressingEuclideanDistance();
            case "Noise Suppressing Angular Distance":
                return new NoiseSuppressingAngularDistance();
            default:
                throw new IllegalStateException("Unrecognized distance measure: " + cmbDM.getSelectedItem().toString());

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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbDM = new javax.swing.JComboBox<>();
        spinNumNodes = new javax.swing.JSpinner();
        spinNN = new javax.swing.JSpinner();
        lblParamName = new javax.swing.JLabel();
        lblParamRange = new javax.swing.JLabel();
        spinParamRange = new javax.swing.JSpinner();
        chkLim = new javax.swing.JCheckBox();
        cmbParam = new javax.swing.JComboBox<>();
        chkProportional = new javax.swing.JCheckBox();
        spinPower = new javax.swing.JSpinner();
        chkVary = new javax.swing.JCheckBox();
        chkLimitByAnn = new javax.swing.JCheckBox();
        panAnn = new javax.swing.JPanel();
        cmbLimitByAnn = new javax.swing.JComboBox<Annotation>();
        lst = new samusik.glasscmp.GlassListSelector();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Maximum number of events to be sampled from each cluster:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(jLabel1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "Distance measure:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(jLabel2, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "Num. nearest neighbors");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(jLabel3, gridBagConstraints);

        cmbDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Angular Distance", "Euclidean Distance", "Noise Suppressing Euclidean Distance", "Noise Suppressing Angular Distance" }));
        cmbDM.setMinimumSize(new java.awt.Dimension(114, 25));
        cmbDM.setPreferredSize(new java.awt.Dimension(114, 25));
        cmbDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDMActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(cmbDM, gridBagConstraints);

        spinNumNodes.setModel(new javax.swing.SpinnerNumberModel(1000, 1, null, 1));
        spinNumNodes.setMinimumSize(new java.awt.Dimension(63, 20));
        spinNumNodes.setPreferredSize(new java.awt.Dimension(63, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(spinNumNodes, gridBagConstraints);

        spinNN.setModel(new javax.swing.SpinnerNumberModel(10, 2, 1000, 1));
        spinNN.setPreferredSize(new java.awt.Dimension(63, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(spinNN, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(lblParamName, "Parameter name:");
        lblParamName.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(lblParamName, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(lblParamRange, "Parameter range (+/-):");
        lblParamRange.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(lblParamRange, gridBagConstraints);

        spinParamRange.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, null, 1.0d));
        spinParamRange.setEnabled(false);
        spinParamRange.setMinimumSize(new java.awt.Dimension(63, 20));
        spinParamRange.setPreferredSize(new java.awt.Dimension(63, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(spinParamRange, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(chkLim, "Limit connections to events within parameter range (e.g. time)");
        chkLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLimActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(chkLim, gridBagConstraints);

        cmbParam.setEnabled(false);
        cmbParam.setPreferredSize(new java.awt.Dimension(28, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(cmbParam, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(chkProportional, "Sample proportionally to the power of cluster size: ");
        chkProportional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkProportionalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(chkProportional, gridBagConstraints);

        spinPower.setModel(new javax.swing.SpinnerNumberModel(0.33d, 0.0d, 1.0d, 1.0d));
        spinPower.setEnabled(false);
        spinPower.setMinimumSize(new java.awt.Dimension(63, 20));
        spinPower.setPreferredSize(new java.awt.Dimension(63, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(spinPower, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(chkVary, "Vary the number of node connections by node density");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(chkVary, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(chkLimitByAnn, "Include cells only from certain annotation groups");
        chkLimitByAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLimitByAnnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(chkLimitByAnn, gridBagConstraints);

        panAnn.setMinimumSize(new java.awt.Dimension(144, 300));
        panAnn.setPreferredSize(new java.awt.Dimension(144, 300));
        panAnn.setLayout(new java.awt.GridBagLayout());

        cmbLimitByAnn.setPreferredSize(new java.awt.Dimension(28, 25));
        cmbLimitByAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLimitByAnnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panAnn.add(cmbLimitByAnn, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panAnn.add(lst, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, "Available terms");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        panAnn.add(jLabel6, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, "Selected terms");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        panAnn.add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(panAnn, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void chkLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLimActionPerformed
        for (Component c : new Component[]{cmbParam, lblParamName, lblParamRange, spinParamRange}) {
            c.setEnabled(chkLim.isSelected());
        }
    }//GEN-LAST:event_chkLimActionPerformed

    private void cmbDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDMActionPerformed

    private void chkProportionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkProportionalActionPerformed
        spinPower.setEnabled(chkProportional.isSelected());
    }//GEN-LAST:event_chkProportionalActionPerformed

    private void chkLimitByAnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLimitByAnnActionPerformed
        panAnn.setEnabled(chkLimitByAnn.isSelected());
        lst.setEnabled(chkLimitByAnn.isSelected());
        cmbLimitByAnn.setEnabled(chkLimitByAnn.isSelected());
        if (!chkLimitByAnn.isSelected()) {
            lst.getAvailableListModel().clear();
            lst.getSelectedListModel().clear();
        }
    }//GEN-LAST:event_chkLimitByAnnActionPerformed

    private void cmbLimitByAnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLimitByAnnActionPerformed
        Annotation a = (Annotation) cmbLimitByAnn.getSelectedItem();
        lst.clear();
        for (String s : a.getTerms()) {
            lst.getAvailableListModel().addElement(s);
        }

    }//GEN-LAST:event_cmbLimitByAnnActionPerformed

    public boolean proportionalSampling() {
        return chkProportional.isSelected();
    }

    public boolean varyConn() {
        return chkVary.isSelected();
    }

    public double power() {
        return (Double) spinPower.getValue();
    }

    public int getNumNodes() {
        return (Integer) spinNumNodes.getValue();
    }

    public int getKNN() {
        return (Integer) spinNN.getValue();
    }

    public int getRestrictionParam() {
        return limitByParam() ? cmbParam.getSelectedIndex() : -1;
    }

    public double getRestrictionParamRange() {
        return (Double) spinParamRange.getValue();
    }

    public boolean limitByParam() {
        return chkLim.isSelected();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkLim;
    private javax.swing.JCheckBox chkLimitByAnn;
    private javax.swing.JCheckBox chkProportional;
    private javax.swing.JCheckBox chkVary;
    private javax.swing.JComboBox<String> cmbDM;
    private javax.swing.JComboBox<Annotation> cmbLimitByAnn;
    private javax.swing.JComboBox<String> cmbParam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblParamName;
    private javax.swing.JLabel lblParamRange;
    private samusik.glasscmp.GlassListSelector lst;
    private javax.swing.JPanel panAnn;
    private javax.swing.JSpinner spinNN;
    private javax.swing.JSpinner spinNumNodes;
    private javax.swing.JSpinner spinParamRange;
    private javax.swing.JSpinner spinPower;
    // End of variables declaration//GEN-END:variables
}
