package network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import game.Main;
import game.PickFrame;
import game.QuestionPanel;

/**
 * <h1>SuperSocketListener</h1>
 * A simple server client that allows for communication between two clients<br>
 * Manages all messages sent and received betweeen a server and the clients<br>
 * Allows for the server to act as a client as well
 * <p>
 * 
 * @author Christopher Lee
 * @version 1.0
 * @since 2023-12-09
 */
final public class SuperSocketListener implements ActionListener {
    public static final int CONNECT = 0, DISCONNECT = 1, PICK = 2, QUESTION = 3, ANSWER = 4, CHAT = 5, ERROR = 6,
            PLAYERSREQ = 7, PLAYERS = 8, START = 9, TURN = 10, END = 11;
    public boolean blnServer;
    public SuperSocketMaster ssm;
    public int counter = 1;
    public String[] strquestioninfo = new String[2];

    @Override
    public void actionPerformed(ActionEvent e) {
        // on the off chance that the source is not the ssm, return
        if (e.getSource() != ssm) {
            return;
        }
        String strMessage = ssm.readText();
        // on the off chance that the message is null, return
        if (strMessage == "") {
            return;
        }

        // Handle the message
        if (Integer.parseInt(strMessage.substring(0, 1)) == CONNECT) {
            if (!this.blnServer) {
                ssm.sendText(Integer.toString(PLAYERSREQ));
            }
            counter++;
            if (counter == 2) {
                Main.chat_box.append("[SYS] User: " + strMessage.substring(2) + " has joined." + "\n");
                Main.chat_box.append("[SYS] Game started." + "\n");
                ssm.sendText(START + "");
            } else if (counter > 2) {
                ssm.sendText(ERROR + "401" + strMessage.substring(2));
                counter = 2;
                return;
            } else {
                Main.chat_box.append("[SYS] User: " + strMessage.substring(2) + " has joined." + "\n");
            }
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == DISCONNECT && strMessage.substring(1,2).equals(",")) {
            Main.chat_box.append("[SYS] User: " + strMessage.substring(2) + " has left." + "\n");
        } else if (Integer.parseInt(strMessage.substring(0,1)) == PICK) {
            String args[] = strMessage.split(",");
            if (!this.blnServer) {
                // start from arg 1
                Game.player2 = Game.getCharFromName(args[1]);
                Main.main_frame.setContentPane(Main.main_panel);
                Main.main_frame.pack();
                return;
            }
            // now that player one has picked (client), server picks
            // start from arg 1
            Game.player1 = Game.getCharFromName(args[1]);
            Main.main_frame.setContentPane(new PickFrame());
            Main.main_frame.pack();
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == QUESTION) {
            String args[] = strMessage.split(",");
            QuestionPanel.questionLog.append("[SYS] User: " + args[1] + " asked about " + args[2] + " being " + args[3] + "\n");
            // enable to answer label, yes and no buttons
            QuestionPanel.answerLabel.setVisible(true);
            QuestionPanel.yesButton.setVisible(true);
            QuestionPanel.noButton.setVisible(true);
            strquestioninfo[0] = args[2];
            strquestioninfo[1] = args[3];
            if (strquestioninfo[0].equals("Character") && !this.blnServer) {
                // client is player1
                System.out.println(strquestioninfo[1] + " " + Game.player1.strName);
                if (Game.checkGuess(Game.getCharFromName(strquestioninfo[1]), Game.player2)) {
                    System.out.println("test");
                    Main.chat_box.append("[SYS] User: " + args[1] + " guessed correctly." + "\n");
                    Main.chat_box.append("[SYS] Game ended." + "\n");
                    ssm.sendText(CHAT + "," + "[SYS] You guessed correctly.");
                    ssm.sendText(CHAT + "," + "[SYS] Game ended.");
                    // disable everything
                    Main.question_panel.submitButton.setEnabled(false);
                    Main.question_panel.mainQuestion.setEnabled(false);
                    Main.question_panel.subQuestion.setEnabled(false);
                    QuestionPanel.answerLabel.setVisible(false);
                    QuestionPanel.yesButton.setVisible(false);
                    QuestionPanel.noButton.setVisible(false);
                    ssm.sendText(END + "");
                } 
            } else if (strquestioninfo[0].equals("Character") && this.blnServer) {
                // client is player1
                System.out.println(strquestioninfo[1] + " " + Game.player2.strName);
                if (Game.checkGuess(Game.getCharFromName(strquestioninfo[1]), Game.player1)) {
                    System.out.println("test");
                    Main.chat_box.append("[SYS] User: " + args[1] + " guessed correctly." + "\n");
                    Main.chat_box.append("[SYS] Game ended." + "\n");
                    ssm.sendText(CHAT + "," + "[SYS] You guessed correctly.");
                    ssm.sendText(CHAT + "," + "[SYS] Game ended.");
                    // disable everything
                    Main.question_panel.submitButton.setEnabled(false);
                    Main.question_panel.mainQuestion.setEnabled(false);
                    Main.question_panel.subQuestion.setEnabled(false);
                    QuestionPanel.answerLabel.setVisible(false);
                    QuestionPanel.yesButton.setVisible(false);
                    QuestionPanel.noButton.setVisible(false);
                    ssm.sendText(END + "");
                } 
            }
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == ANSWER) {
            String args[] = strMessage.split(",");
            QuestionPanel.questionLog.append("[SYS] User: " + args[1] + " answered " + args[2] + " being " + args[3] + " with " + args[4] + "\n");
            ssm.sendText(TURN + "");
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == CHAT) {
            Main.chat_box.append(strMessage.substring(2) + "\n");
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == ERROR) {
            // Handle ERROR message
            if (strMessage.substring(1, 4).equals("401") && ssm.getMyAddress().equals(strMessage.substring(4))) {
                Main.chat_box
                        .append("[SYS] You cannot join a game that has the maximum amount of players" + "\n");
                ssm.disconnect();
            }
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == PLAYERSREQ) {
            if (!this.blnServer) {
                return;
            }
            ssm.sendText(PLAYERS + "," + counter);
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == PLAYERS) {
            counter = Integer.parseInt(strMessage.substring(2));
        } else if (Integer.parseInt(strMessage.substring(0, 1)) == START) {
            Main.chat_box.append("[SYS] Game started." + "\n");
            Main.main_frame.setContentPane(new PickFrame());
            Main.main_frame.pack();
        } else if (!strMessage.substring(1, 2).equals(",") && strMessage.substring(1,2).equals("0")) {
            Main.question_panel.submitButton.setEnabled(true);
            QuestionPanel.questionLog.append("[SYS] It is your turn.\n");
        } else if (!strMessage.substring(1, 2).equals(",") && strMessage.substring(1,2).equals("0")) {
            Main.question_panel.submitButton.setEnabled(false);
            Main.question_panel.mainQuestion.setEnabled(false);
            Main.question_panel.subQuestion.setEnabled(false);
            QuestionPanel.answerLabel.setVisible(false);
            QuestionPanel.yesButton.setVisible(false);
            QuestionPanel.noButton.setVisible(false);
        }
    }

    /**
     * Create a SuperSocketListener that acts as a client
     * @param strIP IP address of the server
     * @param intPort Port of the server
     */
    public SuperSocketListener(String strIP, int intPort) {
        blnServer = false;
        ssm = new SuperSocketMaster(strIP, intPort, this);
        ssm.connect();
    }

    /**
     * Create a SuperSocketListener that acts as a server
     * @param intPort Port of the server
     */
    public SuperSocketListener(int intPort) {
        blnServer = true;
        ssm = new SuperSocketMaster(intPort, this);
        ssm.connect();
    }

}
