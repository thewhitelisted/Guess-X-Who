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
    String[] strCharacterQuestions = {"adeline", "aidan", "alex", "andrea", "ariana", "brandon", "caitlyn", "chloe", "donald", "fizan", "jennifer", "jensen", "jeremy", "johnny", "jong", "kimmy", "milly", "nathan", "peter", "poon", "samira", "seamus", "taylor", "thomphson", "xinyan"};

    JComboBox<String> mainQuestion = new JComboBox<>(strMainQuestions);
    JComboBox<String> subQuestion = new JComboBox<>(strEyeQuestions);

    JLabel characterLabel = new JLabel();

    public static JTextArea questionLog = new JTextArea();
    JScrollPane questionScroll = new JScrollPane(questionLog);

    JButton submitButton = new JButton("Submit");

    QuestionPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(560, 360));

        questionScroll.setBounds(0, 160, 560, 200);
        mainQuestion.setBounds(10, 10, 100, 20);
        subQuestion.setBounds(110, 10, 100, 20);
        submitButton.setBounds(250, 10, 100, 20);
        characterLabel.setBounds(110, 10, 100, 20);

        questionLog.setEditable(false);

        characterLabel.setVisible(false);

        submitButton.addActionListener(this);
        mainQuestion.addActionListener(this);
        this.add(questionScroll);
        this.add(mainQuestion);
        this.add(subQuestion);
        this.add(submitButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainQuestion){
            subQuestion.removeAllItems();
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
                    for (String str : strCharacterQuestions){
                        subQuestion.addItem(str);
                    }
                    break;
            }
        }else if (e.getSource() == submitButton){
            questionLog.append("You asked about " + mainQuestion.getSelectedItem() + " being " + subQuestion.getSelectedItem() + "\n");
            Main.ssl.ssm.sendText(SuperSocketListener.QUESTION + "," + Main.ssl.ssm.getMyAddress() + "," + mainQuestion.getSelectedItem() + "," + subQuestion.getSelectedItem());
        }
    }
}
