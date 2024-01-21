package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import network.SuperSocketListener;

final public class PickFrame extends JPanel implements ActionListener{
    JPanel panel;
    JLabel title = new JLabel("Pick a character");
    JButton pick = new JButton("Pick");
    String[] strCharacterQuestions = {"Adeline", "Aidan", "Alex", "Andrea", "Ariana", "Brandon", "Caitlyn", "Chloe", "Donald", "Fizan", "Jennifer", "Jensen", "Jeremy", "Johnny", "Jong", "Kimmy", "Milly", "Nathan", "Peter", "Poon", "Samira", "Seamus", "Taylor", "Thomphson", "Xinyan"};
    JComboBox<String> characters = new JComboBox<String>(strCharacterQuestions);

    public PickFrame(){
        this.setBounds(0, 0, 1280, 720);
        this.add(title);
        this.add(characters);
        this.add(pick);
        this.pick.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pick) {
            if (!Main.ssl.blnServer) {
                Game.player1 = Game.getCharFromName(strCharacterQuestions[characters.getSelectedIndex()]);
            } else {
                Game.player2 = Game.getCharFromName(strCharacterQuestions[characters.getSelectedIndex()]);
                Main.main_frame.setContentPane(Main.main_panel);
                Main.main_frame.pack();
                    
                Main.ssl.ssm.sendText(SuperSocketListener.TURN + "");
            }
            Main.ssl.ssm.sendText(SuperSocketListener.PICK + "," + strCharacterQuestions[characters.getSelectedIndex()]);
        }
    }
}
