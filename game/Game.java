package game;

public class Game {
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
}
