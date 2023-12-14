package game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Expression;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class QuestionPanel extends JPanel implements ActionListener{
    String[] strMainQuestions = {"Eye Color", "Hair Color", "Skin Color", "Hair Length", "Expression", "Hat Type", "Glasses Type", "Face Shape", "Gender", "Facial Hair"};
    String[] strEyeQuestions = {"Brown", "Blue", "Green"};
    String[] strHairQuestions = {"Black", "Brown", "Blonde"};
    String[] strSkinQuestions = {"White", "Black", "Brown"};
    String[] strLengthQuestions = {"Long", "Short", "Bald"};
    String[] strExpressionQuestions = {"Happy", "Angry", "Sad", "Neutral"};
    String[] strHatQuestions = {"None", "Cap", "Tophat"};
    String[] strGlassesQuestions = {"None", "Glasses", "Sunglasses"};
    String[] strFaceQuestions = {"Round", "Square", "Oval"};
    String[] strGenderQuestions = {"Male", "Female"};
    String[] strFacialQuestions = {"None", "Moustache", "Beard"};


    JComboBox mainQuestion = new JComboBox(strMainQuestions);
    JComboBox subQuestion = new JComboBox();

    QuestionPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(560, 360));

        mainQuestion.setBounds(10, 10, 100, 20);
        subQuestion.setBounds(110, 10, 100, 20);

        mainQuestion.addActionListener(this);
        this.add(mainQuestion);
        this.add(subQuestion);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainQuestion){
            if (mainQuestion.getSelectedItem().equals("Eye Color")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strEyeQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Hair Color")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strHairQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Skin Color")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strSkinQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Hair Length")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strLengthQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Expression")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strExpressionQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Hat Type")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strHatQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Glasses Type")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strGlassesQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Face Shape")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strFaceQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Gender")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strGenderQuestions);
            }else if (mainQuestion.getSelectedItem().equals("Facial Hair")){
                subQuestion.removeAllItems();
                subQuestion.addItem(strFacialQuestions);
            }

        }
    }
}
