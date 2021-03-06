/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.JToggleButton.ToggleButtonModel;

/**
 *
 * @author POSITIVITY
 */
public class Promotion extends javax.swing.JFrame {
    String color="B";
    String select;
    Icon wQ = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhiteQueen.png"));
    Icon bQ = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackQueen.png"));
    
    Icon wR= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhiteRook.png"));
    Icon bR= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackRook.png"));
    
    Icon wB = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhiteBishop.png"));
    Icon bB = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackBishop.png"));
    
    Icon wK= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhiteKnight.png"));
    Icon bK= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackKnight.png"));

    Map<JCheckBox,String> pairing = new HashMap<JCheckBox,String>();/**
     * Creates new form Promotion
     */
    public Promotion(String p) {
        initComponents();
        color=p;
        setIcons();
        setTitle("Pun Promotion");
        pair();
    }
    public Promotion() {
        initComponents();
        setIcons();
        setTitle("Pun Promotion");
        pair();
    }
    void setIcons(){
        if(color.equals("W")){
            iQ.setIcon(wQ);
            iR.setIcon(wR);
            iB.setIcon(wB);
            iK.setIcon(wK);
        } else {
            iQ.setIcon(bQ);
            iR.setIcon(bR);
            iB.setIcon(bB);
            iK.setIcon(bK);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        cQ = new javax.swing.JCheckBox();
        iQ = new javax.swing.JLabel();
        iR = new javax.swing.JLabel();
        cR = new javax.swing.JCheckBox();
        iB = new javax.swing.JLabel();
        cB = new javax.swing.JCheckBox();
        iK = new javax.swing.JLabel();
        cK = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 0));

        buttonGroup1.add(cQ);
        cQ.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        cQ.setText("Queen");

        buttonGroup1.add(cR);
        cR.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        cR.setText("Rook");

        buttonGroup1.add(cB);
        cB.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        cB.setText("Bishop");

        buttonGroup1.add(cK);
        cK.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        cK.setText("Knight");

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe Script", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 255));
        jButton1.setText("Accept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iK, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(iR, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(iQ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cQ, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cK, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cR, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(iQ, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iR, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iB, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(cQ, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cR, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cK, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String n;
                if(buttonGroup1.getSelection()!=null){
                if(cQ.isSelected()){
                   n= pairing.get(cQ);
                } else if(cR.isSelected()){
                   n= pairing.get(cR);
                } else if(cB.isSelected()){
                   n= pairing.get(cB);
                } else {
                   n= pairing.get(cK);
                }
                int a = JOptionPane.showConfirmDialog(null, "Promote to "+n + "?","Prompt" ,JOptionPane.YES_NO_OPTION);
                if(a==JOptionPane.YES_OPTION){
                    setVisible(false);
                } else {
                    buttonGroup1.clearSelection();
                }
            }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pair(){
        pairing.put(cQ,"Queen");
        pairing.put(cR,"Rook");
        pairing.put(cB,"Bishop");
        pairing.put(cK,"Knight");
    }    
    
    String getSelected(){
        return select;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Promotion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cB;
    private javax.swing.JCheckBox cK;
    private javax.swing.JCheckBox cQ;
    private javax.swing.JCheckBox cR;
    private javax.swing.JLabel iB;
    private javax.swing.JLabel iK;
    private javax.swing.JLabel iQ;
    private javax.swing.JLabel iR;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
