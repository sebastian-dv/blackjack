package src;

public class Blackjack {

    Deck deck;
    Player player;
    Player dealer;
    private int currCard = 0;
    private static final int winCondition = 21;

    
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
        
    }

    public boolean checkWinner() {

        return false;
    }
}
