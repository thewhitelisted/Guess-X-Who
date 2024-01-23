package game;

import java.awt.event.MouseEvent;
/*
 * <h1>Game</h1>
 * Game.java is the logic for when you click a card and returns character data from the character csv file<br>
 * Contains code to start the timer for card flipping animation, or click a card for guessing the character,<br>
 * or clicking a card for getting info on a character<br>
 * cardClick, guessClick, and infoClick all use MouseEvent to find the correct index for the card<br>
 * guessClick and infoClick will return character data<br>
 * guessClick will return names, and infoClick will return character data<br>
 * <p>
 * 
 * @author Addison Wong
 * @version 1.0
 * @since 2023-12-09
 */
public class Game {
    public static Character player1;
    public static Character player2;

    public static boolean checkGuess(Character guess, Character answer) {
        //returns player's guess and checks if it is the right character
        return guess.strName.equals(answer.strName);
    }
    public static int index;

    public static void cardClick(MouseEvent e) {
        //Finds index of card based on what card players have clicked
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX - 20) / 140;
        int row = (MouseY - 20) / 140;
        index = row *5 + column;
        //If card is already flipped, it will set the flipped boolean to be false to indicate that the card is not flipped
        if (Main.game_panel.characters[index].isFlipped()) {
            Main.game_panel.characters[index].setFlipped(false);
            Main.game_panel.repaint();
            return;
        }
        //Otherwise when it is clicked, it sets flipping to be true and starts the timer for the animation
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
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX - 20) / 140;
        int row = (MouseY - 20) / 140;
        int index = row * 5 + column;
        if (index >= 0 && index < Main.game_panel.characters.length && Main.game_panel.characters[index] != null) {
            // Flip the card with animation
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

    public static Character getCharFromName(String name) {
        for (Character character : Main.game_panel.characters) {
            if (character.strName.equals(name)) {
                return character;
            }
        }
        return null;
    }
}
