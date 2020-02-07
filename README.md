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
public void startGame(Shoe s, Hand comHand) {
  // Deal card from shoe s to userHand, then deal card to comHand, repeat once more
  // call isBlackjack for the computer's hand and the user's hand, and display the hand of the user on screen
  // if anyone has blackjack, call calculate winnings appropriately
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
public void stand(ComPlayer c) {
  // ends the player's turn and starts ComPlayer c's turn
}
public void calculateWinnings(int PlayerScore, boolean isBlack, int ComScore, PlayerChips p) {
  // if isBlack is true, then call addChips from p and add 5/2 times the current bet
  // if isBlack is false and the user wins then add 2 times the current bet
  // otherwise exit
}
```
### ComPlayer (for computer player as it will differ)
#### Instances
```
private Hand hand;
```
#### Methods
```
public int computerPlay(Shoe s) {
  // if the value of computer's hand is less than 17, then the computer must hit until the computer's hand 
  // is greater than 16
  // run calculateWinnings once computer's play ends
}
```                 
### PlayerChips (for the chips of the player)
#### Instances
```
private int chips;
private int bet;
```
#### Methods
```
public void bet(int b) {
  // set the bet to b
  // call removeChips(b)
}
public void addChips(int c) {
  // adds c to chips
}
public void removeChips(int c) {
  // removes c from chips
}
```
### Hand (for the cards that a player has)
#### Instances
```
private ArrayList hand;
```
#### Methods
```
public int hit(Shoe s) {
  // takes the shoe s and adds a random card to the ArrayList hand
  // returns the new value of the card by calling value()
}
public int value() {
  // add up the rank of each of the cards, if the rank total goes above 21, check if there are aces in the hand and convert 
  // all of them to 1 (subract 10 for every ace) and then return the value.
}
```

                    
                   
                    
