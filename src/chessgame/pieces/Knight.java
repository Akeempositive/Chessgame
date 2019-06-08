package chessgame.pieces;

import java.util.ArrayList;
import java.util.Map;


public class Knight implements Piece{
    //Variable(s) Declaration
    private String name;
    private boolean kingChecked=false;
    private Map<Piece,String> map;
    //Constructor(s)
    public Knight(String p){
        name = p;
    }
    
    //Interface Overwritten Method(s)
    @Override
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name= name;
    }
   
    @Override
    public ArrayList<String>nextMoves(String currentLocation, String color,String opponentColor) {
        int row= Integer.parseInt(currentLocation.substring(1,2)), columnNumber=0, columnUsed,rowUsed;
        String column= currentLocation.substring(0,1);
//        int[] allRows= Piece.rows;
        if (column.equals("A"))columnNumber =1;
        if (column.equals("B"))columnNumber =2;
        if (column.equals("C"))columnNumber =3;
        if (column.equals("D"))columnNumber =4;
        if (column.equals("E"))columnNumber =5;
        if (column.equals("F"))columnNumber =6;
        if (column.equals("G"))columnNumber =7;
        if (column.equals("H"))columnNumber =8;
        
        columnUsed = columnNumber-1;
        rowUsed =  row-2;
        String[] allColumn= Bishop.columns; 
        ArrayList<String> nextMoves = new ArrayList<String>();
        
        
        if (columnUsed>=1){
            if(rowUsed>=1){
            if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
                }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
            else {}
         rowUsed = row + 2;  
         if (rowUsed<=8){
       if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
           if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
               }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
         else {}
        }else {}
       columnUsed= columnNumber +1;rowUsed= row-2;
       if(columnUsed<=8){
       if(rowUsed>=1){
       if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
                }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
           else {}
         rowUsed = row + 2; 
         if (rowUsed<=8){
       if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
           if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
                }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
        else {}}
       else {}
    
       columnUsed = columnNumber -2; rowUsed = row-1;
    if (columnUsed>=1){
        if (rowUsed>=1){
       if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
           if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
            }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
        else {}
        
        
        rowUsed = row + 1;  
         
       if (rowUsed<=8){
       if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
            if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
              }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
       else {}
    }else {}
       columnUsed= columnNumber +2;rowUsed= row-1;
       if(columnUsed<=8){
       if (rowUsed>=1){    
       if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
            if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
               }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
       else {}
       rowUsed = row + 1;  
       if(rowUsed<=8){
       if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
           if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                 }
             }
            else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
        } else {nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);}}
       else {}
       }else {}
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
    
    @Override
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