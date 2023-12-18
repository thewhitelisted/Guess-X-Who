package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    // GamePanel is 720 x 720
    // Each image can be 120 x 120, with 20 size gap between and at the edges
    int intXPos = 20;
    int intYPos = 20;
    
    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        for (int x = 0; x < 5; x++){
            intYPos = 0;
            for(int y = 0; y < 5; y++){
                //g.fillRect(intXPos, intYPos, 120, 120);
                System.out.println(intXPos);
                intYPos += 140;
            }
            intXPos += 140;
        }
    }

    public GamePanel(){
        
    }
}
