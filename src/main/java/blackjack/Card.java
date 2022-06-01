// Card class for general playing cards. Abstracting enumerations of suits and ranks.
package blackjack;

public class Card {
    
    // declare variables
    private CardSuit suit;
    private CardRank rank;

    // constructor
    public Card(CardSuit suit, CardRank rank) 
        {
            this.rank = rank;
            this.suit = suit;
        }

    // copy constructor for Deck adding and removing (paramater is another card)
    public Card(Card card) 
        {
            this.rank = card.getRank();
            this.suit = card.getSuit();
        }

    // return rank of the card
    public CardRank getRank() 
        {
            return rank;
        }

    // return suit of Card
    public CardSuit getSuit()
         {
         return suit;
        }
    
    // return the value of the card
    public int getRankValue()
        {
            return rank.rankValue;
        }
    
    // return String representation of Card
    public String toString()
        {
        return String.format("%s of %s", rank, suit);
        
        }

}
