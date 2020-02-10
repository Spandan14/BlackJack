
/**
 * Write a description of class ComPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComPlayer
{
    private Hand hand;
    public ComPlayer(Deck h){
        hand=h;
    }
    
    public int computerPlay(Shoe s){
        while(hand.value<17){
            hand.value+=hand.hit();
            if(hand.value()>16){
              Play.calculateWinnings();  
            }
        }
    }
}
