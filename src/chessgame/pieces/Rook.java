package chessgame.pieces;

import java.util.ArrayList;
import java.util.Map;


public class Rook implements Piece{
    //Variable(s) Declaration
    String name;
    private boolean kingChecked=false;
    private Map<Piece,String> map;
    //Constructor(s)
    public Rook(String n){
        name = n;
    }
    
    //Interface Overwritten Methods
    @Override
    public String getName() {
        return name;
    }
     
    public void setName(String name){
        this.name= name;
    }
    @Override
    public ArrayList<String>nextMoves(String currentLocation, String color,String opponentColor) {
        int row= Integer.parseInt(currentLocation.substring(1,2)), columnNumber=0, columnUsed,rowUsed;boolean obstruct=false;
        String column= currentLocation.substring(0,1);
        if (column.equals("A"))columnNumber =1;
        if (column.equals("B"))columnNumber =2;
        if (column.equals("C"))columnNumber =3;
        if (column.equals("D"))columnNumber =4;
        if (column.equals("E"))columnNumber =5;
        if (column.equals("F"))columnNumber =6;
        if (column.equals("G"))columnNumber =7;
        if (column.equals("H"))columnNumber =8;
        columnUsed = columnNumber;
        rowUsed=  row-1;
        String[] allColumn= Piece.columns; 
        ArrayList<String> nextMoves = new ArrayList<String>();
        
        while(rowUsed!=0&&obstruct==false){
            if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
            }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            } else {
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            }
            rowUsed--;
        } obstruct = false; rowUsed=row+1;    
         while(rowUsed!=9&&obstruct==false){
            if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
            }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
               }
            else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}
            rowUsed++; 
            
        } obstruct = false;columnUsed= columnNumber-1; rowUsed=row;
         while(columnUsed!=0&&obstruct==false){
            if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
                }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        }else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}
            columnUsed--;
        
        } obstruct = false;columnUsed= columnNumber+1; rowUsed=row;
         while(columnUsed!=9&&obstruct==false){
            if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
               }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        }else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}
            columnUsed++;
        }
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