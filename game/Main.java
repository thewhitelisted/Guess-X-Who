package game;

// TODO: find way to restrict users to 2 players

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import network.SuperSocketListener;

public class Main implements ActionListener, WindowListener {
    private JFrame main_frame = new JFrame("Guess X Who");
    private JPanel main_panel = new JPanel();

    // connect and create frames
    private JFrame connect_frame = new JFrame("Connect to a game");
    private JPanel connect_panel = new JPanel();
    private JFrame create_frame = new JFrame("Create a game");
    private JPanel create_panel = new JPanel();

    // connect and create panel components
    private JLabel connect_ip_label = new JLabel("IP Address");
    private JLabel connect_port_label = new JLabel("Port Number");
    private JLabel create_port_label = new JLabel("Port Number");
    private JTextField connect_ip = new JTextField(50);
    private JTextField connect_port = new JTextField(50);
    private JTextField create_port = new JTextField(50);
    private JButton connect_button = new JButton("Connect");
    private JButton create_button = new JButton("Create");

    // game panel will contain the game board, and the character cards
    public GamePanel game_panel = new GamePanel();

    // chat panel will contain the chat box, and the chat input
    public static JTextArea chat_box = new JTextArea();
    public JTextField chat_input = new JTextField(50);
    public JPanel chat_panel = new JPanel();
    public JScrollPane chat_scroll = new JScrollPane(chat_box);

    // question panel will contain the question box, and the question input
    private QuestionPanel question_panel = new QuestionPanel();

    // JMenuBar
    private JMenuBar menu_bar = new JMenuBar();
    private JMenu menu = new JMenu("Game");
    private JMenuItem create_game = new JMenuItem("Create Game");
    private JMenuItem join_game = new JMenuItem("Join Game");
    private JMenuItem exit_game = new JMenuItem("Exit Game");

    // SuperSocketListener
    private SuperSocketListener ssl;

    // action listener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chat_input) {
            // send chat message
            if (chat_input.getText().length() == 0) {
                return;
            }
            if (ssl == null) {
                chat_box.append("[SYS] You are not connected to a game.\n");
                chat_input.setText("");
                return;
            }
            ssl.ssm.sendText(SuperSocketListener.CHAT + "," + ssl.ssm.getMyAddress() + ": " + chat_input.getText());
            chat_box.append("You: " + chat_input.getText() + "\n");
            chat_input.setText("");
        } else if (e.getSource() == create_game) {
            // create dialog box to get port number
            create_frame.setVisible(true);
        } else if (e.getSource() == join_game) {
            // create dialog box to get ip address and port number
            connect_frame.setVisible(true);
        } else if (e.getSource() == exit_game) {
            ssl.ssm.sendText(SuperSocketListener.DISCONNECT + "," + ssl.ssm.getMyAddress());
            chat_box.append("[SYS] User: " + ssl.ssm.getMyAddress() + " has left." + "\n");
            ssl.ssm.disconnect();
        } else if (e.getSource() == connect_button) {
            // connect to server
            ssl = new SuperSocketListener(connect_ip.getText(), Integer.parseInt(connect_port.getText()));
            ssl.ssm.sendText(SuperSocketListener.CONNECT + "," + ssl.ssm.getMyAddress());
            chat_box.append("[SYS] Connected to ip address: " + connect_ip.getText() + " and port number: "
                    + connect_port.getText() + "\n");
            chat_box.append("[SYS] User: " + ssl.ssm.getMyAddress() + " has joined.\n");
            connect_frame.setVisible(false);
        } else if (e.getSource() == create_button) {
            // create server
            ssl = new SuperSocketListener(Integer.parseInt(create_port.getText()));
            chat_box.append("[SYS] Server created at ip address: " + ssl.ssm.getMyAddress() + " and port number: "
                    + create_port.getText() + "\n");
            create_frame.setVisible(false);
        }
    }

    // window listener
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if (ssl != null) {
            ssl.ssm.sendText(SuperSocketListener.DISCONNECT + "," + ssl.ssm.getMyAddress());
            ssl.ssm.disconnect();
        }
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    public Main() {
        main_panel.setPreferredSize(new Dimension(1280, 720));
        main_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        main_frame.addWindowListener(this);
        main_frame.setContentPane(main_panel);
        main_panel.setLayout(new BoxLayout(this.main_panel, BoxLayout.X_AXIS));

        connect_panel.setPreferredSize(new Dimension(300, 300));
        connect_frame.setContentPane(connect_panel);
        connect_frame.pack();
        connect_frame.setResizable(false);
        connect_panel.setLayout(null);

        // connect components
        connect_ip_label.setBounds(0, 0, 300, 50);
        connect_panel.add(connect_ip_label);
        connect_ip.setBounds(0, 50, 300, 50);
        connect_panel.add(connect_ip);
        connect_port_label.setBounds(0, 100, 300, 50);
        connect_panel.add(connect_port_label);
        connect_port.setBounds(0, 150, 300, 50);
        connect_panel.add(connect_port);
        connect_button.setBounds(0, 200, 300, 50);
        connect_panel.add(connect_button);

        create_panel.setPreferredSize(new Dimension(300, 300));
        create_frame.setContentPane(create_panel);
        create_frame.pack();
        create_frame.setResizable(false);
        create_panel.setLayout(null);

        // create components
        create_port_label.setBounds(0, 0, 300, 50);
        create_panel.add(create_port_label);
        create_port.setBounds(0, 50, 300, 50);
        create_panel.add(create_port);
        create_button.setBounds(0, 100, 300, 50);
        create_panel.add(create_button);

        menu.add(create_game);
        menu.add(join_game);
        menu.add(exit_game);
        menu_bar.add(menu);
        main_frame.setJMenuBar(menu_bar);

        create_game.addActionListener(this);
        join_game.addActionListener(this);
        exit_game.addActionListener(this);
        connect_button.addActionListener(this);
        create_button.addActionListener(this);

        main_panel.setBounds(0, 0, 1280, 720);
        main_panel.setLayout(null);

        main_panel.add(game_panel);
        main_panel.add(chat_panel);
        main_panel.add(question_panel);

        game_panel.setBounds(0, 0, 720, 720);
        game_panel.setPreferredSize(new Dimension(720, 720));
        game_panel.setLayout(null);

        chat_panel.setBounds(720, 360, 560, 360);
        chat_panel.setPreferredSize(new Dimension(560, 360));
        chat_panel.setLayout(null);

        question_panel.setBounds(720, 0, 560, 360);
        question_panel.setPreferredSize(new Dimension(560, 360));

        chat_scroll.setBounds(0, 0, 560, 325);
        chat_box.setEditable(false);

        chat_panel.add(chat_scroll);
        chat_input.setBounds(0, 325, 560, 35);
        chat_input.addActionListener(this);
        chat_panel.add(chat_input);
        DefaultCaret caret = (DefaultCaret) chat_box.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        main_frame.pack();
        main_frame.setResizable(false);
        main_frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
