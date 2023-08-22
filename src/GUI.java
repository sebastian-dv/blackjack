package src;

import javax.swing.JFrame;

public class GUI {

    private JFrame frame;

    public GUI() {
        frame = new JFrame();
    }

    public void start() {
        frame.setTitle("Blackjack");
        frame.setSize(400, 400);
    }
}
