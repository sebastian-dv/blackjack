package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI {

    private JFrame frame;
    private JPanel player;
    private JPanel dealer;

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
        frame.setSize(600, 425);

        // Panels
        JPanel exit = new JPanel();
        dealer = new JPanel();
        player = new JPanel();
        JPanel playerButtons = new JPanel();

        dealer.setLayout(new FlowLayout(FlowLayout.LEFT));
        dealer.setBorder(new EmptyBorder(4, 5, 0, 10));
        player.setLayout(new FlowLayout(FlowLayout.LEFT));
        player.setBorder(new EmptyBorder(0, 0, 0, 0));
        playerButtons.setBorder(new EmptyBorder(16, 0, 0, 0));

        exit.setPreferredSize(new Dimension(75, 200));
        dealer.setPreferredSize(new Dimension(525, 200));
        playerButtons.setPreferredSize(new Dimension(75, 200));
        player.setPreferredSize(new Dimension(525, 200));

        exit.setBackground(new Color(1, 50, 32));
        dealer.setBackground(new Color(1, 50, 32));
        playerButtons.setBackground(new Color(1, 50, 32));
        player.setBackground(new Color(1, 50, 32));

        // Labels
        JLabel cardBack = createImage("images/card.png", 100, 150);

        // Starting the game
        Blackjack bj = new Blackjack();
        bj.play();
        Player p = bj.player;
        Player d = bj.dealer;
        
        // adding player's cards
        for (int i = 0; i < 2; i ++) {
            String card = p.getCard(i);
            card = "images/" + card.replace(' ', '_') + ".png";
            JLabel cardImage = createImage(card, 100, 150);
            player.add(cardImage);
        }

        // adding dealer's cards
        String card = d.getCard(0);
        card = "images/" + card.replace(' ', '_') + ".png";
        JLabel cardImage = createImage(card, 100, 150);
        dealer.add(cardImage);
        card = d.getCard(1);
        card = "images/" + card.replace(' ', '_') + ".png";
        cardImage = createImage(card, 100, 150);
        dealer.add(cardImage);
        
        //dealer.add(cardBack);

        // exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI gui = new GUI();
                gui.start();
            }
        });
        // hit button
        JButton hit = new JButton("Hit");
        hit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String card = bj.deal(p);
                card = "images/" + card.replace(' ', '_') + ".png";
                JLabel cardImage = createImage(card, 100, 150); 
                player.add(cardImage);
                p.calcPoints();
                frame.validate();;
                int points = p.getPoints();
                if (points > 21) {
                    playerButtons.setVisible(false);
                    player.setBorder(new EmptyBorder(25, 10, 0, 0));
                    results(bj);
                }
            }
        });
        // stand button
        JButton stand = new JButton("Stand");
        stand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerButtons.setVisible(false);
                player.setBorder(new EmptyBorder(25, 10, 0, 0));
                dealerTurn(d, bj);
                p.calcPoints();
                d.calcPoints();
                results(bj);
            }
        });;

        // adding components to panels
        exit.add(exitButton);
        playerButtons.add(hit);
        playerButtons.add(stand);
        player.add(playerButtons, FlowLayout.LEFT);

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

    private void dealerTurn(Player d, Blackjack b) {
        int i = 2;
        while (d.dealerHit()) {
            b.deal(d);
            String card = d.getCard(i);
            card = "images/" + card.replace(' ', '_') + ".png";
            JLabel cardImage = createImage(card, 100, 150);
            dealer.add(cardImage);
            i++;
        }
    }

    private void revealDealersCards(Player d) {

    }

    private void results(Blackjack b) {
        String results = b.checkWinner();

        JFrame f = new JFrame("Results");
        f.setSize(150, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        JLabel resultText = new JLabel(results + "!");

        JButton retry = new JButton("Play Again");
        retry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                frame.dispose();
                GUI gui = new GUI();
                gui.play();
            }
            
        });
        
        // center aligning components
        resultText.setAlignmentX(Component.CENTER_ALIGNMENT);
        retry.setAlignmentX(Component.CENTER_ALIGNMENT);

        // adding components to panel
        resultPanel.add(resultText, Component.CENTER_ALIGNMENT);
        resultPanel.add(retry, Component.CENTER_ALIGNMENT);

        // adding panel to frame
        f.add(resultPanel);

        f.setVisible(true);
    }
}
