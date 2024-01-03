package game;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    // GamePanel is 720 x 720
    // Each image can be 120 x 120, with 20 size gap between and at the edges
    int intXPos = 20;
    int intYPos = 20;

    Character[] characters = new Character[25];
    
    public void paintComponent(Graphics g){
        for (int x = 0; x < 5; x++){
            intYPos = 20;
            for(int y = 0; y < 5; y++){
                //g.fillRect(intXPos, intYPos, 120, 120);
                if (characters[y * 5 + x] == null){
                    break;
                }
                g.drawImage(characters[y * 5 + x].imgIcon, intXPos, intYPos, null);
                //System.out.println(intXPos);
                intYPos += 140;
            }
            intXPos += 140;
        }
        intXPos = 20;
        intYPos = 20;
    }

    public GamePanel(){
        characters = Character.importCharacters();
    }
}
