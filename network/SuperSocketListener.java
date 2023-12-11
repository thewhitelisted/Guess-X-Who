package network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.Main;

public class SuperSocketListener implements ActionListener{
    public static final int CONNECT=0, DISCONNECT=1, PICK=2, QUESTION=3, ANSWER=4, CHAT=5;
    public boolean blnServer;
    public SuperSocketMaster ssm;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ssm) {
            String strMessage = ssm.readText();
            if (strMessage != null) {
                String[] strMessageSplit = strMessage.split(",");
                if (Integer.parseInt(strMessageSplit[0]) == CHAT) {
                    // chat message
                    String strSendMessage[] = new String[strMessageSplit.length - 2];
                    for (int i = 2; i < strMessageSplit.length; i++) {
                        strSendMessage[i - 2] = strMessageSplit[i];
                    }
                    Main.chat_box.append(strMessageSplit[1] + ": " + String.join(",", strSendMessage) + "\n");
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
