import java.util.Scanner;
/**
 * Write a description of class PlayerChipsRunner here.
 *
 * @author Kai Sato
 * @version (a version number or a date)
 */
public class PlayerChipsRunner
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);    
        System.out.println("Test?   YES=1   No=2");
        int test = scan.nextInt();
        while(test==1)
        {
            System.out.println("Enter Bet: ");
            int bet1 = scan.nextInt();
            PlayerChips p1 = new PlayerChips(100);
            p1.bet(bet1);
            System.out.println(p1);
            System.out.println("Test?   YES=1   No=2");
            test = scan.nextInt();
        }

    }
}
