package blackjack;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;


public class Deck {

    private List<Card> deck; // declare List that will store Cards

    // constructor for Deck
    public Deck() {
        // create a list of cards
        deck = new ArrayList<Card>();
    };

    // constructor for Deck with parameter to populate
    public Deck(boolean newDeck) 
    {   

        // create a list of cards
        deck = new ArrayList<Card>();

             // if deck is true populate deck with Card objects with enhanced for loop to be fancy
            if (newDeck) {
                // loop through each suit
                for(CardSuit suit : CardSuit.values()) {
                    // loop through each rank
                    for(CardRank rank : CardRank.values()) {
                    // add card to deck - use array list instead of List to get add function
                    deck.add(new Card(suit, rank));
                    }
                }
            }
    }



// shuffle deck (is this random?)
    public void shuffle() {
        Collections.shuffle(deck);
    }

// return number of cards in deck
    public int cardsRemaining() {
        return deck.size();
    }

// return String of all cards in deck
    public String toString() {
       
        String deckString = "";
        for (Card card : deck) {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }

// return a card from the deck
    public Card getCard() {
        // copy the card that you are taking from the deck
        Card getCard = deck.get(0);

        // remove the card from the deck List
        deck.remove(0);

        return getCard;
    }





}
