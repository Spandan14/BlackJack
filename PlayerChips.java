
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
    public int getChips() {
        return chips;
    }
    public int getBet() {
        return bet;
    }
    /**
     * @des remoivng bet from the chips
     * @Name bet
     * @param int b: bet
     */
    public void bet(int b)
    {
        removeChips(b);
    }
    /**
     * @des adds the bet back as there is a tie
     * @Name push
     */
     public void push() {
        addChips(bet);
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
}
