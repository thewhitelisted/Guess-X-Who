package game;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PickFrame extends JPanel{
    JLabel title = new JLabel("Pick a character");
    JButton pick = new JButton("Pick");
    String[] strCharacterQuestions = {"Adeline", "Aidan", "Alex", "Andrea", "Ariana", "Brandon", "Caitlyn", "Chloe", "Donald", "Fizan", "Jennifer", "Jensen", "Jeremy", "Johnny", "Jong", "Kimmy", "Milly", "Nathan", "Peter", "Poon", "Samira", "Seamus", "Taylor", "Thomphson", "Xinyan"};
    JComboBox<String> characters = new JComboBox<String>(strCharacterQuestions);

    public PickFrame(){
        this.setLayout(null);
        this.setBounds(0, 0, 1280, 720);

        // put components on panel
        title.setBounds(0, 0, 800, 50);
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);

        characters.setBounds(300, 100, 200, 30);
        characters.setSelectedIndex(0);
        characters.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        this.add(characters);

        pick.setBounds(350, 150, 100, 30);
        pick.setAlignmentX(JButton.CENTER_ALIGNMENT);
        this.add(pick);

        this.setSize(800, 600);
    }
}
