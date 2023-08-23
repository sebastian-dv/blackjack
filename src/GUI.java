package src;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI {

    private JFrame frame;
    private JPanel panel;
    private JPanel bottomPanel;
    private JButton play;
    private JButton hit;
    private JButton stand;
    
    private ImageIcon card;

    public GUI() {
        frame = new JFrame();
        frame.setTitle("Blackjack");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        

        card = new ImageIcon(getClass().getResource("card.png"));

        bottomPanel = new JPanel();
    }

    public void start() {
        frame.setLayout(new BorderLayout(0, 10)); 

        JLabel img = new JLabel(card);
        panel.add(img, BorderLayout.CENTER);
        
        play = new JButton("Play");
        play.setSize(100, 70);
        bottomPanel.add(play, BorderLayout.PAGE_END);

        frame.add(panel);
        frame.add(bottomPanel);
        frame.setVisible(true);
    }

    public void play() {

        frame.setVisible(true);
    }
}
