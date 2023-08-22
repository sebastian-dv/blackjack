package src;

import java.util.ArrayList;
import java.util.Map;

public class Player {

    private int points;
    private ArrayList<String> hand;
    private static final Map<String, Integer> values = Map.ofEntries(
        Map.entry("TWO", 2),
        Map.entry("THREE", 3),
        Map.entry("FOUR", 4),
        Map.entry("FIVE", 5),
        Map.entry("SIX", 6),
        Map.entry("SEVEN", 7),
        Map.entry("EIGHT", 8),
        Map.entry("NINE", 9),
        Map.entry("TEN", 10),
        Map.entry("JACK", 10),
        Map.entry("QUEEN", 10),
        Map.entry("KING", 10)
    );
    
    public Player() {
        points = 0;
        hand = new ArrayList<>();
    }

    public int getPoints() {
        return points;
    }

    public void calcPoints() {
        points = 0;
        int s = hand.size();
        boolean ace = false;
        for (int i = 0; i < s; i++) {
            int index = hand.get(i).indexOf(" ");
            String rank = hand.get(i).substring(0, index);
            if (rank.equals("ACE")) {
                ace = true;
            } else {
                points += values.get(rank);
            }
        }
        if (ace) {
            if (points + 11 > 21) {
                points += 1;
            } else {
                points += 11;
            }
        }
    }

    public void addHand(String s) {
        hand.add(s);
    }

    // return true on hit, false on stand
    public boolean playerHit() {
        
        return false;
    }

    // return true on hit, false on stand
    public boolean dealerHit() {
        if (this.getPoints() < 17) {
            return true;
        }
        return false;
    }
}
