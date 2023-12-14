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
                if (Integer.parseInt(strMessage.substring(0, 1)) == CONNECT) {
                    Main.chat_box.append("User: " + strMessage.substring(2) +  " has joined." + "\n");
                } else if (Integer.parseInt(strMessage.substring(0, 1)) == CHAT) {
                    Main.chat_box.append(strMessage.substring(2) + "\n");
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
