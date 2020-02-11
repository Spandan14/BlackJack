
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
    public PlayerChips(int c, int b)
    {
        chips = c;
        bet = b;
    }
    public void bet(int b)
    {
        removeChips(b);
    }
    public void addChips(int c)
    {
        chips+=c;
    }
    public void removeChips(int c)
    {
        chips-=c;
    }
}
