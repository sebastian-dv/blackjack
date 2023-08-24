package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI {

    private JFrame frame;

    public GUI() {
        frame = new JFrame();
        frame.setTitle("Blackjack");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
    }

    public void start() {
        // panels for image and button
        JPanel panel = new JPanel();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(400, 75));
        
        // add image to panel
        JLabel img = createImage("images/bj.png", 350, 250);
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
        // Panels
        JPanel exit = new JPanel();
        JPanel dealer = new JPanel();
        JPanel player = new JPanel();
        JPanel playerButtons = new JPanel();

        dealer.setLayout(new BorderLayout());
        dealer.setBorder(new EmptyBorder(0, 10, 0, 10));
        player.setLayout(new BorderLayout());

        exit.setPreferredSize(new Dimension(75, 200));
        dealer.setPreferredSize(new Dimension(325, 200));
        playerButtons.setPreferredSize(new Dimension(75, 200));
        player.setPreferredSize(new Dimension(325, 200));

        exit.setBackground(new Color(1, 50, 32));
        dealer.setBackground(new Color(1, 50, 32));
        playerButtons.setBackground(new Color(1, 50, 32));
        player.setBackground(new Color(1, 50, 32));

        // Labels
        JLabel deck = createImage("images/card.png", 100, 150);

        // Starting the game
        Blackjack bj = new Blackjack();
        bj.play();
        Player p = bj.player;
        Player d = bj.dealer;

        // Buttons
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
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
                String card = bj.deal(p);
                dealCard(p, card);
            }
        });
        JButton stand = new JButton("Stand");
        stand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        

        // adding components to panels
        exit.add(exitButton);
        dealer.add(deck, BorderLayout.EAST);
        playerButtons.add(hit);
        playerButtons.add(stand);
        player.add(playerButtons, BorderLayout.WEST);

        // adding panels to frame
        frame.add(exit, BorderLayout.LINE_START);
        frame.add(dealer, BorderLayout.CENTER);
        frame.add(player, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    private JLabel createImage(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        return new JLabel(icon);
    }

    private void dealCard(Player p, String c) {
        String card = c.replace(' ', '_') + ".png";
        
    }
}
