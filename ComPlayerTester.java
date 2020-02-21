
/**
 * Write a description of class comPLayerTester here.
 *
 * @author: Shiva Nallapati
 * @version (a version number or a date)
 */
public class ComPlayerTester
{
    public static void main (String [] args)
    {
        Shoe comHand=new Shoe(4);
        ComPlayer c1=new ComPlayer(comHand);
        
        System.out.println(c1);
        
        
        if(c1.getHandValue()<17){
            c1.dealToCom();
            System.out.println(c1);
        }
        
        if(c1.getHandValue()>17&&c1.getHandValue()<=21 ){
            c1.computerPlay();
            System.out.println(c1);
         
        }
       
    
    
   }
}
