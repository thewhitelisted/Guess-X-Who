package network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperSocketListener implements ActionListener{
    public static final int CONNECT=0, DISCONNECT=1, PICK=2, QUESTION=3, ANSWER=4, CHAT=5;
    public boolean blnServer;
    public boolean blnConnected;
    public SuperSocketMaster ssm;

    @Override
    public void actionPerformed(ActionEvent e) {
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
