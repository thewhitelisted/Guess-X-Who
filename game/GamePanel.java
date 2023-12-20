package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    // GamePanel is 720 x 720
    // Each image can be 120 x 120, with 20 size gap between and at the edges
    int intXPos = 20;
    int intYPos = 20;

    InputStream r1c1input = null;
    InputStream r1c2input = null;
    InputStream r1c3input = null;
    InputStream r1c4input = null;
    InputStream r1c5input = null;
    BufferedImage r1c1 = null;
    BufferedImage r1c2 = null;
    BufferedImage r1c3 = null;
    BufferedImage r1c4 = null;
    BufferedImage r1c5 = null;
    
    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        for (int x = 0; x < 5; x++){
            intYPos = 20;
            for(int y = 0; y < 5; y++){
                //g.fillRect(intXPos, intYPos, 120, 120);
                g.drawImage(r1c1, intXPos, intYPos, null);
                //System.out.println(intXPos);
                intYPos += 140;
            }
            intXPos += 140;
        }
    }

    public GamePanel(){
        r1c1input = this.getClass().getResourceAsStream("img/poon.png");
        try{
            r1c1 = ImageIO.read(r1c1input);
        }catch(IOException e){
            // if poonpicture does not load, load from folder
            try {
                r1c1 = ImageIO.read(new File("img/poon.png"));
            } catch (IOException e1) {
            } 
        }
    }
}
