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
        WHITE,
        BALD
    }

    public enum SkinColour {
        WHITE,
        BLACK,
        BROWN,
    }

    public enum HairLength {
        BALD,
        SHORT,
        MEDIUM,
        LONG,
    }

    public enum Expression {
        HAPPY,
        SAD,
        ANGRY,
        NEUTRAL,
    }

    public enum HatType {
        NONE,
        CAP,
        TOPHAT,
    }

    public enum GlassesType {
        NONE,
        GLASSES,
        SUNGLASSES,
    }

    public enum FaceType {
        CIRCLE,
        SQUARE,
        OVAL,
    }

    public enum Gender {
        MALE,
        FEMALE,
    }

    public enum FacialHair {
        NONE,
        MOUSTACHE,
        BEARD,
    }

    // Character defining attributes
    public String strName;
    public HairColour hairColour;
    public EyeColour eyeColour;
    public boolean hasHat;

    // Character constructor
    public Character(String name) {
        // TODO: if statement to determine which character is being created
        strName = name;
    }
}