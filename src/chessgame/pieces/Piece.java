package chessgame.pieces;

import java.util.ArrayList;
import java.util.Map;

public interface Piece{
    //Variable declaration
    String columns[]={"A","B","C","D","E","F","G","H"};
    boolean kingChecked=false;
     //Interface Method(s)
    public String getName();
    
    void setKingChecked();
    
    ArrayList<String>nextMoves(String currentLocation, String color,String opponentColor);

    public void setBoardState(Map<Piece, String> boardState);
    
    public void setNotKingChecked();

}