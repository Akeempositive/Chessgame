package chessgame.pieces;

import java.util.ArrayList;
import java.util.Map;


public class Queen implements Piece{
    //Variable(s) Declaration
    String name;
    private boolean kingChecked=false;
    private Map<Piece,String> map;
    
    //Constructor(s)
    public Queen(String p){
        name = p;
        
    }
    
    //Inteface OverWritten Method(s)
    @Override
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name= name;
    }
    
    @Override
    public ArrayList<String>nextMoves(String currentLocation, String color,String opponentColor) {
        ArrayList<String> nextMoves;
        ArrayList<String> nextMoves2;
        Bishop bishop=new Bishop("This");
        bishop.setKingChecked(kingChecked);
        bishop.setBoardState(map);
        nextMoves= bishop.nextMoves(currentLocation, color, opponentColor);
        Rook rook=new Rook("This");
        rook.setBoardState(map);
        rook.setKingChecked(kingChecked);
        nextMoves2= rook.nextMoves(currentLocation, color, opponentColor);
        nextMoves.addAll(nextMoves2);
        return nextMoves;
    }

    @Override
    public void setKingChecked() {
        kingChecked=true;
    }

    @Override
    public void setBoardState(Map<Piece, String> boardState) {
       map=boardState;
    }
    
    public void setNotKingChecked(){
        kingChecked=false;
    }

    public boolean isKingChecked() {
        return kingChecked;
    }

    public void setKingChecked(boolean kingChecked) {
        this.kingChecked = kingChecked;
    }

    public Map<Piece,String> getMap() {
        return map;
    }

    public void setMap(Map<Piece,String> map) {
        this.map = map;
    }
  
}