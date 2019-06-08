package chessgame;

import chessgame.pieces.Knight;
import chessgame.pieces.Piece;
import chessgame.pieces.Rook;
import chessgame.pieces.Bishop;
import chessgame.pieces.King;
import chessgame.pieces.Pun;
import chessgame.pieces.Queen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardState{
ArrayList<Piece> boardPieces= new ArrayList<Piece>();
Map<String, Piece> board = new HashMap<String, Piece>();
Map<Piece, String> board2;
Piece blackPun1=new Pun("bPun1"),blackPun2=new Pun("bPun2"),blackPun3=new Pun("bPun3"),blackPun4=new Pun("bPun4");
Piece blackPun5=new Pun("bPun5"),blackPun6=new Pun("bPun6"),blackPun7=new Pun("bPun7"),blackPun8=new Pun("bPun8");
Piece whitePun1= new Pun("wPun1"),whitePun2=new Pun("wPun2"),whitePun3=new Pun("wPun3"),whitePun4=new Pun("wPun4");
Piece whitePun5=new Pun("wPun5"),whitePun6=new Pun("wPun6"),whitePun7=new Pun("wPun7"),whitePun8=new Pun("wPun8");
Knight whiteKnight1= new Knight("whiteKnight1"), whiteKnight2= new Knight("whiteKnight2"), blackKnight1= new Knight("blackKnight1"), blackKnight2=new Knight("blackKnight2");
Bishop whiteWhiteBishop= new Bishop("whiteWhiteBishop"),whiteBlackBishop= new Bishop("whiteBlackBishop"),blackWhiteBishop= new Bishop("blackWhiteBishop"),blackBlackBishop= new Bishop("blackBlackBishop");
Rook whiteRook1= new Rook("whiteRook1"),whiteRook2= new Rook("whiteRook2"),blackRook1= new Rook("blackRook1"),blackRook2= new Rook("blackRook2");
Queen whiteQueen= new Queen("whiteQueen"), blackQueen= new Queen("blackQueen");
Piece whiteKing= new King("whiteKing"), blackKing= new King("blackKing");


void defaultState(){
    board.put("A1W",whiteRook1);
    board.put("B1W",whiteKnight2);
    board.put("C1W",whiteWhiteBishop );
    board.put("D1W",whiteKing);
    board.put("E1W",whiteQueen);
    board.put("D4W",whiteBlackBishop );
    board.put("G1W",whiteKnight1 );
    board.put("H1W",whiteRook2);
    
    board.put("A8B",blackRook1);
    board.put("B8B",blackKnight2);
    board.put("C8B",blackBlackBishop);
    board.put("D8B",blackKing);
    board.put("E8B",blackQueen);
    board.put("F8B",blackWhiteBishop);
    board.put("G8B",blackKnight1);
    board.put("H8B",blackRook2 );
    
    board.put("A2W",whitePun1);
    board.put("B2W",whitePun2);
    board.put("C2W",whitePun3);
    board.put("D2W",whitePun4);
    board.put("E2W",whitePun5);
    board.put("F2W",whitePun6);
    board.put("G2W",whitePun7);
    board.put("H2W",whitePun8);
    
    board.put("A7B",blackPun1);
    board.put("B7B",blackPun2);
    board.put("C7B",blackPun3);
    board.put("D7B",blackPun4);
    board.put("E7B",blackPun5);
    board.put("F7B",blackPun6);
    board.put("G7B",blackPun7);
    board.put("H7B",blackPun8);
    board2= reversedMap(board);
}

ArrayList<Piece> removePiece(){
    return boardPieces;
}

Map<Piece, String> reversedMap (Map<String ,Piece> map1){
    Map<Piece,String> map2= new HashMap<Piece,String>();
    for (String k : map1.keySet()){
        map2.put(map1.get(k), k);
    }
    return map2;
}

public static void main(String args[]){
 /*  
System.out.print(new BoardState().blackBlackBishop.getName());
BoardState boardState = new BoardState();
ArrayList<String> nextMoves = boardState.whiteKing.nextMoves("F3W", "W", "B",boardState.board2);
System.out.println("These are possible moves");
    for (String move : nextMoves){
        System.out.println(move);
    }
    System.out.println(nextMoves.size());
    }

* 
*/
}
}