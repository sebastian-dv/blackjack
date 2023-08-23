package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {

    private JFrame frame;

    public GUI() {
        frame = new JFrame();
        frame.setTitle("Blackjack");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout(0, 0));
    }

    public void start() {
        // panels for image and button
        JPanel panel = new JPanel();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(400, 75));
        
        // add image to panel
        JLabel img = createImage("bj.png", 350, 250);
        panel.add(img);
        
        // create and add button to panel
        JButton play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI gui = new GUI();
                gui.play();
            }
        });
        bottomPanel.add(play);

        // add panel to frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void play() {
        //Panels


        // Buttons
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI gui = new GUI();
                gui.start();
            }
        });
        JButton hit = new JButton("Hit");
        hit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JButton stand = new JButton("Stand");
        stand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        frame.setVisible(true);
    }

    private JLabel createImage(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        return new JLabel(icon);
    }
}
