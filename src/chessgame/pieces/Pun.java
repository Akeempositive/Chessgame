package chessgame.pieces;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

public class Pun implements Piece {

    //Variable(s) Declaration
    private boolean capturedOnly = false;
    String name;
    private boolean enpassant = false;
    private boolean kingChecked = false;
    private String enpassantLocation = "";
    private Map<Piece, String> map;

    //Constructor(s)
    public Pun(String p) {
        name = p;
    }

    //Inteface Overwritten Method(s)
    @Override
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name= name;
    }

    @Override
    public ArrayList<String> nextMoves(String currentLocation, String color, String opponentColor) {
        String column = currentLocation.substring(0, 1);
        String[] columns = Piece.columns;
        int columnNumber = 0;
        if (column.equals("A")) {
            columnNumber = 0;
        } else if (column.equals("B")) {
            columnNumber = 1;
        } else if (column.equals("C")) {
            columnNumber = 2;
        } else if (column.equals("D")) {
            columnNumber = 3;
        } else if (column.equals("E")) {
            columnNumber = 4;
        } else if (column.equals("F")) {
            columnNumber = 5;
        } else if (column.equals("G")) {
            columnNumber = 6;
        } else if (column.equals("H")) {
            columnNumber = 7;
        }
        ArrayList<String> nextMoves = new ArrayList<String>();
        int row = Integer.parseInt(currentLocation.substring(1, 2));
        if (color.equals("W")) {
            int j[] = {1, 2};
            if (!capturedOnly) {
                for (int i : j) {
                    if (columnNumber <= 8 && columnNumber >= 0) {
                        if (i == 1) {
                            if (!(map.containsValue(columns[columnNumber] + Integer.toString(row + i) + opponentColor) || map.containsValue(columns[columnNumber] + Integer.toString(row + i) + color))) {
                                nextMoves.add(column + Integer.toString(row + i) + color);
                            }
                        }
                        if (row == 2 && i == 2 && !nextMoves.isEmpty()) {
                            if ((!map.containsValue(columns[columnNumber] + Integer.toString(row + i) + opponentColor) || map.containsValue(columns[columnNumber] + Integer.toString(row + i) + color))) {
                                nextMoves.add(columns[columnNumber] + Integer.toString(row + i) + color);
                            }
                        }
                    }
                }
            }
            j[0] = -1;
            j[1] = 1;
            for (int i2 : j) {
                if (columnNumber + i2 < 8 && columnNumber + i2 >= 0) {
                    if ((map.containsValue(columns[columnNumber + i2] + Integer.toString(row + 1) + opponentColor)) || (enpassant && enpassantLocation.equals(columns[columnNumber + i2] + Integer.toString(row + 1)))) {
                        nextMoves.add(columns[columnNumber + i2] + Integer.toString(row + 1) + color);
                    } else if (map.containsValue(columns[columnNumber + i2] + Integer.toString(row - 1) + color) && kingChecked) {
                        nextMoves.add(columns[columnNumber + i2] + Integer.toString(row - 1) + color);
                    }
                }

            }

        } else {
            int j[] = {1, 2};
            if (!capturedOnly) {
                for (int i : j) {
                    if (columnNumber <= 8 && columnNumber >= 0) {
                        if (i == 1) {
                            if (!(map.containsValue(columns[columnNumber] + Integer.toString(row - i) + opponentColor) || map.containsValue(columns[columnNumber] + Integer.toString(row - i) + color))) {
                                nextMoves.add(column + Integer.toString(row - i) + color);
                            }
                        }
                        if (row == 7 && i == 2 && !nextMoves.isEmpty()) {
                            if (!(map.containsValue(columns[columnNumber] + Integer.toString(row - i) + opponentColor) || map.containsValue(columns[columnNumber] + Integer.toString(row - i) + color))) {
                                nextMoves.add(columns[columnNumber] + Integer.toString(row - i) + color);
                            }
                        }
                    }
                }
            }
            j[0] = -1;
            j[1] = 1;
            for (int i2 : j) {
                if (columnNumber + i2 <= 7 && columnNumber + i2 >= 0) {
                    if ((map.containsValue(columns[columnNumber + i2] + Integer.toString(row - 1) + opponentColor)) || (enpassant && enpassantLocation.equals(columns[columnNumber + i2] + Integer.toString(row - 1)))) {
                        nextMoves.add(columns[columnNumber + i2] + Integer.toString(row - 1) + color);
                    } else if (map.containsValue(columns[columnNumber + i2] + Integer.toString(row - 1) + color) && kingChecked) {
                        nextMoves.add(columns[columnNumber + i2] + Integer.toString(row - 1) + color);
                    }
                }

            }
        }
        return nextMoves;
    }

    @Override
    public void setKingChecked() {
        kingChecked = true;
    }

    @Override
    public void setBoardState(Map<Piece, String> boardState) {
        map = boardState;
    }

    @Override
    public void setNotKingChecked() {
        kingChecked = false;
    }

    public boolean isCapturedOnly() {
        return capturedOnly;
    }

    public void setCapturedOnly(boolean capturedOnly) {
        this.capturedOnly = capturedOnly;
    }

    public boolean isEnpassant() {
        return enpassant;
    }

    public void setEnpassant(boolean enpassant) {
        this.enpassant = enpassant;
    }

    public boolean isKingChecked() {
        return kingChecked;
    }

    public void setKingChecked(boolean kingChecked) {
        this.kingChecked = kingChecked;
    }

    public String getEnpassantLocation() {
        return enpassantLocation;
    }

    public void setEnpassantLocation(String enpassantLocation) {
        this.enpassantLocation = enpassantLocation;
    }

    public Map<Piece, String> getMap() {
        return map;
    }

    public void setMap(Map<Piece, String> map) {
        this.map = map;
    }

}
