/**
 * @author Spandan Goel
 * @class Hand
 */
import java.util.ArrayList;
public class Hand {
    private ArrayList<Card>hand;
    private Shoe s;
    public Hand(Shoe sh) {
        hand = new ArrayList<Card>();
        s = sh;
        s.shuffleShoe();
        hand.add(s.dealCard());
        hand.add(s.dealCard());
    }
    /**
     * Hit method
     * @param Shoe shoe to deal from
     * @return int new value of hand
     */
    public int hit() {
        hand.add(s.dealCard());
        return this.value();
    }
    /**
     * Value method
     * @return int value of hand
     */
    public int value() {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            sum += (hand.get(i)).getCardValue();
        }
        if (sum > 21) {
            for (int i = 0; i < hand.size(); i++) {
                if ((hand.get(i)).isAce()) {
                    sum -= 10;
                }
            }
        }
        return sum;
    }
    /**
     * checks for Blackjack
     * @return boolean if blackjack exists
     */
    public boolean isBlackjack() {
        if (hand.size() == 2)
            return this.value() == 21;
        return false;
    }
    /**
     * checks for bust
     * @return boolean if hand is a bust
     */
    public boolean isBust() {
        return this.value() > 21;
    }
    public Card returnFirstCard() {
        return hand.get(0);
    }
    /**
     * returns hand
     * @return string cards in hand
     */
    public String toString() {
        String output = "";
        for (Card i: hand) {
            output += i.toString() + "\n";
        }
        output += ("The value of the hand is: " + String.valueOf(this.value()));
        return output;
    }
}