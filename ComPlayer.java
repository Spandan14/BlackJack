
/**
 * Write a description of class ComPlayer here.
 *
 * @author (Shiva Nallapati)
 * @version (a version number or a date)
 */
public class ComPlayer
{
    private Hand hand;
    public ComPlayer(Shoe s){
         hand=new Hand(s);
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
    public Hand getHand() {
        return hand;
    }
    public Card getFirstCard() {
        return hand.returnFirstCard();
    }
    public void dealToCom(){
        hand.hit();
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
    
    public String toString(){
        if(hand.value()>21){
            return "Dealer Busts, Value is: "+hand.value();
        }
        return "Dealers Value: "+hand.value(); 
        
    }
}