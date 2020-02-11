

/**
 * Write a description of class ComPlayer here.
 *
 * @author (Shiva Nallapati)
 * @version (a version number or a date)
 */
public class ComPlayer
{
    private Hand hand;
    public ComPlayer(Deck h){
        hand=h;
    }
    
    /**
     * @Name: getHandValue
     * @Param: None
     * 
     * description: returns the value of the computer players hand.
     * return: int
     */
    public int getHandValue() {
        return hand.value();
    }
    
    /**
     * @Name: computerPlay
     * @Param: None
     * description: this method makes the computer player or dealer hit everytime 
     * they are below 17, and end their turn once they are above 16.
     * return: no return, void
     * 
     */
    public void computerPlay(){
         while(hand.value()<17){
            hand.hit();
         }
        
    }
}
