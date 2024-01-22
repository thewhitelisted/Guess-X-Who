package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

public class Game implements ActionListener{
    public static Character player1;
    public static Character player2;

    public static boolean checkGuess(Character guess, Character answer) {
        return guess == answer;
    }

    Timer timer = new Timer(1000 / 48, this);
    public int cardindex = 0;
    public static int index;
    /* 
    public void startCardFlip() {
        timer.start();
    }
*/
    public void cardFlip(ActionEvent evt) {
        /* 
        Main.game_panel.flipImage = Main.game_panel.cardBackFrames[Main.game_panel.intAnimationFrame];
        Main.game_panel.intAnimationFrame++;
        if (Main.game_panel.intAnimationFrame == 13) {
            timer.stop();
            //Main.game_panel.intAnimationFrame = 0;
            Main.game_panel.onlyOneAnimation = -1;
        }
        Main.game_panel.repaint();
            */
    }

    public static void cardClick(MouseEvent e) {
        System.out.println("Card clicked");
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX - 20) / 140;
        int row = (MouseY - 20) / 140;
        index = row *5 + column;
        System.out.println(index + "index");
        if (Main.game_panel.characters[index].isFlipped()) {
            Main.game_panel.characters[index].setFlipped(false);
            Main.game_panel.repaint();
            return;
        }
        Main.game_panel.characters[index].flipping = true;
        Main.game_panel.startCardFlip(index);
        Main.game_panel.characters[index].setFlipped(!Main.game_panel.characters[index].isFlipped());
        Main.game_panel.repaint();
    }

    public static String guessClick(MouseEvent e) {
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX - 20) / 140;
        int row = (MouseY - 20) / 140;
        int index = row * 5 + column;
        if (index >= 0 && index < Main.game_panel.characters.length && Main.game_panel.characters[index] != null) {
            // Flip the card with animation
            return Main.game_panel.characters[index].strName;
            // Main.game_panel.characters[index].setFlipped(!Main.game_panel.characters[index].isFlipped());
            // Main.game_panel.repaint();
        } else {
            return null;
        }
    }

    public static String[] infoClick(MouseEvent e) {
        System.out.println("Info");
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX - 20) / 140;
        int row = (MouseY - 20) / 140;
        int index = row * 5 + column;
        if (index >= 0 && index < Main.game_panel.characters.length && Main.game_panel.characters[index] != null) {
            // Flip the card with animation

            System.out.println(returnCharacterData(Main.game_panel.characters[index]));
            Main.question_panel.infoLabel.setVisible(false);
            return returnCharacterData(Main.game_panel.characters[index]);
            // Main.game_panel.characters[index].setFlipped(!Main.game_panel.characters[index].isFlipped());
            // Main.game_panel.repaint();
        } else {
            return null;
        }
    }

    public static String[] returnCharacterData(Character character) {
        return new String[] { character.strName, character.hairColour.toString(), character.eyeColour.toString(),
                character.hatType.toString(), character.glassesType.toString(), character.facialHair.toString(),
                character.skinColour.toString(), character.hairLength.toString(), character.expression.toString(),
                character.faceType.toString(), character.gender.toString() };
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
       /* 
        if (evt.getSource() == timer) {
            cardFlip(evt);
            Main.game_panel.repaint();
        }
        */
    }

    public static Character getCharFromName(String name) {
        for (Character character : Main.game_panel.characters) {
            if (character.strName.equals(name)) {
                return character;
            }
        }
        return null;
    }
}
