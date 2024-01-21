package game;

import java.awt.event.MouseEvent;

public class Game {
    public static int turn = 0;

    public static boolean checkGuess(Character guess, Character answer) {
        return guess == answer;
    }

    public static void cardClick(MouseEvent e){
        System.out.println("Card clicked");
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX-20)/140;
        int row = (MouseY-20)/140;
        int index = row * 5 + column;
        if (index >= 0 && index < Main.game_panel.characters.length && Main.game_panel.characters[index] != null) {
            // Flip the card with animation
            Main.game_panel.characters[index].setFlipped(!Main.game_panel.characters[index].isFlipped());
            Main.game_panel.repaint();
        }   
    }

    public static String guessClick(MouseEvent e){
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX-20)/140;
        int row = (MouseY-20)/140;
        int index = row * 5 + column;
        if (index >= 0 && index < Main.game_panel.characters.length && Main.game_panel.characters[index] != null) {
            // Flip the card with animation
            return Main.game_panel.characters[index].strName;
            //Main.game_panel.characters[index].setFlipped(!Main.game_panel.characters[index].isFlipped());
            //Main.game_panel.repaint();
        }
        else {
            return null;
        }   
    }

    public static String[] infoClick(MouseEvent e){
        System.out.println("Info");
        int MouseX = e.getX();
        int MouseY = e.getY();
        int column = (MouseX-20)/140;
        int row = (MouseY-20)/140;
        int index = row * 5 + column;
        if (index >= 0 && index < Main.game_panel.characters.length && Main.game_panel.characters[index] != null) {
            // Flip the card with animation
            System.out.println(returnCharacterData(Main.game_panel.characters[index]));
            Main.question_panel.infoLabel.setVisible(false);
            return returnCharacterData(Main.game_panel.characters[index]);
            //Main.game_panel.characters[index].setFlipped(!Main.game_panel.characters[index].isFlipped());
            //Main.game_panel.repaint();
        }
        else {
            return null;
        }   
    }

    public static String[] returnCharacterData(Character character) {
        return new String[] {character.strName, character.hairColour.toString(), character.eyeColour.toString(), character.hatType.toString(), character.glassesType.toString(), character.facialHair.toString(), character.skinColour.toString(), character.hairLength.toString(), character.expression.toString(), character.faceType.toString(), character.gender.toString()};
    }
}
