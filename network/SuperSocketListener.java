package network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import game.Main;
import game.PickFrame;
import game.QuestionPanel;

public class SuperSocketListener implements ActionListener {
    public static final int CONNECT = 0, DISCONNECT = 1, PICK = 2, QUESTION = 3, ANSWER = 4, CHAT = 5, ERROR = 6,
            PLAYERSREQ = 7, PLAYERS = 8, START = 9;
    public boolean blnServer;
    public SuperSocketMaster ssm;
    public int counter = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ssm) {
            String strMessage = ssm.readText();
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
                } else if (Integer.parseInt(strMessage.substring(0, 1)) == DISCONNECT) {
                    Main.chat_box.append("[SYS] User: " + strMessage.substring(2) + " has left." + "\n");
                } else if (Integer.parseInt(strMessage.substring(0,1)) == PICK) {
                } else if (Integer.parseInt(strMessage.substring(0, 1)) == QUESTION) {
                    String args[] = strMessage.split(",");
                    // TODO: HANDLE TURNS
                    QuestionPanel.questionLog.append("[SYS] User: " + args[1] + " asked about " + args[2] + " being " + args[3] + "\n");
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
