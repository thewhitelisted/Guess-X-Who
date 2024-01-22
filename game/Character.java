package game;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

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
        BALD,
        BLACK,
        BROWN,
        BLONDE
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
        TRIANGLE,
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
    public int RotationAngle = 0;
    public int getRotationAngle(){
        return RotationAngle;
    }
    public void setRotationAngle(int RotationAngle){
        this.RotationAngle = RotationAngle;
    }
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
    
    public boolean isFlipped(){
        return isFlipped;
    }
    public void setFlipped(boolean flipped){
        isFlipped = flipped;
    }
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
                System.out.println(line);
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

    // Character constructor
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