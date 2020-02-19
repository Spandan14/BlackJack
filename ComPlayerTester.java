

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
        
        System.out.println(c1);
        
        c1.computerPlay();
        
        System.out.println(c1);
        
        
    
    
   }
}
