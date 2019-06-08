package chessgame.pieces;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;


public class Bishop implements Piece{
    //Variable(s) declaration
    private String name;
    private boolean kingChecked=false;
    private Map<Piece,String> map;
    //Constructor(s)
    public Bishop(String p){
        name = p;
        this.map=map;
    }
    
    //Overwritten Mathod(s)
    @Override
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name= name;
    }
    
    @Override
    public ArrayList<String>nextMoves(String currentLocation, String color,String opponentColor) {
        int row= Integer.parseInt(currentLocation.substring(1,2)), columnNumber=0, columnUsed,rowUsed;boolean obstruct=false;
        String column= currentLocation.substring(0,1);
        if (column.equals("A")){
            columnNumber =1;
        }
        else if (column.equals("B")){
            columnNumber =2;
        }
        else if (column.equals("C")){
            columnNumber =3;
        }
        else if (column.equals("D")){
            columnNumber =4;
        }
        else if (column.equals("E")){
            columnNumber =5;
        }
        else if (column.equals("F")){
            columnNumber =6;
        }
        else if (column.equals("G")){
            columnNumber =7;
        }
        else if (column.equals("H")){
            columnNumber =8;
        }
        columnUsed = columnNumber-1;
        rowUsed = row-1;
        String [] allColumn= Bishop.columns; 
        ArrayList<String> nextMoves = new ArrayList<String>();
        while(rowUsed>0 && columnUsed>0&&!obstruct){
            if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
            } else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            } else {
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            } rowUsed--; columnUsed--;
            } obstruct = false;columnUsed= columnNumber+1; rowUsed=row-1;    
         while(rowUsed>0 && columnUsed<=8&&!obstruct){
             if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
            } else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            } else {
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            }
            rowUsed--; columnUsed++;
        } obstruct = false;columnUsed= columnNumber-1; rowUsed=row+1;
         while(rowUsed<=8 && columnUsed>0&&!obstruct){
             if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
            }  else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            }else {
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            }
            rowUsed++; columnUsed--;
        } obstruct = false;columnUsed= columnNumber+1; rowUsed=row+1;
         while(rowUsed<=8 && columnUsed<=8 && !obstruct){
             if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color)){
                obstruct=true;
                if(kingChecked){
                    nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
                }
            } else if (map.containsValue(allColumn[columnUsed-1] + Integer.toString(rowUsed) + opponentColor)){
                obstruct=true;
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            }else {
                nextMoves.add(allColumn[columnUsed-1] + Integer.toString(rowUsed) + color);
            }
            rowUsed++; columnUsed++;
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