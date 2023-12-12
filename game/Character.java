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
    public HatType hatType;
    public boolean hasGlasses;
    public GlassesType glassesType;
    public boolean hasFacialHair;
    public FacialHair facialHair;
    public SkinColour skinColour;
    public HairLength hairLength;
    public Expression expression;
    public FaceType faceType;

    // Character constructor
    public Character(String name, HairColour hairColour, EyeColour eyeColour, HatType hatType, boolean hasGlasses, GlassesType glassesType, boolean hasFacialHair, FacialHair facialHair, SkinColour skinColour, HairLength hairLength, Expression expression, FaceType faceType) {
        this.strName = name;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
        this.hatType = hatType;
        this.hasGlasses = hasGlasses;
        this.glassesType = glassesType;
        this.hasFacialHair = hasFacialHair;
        this.facialHair = facialHair;
        this.skinColour = skinColour;
        this.hairLength = hairLength;
        this.expression = expression;
        this.faceType = faceType;
    }
}