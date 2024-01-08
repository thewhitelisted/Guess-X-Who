package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    // GamePanel is 720 x 720
    // Each image can be 120 x 120, with 20 size gap between and at the edges
    int intXPos = 20;
    int intYPos = 20;
    int intMouseX = 300;
    int intMouseY = 300;
    BufferedImage backside;
    
    Character[] characters = new Character[25];

    public Character[] getCharacters(){
        return characters;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 720, 720);
        for (int x = 0; x < 5; x++) {
            intYPos = 20;
            for (int y = 0; y < 5; y++) {
                // g.fillRect(intXPos, intYPos, 120, 120);
                if (characters[y * 5 + x] == null) {
                    break;
                }
                if (characters[y * 5 + x].isFlipped) {
                    g.drawImage(backside, intXPos, intYPos, null);
                    intYPos += 140;
                    continue;
                }
                g.drawImage(characters[y * 5 + x].imgIcon, intXPos, intYPos, null);
                // System.out.println(intXPos);
                intYPos += 140;
            }
            intXPos += 140;
        }
        intXPos = 20;
        intYPos = 20;
    }

    public GamePanel() {
        try {
            backside = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard.jpg"));
        } catch (IllegalArgumentException | IOException e) {
            try {
                backside = ImageIO.read(new File("game/img/backofcard.jpg"));
            } catch (IOException e1) {
            }
        }
        characters = Character.importCharacters();
    }
}
