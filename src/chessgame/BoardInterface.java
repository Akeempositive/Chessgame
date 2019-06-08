/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import chessgame.pieces.Knight;
import chessgame.pieces.Piece;
import chessgame.pieces.Rook;
import chessgame.pieces.Bishop;
import chessgame.pieces.King;
import chessgame.pieces.Pun;
import chessgame.pieces.Queen;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author POSITIVITY
 */
public class BoardInterface extends javax.swing.JFrame {
    //Variable(s) declaration
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     
    boolean whiteCastling=true, blackCastling=true;
    boolean whiteQueenRook=true, whiteKingRook=true, blackQueenRook=true, blackKingRook=true; 
    boolean againstCPU=false;
    private Map<String, Icon> capturableSpots= new HashMap<String, Icon>();
    
    Icon wWhiteP=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhitePun.png"));
    Icon bWhiteP=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhitePun.png"));
    
    Icon wWhiteK=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhiteKing.png"));
    Icon bWhiteK=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhiteKing.png"));
    
    Icon wWhiteQ = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhiteQueen.png"));
    Icon bWhiteQ = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhiteQueen.png"));
    
    Icon wWhiteR= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhiteRook.png"));
    Icon bWhiteR= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhiteRook.png"));
    
    Icon wWhiteB = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhiteBishop.png"));
    Icon bWhiteB = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhiteBishop.png"));
    
    Icon wWhiteKn= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteWhiteKnight.png"));
    Icon bWhiteKn= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackWhiteKnight.png"));
    
    
    
    Icon wBlackP=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackPun.png"));
    Icon bBlackP=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackPun.png"));
    
    Icon wBlackK=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackKing.png"));
    Icon bBlackK=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackKing.png"));
    
    Icon wBlackQ = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackQueen.png"));
    Icon bBlackQ = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackQueen.png"));
    
    Icon wBlackR= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackRook.png"));
    Icon bBlackR= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackRook.png"));
    
    Icon wBlackB = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackBishop.png"));
    Icon bBlackB = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackBishop.png"));
    
    Icon wBlackKn= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "whiteBlackKnight.png"));
    Icon bBlackKn= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "blackBlackKnight.png"));
    
    Icon bPTC=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "bPTC.png"));
    Icon wPTC=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "wPTC.png"));
    
    Icon bBTC=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "bBTC.png"));
    Icon wBTC=new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "wBTC.png"));
    
    Icon bKnTC = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "bKnTC.png"));
    Icon wKnTC = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "wKnTC.png"));
    Icon bRTC= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "bRTC.png"));
    Icon wRTC= new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "wRTC.png"));
    Icon wQTC = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "wQTC.png"));
    Icon bQTC = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Constants.IMG_DIR + "bQTC.png"));
    JButton initialClicked,finalClicked;
    Map<JButton, String> board = new HashMap<JButton, String>();
    Map<String, JButton> board2 = new HashMap<String,JButton>();
    ArrayList<String> moves;
    ArrayList<Piece> boardPieces= new ArrayList<Piece>();
    Map<String, Piece> gameState1 = new HashMap<String, Piece>();
    Map<Piece, String> gameState2;
    Pun blackPun1=new Pun("bPun1"),blackPun2=new Pun("bPun2"),blackPun3=new Pun("bPun3"),blackPun4=new Pun("bPun4");
    Pun blackPun5=new Pun("bPun5"),blackPun6=new Pun("bPun6"),blackPun7=new Pun("bPun7"),blackPun8=new Pun("bPun8");
    Pun whitePun1= new Pun("wPun1"),whitePun2=new Pun("wPun2"),whitePun3=new Pun("wPun3"),whitePun4=new Pun("wPun4");
    Pun whitePun5=new Pun("wPun5"),whitePun6=new Pun("wPun6"),whitePun7=new Pun("wPun7"),whitePun8=new Pun("wPun8");
    Knight whiteKnight1= new Knight("wKnight1"), whiteKnight2= new Knight("wKnight2"), blackKnight1= new Knight("bKnight1"), blackKnight2=new Knight("bKnight2");
    Bishop whiteWhiteBishop= new Bishop("wWhiteBishop"),whiteBlackBishop= new Bishop("wBlackBishop"),blackWhiteBishop= new Bishop("bWhiteBishop"),blackBlackBishop= new Bishop("bBlackBishop");
    Rook whiteRook1= new Rook("wRook1"),whiteRook2= new Rook("wRook2"),blackRook1= new Rook("bRook1"),blackRook2= new Rook("bRook2");
    Queen whiteQueen= new Queen("wQueen"), blackQueen= new Queen("bQueen");
    King whiteKing= new King("wKing"), blackKing= new King("bKing");
    ArrayList<JButton> labels;String initialSpot, finalSpot,cl="W",enpassantLocation;
    int numberOfMoves= 0;Color initialColor;
    String kingLocations [] = new String[2],promoteTo,promoteL;
    boolean onCheck=false, enpassant,promote;
    Map<JCheckBox,String> pairing = new HashMap<JCheckBox,String>();/**
     * Creates new form Promotion
     */
    void defaultState(){
    gameState1.put("A1W",whiteRook1);
    gameState1.put("B1W",whiteKnight1);
    gameState1.put("C1W",whiteWhiteBishop );
    gameState1.put("D1W",whiteKing);
    gameState1.put("E1W",whiteQueen);
    gameState1.put("F1W",whiteBlackBishop );
    gameState1.put("G1W",whiteKnight2);
    gameState1.put("H1W",whiteRook2);
    
    gameState1.put("A8B",blackRook1);
    gameState1.put("B8B",blackKnight1);
    gameState1.put("C8B",blackBlackBishop);
    gameState1.put("D8B",blackKing);
    gameState1.put("E8B",blackQueen);
    gameState1.put("F8B",blackWhiteBishop);
    gameState1.put("G8B",blackKnight2);
    gameState1.put("H8B",blackRook2 );
    
    gameState1.put("A2W",whitePun1);
    gameState1.put("B2W",whitePun2);
    gameState1.put("C2W",whitePun3);
    gameState1.put("D2W",whitePun4);
    gameState1.put("E2W",whitePun5);
    gameState1.put("F2W",whitePun6);
    gameState1.put("G2W",whitePun7);
    gameState1.put("H2W",whitePun8);
    
    gameState1.put("A7B",blackPun1);
    gameState1.put("B7B",blackPun2);
    gameState1.put("C7B",blackPun3);
    gameState1.put("D7B",blackPun4);
    gameState1.put("E7B",blackPun5);
    gameState1.put("F7B",blackPun6);
    gameState1.put("G7B",blackPun7);
    gameState1.put("H7B",blackPun8);
       
    gameState2= reversedMap(gameState1);
    
    setKingLocations();
}
    Map<Piece, String> reversedMap (Map<String ,Piece> map1){
    Map<Piece,String> map2= new HashMap<Piece,String>();
    for (String k : map1.keySet()){
        map2.put(map1.get(k), k);
    }
    return map2;
}
    Map<String, JButton> reversedMap2 (Map<JButton ,String> map1){
    Map<String, JButton> map2= new HashMap<String,JButton>();
    for (JButton k : map1.keySet()){
        map2.put(map1.get(k), k);
    }
    return map2;
}
    /**
     * Creates new form BoardInterface
     */
    
    public BoardInterface() {
        initComponents();
        defaultState();
        loadBoard();
        setSize(screenSize);
        setTitle("Chess Game");
        setIcons();
        pair();
        promotion.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        status = new javax.swing.JTextField();
        playerMove = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        records = new javax.swing.JTextArea();
        human = new javax.swing.JCheckBox();
        cPU = new javax.swing.JCheckBox();
        promotion = new javax.swing.JInternalFrame();
        iQ = new javax.swing.JLabel();
        cQ = new javax.swing.JCheckBox();
        iR = new javax.swing.JLabel();
        cR = new javax.swing.JCheckBox();
        iB = new javax.swing.JLabel();
        cB = new javax.swing.JCheckBox();
        cK = new javax.swing.JCheckBox();
        iK = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess Game");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));

        status.setEditable(false);
        status.setFont(new java.awt.Font("Sakkal Majalla", 0, 24)); // NOI18N

        playerMove.setEditable(false);
        playerMove.setFont(new java.awt.Font("Sakkal Majalla", 0, 24)); // NOI18N
        playerMove.setText("White Move");

        records.setColumns(20);
        records.setEditable(false);
        records.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        records.setForeground(new java.awt.Color(0, 153, 153));
        records.setRows(5);
        records.setText("\tGame Records\n\nWhite\t\tBlack");
        jScrollPane2.setViewportView(records);

        human.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup2.add(human);
        human.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 18)); // NOI18N
        human.setForeground(new java.awt.Color(0, 102, 102));
        human.setText("Play With Human");
        human.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                humanStateChanged(evt);
            }
        });

        cPU.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup2.add(cPU);
        cPU.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 18)); // NOI18N
        cPU.setForeground(new java.awt.Color(0, 102, 102));
        cPU.setSelected(true);
        cPU.setText("Play With CPU");
        cPU.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cPUStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(status)
                            .addComponent(playerMove, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(human, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cPU, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerMove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(human, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cPU, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(734, Short.MAX_VALUE))
        );

        promotion.setVisible(true);

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

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
        jButton1.setFont(new java.awt.Font("Sakkal Majalla", 3, 24)); // NOI18N
        jButton1.setText("Promote");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout promotionLayout = new javax.swing.GroupLayout(promotion.getContentPane());
        promotion.getContentPane().setLayout(promotionLayout);
        promotionLayout.setHorizontalGroup(
            promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promotionLayout.createSequentialGroup()
                .addGroup(promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(promotionLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(promotionLayout.createSequentialGroup()
                                .addComponent(cB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cK))
                            .addGroup(promotionLayout.createSequentialGroup()
                                .addComponent(iB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iK, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(promotionLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        promotionLayout.setVerticalGroup(
            promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promotionLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, promotionLayout.createSequentialGroup()
                        .addGroup(promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iK, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(promotionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cB)
                            .addComponent(cK, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(promotionLayout.createSequentialGroup()
                        .addComponent(iR, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cR))
                    .addGroup(promotionLayout.createSequentialGroup()
                        .addComponent(iQ, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cQ, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(promotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(promotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(690, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                     
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
    }//GEN-LAST:event_formMousePressed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
                       
    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
           
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(buttonGroup1.getSelection()!=null){
            if(cQ.isSelected()){
                promoteTo= pairing.get(cQ);
            } else if(cR.isSelected()){
                promoteTo= pairing.get(cR);
            } else if(cB.isSelected()){
                promoteTo= pairing.get(cB);
            } else {
                promoteTo= pairing.get(cK);
            }
            int a = JOptionPane.showConfirmDialog(null, "Promote to "+promoteTo + "?","Prompt" ,JOptionPane.YES_NO_OPTION);
            if(a==JOptionPane.YES_OPTION){
                promotion.setVisible(false);
            } else {
                buttonGroup1.clearSelection();
            }
        }    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void humanStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_humanStateChanged
       if(human.isSelected()){
           againstCPU=false;
       }
    }//GEN-LAST:event_humanStateChanged

    private void cPUStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cPUStateChanged
        if(cPU.isSelected()){
            againstCPU=true;
            status.setText("CPU Mode");
        }
    }//GEN-LAST:event_cPUStateChanged

    private void pair(){
        pairing.put(cQ,"Queen");
        pairing.put(cR,"Rook");
        pairing.put(cB,"Bishop");
        pairing.put(cK,"Knight");
    } 
    
    void setIcons(){
        if(cl.equals("W")){
            iQ.setIcon(wWhiteQ);
            iR.setIcon(bWhiteR);
            iB.setIcon(wWhiteB);
            iK.setIcon(bWhiteK);
        } else {
            iQ.setIcon(bBlackQ);
            iR.setIcon(wBlackR);
            iB.setIcon(bBlackB);
            iK.setIcon(wBlackK);
        }
    }
    /**
     * @param args the command line arguments
     */
    
    void loadBoard(){
        labels = createSpots();
        rollback();
        board2=reversedMap2(board);
        putPieces();
        }
    void putPieces(){
          board2.get("A1").setIcon(wWhiteR);board2.get("B1").setIcon(bWhiteKn);board2.get("C1").setIcon(wWhiteB);board2.get("D1").setIcon(bWhiteK);
          board2.get("E1").setIcon(wWhiteQ);board2.get("F1").setIcon(bWhiteB);board2.get("G1").setIcon(wWhiteKn);board2.get("H1").setIcon(bWhiteR);
          board2.get("A2").setIcon(bWhiteP);board2.get("B2").setIcon(wWhiteP);board2.get("C2").setIcon(bWhiteP);board2.get("D2").setIcon(wWhiteP);
          board2.get("E2").setIcon(bWhiteP);board2.get("F2").setIcon(wWhiteP);board2.get("G2").setIcon(bWhiteP);board2.get("H2").setIcon(wWhiteP);
          board2.get("A8").setIcon(bBlackR);board2.get("B8").setIcon(wBlackKn);board2.get("C8").setIcon(bBlackB);board2.get("D8").setIcon(wBlackK);
          board2.get("E8").setIcon(bBlackQ);board2.get("F8").setIcon(wBlackB);board2.get("G8").setIcon(bBlackKn);board2.get("H8").setIcon(wBlackR);
          board2.get("A7").setIcon(wBlackP);board2.get("B7").setIcon(bBlackP);board2.get("C7").setIcon(wBlackP);board2.get("D7").setIcon(bBlackP);
          board2.get("E7").setIcon(wBlackP);board2.get("F7").setIcon(bBlackP);board2.get("G7").setIcon(wBlackP);board2.get("H7").setIcon(bBlackP);
       }
    void rollback(){
        String []column = {"A","B","C","D","E","F","G","H"};
        Color [] colors = {Color.YELLOW, Color.GREEN};
        for (int i =0; i<8;i++){
            int p = i%2;
            int j =0;
            for (String l : column){
                JButton spot = labels.get(i * (column.length) + j);
                spot.setLocation(j * 80 +300, i * 80+10 );
                spot.setBackground(colors[p%2]);
                spot.setVisible(true);
                spot.setText(l + Integer.toString(i+1));
                add(spot);                               
                board.put(spot,l + Integer.toString(i+1));
                j++;
                p++;
            }
        }
    }
    boolean rollback(boolean castMove){
        String []column = {"A","B","C","D","E","F","G","H"};
        Color [] colors = {Color.YELLOW, Color.GREEN};
        for (int i =0; i<8;i++){
            int p = i%2;
            int j =0;
            for (String l : column){
                JButton spot = labels.get(i * (column.length) + j);
                spot.setLocation(j * 80 +300, i * 80+10 );
                if(spot.getBackground().equals(Color.CYAN)){
                    castMove = true;
                }
                spot.setBackground(colors[p%2]);
                spot.setVisible(true);
                spot.setText(l + Integer.toString(i+1));
                add(spot);                               
                board.put(spot,l + Integer.toString(i+1));
                j++;
                p++;
            }
        }
        return castMove;
    }
    void nextMoves(){
        if(numberOfMoves%2==0){
            playerMove.setText("White to move");
            cl= "W";
        }
        else {
             playerMove.setText("Black to move");
             cl = "B";
        }
    }
    ArrayList<JButton> createSpots(){
        ArrayList<JButton> labels = new ArrayList<JButton>();
        int i=0;
        while (i<64){
            final JButton c = new JButton();
             c.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   if(c.getBackground().equals(Color.PINK)||c.getBackground().equals(Color.CYAN)){
                        finalSpot= c.getText();
                        finalClicked=c;
                        onCheck=false;
                        boolean castMove=false;
                        castMove=rollback(castMove);
                        makeMove(initialClicked, finalClicked,castMove);
                        nextMoves();
                        if(isGameOver(cl)){
                            JOptionPane.showMessageDialog(null, cl + " has loss the game","CheckMate", JOptionPane.PLAIN_MESSAGE);
                          }
                        if(promote){
                           // JOptionPane.showMessageDialog(null,"PawnPromotion");
                           // placePromotePiece(promoteL,promoteTo,cl);
                        }
                       if(againstCPU){
                           cl="B";
                           status.setText("CPU is thinking");
                           String bestMove[]={"A7B", "A5B"};
                            bestMove=new ChessEngine(gameState1, kingLocations, cl).miniMaxing(gameState1, cl, 1, 1);
                            System.out.println(bestMove[0]);
                            System.out.println(bestMove[1]);
                            engineMove(bestMove);
                            nextMoves();
                            cl="W";
                       }
                  } else {
                        if(initialClicked!=null){
                        initialClicked.setBackground(initialColor);
                        rollback();
                        }
                        if(!onCheck){
                            String kingL =cl.equals("W")?kingLocations[0]:kingLocations[1];
                            if(new GameEvent(gameState1).isStalemate(kingL, cl, alt(cl), gameState2)){
                                status.setText("StaleMate");
                            }
                        }
                        JButton j =(JButton)e.getSource();
                        boolean t =gameState1.containsKey(board.get(j) + cl);
                        if(t){
                            initialColor = c.getBackground();
                            initialClicked = c;
                            initialSpot = c.getText();
                            c.setBackground(Color.blue);
                            moves = new MovementAI(board.get(j), gameState1, cl,enpassant, enpassantLocation).getMoves();
                            String op;
                            if(cl.equals("B")){
                                op="W";
                            } else {
                                op="B";
                            }
                            effectMoves(initialSpot,moves,op);
                            } else {
                           }                                    
                }
                   
                }
                
                }
                     
              
              );
            c.setSize(80,80);
            labels.add(c);
            i++;
        }
        return labels;
    }
    void placePromotePiece(String pieceLocation, String promoteTo, String c){
        if(cl.equals("W")){
           if(board2.get(pieceLocation).getBackground().equals(Color.YELLOW)){
               if(promoteTo.equals("Queen")){
                   board2.get(pieceLocation).setIcon(wWhiteQ);
               } else if(promoteTo.equals("Rook")){
                   board2.get(pieceLocation).setIcon(wWhiteR);                 
               } else if(promoteTo.equals("Bishop")){
                   board2.get(pieceLocation).setIcon(wWhiteB);                 
               } else if(promoteTo.equals("Knight")){
                   board2.get(pieceLocation).setIcon(wWhiteKn);                 
               }
           } else {
               if(promoteTo.equals("Queen")){
                   board2.get(pieceLocation).setIcon(bWhiteQ);
               } else if(promoteTo.equals("Rook")){
                   board2.get(pieceLocation).setIcon(bWhiteR);                 
               } else if(promoteTo.equals("Bishop")){
                   board2.get(pieceLocation).setIcon(bWhiteB);                 
               } else if(promoteTo.equals("Knight")){
                   board2.get(pieceLocation).setIcon(bWhiteKn);                 
               }
           }
        } else {
            if(board2.get(pieceLocation).getBackground().equals(Color.YELLOW)){
               if(promoteTo.equals("Queen")){
                   board2.get(pieceLocation).setIcon(wBlackQ);
               } else if(promoteTo.equals("Rook")){
                   board2.get(pieceLocation).setIcon(wBlackR);                 
               } else if(promoteTo.equals("Bishop")){
                   board2.get(pieceLocation).setIcon(wBlackB);                 
               } else if(promoteTo.equals("Knight")){
                   board2.get(pieceLocation).setIcon(wBlackKn);                 
               }
           } else {
               if(promoteTo.equals("Queen")){
                   board2.get(pieceLocation).setIcon(bBlackQ);
               } else if(promoteTo.equals("Rook")){
                   board2.get(pieceLocation).setIcon(bBlackR);                 
               } else if(promoteTo.equals("Bishop")){
                   board2.get(pieceLocation).setIcon(bBlackB);                 
               } else if(promoteTo.equals("Knight")){
                   board2.get(pieceLocation).setIcon(bBlackKn);                 
               }
           }
        
        
        } 
        
         promote=false;   
    }
    String alt(String c){
        return c.equals("W")? "B": "W";
    }
    void makeMove(JButton initial, JButton last,boolean castMove){
        String opCl;
        String k = initial.getText(), j = last.getText();
        if(k.equals("A1")){
            whiteKingRook=false;
        } else if(k.equals("A8")){
            blackKingRook=false;
        } else if(k.equals("H1")){
            whiteQueenRook = false;
        } else if(k.equals("H8")){
            blackQueenRook=false;
        } else if (k.equals("D1")){
            whiteCastling = false;
        } else if (k.equals("D8")){
            blackCastling= false;
        }
        if(j.equals(enpassantLocation)){
            int d = Integer.parseInt(j.substring(1));
            JOptionPane.showMessageDialog(null,"enpassant capture observe");
            if (cl.equals("W")){
                gameState1.remove(j.substring(0,1) + Integer.toString(d-1) + "B");
                board2.get(j.substring(0,1) + Integer.toString(d-1)).setIcon(null);
            } else {
                board2.get(j.substring(0,1) + Integer.toString(d+1)).setIcon(null);
                gameState1.remove(j.substring(0,1) + Integer.toString(d+1) + "W");
            }
        }
        String loc = board.get(initial) +cl;
        Piece d = gameState1.get(loc);
        String name=d.getName();
        if(cl.equals("B")){
            opCl="W";
        } else {
            opCl= "B";
        } 
        if(castMove){
            if(board.get(last).contains("B")){
               if(cl.equals("W")){
                   board2.get("C1").setIcon(board2.get("A1").getIcon());
                   Piece piece=gameState1.remove("A1W");
                   gameState1.put("C1W",piece);
                   board2.get("A1").setIcon(null);
                   whiteCastling=false;
               } else {
                   board2.get("C8").setIcon(board2.get("A8").getIcon());
                   Piece piece=gameState1.remove("A8B");
                   gameState1.put("C8B",piece);
                   board2.get("A8").setIcon(null); 
                   blackCastling=false;
               }
            } else if(board.get(last).contains("F")){
               if(cl.equals("W")){
                   board2.get("E1").setIcon(board2.get("A1").getIcon());
                   Piece piece=gameState1.remove("H1W");
                   gameState1.put("E1W",piece);
                   board2.get("H1").setIcon(null);
                   whiteCastling=false;
               } else {
                   board2.get("E8").setIcon(board2.get("A8").getIcon());
                   Piece piece=gameState1.remove("H8B");
                   gameState1.put("E8B",piece);
                   board2.get("H8").setIcon(null);
                   blackCastling=false;
               }
            }
        }
        if(initial.getBackground()==last.getBackground()){
            last.setIcon(initial.getIcon());
        } else {
            if(last.getBackground()==Color.GREEN){
                if(name.startsWith("b")){
                    if(name.contains("Pun")){
                        last.setIcon(bBlackP);
                    } else if(name.contains("King")){
                        last.setIcon(bBlackK);
                    } else if(name.contains("Queen")){
                        last.setIcon(bBlackQ);
                    } else if (name.contains("Rook")){
                        last.setIcon(bBlackR);
                    } else if (name.contains("Knight")){
                        last.setIcon(bBlackKn);                    
                    } 
                } else {
                    if(name.contains("Pun")){
                        last.setIcon(bWhiteP);
                    } else if(name.contains("King")){
                        last.setIcon(bWhiteK);
                    } else if(name.contains("Queen")){
                        last.setIcon(bWhiteQ);
                    } else if (name.contains("Rook")){
                        last.setIcon(bWhiteR);
                    } else if (name.contains("Knight")){
                        last.setIcon(bWhiteKn);                    
                    }                    
                }
            } else{
                if(name.startsWith("b")){
                    if(name.contains("Pun")){
                        last.setIcon(wBlackP);
                    } else if(name.contains("King")){
                        last.setIcon(wBlackK);
                    } else if(name.contains("Queen")){
                        last.setIcon(wBlackQ);
                    } else if (name.contains("Rook")){
                        last.setIcon(wBlackR);
                    } else if (name.contains("Knight")){
                        last.setIcon(wBlackKn);                    
                    }   
                } else {
                    if(name.contains("Pun")){
                        last.setIcon(wWhiteP);
                    } else if(name.contains("King")){
                        last.setIcon(wWhiteK);
                    } else if(name.contains("Queen")){
                        last.setIcon(wWhiteQ);
                    } else if (name.contains("Rook")){
                        last.setIcon(wWhiteR);
                    } else if (name.contains("Knight")){
                        last.setIcon(wWhiteKn);                    
                    }                    
                }
            }
        }
        boolean cap=gameState1.containsKey(finalSpot+opCl);
        gameRecords(name,cl,initialSpot,finalSpot,cap,castMove);
        initial.setIcon(null);
        restore(opCl,finalSpot);
        updateBoard(initialSpot,finalSpot,cl);
        numberOfMoves++;          
    }
    void updateBoard(String initialSpot, String finalSpot, String cl){
        Piece piece= gameState1.get(initialSpot + cl);
        if(piece.getName().contains("Pun")){
            boolean k = GameEvent.punPromotion(finalSpot, gameState2, board2.get(finalSpot).getBackground());
            if(k){
                promote=true;
                promoteL=finalSpot;
                //promotion.setVisible(true);
                promoteTo = JOptionPane.showInputDialog(null, "Which officer do you want?", "Prompt", JOptionPane.PLAIN_MESSAGE);
                if(cl.equals("W")){
                    if(promoteTo.equals("Queen")){
                        piece = whiteQueen;
                    }else if(promoteTo.equals("Rook")){
                        piece = whiteRook1;
                    }else if(promoteTo.equals("Knight")){
                        piece= whiteKnight1;
                    } else {
                        if(board2.get(finalSpot).getBackground().equals(Color.YELLOW)){
                            piece = whiteWhiteBishop;
                        } else {
                            piece = whiteBlackBishop;
                        } 
                    } 
                } else {
                    if(promoteTo.equals("Queen")){
                        piece = blackQueen;
                    }else if(promoteTo.equals("Rook")){
                        piece = blackRook1;
                    }else if(promoteTo.equals("Knight")){
                        piece= blackKnight1;
                    } else {
                        if(board2.get(finalSpot).getBackground().equals(Color.YELLOW)){
                            piece = blackWhiteBishop;
                        } else {
                            piece = blackBlackBishop;
                        } 
                    }
                }
               placePromotePiece(finalSpot,promoteTo,cl); 
            }
            
        }
        if(cl.equals("B")){
            if(gameState1.containsKey(finalSpot + "W")){
                gameState1.remove(finalSpot + "W");
            }
        } else {
            if(gameState1.containsKey(finalSpot + "B")){
                gameState1.remove(finalSpot + "B");
            }
        }
        gameState1.remove(initialSpot + cl);
        gameState1.put(finalSpot + cl,piece);
        gameState2=reversedMap(gameState1);
        if(piece.getName().contains("King")){
            setKingLocations();
        }
        onCheck= isKingChecked(gameState2);
        if(onCheck && cl.equals("B")){
            status.setText("White King Check");
        } else if (onCheck && cl.equals("W")){
            status.setText("Black King Check");
        } else {
            status.setText("");
        }
        enpassant=false; 
        enpassantLocation="";
        if (piece.getName().contains("Pun")){
            int step = Math.abs(Integer.parseInt(finalSpot.substring(1))-Integer.parseInt(initialSpot.substring(1)));
            if(step==2){
                enpassant=true;
                int d= Integer.parseInt(finalSpot.substring(1));
                if(cl.equals("W")){
                    enpassantLocation = initialSpot.substring(0,1) + Integer.toString(d-1);
                } else {
                    enpassantLocation = initialSpot.substring(0,1) + Integer.toString(d+1);
                }
            }
        }
    }
    boolean isKingChecked(Map<Piece,String> gameState){
       String kingLocation;
       if(cl.equals("B")){
           kingLocation = kingLocations[0];
       } else {
           kingLocation = kingLocations[1];
       }
       GameEvent p= new GameEvent(gameState1);
       return p.isKingChecked(cl, p.boardState, kingLocation);
       // return false;
   }
    void castling(String color){
        String oppCol;
        int castlingType;
        if(!onCheck){
            if(color.equals("W")){
                oppCol = "B";
                if(whiteCastling){
                    if(whiteKingRook){
                        castlingType= 1;
                        verifyCastling(castlingType, oppCol, color,gameState2);
                    } if (whiteQueenRook){
                        castlingType= 2;
                        verifyCastling(castlingType, oppCol, color,gameState2);
                    }
                }
            } else {
                oppCol="W";
                if(blackCastling){
                    if(blackKingRook){
                        castlingType= 1;
                        verifyCastling(castlingType, oppCol, color,gameState2);                                        
                    } if (blackQueenRook){
                        castlingType= 2;
                        verifyCastling(castlingType, oppCol, color,gameState2);
                    }
                }
            //blackCastling=false;
            }
        }
    }
    void effectCastling(String color, int castlingType){
        if(color.equals("W")){
            if(castlingType==1){
                board2.get("B1").setBackground(Color.CYAN);
                //board2.get("C1").setBackground(Color.ORANGE);
            } else {
                board2.get("F1").setBackground(Color.CYAN);
                //board2.get("E1").setBackground(Color.ORANGE);
            }
        } else {
            if(castlingType==1){
                board2.get("B8").setBackground(Color.CYAN);
                //board2.get("C8").setBackground(Color.ORANGE);
            } else {
                board2.get("F8").setBackground(Color.CYAN);
                //board2.get("E8").setBackground(Color.ORANGE);
            }
        } 
    }
    void verifyCastling(int castlingType, String oppCol, String color, Map<Piece,String> gameState){
        String spots[];
        if(color.equals("W")){
            if(castlingType==1){
                spots=new String[2];
                spots[0]="B1";
                spots[1]="C1";
            } else {
                spots = new String[3];
                spots[0]= "E1";
                spots[1]= "F1";
            }
        } else {
            if(castlingType==1){
                spots=new String[2];
                spots[0]="B8";
                spots[1]="C8";
            } else {
                spots = new String[3];
                spots[0]= "E8";
                spots[1]= "F8";
            }
        }
        boolean possible=true;
        int i=0;
        while(possible && i<spots.length){
            possible = !new GameEvent(gameState1).isKingChecked(oppCol,gameState,spots[i]);
            i++;
        }
        if(possible){
            if(color.equals("W")){
                if(castlingType==1){
                    possible = !(gameState1.containsKey("B1W")||gameState1.containsKey("C1W"));
                    if(possible){
                        possible = !(gameState1.containsKey("B1B")||gameState1.containsKey("C1B"));
                    }
                } else {
                    possible = !(gameState1.containsKey("E1W")||gameState1.containsKey("F1W")||gameState1.containsKey("G1W"));
                    if(possible){
                        possible = !(gameState1.containsKey("E1B")||gameState1.containsKey("F1B")||gameState1.containsKey("G1B"));
                    }
                }
            } else {
                if(castlingType==1){
                    possible = !(gameState1.containsKey("B8W")||gameState1.containsKey("C8W"));
                    if(possible){
                        possible = !(gameState1.containsKey("B8B")||gameState1.containsKey("C8B"));
                    }
                } else {
                    possible = !(gameState1.containsKey("E8W")||gameState1.containsKey("F8W")||gameState1.containsKey("G8W"));
                    if(possible){
                        possible = !(gameState1.containsKey("E8B")||gameState1.containsKey("F8B")||gameState1.containsKey("G8B"));
                    }
                }
            }
        }
        if(possible){
          effectCastling(color, castlingType);
          }
    }
    void effectMoves(String initial,ArrayList<String> moves, String opponentCl){
       String kingLocation;  
        if(cl.equals("W")){
            kingLocation=kingLocations[0];
        } else {
            kingLocation=kingLocations[1];
        }
        for (String move : moves){
           GameEvent p1= new GameEvent(gameState1);
           boolean prevented= p1.checkPrevented(initial,move.substring(0,2), kingLocation, cl,opponentCl,p1.boardState);
           String  move1=move.substring(0,2);
           move1+=opponentCl;
           if(prevented){    
               if (gameState1.containsKey(move1)){
                    JButton p = board2.get(move1.substring(0,2));
                    Piece piece = gameState1.get(move1);
                    if(opponentCl.equals("B")){
                        if(piece.getName().contains("Queen")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(bQTC);
                        } else if(piece.getName().contains("Rook")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(bRTC);
                        } else if (piece.getName().contains("Bishop")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(bBTC);
                        } else if(piece.getName().contains("Knight")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(bKnTC);
                        } else if(piece.getName().contains("Pun")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(bPTC);
                        }
                    } else {
                        if(piece.getName().contains("Queen")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(wQTC);
                        } else if(piece.getName().contains("Rook")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(wRTC);
                        } else if (piece.getName().contains("Bishop")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(wBTC);
                        } else if(piece.getName().contains("Knight")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(wKnTC);
                        } else if(piece.getName().contains("Pun")){
                            capturableSpots.put(move1,p.getIcon());
                            p.setIcon(wPTC);
                        }
                    }
                    p.setBackground(Color.PINK);
                } else {
                    JButton p = board2.get(move.substring(0,2));
                    p.setBackground(Color.PINK);
                }
          }
       }
       if(initialSpot.equals(kingLocations[0])||initialSpot.equals(kingLocations[1])){
            castling(cl);
       }
       
   }
    void restore(String opponentCl, String lastMove){
       capturableSpots.remove(lastMove + opponentCl);
       for(String p: capturableSpots.keySet()){
           board2.get(p.substring(0,2)).setIcon(capturableSpots.get(p));
       }
       capturableSpots.clear();
   }
    boolean isGameOver(String cl){
        boolean isCheckMate=false;
        String kingL;
        if(cl.equals("W")){
            kingL=kingLocations[0];
        } else {
            kingL= kingLocations[1];
        }
        GameEvent p = new GameEvent(gameState1);
        if(onCheck){
            isCheckMate= p.isCheckmate(cl, kingL);
            if(isCheckMate){
                records.setText(records.getText() + "!");
                status.setText("Checkmate");
            } else {
                records.setText(records.getText() + "#");
            }
        }
        return isCheckMate;
    }
    private void setKingLocations(){
        kingLocations[0]= gameState2.get(whiteKing).substring(0,2);
        kingLocations[1]=gameState2.get(blackKing).substring(0,2);
    }
    void engineMove(String bestMove[]){
        String initial = bestMove[0].substring(0,2);
        String last= bestMove[1].substring(0,2);
        makeMove(board2.get(initial),board2.get(last),false);
        //makeMove(board2.get(bestMove[0].substring(0,2)), board2.get(bestMove[1].substring(1)),false);
        //updateBoard(bestMove[0].substring(0,2), bestMove[1].substring(0,2), "B");
        }
    private void gameRecords(String pieceName, String color,String from, String to, boolean capturing,boolean castMove){
        String record="",d="",spacing;
        if(color.equalsIgnoreCase("W")){
            spacing="\n";
        } else {
            spacing ="\t\t";
        }
        if(!castMove){
        if(capturing){
            d="X";
        }
        if(pieceName.contains("Kn")){
           record=spacing+"N" + from + "-" +d+ to; 
        } else {
            record=spacing+pieceName.substring(1,2)+from +"-"+d+to;
        }
        records.setText(records.getText() + record);
        } else {
            if(to.contains("B")){
                records.setText(records.getText() + spacing + "O-O");
            } else {
                records.setText(records.getText() + spacing+"O-O-O");
            }
        }
    }
    //To do task
    // Chess Engine
    
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
            java.util.logging.Logger.getLogger(BoardInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BoardInterface().setVisible(true);
              
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cB;
    private javax.swing.JCheckBox cK;
    private javax.swing.JCheckBox cPU;
    private javax.swing.JCheckBox cQ;
    private javax.swing.JCheckBox cR;
    private javax.swing.JCheckBox human;
    private javax.swing.JLabel iB;
    private javax.swing.JLabel iK;
    private javax.swing.JLabel iQ;
    private javax.swing.JLabel iR;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField playerMove;
    private javax.swing.JInternalFrame promotion;
    private javax.swing.JTextArea records;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}