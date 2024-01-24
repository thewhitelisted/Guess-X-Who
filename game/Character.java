package game;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

/** 
 * <h1>Character</h1>
 * A character class that stores all the information about a character<br>
 * Contains code to import character data from a csv file<br>
 * <p>
 * 
 * @author Christopher Lee
 * @version 1.0
 * @since 2023-12-09
 */
public class Character {
    // file format: name, file, skin colour, hair colour, eye colour,
    // hair length, expression, hat type, glasses type, face type,
    // gender facial hair

    /**
     * <h1>EyeColour</h1>
     * An enum that stores all the possible eye colours<br>
     */
    public enum EyeColour {
        BLACK,
        BROWN,
        BLUE,
        GREEN,
    }

    /**
     * <h1>HairColour</h1>
     * An enum that stores all the possible hair colours<br>
     */
    public enum HairColour {
        BALD,
        BLACK,
        BROWN,
        BLONDE
    }

    /**
     * <h1>SkinColour</h1>
     * An enum that stores all the possible skin colours<br>
     */
    public enum SkinColour {
        WHITE,
        BLACK,
        BROWN
    }

    /**
     * <h1>HairLength</h1>
     * An enum that stores all the possible hair lengths<br>
     */
    public enum HairLength {
        BALD,
        SHORT,
        LONG,
    }

    /**
     * <h1>Expression</h1>
     * An enum that stores all the possible expressions<br>
     */
    public enum Expression {
        HAPPY,
        SAD,
        ANGRY,
        NEUTRAL,
    }

    /**
     * <h1>HatType</h1>
     * An enum that stores all the possible hat types<br>
     */
    public enum HatType {
        NONE,
        CAP,
        TOPHAT,
    }

    /**
     * <h1>GlassesType</h1>
     * An enum that stores all the possible glasses types<br>
     */
    public enum GlassesType {
        NONE,
        GLASSES,
        SUNGLASSES,
    }

    /**
     * <h1>FaceType</h1>
     * An enum that stores all the possible face types<br>
     */
    public enum FaceType {
        CIRCLE,
        SQUARE,
        TRIANGLE,
        OVAL,
    }

    /**
     * <h1>Gender</h1>
     * An enum that stores all possible genders<br>
     */
    public enum Gender {
        MALE,
        FEMALE,
    }

    /**
     * <h1>FacialHair</h1>
     * An enum that stores all possible facial hair types<br>
     */
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
    public boolean flipping = false;
    
    /**
     * <h1>isFlipped</h1>
     * Checks if the card is flipped or not<br>
     * @return flip state of the card<br>
     */
    public boolean isFlipped(){
        return isFlipped;
    }

    /**
     * <h1>setFlipped</h1>
     * Sets the flip state of the card<br>
     * @param flipped
     */
    public void setFlipped(boolean flipped){
        isFlipped = flipped;
    }

    /**
     * <h1>importCharacters</h1>
     * Imports all the characters from a csv file<br>
     * @return an array of characters<br>
     */
    public static Character[] importCharacters() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("game/characters.csv"));
        } catch (FileNotFoundException e) {
        }

        Character[] characters = new Character[25];
        String line = "";
        String[] character;
        int idx = 0;

        try {
            while ((line = br.readLine()) != null) {
                character = line.split(",");
                
                String name = character[0];
                BufferedImage icon = null;
                try {
                    icon = ImageIO.read(Character.class.getClassLoader().getResourceAsStream(character[1]));
                } catch (IllegalArgumentException | IOException e) {
                    icon = ImageIO.read(new File(character[1]));
                }
                Character.HairColour hair_colour = Character.HairColour.valueOf(character[2]);
                Character.EyeColour eye_colour = Character.EyeColour.valueOf(character[3]);
                Character.HatType hat_type = Character.HatType.valueOf(character[4]);
                Character.GlassesType glasses_type = Character.GlassesType.valueOf(character[5]);
                Character.FacialHair facial_hair = Character.FacialHair.valueOf(character[6]);
                Character.SkinColour skin_colour = Character.SkinColour.valueOf(character[7]);
                Character.HairLength hair_length = Character.HairLength.valueOf(character[8]);
                Character.Expression expression = Character.Expression.valueOf(character[9]);
                Character.FaceType faceType = Character.FaceType.valueOf(character[10]);
                Character.Gender gender = Character.Gender.valueOf(character[11]);
                characters[idx] = new Character(name, icon, hair_colour, eye_colour, hat_type, glasses_type,
                        facial_hair, skin_colour, hair_length, expression, faceType, gender);
                idx++;
            }
        } catch (IOException e) {
        }
        return characters;
    }

    /**
     * <h1>Character</h1>
     * Constructor for the character class<br>
     * @param name
     * @param imgIcon
     * @param hairColour
     * @param eyeColour
     * @param hatType
     * @param glassesType
     * @param facialHair
     * @param skinColour
     * @param hairLength
     * @param expression
     * @param faceType
     * @param gender
     */
    public Character(String name, BufferedImage imgIcon, HairColour hairColour, EyeColour eyeColour, HatType hatType,
            GlassesType glassesType, FacialHair facialHair, SkinColour skinColour, HairLength hairLength,
            Expression expression, FaceType faceType, Gender gender) {
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