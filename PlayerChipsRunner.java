
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
        PlayerChips p1 = new PlayerChips(100);
        p1.bet(10);
        System.out.println(p1);
        
        PlayerChips p2 = new PlayerChips(100);
        p2.bet(80);
        System.out.println(p2);
        
        PlayerChips p3 = new PlayerChips(100);
        p3.bet(101);
        System.out.println(p3);
    }
}
