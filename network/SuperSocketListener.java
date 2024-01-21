package network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import game.Main;
import game.PickFrame;
import game.QuestionPanel;

public class SuperSocketListener implements ActionListener {
    public static final int CONNECT = 0, DISCONNECT = 1, PICK = 2, QUESTION = 3, ANSWER = 4, CHAT = 5, ERROR = 6,
            PLAYERSREQ = 7, PLAYERS = 8, START = 9, TURN = 10;
    public boolean blnServer;
    public SuperSocketMaster ssm;
    public int counter = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ssm) {
            String strMessage = ssm.readText();
            System.out.println(strMessage);
            if (strMessage != null) {
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
                        return;
                    } else {
                        Main.chat_box.append("[SYS] User: " + strMessage.substring(2) + " has joined." + "\n");
                    }
                } else if (Integer.parseInt(strMessage.substring(0, 1)) == DISCONNECT && strMessage.substring(0, 2) == "1,") {
                    System.out.println("disconnect");
                    Main.chat_box.append("[SYS] User: " + strMessage.substring(2) + " has left." + "\n");
                } else if (Integer.parseInt(strMessage.substring(0,1)) == PICK) {
                    String args[] = strMessage.split(",");
                    if (!this.blnServer) {
                        // start from arg 1
                        Game.player2 = Game.getCharFromName(args[1]);
                        Main.main_frame.setContentPane(Main.main_panel);
                        Main.main_frame.pack();

                    }
                    // now that player one has picked (client), server picks
                    if (this.blnServer) {
                        // start from arg 1
                        Game.player1 = Game.getCharFromName(args[1]);
                        Main.main_frame.setContentPane(new PickFrame());
                        Main.main_frame.pack();
                    }
                } else if (Integer.parseInt(strMessage.substring(0, 1)) == QUESTION) {
                    String args[] = strMessage.split(",");
                    QuestionPanel.questionLog.append("[SYS] User: " + args[1] + " asked about " + args[2] + " being " + args[3] + "\n");
                    // enable to answer label, yes and no buttons
                    QuestionPanel.answerLabel.setVisible(true);
                    QuestionPanel.yesButton.setVisible(true);
                    QuestionPanel.noButton.setVisible(true);
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
                    System.out.println(counter);
                } else if (Integer.parseInt(strMessage.substring(0, 1)) == START) {
                    Main.chat_box.append("[SYS] Game started." + "\n");
                    Main.main_frame.setContentPane(new PickFrame());
                    Main.main_frame.pack();
                } else if (Integer.parseInt(strMessage) == TURN) {
                    System.out.println("turn");
                    Main.question_panel.submitButton.setEnabled(true);
                    QuestionPanel.questionLog.append("[SYS] It is your turn.\n");
                }
            }
        }

    }

    public SuperSocketListener(String strIP, int intPort) {
        blnServer = false;
        ssm = new SuperSocketMaster(strIP, intPort, this);
        ssm.connect();
    }

    public SuperSocketListener(int intPort) {
        blnServer = true;
        ssm = new SuperSocketMaster(intPort, this);
        ssm.connect();
    }

}
