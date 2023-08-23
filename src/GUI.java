package src;

import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

    private JFrame frame;
    private JPanel panel;
    private JPanel bottomPanel;
    private JButton play;
    private JButton hit;
    private JButton stand;

    public GUI() {
        frame = new JFrame();
        frame.setTitle("Blackjack");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setSize(400, 300);

        bottomPanel = new JPanel();

    }

    public void start() {
        GridBagLayout grid = new GridBagLayout();
        frame.setLayout(grid);

        play = new JButton("Play");
        play.setSize(100, 70);
        bottomPanel.add(play);
        
        frame.add(panel);
        frame.add(bottomPanel);
        frame.setVisible(true);
    }

    public void play() {

        frame.setVisible(true);
    }
}
