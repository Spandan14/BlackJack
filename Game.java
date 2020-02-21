import java.util.Scanner;
public class Game
{
   private Shoe gameShoe;
   private ComPlayer computer;
   private PlayerChips playerMoney;
   private Scanner scan;
   private Hand userHand;
   public Game()  {
       gameShoe = new Shoe(7);
       computer = new ComPlayer(gameShoe);
       playerMoney = new PlayerChips(1000);
       scan = new Scanner(System.in);
       Hand userHand = new Hand(gameShoe);
   }
   public void runGame() {
    
   }
   public void startGame() {
       System.out.println(userHand);
       System.out.println("One of com's cards is hidden. The other one is: " + computer.getFirstCard());
       System.out.println("What is your bet?: ");
       while (scan.nextInt() % 10 != 0 || scan.nextInt() <= 0 || scan.nextInt() > playerMoney.getChips()) {
           System.out.println("Invalid Bet! Do you want me to call the bouncer?!");
           System.out.println("What is your bet?: ");
       }
       if (computer.getHand().isBlackjack() || userHand.isBlackjack()) {
           calculateWinnings();
       }
   }
   public void calculateWinnings() {
       if (computer.getHand().isBlackjack()) {
           System.out.println("Computer has blackjack! Lucky it!");
           if (userHand.isBlackjack()) {
               System.out.println("Fate determines that you also have blackjack! Such insanity!");
               System.out.println("A push occurs!");
               playerMoney.push();
               return;
           }
       }
       if (userHand.isBlackjack()) {
           System.out.println("The stars have aligned in your favor to give you blackjack!");
           playerMoney.addChips((5*playerMoney.getBet())/2);
           return;
       }
       if (userHand.isBust()) {
           System.out.println("Oh no, you bust! Such a loser");
           return;
       }
       if (userHand.value() < computer.getHand().value()) {
           System.out.println("Oh no, your value is smaller than the computer's. Such a loser");
           System.out.println("Your hand's details:\n" + userHand);
           System.out.println("Computer's hand's details:\n" + computer.getHand());
           
       }
   }
}
