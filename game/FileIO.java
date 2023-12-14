package game;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileIO {
    public static Character[] importCharacters() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("game/characters.csv"));
        } catch (FileNotFoundException e) {}

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
                    icon = ImageIO.read(new File(character[1]));
                } catch (IOException e) {}
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
                characters[idx] = new Character(name, icon, hair_colour, eye_colour, hat_type, glasses_type, facial_hair, skin_colour, hair_length, expression, faceType, gender);
                idx++;
            }
        } catch (IOException e) {}
        return characters;
    }
}
