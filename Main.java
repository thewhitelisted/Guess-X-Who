import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import network.SuperSocketListener;

public class Main implements ActionListener{
    JFrame main_frame = new JFrame("Guess X Who");
    JPanel main_panel = new JPanel();

    // connect and create frames
    JFrame connect_frame = new JFrame("Connect to a game");
    JPanel connect_panel = new JPanel();
    JFrame create_frame = new JFrame("Create a game");
    JPanel create_panel = new JPanel();

    // connect and create panel components
    JLabel connect_ip_label = new JLabel("IP Address");
    JLabel connect_port_label = new JLabel("Port Number");
    JLabel create_port_label = new JLabel("Port Number");
    JTextField connect_ip = new JTextField(50);
    JTextField connect_port = new JTextField(50);
    JTextField create_port = new JTextField(50);
    JButton connect_button = new JButton("Connect");
    JButton create_button = new JButton("Create");

    // game panel will contain the game board, and the character cards
    // TODO: add game board and character cards
    JPanel game_panel = new JPanel();

    // chat panel will contain the chat box, and the chat input
    JPanel chat_panel = new JPanel();
    JTextArea chat_box = new JTextArea(10, 50);
    JTextField chat_input = new JTextField(50);

    // question panel will contain the question box, and the question input
    JFrame question_frame = new JFrame("Ask a question");
    JPanel question_panel = new JPanel();

    // JMenuBar
    JMenuBar menu_bar = new JMenuBar();
    JMenu menu = new JMenu("Game");
    JMenuItem create_game = new JMenuItem("Create Game");
    JMenuItem join_game = new JMenuItem("Join Game");

    // SuperSocketListener
    SuperSocketListener ssl;

    // action listener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chat_input) {
            String input = chat_input.getText();
            chat_box.append(input + "\n");
            chat_input.setText("");
        } else if (e.getSource() == create_game) {
            // create dialog box to get port number
            create_frame.setVisible(true);
        } else if (e.getSource() == join_game) {
            // create dialog box to get ip address and port number
            connect_frame.setVisible(true);
        } else if (e.getSource() == connect_button) {
            // connect to server
            ssl = new SuperSocketListener(connect_ip.getText(), Integer.parseInt(connect_port.getText()));
            connect_frame.setVisible(false);
        } else if (e.getSource() == create_button) {
            // create server
            ssl = new SuperSocketListener(Integer.parseInt(create_port.getText()));
            create_frame.setVisible(false);
        }
    }

    public Main() {
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setPreferredSize(new Dimension(800, 635));
        main_frame.setVisible(true);
        main_frame.setContentPane(main_panel);
        main_panel.setLayout(new BoxLayout(this.main_panel, BoxLayout.X_AXIS));

        connect_panel.setPreferredSize(new Dimension(300,300));
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

        create_panel.setPreferredSize(new Dimension(300,300));
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
        menu_bar.add(menu);
        main_frame.setJMenuBar(menu_bar);

        create_game.addActionListener(this);
        join_game.addActionListener(this);
        connect_button.addActionListener(this);
        create_button.addActionListener(this);

        main_panel.setBounds(0, 0, 800, 600);
        main_panel.setLayout(null);
        game_panel.setPreferredSize(new Dimension(600, 600));
        main_panel.add(game_panel);
        chat_panel.setPreferredSize(new Dimension(200, 600));
        main_panel.add(chat_panel);

        game_panel.setBounds(0, 0, 600, 600);
        game_panel.setLayout(null);

        chat_panel.setBounds(600, 0, 200, 600);
        chat_panel.setLayout(null);
        chat_box.setBounds(0, 0, 200, 525);
        chat_box.setEditable(false);
        chat_box.setFocusable(false);
        chat_panel.add(chat_box);
        chat_input.setBounds(0, 525, 200, 50);
        chat_panel.add(chat_input);
        chat_input.grabFocus();
        chat_input.addActionListener(this);

        main_frame.pack();
        main_frame.setResizable(false);
    }

    public static void main(String[] args) {
        new Main();
    }
}
