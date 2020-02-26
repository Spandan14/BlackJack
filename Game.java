


import java.util.Scanner;
public class Game
{
    private Shoe gameShoe;
    private ComPlayer computer;
    private PlayerChips playerMoney;
    private Scanner scan;
    public Game()  {
        gameShoe = new Shoe(7);
        playerMoney = new PlayerChips(1000);
        scan = new Scanner(System.in);
    }
    public void runGame() {
        System.out.println("\u000C");
        System.out.println("Welcome to the [segmentation fault (core dumped)] casino!");
        while (playerMoney.getChips() > 0) {
            System.out.println();
            System.out.println();
            computer = new ComPlayer(gameShoe);
            Hand userHand = startGame();
            if (userHand == null) {
                continue;
            }

            if (playerMoney.getBet() > playerMoney.getChips()) {
                System.out.println("You cannot double down due to a lack of chips, poor player!");
            }
            else {
                System.out.println("Do you wish to double down? (y/n)");
                if (scan.next().equals("y")) {
                    doubleDown(userHand);
                    continue;
                }
            }
            System.out.println("\n\n");
            System.out.println("Do you wish to stand? (y/n)");
            if (scan.next().equals("y")) {
                stand(userHand);
                continue;
            }
            System.out.println("\n\n");
            System.out.println("Do you wish to hit? If not, then you will stand (y/n)");
            while (scan.next().equals("y")) {
                userHand.hit();
                System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
                System.out.println("Your hand's details after hitting:\n" + userHand);
                System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
                if (userHand.isBust()) {
                    calculateWinnings(userHand);
                    break;
                }
                System.out.println("\n\n");
                System.out.println("Do you wish to hit? If not, then you will stand. (y/n)");
            }
            if (userHand.isBust()) {continue;}
            System.out.println("You have now stood.");
            stand(userHand);
            continue;
        }
        return;
    }
    private Hand startGame() {
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
        System.out.println(playerMoney);
        System.out.println("What is your bet?: ");

        int q = scan.nextInt();
        while ((q <= 0 || q % 10 != 0) || q > playerMoney.getChips()) {
            System.out.println("\n\nInvalid Bet! Do you want me to call the bouncer?!");
            System.out.println("What is your bet?: ");
            q = scan.nextInt();
        }
        System.out.println("Bet made!");
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");

        playerMoney.bet(q);

        Hand userHand = new Hand(gameShoe);
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
        System.out.println(userHand);
        System.out.println("One of com's cards is hidden. The other one is: " + computer.getFirstCard());
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");

        if (computer.getHand().isBlackjack() || userHand.isBlackjack()) {
            calculateWinnings(userHand);
            return null;
        }
        return userHand;
    }
    private void stand(Hand userHand) {

        computer.computerPlay();
        calculateWinnings(userHand);
    }
    private void doubleDown(Hand userHand) {
        System.out.println();
        System.out.println();
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
        System.out.println("Your hand's details:\n" + userHand);
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
        playerMoney.bet(playerMoney.getBet());
        userHand.hit();
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
        System.out.println("Your hand's details after hitting once:\n" + userHand);
        System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
        stand(userHand);
    }
    private void calculateWinnings(Hand userHand) {
        System.out.println();
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        if (computer.getHand().isBlackjack()) {
            System.out.println("Computer has blackjack! Lucky it!");
            if (userHand.isBlackjack()) {
                System.out.println("Fate determines that you also have blackjack! Such insanity!");
                System.out.println("A push occurs!");
                playerMoney.push();
                System.out.println(playerMoney);

                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                return;
            }
        }
        if (userHand.isBlackjack()) {
            System.out.println("The stars have aligned in your favor to give you blackjack!");
            playerMoney.addChips((5*playerMoney.getBet())/2);
            System.out.println(playerMoney);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            return;
        }
        if (userHand.isBust()) {
            System.out.println("Oh no, you bust! Such a loser");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Your hand's details:\n" + userHand);
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            System.out.println(playerMoney);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            return;
        }
        if (computer.getHand().isBust()) {
            System.out.println("Oh yes, computer busts! Computer is such a loser! Good job, pro!");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Your hand's details:\n" + userHand);
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Computer's hand's details:\n" + computer.getHand());
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            playerMoney.addChips(2*playerMoney.getBet());
            System.out.println(playerMoney);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            return;
        }
        if (userHand.value() == computer.getHand().value()) {
            System.out.println("Look at that, both of you have the same hand value! It is a push!");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Your hand's details:\n" + userHand);
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Computer's hand's details:\n" + computer.getHand());
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            playerMoney.push();
            System.out.println(playerMoney);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            return;
        }
        if (userHand.value() < computer.getHand().value()) {
            System.out.println("Oh no, your value is smaller than the computer's. Such a loser");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Your hand's details:\n" + userHand);
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Computer's hand's details:\n" + computer.getHand());
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            System.out.println(playerMoney);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            return;
        }
        else {
            System.out.println("Oh yes, your value is bigger than the computer's. Good job!");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Your hand's details:\n" + userHand);
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢");
            System.out.println("Computer's hand's details:\n" + computer.getHand());
            System.out.println("♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢♠♣♥♦♤♧♡♢\n");
            playerMoney.addChips(2*playerMoney.getBet());
            System.out.println(playerMoney);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            return;
        }
    }
}
