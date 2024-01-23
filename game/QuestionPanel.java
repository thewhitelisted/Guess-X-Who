package game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import network.SuperSocketListener;

public class QuestionPanel extends JPanel implements ActionListener{
    String[] strMainQuestions = {"Eye Color", "Hair Color", "Skin Color", "Hair Length", "Expression", "Hat Type", "Glasses Type", "Face Shape", "Gender", "Facial Hair", "Character"};
    String[] strEyeQuestions = {"Brown", "Blue", "Green", "Black"};
    String[] strHairQuestions = {"Black", "Brown", "Blonde"};
    String[] strSkinQuestions = {"White", "Black", "Brown"};
    String[] strLengthQuestions = {"Long", "Short", "Bald"};
    String[] strExpressionQuestions = {"Happy", "Angry", "Sad", "Neutral"};
    String[] strHatQuestions = {"None", "Cap", "Tophat"};
    String[] strGlassesQuestions = {"None", "Glasses", "Sunglasses"};
    String[] strFaceQuestions = {"Round", "Square", "Triangle"};
    String[] strGenderQuestions = {"Male", "Female"};
    String[] strFacialQuestions = {"None", "Moustache", "Beard"};

    JComboBox<String> mainQuestion = new JComboBox<>(strMainQuestions);
    JComboBox<String> subQuestion = new JComboBox<>(strEyeQuestions);

    public static JLabel answerLabel = new JLabel("ANSWER THE QUESTION");
    public static JButton yesButton = new JButton("Yes");
    public static JButton noButton = new JButton("No");

    JLabel characterLabel = new JLabel("Click on a face");
    JLabel infoLabel = new JLabel("Click on a face");

    public static JTextArea questionLog = new JTextArea();
    JScrollPane questionScroll = new JScrollPane(questionLog);

    public JButton submitButton = new JButton("Submit");
    JButton infoButton = new JButton("Get Info");

    boolean blnInfo = false;

    QuestionPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(560, 360));

        questionScroll.setBounds(0, 140, 560, 220);
        mainQuestion.setBounds(10, 10, 100, 20);
        subQuestion.setBounds(110, 10, 100, 20);
        submitButton.setBounds(250, 10, 100, 20);
        submitButton.setEnabled(false);
        infoButton.setBounds(10, 35, 100, 20);
        characterLabel.setBounds(120, 10, 100, 20);
        answerLabel.setBounds(10, 75, 200, 20);
        answerLabel.setVisible(false);
        yesButton.setBounds(10, 100, 100, 20);
        yesButton.setVisible(false);
        noButton.setBounds(120, 100, 100, 20);
        noButton.setVisible(false);
        infoLabel.setBounds(115, 35, 100, 20);

        questionLog.setEditable(false);

        characterLabel.setVisible(false);
        infoLabel.setVisible(false);

        infoButton.addActionListener(this);
        submitButton.addActionListener(this);
        mainQuestion.addActionListener(this);
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        this.add(questionScroll);
        this.add(mainQuestion);
        this.add(subQuestion);
        this.add(submitButton);
        this.add(characterLabel);
        this.add(infoButton);
        this.add(answerLabel);
        this.add(yesButton);
        this.add(noButton);
        this.add(infoLabel);

        DefaultCaret caret = (DefaultCaret) questionLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainQuestion){
            subQuestion.removeAllItems();
            characterLabel.setVisible(false);
            characterLabel.setText("Click on a face");
            subQuestion.setVisible(true);
            switch (mainQuestion.getSelectedItem().toString()) {
                case "Eye Color":
                    
                    for (String str : strEyeQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Hair Color":
                    for (String str : strHairQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Skin Color":
                    for (String str : strSkinQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Hair Length":
                    for (String str : strLengthQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Expression":
                    for (String str : strExpressionQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Hat Type":
                    for (String str : strHatQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Glasses Type":
                    for (String str : strGlassesQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Face Shape":
                    for (String str : strFaceQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Gender":
                    for (String str : strGenderQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Facial Hair":
                    for (String str : strFacialQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
                case "Character":
                    characterLabel.setVisible(true);
                    subQuestion.setVisible(false);
                    break;
            }
        }else if (e.getSource() == submitButton){
            if (mainQuestion.getSelectedItem() == "Character"){
                if (characterLabel.getText() != "Click on a face"){
                    questionLog.append("You asked about " + mainQuestion.getSelectedItem() + " being " + characterLabel.getText() + "\n");
                    Main.ssl.ssm.sendText(SuperSocketListener.QUESTION + "," + Main.ssl.ssm.getMyAddress() + "," + mainQuestion.getSelectedItem() + "," + characterLabel.getText());
                }
            }
            if (mainQuestion.getSelectedItem() != "Character"){
                questionLog.append("You asked about " + mainQuestion.getSelectedItem() + " being " + subQuestion.getSelectedItem() + "\n");
                Main.ssl.ssm.sendText(SuperSocketListener.QUESTION + "," + Main.ssl.ssm.getMyAddress() + "," + mainQuestion.getSelectedItem() + "," + subQuestion.getSelectedItem());
            }
            submitButton.setEnabled(false);
        } else if (e.getSource() == infoButton){
            blnInfo = true;
            infoLabel.setVisible(true);
        } else if (e.getSource() == yesButton) {
            questionLog.append("You answered yes to " + Main.ssl.strquestioninfo[0] + " being " + Main.ssl.strquestioninfo[1] + "\n");
            Main.ssl.ssm.sendText(SuperSocketListener.ANSWER + "," + Main.ssl.ssm.getMyAddress() + "," + Main.ssl.strquestioninfo[0] + "," + Main.ssl.strquestioninfo[1] + "," + "yes");
            answerLabel.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
        } else if (e.getSource() == noButton) {
            questionLog.append("You answered no to " + mainQuestion.getSelectedItem() + " being " + subQuestion.getSelectedItem() + "\n");
            Main.ssl.ssm.sendText(SuperSocketListener.ANSWER + "," + Main.ssl.ssm.getMyAddress() + "," + Main.ssl.strquestioninfo + "," + Main.ssl.strquestioninfo + "," + "no");
            answerLabel.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
        }
    }
}
