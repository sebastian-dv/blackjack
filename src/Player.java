package src;

import java.util.ArrayList;

public class Player {

    private int points;
    private ArrayList<String> hand;
    
    public Player() {
        points = 0;
        hand = new ArrayList<>();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int p) {
        points = p;
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
