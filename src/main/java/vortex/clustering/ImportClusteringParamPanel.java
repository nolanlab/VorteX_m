/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImportClusteringParamPanel.java
 *
 * Created on 31-Mar-2011, 03:39:53
 */
package vortex.clustering;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import util.DefaultEntry;
import util.IO;
import util.logger;

/**
 *
 * @author Nikolay
 */
public class ImportClusteringParamPanel extends javax.swing.JPanel {

    /**
     * Creates new form ImportClusteringParamPanel
     */
    public ImportClusteringParamPanel() {
        initComponents();
        
    }
    

    public String getClusteringMethodName() {
        return txtMethod.getText();
    }

    public Entry<String, ArrayList<String[]>>[] getProfileIDLists() {
        String txt = jTextArea1.getText();
        String[] s2 = txt.split("\n");
        Entry<String, ArrayList<String[]>>[] out = new Entry[s2.length];
        for (int i = 0; i < out.length; i++) {
            String line = s2[i];
            String[] s3 = line.split("\t");

            if (s3.length == 1) {
                throw new IllegalArgumentException("Illegal format on line #" + (i + 1) + ": missing tab");
            }

            String param = s3[0];
            String[] cl = s3[1].split("\\|");
            ArrayList<String[]> cm = new ArrayList<>();
            for (String cluster : cl) {
                cm.add(cluster.split(","));
            }
            out[i] = new DefaultEntry<>(param, cm);
        }
        return out;
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtMethod = new samusik.glasscmp.GlassEdit();
        jLabel2 = new javax.swing.JLabel();
        cmdDeleteDataset = new samusik.glasscmp.GlassButton();

        setOpaque(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Paste cluster sets here, one per row. First column parameter setting, then tab, then clusters separated by \"|\" EventIDs separated by \",\". You can look up eventIDs by exporting any clustering to CSV");

        jLabel2.setText("Clustering method name");

        cmdDeleteDataset.setText("Add Index files");
        cmdDeleteDataset.setToolTipText("Delete dataset");
        cmdDeleteDataset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdDeleteDataset.setIconTextGap(0);
        cmdDeleteDataset.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cmdDeleteDataset.setMaximumSize(new java.awt.Dimension(36, 35));
        cmdDeleteDataset.setMinimumSize(new java.awt.Dimension(36, 35));
        cmdDeleteDataset.setPreferredSize(new java.awt.Dimension(36, 35));
        cmdDeleteDataset.setVerifyInputWhenFocusTarget(false);
        cmdDeleteDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteDatasetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(cmdDeleteDataset, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdDeleteDataset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDeleteDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteDatasetActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        fc.showOpenDialog(this);
        if(jTextArea1.getText().contains("\t"))jTextArea1.setText(jTextArea1.getText()+"\n");
        for(File f : fc.getSelectedFiles()){
        if (f != null) {
            try {
                ArrayList<Integer> al = IO.getListOfIntegersFromStream(new FileInputStream(f), -1);

                ArrayList<Entry<Integer, Integer>> al2 = new ArrayList<>();

                for (int i = 0; i < al.size(); i++) {
                    if(al.get(i)>=0){
                    al2.add(new DefaultEntry<>(i, al.get(i)));
                    }
                }

                Collections.sort(al2, new Comparator<Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });

                StringBuilder sb = new StringBuilder();
                
                String filename =f.getName();//.split("\\.")[0];
                logger.print(filename, filename.lastIndexOf(" "));
                double freeParam = -1.0;
                try{
                     freeParam= Double.parseDouble(filename.substring(filename.lastIndexOf(" ")+1,filename.length()));
                      sb.append(String.valueOf(freeParam) + "\t");
                }catch(NumberFormatException n){
                    sb.append(JOptionPane.showInputDialog("Free parameter value (file: "+f.getName()+")",String.valueOf(freeParam)) + "\t");
                }
                
                for (int i = 1; i < al2.size(); i++) {
                    sb.append(al2.get(i).getKey());
                    sb.append((al2.get(i).getValue().equals(al2.get(i - 1).getValue())) ? "," : "|");
                }

                jTextArea1.setText(jTextArea1.getText() + sb.toString()+(f.equals(fc.getSelectedFiles()[fc.getSelectedFiles().length-1])?"":"\n"));
            } catch (FileNotFoundException ex) {
                logger.showException(ex);
            }
        }
        }

    }//GEN-LAST:event_cmdDeleteDatasetActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private samusik.glasscmp.GlassButton cmdDeleteDataset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private samusik.glasscmp.GlassEdit txtMethod;
    // End of variables declaration//GEN-END:variables
}
