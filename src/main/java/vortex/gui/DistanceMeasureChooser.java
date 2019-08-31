/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DistanceMeasureChooser.java
 *
 * Created on 25-May-2012, 13:48:15
 */
package vortex.gui;

import javax.swing.DefaultComboBoxModel;
import sandbox.clustering.DistanceMeasure;
import vortex.util.ClassWrapper;
import util.logger;

/**
 *
 * @author Nikolay
 */
public class DistanceMeasureChooser extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form DistanceMeasureChooser
     */
    public DistanceMeasureChooser() {
        initComponents();
        Class<DistanceMeasure>[] c = DistanceMeasure.getAvailableSubclasses();
        for (Class<DistanceMeasure> c1 : c) {
            try {
                ((DefaultComboBoxModel) cmbDistanceMeasure.getModel()).addElement(c1.getConstructor().newInstance());
            } catch (Exception e) {
                logger.showException(e);
            }
        }
        if (cmbDistanceMeasure.getItemCount() > 0) {
            cmbDistanceMeasure.setSelectedIndex(0);
        }
    }

    public DistanceMeasure getDistanceMeasure() {
        if (cmbDistanceMeasure.getSelectedIndex() == -1) {
            return null;
        }
        DistanceMeasure dm = (DistanceMeasure) cmbDistanceMeasure.getSelectedItem();
        return dm;
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

        cmbDistanceMeasure = new samusik.glasscmp.GlassComboBox();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        cmbDistanceMeasure.setMinimumSize(new java.awt.Dimension(34, 28));
        cmbDistanceMeasure.setPreferredSize(new java.awt.Dimension(34, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(cmbDistanceMeasure, gridBagConstraints);

        jLabel1.setText("Distance measure:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(jLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private samusik.glasscmp.GlassComboBox cmbDistanceMeasure;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
