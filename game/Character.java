package game;

import java.awt.image.BufferedImage;

public class Character {
    // file format: name, file, skin colour, hair colour, eye colour, 
    // hair length, expression, hat type, glasses type, face type, 
    // gender facial hair

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
        BROWN
    }

    public enum HairLength {
        BALD,
        SHORT,
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
    public BufferedImage imgIcon;
    public HairColour hairColour;
    public EyeColour eyeColour;
    public HatType hatType;
    public GlassesType glassesType;
    public boolean hasFacialHair;
    public FacialHair facialHair;
    public SkinColour skinColour;
    public HairLength hairLength;
    public Expression expression;
    public FaceType faceType;
    public Gender gender;
    public boolean isFlipped = false;

    // Character constructor
    public Character(String name, BufferedImage imgIcon, HairColour hairColour, EyeColour eyeColour, HatType hatType, GlassesType glassesType, FacialHair facialHair, SkinColour skinColour, HairLength hairLength, Expression expression, FaceType faceType, Gender gender) {
        this.strName = name;
        this.imgIcon = imgIcon;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
        this.hatType = hatType;
        this.glassesType = glassesType;
        this.facialHair = facialHair;
        this.skinColour = skinColour;
        this.hairLength = hairLength;
        this.expression = expression;
        this.faceType = faceType;
        this.gender = gender;
    }
}