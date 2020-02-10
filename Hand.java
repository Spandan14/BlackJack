import java.util.ArrayList;
public class Hand {
    private ArrayList<Card>hand;
    public Hand(Shoe s) {
        hand = new ArrayList<Card>();
        hand.add(s.dealCard());
        hand.add(s.dealCard());
    }
    public int hit(Shoe s) {
        hand.add(s.dealCard());
        return this.value();
    }
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
}