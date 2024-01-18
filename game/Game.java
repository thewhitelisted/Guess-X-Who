package game;

import java.awt.event.MouseEvent;

public class Game {
    public static int turn = 0;

    public static boolean checkGuess(Character guess, Character answer) {
        return guess == answer;
    }

    public static boolean flippedWrong(Character[] characters, Character answer) {
        for (Character character : characters) {
            if (character.isFlipped && character == answer) {
                return true;
            }
        }
        return false;
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
}
