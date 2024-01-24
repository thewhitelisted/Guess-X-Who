package game;

import java.awt.event.ActionEvent;

/**
 * <h1>Help Question Panel</h1>
 * additional question panel used for the help screen to prevent bugs <br>
 * only has code to change the comboboxes. Buttons do not do anything
 * 
 * @author Nicholas Poon
 * @version 1.0
 * @since 2023-12-09
 */
public class HelpQuestionPanel extends QuestionPanel{
    
    public HelpQuestionPanel(){

    }

    @Override
    public void actionPerformed(ActionEvent e){
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
        }
    }

}
