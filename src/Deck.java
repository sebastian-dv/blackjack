package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    Rank rank;
    Suit suit;
    private String[] cards = new String[52];

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards[rank.ordinal() + suit.ordinal() * 13] = rank + " of " + suit;
            }
        }
    }

    public void shuffle() {
        List<String> cardList = Arrays.asList(cards);
        Collections.shuffle(cardList);
        cardList.toArray(cards);
    }

    public String[] getCards() {
        return cards;
    }
}
