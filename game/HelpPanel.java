package game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener{

    GamePanel help_game_panel = new GamePanel();
    QuestionPanel help_question_panel = new QuestionPanel();
    JPanel textPanel1 = new JPanel();
    JPanel textPanel2 = new JPanel();

    JLabel rule1 = new JLabel("Here are the rules for Guess Who:");
    JLabel rule2 = new JLabel("You and your opponent have to choose a character from this grid");
    JLabel rule3 = new JLabel("The goal is to guess your opponent's character by asking yes / no questions");
    JLabel rule4 = new JLabel("You can flip over faces in the grid to assist and narrow down the possibilities");
    JLabel rule5 = new JLabel("Here is how you can ask questions to each other");
    JLabel rule6 = new JLabel("The subquestion will change depending on your main question");
    JLabel rule7 = new JLabel("You can guess for characteristics or individual characters");
    JLabel rule8 = new JLabel("All interactions will be available in the question log");
    JLabel rule9 = new JLabel("To guess a character, or to get info, ");
    JLabel rule10 = new JLabel("You will pick your character by clicking on the face");
    JLabel rule11 = new JLabel("");

    JButton nextButton = new JButton("Next");
    JButton backButton = new JButton("Back");


    public HelpPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(1280, 720));
        help_game_panel.setBounds(0, 0, 720, 720);
        help_game_panel.setPreferredSize(new Dimension(720, 720));
        help_game_panel.setLayout(null);
        textPanel1.setLayout(null);
        textPanel1.setBounds(720,0,560,720);
        textPanel1.setPreferredSize(new Dimension(560, 720));
        help_question_panel.setLayout(null);
        help_question_panel.setBounds(720, 0, 560, 360);
        help_question_panel.setPreferredSize(new Dimension(560, 360));
        textPanel2.setLayout(null);
        textPanel2.setBounds(0, 0, 720, 720);
        textPanel2.setPreferredSize(new Dimension(720, 720));
        
        this.add(help_game_panel);
        this.add(textPanel2);
        this.add(help_question_panel);
        this.add(textPanel1);
        
        help_question_panel.setVisible(false);
        textPanel2.setVisible(false);

        rule1.setFont(rule1.getFont().deriveFont(14.0f));
        rule2.setFont(rule2.getFont().deriveFont(10.0f));
        rule3.setFont(rule3.getFont().deriveFont(10.0f));
        rule4.setFont(rule4.getFont().deriveFont(10.0f));
        rule5.setFont(rule5.getFont().deriveFont(10.0f));
        rule6.setFont(rule6.getFont().deriveFont(10.0f));
        rule7.setFont(rule7.getFont().deriveFont(10.0f));
        rule8.setFont(rule8.getFont().deriveFont(10.0f));
        rule9.setFont(rule9.getFont().deriveFont(10.0f));
        rule10.setFont(rule10.getFont().deriveFont(10.0f));
        rule11.setFont(rule11.getFont().deriveFont(10.0f));

        this.nextButton.setBounds(50, 500, 120, 120);
        this.backButton.setBounds(50, 500, 120, 120);

        this.rule1.setBounds(50,0, 500, 40);
        this.rule2.setBounds(50, 40, 500, 40);
        this.rule3.setBounds(50, 80, 500, 40);
        this.rule4.setBounds(50, 120, 500, 30);
        this.rule5.setBounds(50, 160, 500, 30);
        this.rule6.setBounds(50, 200, 500, 30);
        this.rule7.setBounds(50, 240, 500, 30);
        this.rule8.setBounds(50, 280, 500, 30);
        this.rule9.setBounds(50, 320, 500, 30);
        this.rule10.setBounds(50, 360, 500, 30);
        this.rule11.setBounds(50, 400, 500, 30);

        help_game_panel.addMouseListener(this);
        help_game_panel.addMouseMotionListener(this);

        nextButton.addActionListener(this);
        backButton.addActionListener(this);

        textPanel1.add(rule1);
        textPanel1.add(rule2);
        textPanel1.add(rule3);
        textPanel1.add(rule4);
        textPanel1.add(nextButton);

        textPanel2.add(rule5);
        textPanel2.add(rule6);
        textPanel2.add(rule7);
        textPanel2.add(rule8);
        textPanel2.add(rule9);
        textPanel2.add(rule10);
        textPanel2.add(backButton);

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Game.cardClick(e);
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton){
            help_game_panel.setVisible(false);
            textPanel1.setVisible(false);
            nextButton.setVisible(false);
            backButton.setVisible(true);
            help_question_panel.setVisible(true);
            textPanel2.setVisible(true);
        }else if (e.getSource() == backButton){
            help_game_panel.setVisible(true);
            textPanel1.setVisible(true);
            nextButton.setVisible(true);
            backButton.setVisible(false);
            help_question_panel.setVisible(false);
            textPanel2.setVisible(false);
        }
    }
}
