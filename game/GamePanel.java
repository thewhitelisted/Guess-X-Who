package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
    // GamePanel is 720 x 720
    // Each image can be 120 x 120, with 20 size gap between and at the edges
    int intXPos = 20;
    int intYPos = 20;
    int intMouseX = 300;
    int intMouseY = 300;
    int cardindex = 0;
    //Timer timer = new Timer(1000/48, this);
    /* 
    BufferedImage redcard = null;
    */
    BufferedImage backside = null;
    BufferedImage redcard = null;
    BufferedImage backside1 = null;
    BufferedImage backside2 = null;
    BufferedImage backside3 = null;
    BufferedImage backside4 = null;
    BufferedImage backside5 = null;
    BufferedImage backside6 = null;
    BufferedImage backside7 = null;
    BufferedImage backside8 = null;
    BufferedImage backside9 = null;
    BufferedImage backside10 = null;
    BufferedImage backside11 = null;
    BufferedImage backside12 = null;
    BufferedImage[] cardBackFrames = new BufferedImage[] {
        redcard, backside1, backside2, backside3, backside4, backside5,
        backside6, backside7, backside8, backside9, backside10,
        backside11, backside12
    };

    Character[] characters = new Character[25];

    public Character[] getCharacters(){
        return characters;
    }
    public void cardFlip(BufferedImage[] cardBackFrames, ActionEvent e){  
        
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
                g.setColor(Color.WHITE);
                g.drawString(characters[y * 5 + x].strName, intXPos + 5, intYPos + 10);
                // System.out.println(intXPos);
                intYPos += 140;
            }
            intXPos += 140;
        }
        intXPos = 20;
        intYPos = 20;
    }
    /* 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer){
            cardindex++;
            if(cardindex >=cardBackFrames.length){
                cardindex = 0;
                timer.stop();
            }
            repaint();
        }
    }
    */
    public GamePanel() {
        try {
            backside = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard.jpg"));
            backside1 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard1.jpg"));
            backside2 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard2.jpg"));
            backside3 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard3.jpg"));
            backside4 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard4.jpg"));
            backside5 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard5.jpg"));
            backside6 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard6.jpg"));
            backside7 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard7.jpg"));
            backside8 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard8.jpg"));
            backside9 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard9.jpg"));
            backside10 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard10.jpg"));
            backside11 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard11.jpg"));
            backside12 = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/backofcard12.jpg"));
            redcard = ImageIO.read(Character.class.getClassLoader().getResourceAsStream("game/img/redcard.jpg"));
        } catch (IllegalArgumentException | IOException e) {
            try {
                backside = ImageIO.read(new File("game/img/backofcard.jpg"));
                backside1 = ImageIO.read(new File("game/img/backofcard1.jpg"));
                backside2 = ImageIO.read(new File("game/img/backofcard2.jpg"));
                backside3 = ImageIO.read(new File("game/img/backofcard3.jpg"));
                backside4 = ImageIO.read(new File("game/img/backofcard4.jpg"));
                backside5 = ImageIO.read(new File("game/img/backofcard5.jpg"));
                backside6 = ImageIO.read(new File("game/img/backofcard6.jpg"));
                backside7 = ImageIO.read(new File("game/img/backofcard7.jpg"));
                backside8 = ImageIO.read(new File("game/img/backofcard8.jpg"));
                backside9 = ImageIO.read(new File("game/img/backofcard9.jpg"));
                backside10 = ImageIO.read(new File("game/img/backofcard10.jpg"));
                backside11 = ImageIO.read(new File("game/img/backofcard11.jpg"));
                backside12 = ImageIO.read(new File("game/img/backofcard12.jpg"));
                redcard = ImageIO.read(new File("game/img/redcard.jpg"));

            } catch (IOException e1) {
            }
        }
        characters = Character.importCharacters();
    }

   
}
