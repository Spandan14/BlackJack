
/**
 * Write a description of class PlayerChips here.
 *
 * @author Kai Sato
 * @version (a version number or a date)
 */
public class PlayerChips
{
    private int chips;
    private int bet;
    /**
     * @Name PlayerChips
     * @param int c: chips int b:bet
     */
    public PlayerChips(int c)
    {
        chips = c;
        bet = 0;
    }

    /**
     * @des remoivng bet from the chips and is the player tries to bet more
     * than their total balance, print "not enough money" 
     * @Name bet
     * @param int b: bet
     */
    public void bet(int b)
    {
        bet = b;
        if(b>=chips)
        {
            System.out.println("Not enough chips");
        }
        else{
            removeChips(b);
        }
    }

    /**
     * @des adding chips to the original instance variable chips
     * @Name addChips
     * @param int c: chips
     */
    public void addChips(int c)
    {
        chips+=c;
    }

    /**
     * @des remoivng bet from the chips
     * @Name removeChips
     * @param int c: chips
     */
    public void removeChips(int c)
    {
        chips-=c;
    }

    public String toString()
    {
        return "Current Bet: " + String.valueOf(bet)+"\n"+
        "Current Balance of Chips: " + String.valueOf(chips)+"\n"; 

    }
}
