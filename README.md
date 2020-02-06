# This is blackjack, made by Kai Sato, Shiva Nallapati, and Spandan Goel
## Classes we need:
### Game (for playing and initializing the game itself)
#### Instances
```
private Shoe gameShoe; // main shoe for the game to run on
private ComPlayer computer; // computer player/dealer
private PlayerChips playerMoney; // represents player's big bucks
private Hand userHand; // user's cards
```
#### Methods
```
public void hit(Hand h, Shoe s) {
  // takes the shoe s and adds a random card to the hand h from the shoe s
  // calculates total value of hand h and checks for bust or blackjack
}
public boolean isBlackjack(Hand h) {
  // checks if the total value of the hand h by calling totalValue from the Hand class is equal to 21
}
public boolean isBust(Hand h) {
  // checks if the total value of the hand h by calling totalValue from the Hand class is greater than 21
}
public void doubleDown(Hand h, PlayerChips p, Shoe s) {
  // calls hit exactly once and then executes isBlackjack and isBust to find the value, and if the player busts
  // then removes the bet from the player's total chips
}
method to double down
method to stand
method to end player turn
method to calculate winning
method for splitting cards
```
##                 ComPlayer (for computer player as it will differ)
                    instance for Hand
                    method for computer to play
                    
##                 PlayerChips (for the chips of the player)
                    instance for number of chips
                    instance for current bet
                    method to bet
                    method for adding chips
                    method for removing chips
                    
##                 Hand (for the cards that a player has)
                    instance for ArrayList of cards
                    method to add a card
                    method to calculate total value of hand
                    
