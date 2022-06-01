import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    
    private ArrayList<Card> hand;
    
    // constructor
    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    // add card to hand from deck
    public void getCardFromDeck(Deck deck) {
        hand.add(deck.getCard());
    }
    
    public void removeCard(Card card) {
        hand.remove(card);
    }

    // toString method for hand
    public String toString() {
        String handString = "";
        for (Card card : hand) {
            handString += card.toString() + "\n";
        }
        return handString;
    } 

    
    // function to clear hand (no need to return cards to deck just use new deck)
    public void clearHand() {
        hand.clear();
    }
    
    // function to check if hand is empty
    public boolean isEmpty() {
        return hand.isEmpty();
    }
    
    // function to check if a card is in the hand to decide whether to show or hide
    public boolean contains(Card card) {
        return hand.contains(card);
    }

    // function to get Card from a hand
    public Card getCard(int index) {
        return hand.get(index);
    }
    
    // function to get the value of the hand
    // must also check for ace for soft hand
    public int getHandValue() {
        int handValue = 0;
        int aceCount = 0;

        for (Card card : hand) {
            handValue += card.getRankValue();

            if (card.getRankValue() == 11) {
                aceCount++;
            }
        }

        // if hand value is greater than 21 and there is an ace, subtract 10 from hand value
        while (handValue > 21 && aceCount > 0) {
            handValue -= 10;
            aceCount--;
        }
        
        return handValue;
    }

}
