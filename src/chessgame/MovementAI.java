 package chessgame;

import chessgame.pieces.Piece;
import chessgame.pieces.Pun;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovementAI{
    private String clickedSpot;
    private Map<String, Piece> gameState;
    private Map<Piece,String> gameState2;
    private String color, opponentColor;
    private String name;
    boolean enpassant;
    String enpassantLocation;
    public MovementAI(String spot, Map<String, Piece> state, String cl,boolean en, String loc){
        clickedSpot=spot + cl;
        if(cl.equals("B")){
            color="B";
            opponentColor="W";
        } else {
            color="W";
            opponentColor="B";
        }
        gameState= state;
        gameState2= reversedMap(gameState);
        enpassant= en;
        enpassantLocation = loc;
    }
        
    private String getPieceName(){
        return gameState.get(clickedSpot).getName();       
    }
    
    ArrayList<String> getMoves(){
        name=getPieceName();
        ArrayList<String> moves;
        Piece piece = gameState.get(clickedSpot);
        if(!name.contains("Pun")){
            piece.setBoardState(gameState2);
            piece.setNotKingChecked();
            moves= piece.nextMoves(clickedSpot, color, opponentColor);
        } else {
            Pun piece1 = (Pun)piece;
            piece1.setCapturedOnly(false);
            piece1.setBoardState(gameState2);
            piece1.setEnpassant(enpassant);
            piece1.setEnpassantLocation(enpassantLocation);
            piece1.setNotKingChecked();
            moves = piece1.nextMoves(clickedSpot, color, opponentColor);
        }
        return moves;
    }
    
   private Map<Piece, String> reversedMap (Map<String ,Piece> map1){
        Map<Piece,String> map2= new HashMap<Piece,String>();
        for (String k : map1.keySet()){
            map2.put(map1.get(k), k);
        }    
        return map2;
    }  

}