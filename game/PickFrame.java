package game;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PickFrame extends JFrame{
    JPanel panel;
    JLabel title = new JLabel("Pick a character");
    JButton pick = new JButton("Pick");
    String[] strCharacterQuestions = {"Adeline", "Aidan", "Alex", "Andrea", "Ariana", "Brandon", "Caitlyn", "Chloe", "Donald", "Fizan", "Jennifer", "Jensen", "Jeremy", "Johnny", "Jong", "Kimmy", "Milly", "Nathan", "Peter", "Poon", "Samira", "Seamus", "Taylor", "Thomphson", "Xinyan"};
    JComboBox<String> characters = new JComboBox<String>(strCharacterQuestions);

    public PickFrame(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);

        // add components
        panel.add(title);
        panel.add(pick);
        panel.add(characters);

        this.add(panel);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
