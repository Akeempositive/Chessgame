package chessgame;

import chessgame.pieces.Piece;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ChessEngine{
    static private int LEVEL_HARD=3, LEVEL_MEDIUM=2, LEVEL_EASY=1, LEVEL_AMATEUR=0;
    static private String  player;
    static private int bestScore;
    static private Map<String, Piece> boardState;
    static private GameEvent gameEvent;
    static String [] kings,bestMove=new String[2];
    
    public ChessEngine(Map<String, Piece> boardState, String [] kings,String player){
        this.boardState= boardState;
        gameEvent= new GameEvent(boardState);
        this.kings= kings;
        this.player = player;
    } 
    
    private static String kingLocation(String[] kings, String c){
        if(c.equals("W")){
            return kings[0];
        }
        return kings[1];
    }
    
    @SuppressWarnings("unchecked")
    static ArrayList<ArrayList<String>> allMoves(String color, Map<String, Piece> boardState){
        ArrayList<Object> outputs = gameEvent.getPlayerPiece(color);
        ArrayList<ArrayList<String>> allMoves= new ArrayList<ArrayList<String>>();
        ArrayList<Piece> pieces = (ArrayList<Piece>) outputs.get(0);
        ArrayList<String> locations= (ArrayList<String>)outputs.get(1);
        int i=0;
        while (i< pieces.size()){
            ArrayList<String>pieceMoves= new ArrayList<String>();
            pieceMoves.add(locations.get(i));
            Piece piece = pieces.get(i);
            piece.setNotKingChecked();
            piece.setBoardState(gameEvent.reversedMap2(boardState));
            ArrayList<String> pieceMove= piece.nextMoves(locations.get(i), color, alt(color));
            for(String move : pieceMove){
                Map<String, Piece>boardState2= updateBoard(boardState, locations.get(i), move, color);
                if(gameEvent.isKingChecked(color, gameEvent.reversedMap2(boardState2), kingLocation(kings, color))){
                   pieceMoves.add(move); 
                   //System.out.println("King not checked with  movement from " + locations.get(i)  + " to " + move + " by  " + piece.getName());
                  // System.exit(0);
                }               
            }
            if(pieceMoves.size()>1){
                allMoves.add(pieceMoves);
            }
            i++;
        }
        return allMoves;
    }
    
    static Map<String, Piece> updateBoard(Map<String, Piece> boardState, String from, String to, String color){
        String color2 = alt(color);
        String oppo=to.substring(0,2) + color2;
        if(boardState.containsKey(oppo)){
            boardState.remove(oppo);
        }
        boardState.remove(from);
        return boardState;
    } 
    
    static int scoreMove(String from, String to, String color, Map<String,Piece> boardState){
        return 0;
    }
    
    static int bestMove(int max, int current, String currentMove){
        if(max>current){
            return max;
        } else {
           // bestMove= currentMove;
            return current;
        }
    }
    
    private static void initiateEngine(int LEVEL_HARD, String color) {
       
    }

    public static void main(String args[]){
    String color="White";
    initiateEngine(ChessEngine.LEVEL_HARD,color );
    System.out.println("gameEnded");
    int a =  new Scanner(System.in).nextInt();
    System.out.println( a==3 ? "  It is 3" : "It is not 3");
    /*
     * Minimaxing Algorithm
     * 
   
     */    
}
    
    private static String alt(String player){
        if(player.equals("W")){
            return "B";
        }
        return "W";
    }

    String[] miniMaxing(Map<String, Piece> boardState,String player, int maxDepth,int currentDepth){
        ArrayList<ArrayList<String>> allMoves = allMoves(player, boardState);
       /* if(currentDepth==maxDepth){
            currentDepth++;
            player= alt(player);
            return miniMaxing(boardState,player,maxDepth,currentDepth);
        //return board.evaluate(Player), None;
        } else {
     
     * 
     */
        /*for (ArrayList<String> pieceMove : allMoves){
                int i =1 ;
                while (i< pieceMove.size()){
                    int moveScore = scoreMove(pieceMove.get(0),pieceMove.get(i), player, boardState);
                    if(moveScore>bestScore && player.equals(this.player)){
                        bestMove[0] = pieceMove.get(0);
                        bestMove[1]= pieceMove.get(i);
                    } else if (moveScore<bestScore && !player.equals(this.player)){
                        bestMove[0]= pieceMove.get(0);
                        bestMove[1]= pieceMove.get(i);
                    }
                    i++;
                }
            }
    //}
    * 
    */
        int i = (int)(Math.random() * allMoves.size());
        ArrayList<String> pieceMoves = allMoves.get(i);
        int j = (int) (Math.random() * pieceMoves.size())+1;
        if(j==pieceMoves.size()){
            j--;
        }
        bestMove[0]= pieceMoves.get(0);
        bestMove[1]= pieceMoves.get(j);
    //bestMove= None
    /*
     * if(board.currentPlayer()==player):bestScore=-INFINITY;
     * else bestScore=INFINITY;
     * Go throughn each move
     * for move in board.getMOves();
     *  newBoard=board.makeMOve(move)
     * Recurse
     * currentScore, currentMove= miniMax(newBoard, player, maxDepth, currentDepth+1)
     * 
     * update the bestScore
     * if(board.currentPlayer()==player):
     * if(currentScore>bestScore):
     * bestScore=currenScore
     * bestMove=move;
     * else:
     *  if currentScore<bestScore:
     *  bestScore=currentScore
     * bestMove= move
     * Return the score and the best move
     * return bestScore, bestMove
     */
        return bestMove;
    }
    
}