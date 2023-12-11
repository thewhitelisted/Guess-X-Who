package game;
public class Character {

    public enum EyeColour {
        BLACK,
        BROWN,
        BLUE,
        GREEN,
    }
    
    public enum HairColour {
        BLACK,
        BROWN,
        BLONDE,
        RED,
        GREY,
        WHITE,
        BALD
    }

    // Character defining attributes
    public String strName;
    HairColour hairColour;
    EyeColour eyeColour;
    boolean hasHat;

    // Character constructor
    public Character(String name) {
        // TODO: if statement to determine which character is being created
        strName = name;
    }
}