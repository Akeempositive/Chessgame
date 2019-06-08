package chessgame.pieces;

import java.util.*;
import java.util.logging.Logger;


public class King implements Piece{
    //Variable(s) Declaration
    String name;
    private Map<Piece,String> map;
    private boolean kingChecked=false;
    //Constructor(s)
    public King(String p ){
        name = p;
    }
    private static final Logger LOG = Logger.getLogger(King.class.getName());
    
    //Interface Overwritten Method(s) 
    @Override
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name= name;
    }

    @Override
    @SuppressWarnings({"unchecked", "unchecked", "unchecked", "unchecked", "unchecked"})
    
    public ArrayList<String>nextMoves(String currentLocation, String color,String opponentColor) {
        ArrayList<Piece> setPieces;
        ArrayList<String> nextMoves = new ArrayList<String>();
        Integer rowUsed = Integer.parseInt(currentLocation.substring(1,2));
        String column = currentLocation.substring(0,1);
        int columnNumber;
        if (column.equals("A")){
            columnNumber =1;
        } else if (column.equals("B")){
            columnNumber =2;
        } else if (column.equals("C")){
            columnNumber =3;
        } else if (column.equals("D")){
            columnNumber =4;
        } else if (column.equals("E")){
            columnNumber =5;
        } else if (column.equals("F")){
            columnNumber =6;
        } else if (column.equals("G")){
            columnNumber =7;
        } else{
            columnNumber =8;
        }
        int [] columnRange = {columnNumber-1, columnNumber,columnNumber +1};
        int [] rowRange = {rowUsed-1,rowUsed, rowUsed + 1};
        for (int a : columnRange){
            if(a>=1&&a<=8){
            String a1 = Piece.columns[a-1];
                for (int b : rowRange){
                    if(!(b==rowUsed&&a==columnNumber)){
                        if(b>=1&&b<=8){
                            if (map.containsValue(a1 + Integer.toString(b) + color)){
                            }   else if (map.containsValue(a1+ Integer.toString(b) + opponentColor)){
                                nextMoves.add(a1 + Integer.toString(b) + color);
                            } else {
                                nextMoves.add(a1+ Integer.toString(b) + color);
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Object> outputs= getPlayerPiece(opponentColor,map);
        setPieces= (ArrayList<Piece>)outputs.get(0);
        ArrayList<String>setLocations=(ArrayList<String>)outputs.get(1);
        Set<String> opponentMoves = new HashSet<String>();
        int i=0;
         while (i<setPieces.size()){
            Piece piece1=setPieces.get(i);
            String pieceL = setLocations.get(i);
            ArrayList<String>pieceMoves;
            try{
              piece1.setKingChecked();
            if(setPieces.get(i).getClass().toString().endsWith("King")){
                opponentMoves.addAll(new King("King").nextMovs(setLocations.get(i), color, opponentColor));
            } else if (setPieces.get(i).getClass().toString().contains("Pun")){
                Pun piece2 = (Pun) piece1;
                piece2.setCapturedOnly(true);
                pieceMoves=piece2.nextMoves(pieceL, opponentColor, color);
                opponentMoves.addAll(pieceMoves);
            } else {
            pieceMoves=piece1.nextMoves(pieceL, opponentColor, color);
            opponentMoves.addAll(pieceMoves);
            }
            } catch (NullPointerException ex){
            
            }
            i++;
         }
        nextMoves.removeAll(opponentMoves);
        return nextMoves;
    }
    
    //Class Method(s)
    private ArrayList<String>nextMovs(String currentLocation, String color,String opponentColor) {
        ArrayList<String> nextMoves = new ArrayList<String>();
        Integer rowUsed = Integer.parseInt(currentLocation.substring(1,2));
        String column = currentLocation.substring(0,1);
        int columnNumber;
        if (column.equals("A")){
            columnNumber =1;
        } else if (column.equals("B")){
            columnNumber =2;
        } else if (column.equals("C")){
            columnNumber =3;
        } else if (column.equals("D")){
            columnNumber =4;
        } else if (column.equals("E")){
            columnNumber =5;
        } else if (column.equals("F")){
            columnNumber =6;
        } else if (column.equals("G")){
            columnNumber =7;
        } else if (column.equals("H")){
            columnNumber =8;
        } else {
            columnNumber =0;
        }
        int [] columnRange = {columnNumber-1, columnNumber,columnNumber +1};
        int [] rowRange = {rowUsed-1,rowUsed, rowUsed + 1};
        for (int a : columnRange){
            if(a>=1&&a<=8){
                String a1 = Piece.columns[a-1];
                for (int b : rowRange){
                    if(!(b==rowUsed&&a==columnNumber)){
                        if(b>=1&&b<=8){
                            if (map.containsValue(a1 + Integer.toString(b) + color)){
                            }
                        } else if (map.containsValue(a1+ Integer.toString(b) + opponentColor)){
                            nextMoves.add(a1 + Integer.toString(b) + color);
                        } else {
                            nextMoves.add(a1+ Integer.toString(b) + color);
                        }
                    }
                }
            }
        }
   /*     @SuppressWarnings("unchecked")
    ArrayList<Piece> setPieces= (ArrayList<Piece>)getPlayerPiece(opponentColor, map).get(0);
    ArrayList<Piece> tobeRemoved= new ArrayList<Piece>();
    for (Piece piece: setPieces){
        if (piece.getName().endsWith("King")){
            tobeRemoved.add(piece);
        }
    }
    setPieces.removeAll(tobeRemoved);
   ArrayList<String> opponentMoves= new ArrayList<String>();
   for (Piece piece1 : setPieces) {
        ArrayList<String>pieceMoves;
        String pieceL = map.get(piece1);
        if (piece1.getName().contains("Pun")){
            Pun piece2 = (Pun) piece1;
            piece2.capturedOnly=true;
            pieceMoves=piece2.nextMoves(pieceL, opponentColor, color, map);
            opponentMoves.addAll(pieceMoves);
            } else {
            pieceMoves=piece1.nextMoves(pieceL, opponentColor, color, map);
            opponentMoves.addAll(pieceMoves);
            }
        }     
       nextMoves.removeAll(opponentMoves);
     
     */
     return nextMoves;
    }
    
    static ArrayList<Object> getPlayerPiece(String playerColor, Map<Piece, String> boardState){
        ArrayList<Object> output = new ArrayList<Object>();
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        ArrayList<String> location = new ArrayList<String>();
        for (Piece piece : boardState.keySet()){
            if(boardState.get(piece).endsWith(playerColor.toUpperCase())){
                location.add(boardState.get(piece));
                pieces.add(piece);
            }
        }
        output.add(pieces);
        output.add(location);
        return output;
    }

    @Override
    public void setKingChecked() {
       // kingChecked=false;
    }

    @Override
    public void setBoardState(Map<Piece, String> boardState) {
        map=boardState;
    }
    
    public void setNotKingChecked(){
        kingChecked=false;
    }

    public Map<Piece,String> getMap() {
        return map;
    }

    public void setMap(Map<Piece,String> map) {
        this.map = map;
    }

    public boolean isKingChecked() {
        return kingChecked;
    }

    public void setKingChecked(boolean kingChecked) {
        this.kingChecked = kingChecked;
    }

}