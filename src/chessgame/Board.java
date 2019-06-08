package chessgame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Board extends JComponent{
    private static final long serialVersionUID = 1L;
    Color color; int locationX, locationY;
    
    Board(Color c, int x, int y){
        color=c;
        locationX= x;
        locationY=y;
        
    }
    
    public void paints(Graphics g){
        g.setColor(color);
        g.fillRect(locationX,locationY,50,50);   
     } // end main

}
