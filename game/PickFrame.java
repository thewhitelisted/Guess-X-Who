package game;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PickFrame extends JPanel{
    JPanel panel;
    JLabel title = new JLabel("Pick a character");
    JButton pick = new JButton("Pick");
    String[] strCharacterQuestions = {"Adeline", "Aidan", "Alex", "Andrea", "Ariana", "Brandon", "Caitlyn", "Chloe", "Donald", "Fizan", "Jennifer", "Jensen", "Jeremy", "Johnny", "Jong", "Kimmy", "Milly", "Nathan", "Peter", "Poon", "Samira", "Seamus", "Taylor", "Thomphson", "Xinyan"};
    JComboBox<String> characters = new JComboBox<String>(strCharacterQuestions);

    public PickFrame(){
        this.add(title);
        this.add(pick);
        this.add(characters);
    }
}
