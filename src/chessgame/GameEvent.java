package chessgame;

import chessgame.pieces.Piece;
import chessgame.pieces.King;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameEvent{
    //Declaration of variables
    static Map<Piece, String>boardState;
    
    //Constructor(s)
    public GameEvent(Map<String, Piece>b){
        boardState=reversedMap2(b);
    }
     
    //Method(s)
    static boolean checkPrevented(String pieceIni,String bPL,String kingLocation, String cl, String oppCl,Map<Piece,String>boardState) {
        Map<Piece,String> boardState3=boardState;
        if(pieceIni.equals(kingLocation)){
            kingLocation=bPL;
        }
        Map<String,Piece>boardState2=reversedMap(boardState3);
        Piece piece = boardState2.remove(pieceIni + cl);
        if(boardState2.containsKey(bPL +oppCl)){
            boardState2.remove(bPL +oppCl);
        }
        boardState2.put(bPL +cl, piece);
        boardState3.clear();
        boardState3.putAll(reversedMap2(boardState2));
        return !isKingChecked(oppCl, boardState3,kingLocation);
    }
    
    public static ArrayList<Object> getPlayerPiece(String playerColor){
        ArrayList<Object> output = new ArrayList<Object>();
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        ArrayList<String> location = new ArrayList<String>();
        int j=0,i=j;
        Map<Piece, String> boardState2=boardState;
        for (Piece piece : boardState2.keySet()){
            j++;
            if(boardState2.get(piece).endsWith(playerColor.toUpperCase())){
                location.add(boardState2.get(piece));
                pieces.add(piece);
                i++;
            }
        }
        output.add(pieces);
        output.add(location);
        return output;
    }

    boolean isCheckmate(String color, String kingL){
        String oppColor;
        if(color.equals("W")){
            oppColor="B";
        } else {
            oppColor="W";
        }
        ArrayList<Object> playerPieces = getPlayerPiece(color);
        @SuppressWarnings("unchecked")
        ArrayList<Piece> pieces = (ArrayList<Piece>)playerPieces.get(0);
        @SuppressWarnings("unchecked")
        ArrayList<String>locations = (ArrayList<String>)playerPieces.get(1);
        int i=0;
        boolean preventable=false;
        Map<Piece,String> boardState2= boardState;
        while(i<pieces.size()){
            pieces.get(i).setKingChecked();
            pieces.get(i).setBoardState(boardState);
            for (String move : pieces.get(i).nextMoves(locations.get(i), color, oppColor)){
                if(!preventable){
                    preventable=checkPrevented(locations.get(i),move.substring(0,2),kingL,color,oppColor,boardState2);
                }
            }
            i++;
        }
           return preventable;
    }
    
    static boolean isKingChecked(String color, Map<Piece, String> boardState, String opponentKing){
        boolean onCheck=false;
        Set<String> allMoves;
        opponentKing += color ;  
        String color2;
        if(color.equals("B")){
            color2="W";
        } else {
            color2="B";
        }
        ArrayList<Object> outputs= getPlayerPiece(color);
        @SuppressWarnings("unchecked")
        ArrayList<Piece> playerPiece= (ArrayList<Piece>)outputs.get(0);
        @SuppressWarnings("unchecked")
        ArrayList<String> locations= (ArrayList<String>) outputs.get(1);
        ArrayList<String> allNextMoves = new ArrayList<String>();
        int i=0;
        while(i<playerPiece.size()){
            playerPiece.get(i).setKingChecked();
            playerPiece.get(i).setBoardState(boardState);
            allNextMoves.addAll(playerPiece.get(i).nextMoves(locations.get(i), color, color2));
            i++;
        }
        allMoves=new HashSet<String>(allNextMoves);
        if(!onCheck ){
            onCheck = allMoves.contains(opponentKing);
        }
        return onCheck;
    }
    
    static boolean punPromotion(String pL, Map<Piece, String> boardState, Color tile){
        if(pL.contains("1")){
            JOptionPane.showMessageDialog(null, "Black pawn merit promotion");
            return true;
         } else if(pL.contains("8")){
            JOptionPane.showMessageDialog(null, "White pawn merit promotion");
            return true;
        }
        return false;
    }
    
    boolean isStalemate(String kingLocation, String color, String opponentColor, Map<Piece, String>map){
        ArrayList<String> otherPieceMoves= new ArrayList<String>();
        ArrayList<Object> outputs= getPlayerPiece(color);
        @SuppressWarnings("unchecked")
        ArrayList<Piece> pieces= (ArrayList<Piece>)outputs.get(0);
        @SuppressWarnings("unchecked")
        ArrayList<String> locations=(ArrayList<String>)outputs.get(1);
        int i=0;
        for (Piece piece : pieces){
            piece.setBoardState(map);
            otherPieceMoves.addAll(piece.nextMoves(locations.get(i), color, opponentColor));
            i++;
        }
        if(otherPieceMoves.isEmpty()){
            King k = new King("This");
            k.setBoardState(map);
            ArrayList<String> validMoves = k.nextMoves(kingLocation, color, opponentColor);
            if(validMoves.isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    static Map<String, Piece> reversedMap (Map<Piece,String> map1){
        Map<String,Piece> map2= new HashMap<String,Piece>();
        for (Piece k : map1.keySet()){
            map2.put(map1.get(k), k);
        }
        return map2;
    } 
    
    static Map<Piece,String> reversedMap2 (Map<String,Piece> map1){
        Map<Piece,String> map2= new HashMap<Piece,String>();
        for (String k : map1.keySet()){
            map2.put(map1.get(k), k);
        }
        return map2;
    }
   
}