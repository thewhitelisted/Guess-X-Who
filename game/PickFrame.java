package game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import network.SuperSocketListener;

/**
 * <h1>PickFrame</h1>
 * This frame allows the user to pick a character <br>
 * <p>
 * 
 * @since 2023-12-09
 */
final public class PickFrame extends JPanel implements ActionListener{
    JPanel panel;
    JLabel title = new JLabel("Pick a character");
    JButton pick = new JButton("Pick");
    String[] strCharacterQuestions = {"adeline", "aidan", "alex", "andrea", "ariana", "brandon", "caitlyn", "chloe", "donald", "fizan", "jennifer", "jensen", "jeremy", "johnny", "jong", "kimmy", "milly", "nathan", "peter", "poon", "samira", "seamus", "taylor", "thomphson", "xinyan"};
    JComboBox<String> characters = new JComboBox<String>(strCharacterQuestions);

    public PickFrame(){
        this.setPreferredSize(new Dimension(1280, 720));

        // set the coordinates of the components

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
