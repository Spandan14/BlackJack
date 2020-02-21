import java.util.Scanner;
public class HandTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to run?");
        while (scan.nextInt() == 1) {
            System.out.println("\u000C");
            Shoe mainshoe = new Shoe(4);
            Hand hand1 = new Hand(mainshoe);
            System.out.println(hand1);
            System.out.println("The hand is a blackjack?: " + hand1.isBlackjack());
         
            while (!hand1.isBust() && !hand1.isBlackjack()) {
                hand1.hit();
                System.out.println(hand1);
                System.out.println("The hand is a blackjack?: " + hand1.isBlackjack());
                System.out.println("The hand is a bust?: " + hand1.isBust());
            }
            
            System.out.println("Do you want to run?");
        }
    }
}