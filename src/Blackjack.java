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
    }

    public String deal(Player p) {
        String card = deck.getCard(currCard);
        p.addHand(card);
        currCard++;
        return card;
    }

    public String checkWinner() {
        if (player.getPoints() > 21) {
            return "Bust";
        }
        if (dealer.getPoints() > 21) {
            return "You Win";
        }
        if (player.getPoints() == dealer.getPoints()) {
            return "Tie";
        }
        if (player.getPoints() == 21 && dealer.getPoints() != 21) {
            return "You Win";
        }
        if (player.getPoints() > dealer.getPoints()) {
            return "You Win";
        } else {
            return "You Lose";
        }
    }
}
