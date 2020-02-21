
/**
 * Write a description of class comPLayerTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComPlayerTester
{
    public static void main (String [] args)
    {
        Shoe comHand=new Shoe(4);
        ComPlayer c1=new ComPlayer(comHand);
        c1.dealToCom();
        c1.computerPlay();
        System.out.println(c1);
        
        
    }
    
}