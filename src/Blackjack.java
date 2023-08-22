package src;

public class Blackjack {

    Deck deck;
    Player player;
    Player dealer;
    private int currCard = 0;
    
    public Blackjack() {
        deck = new Deck();
        deck.shuffle();
        player = new Player();
        dealer = new Player();
    }

    public void reset() {
        currCard = 0;
    }

    public void play() {
        deal(player);
        deal(dealer);
        deal(player);
        deal(dealer);
        while(player.playerHit() || dealer.dealerHit()) {
            player.playerHit();
            dealer.dealerHit();
        }
        checkWinner();
    }

    public void deal(Player p) {
        String card = deck.getCard(currCard);
        p.addHand(card);
        currCard++;
    }

    public String checkWinner() {
        if (player.getPoints() > 21) {
            return "Bust";
        }
        if (dealer.getPoints() > 21) {
            return "Win";
        }
        if (player.getPoints() == 21 && dealer.getPoints() == 21) {
            return "Tie";
        }
        if (player.getPoints() == 21 && dealer.getPoints() != 21) {
            return "Win";
        }
        if (player.getPoints() > dealer.getPoints()) {
            return "Win";
        } else {
            return "Lose";
        }
    }
}
