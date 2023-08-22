package src;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI {

    private JFrame frame;
    ImageIcon image = new ImageIcon("icon.png");

    public GUI() {
        frame = new JFrame();
    }

    public void start() {
        frame.setTitle("Blackjack");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(image.getImage());
        frame.setVisible(true);
    }
}
