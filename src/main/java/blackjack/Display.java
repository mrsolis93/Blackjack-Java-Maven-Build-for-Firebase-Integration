package blackjack;

import java.util.concurrent.ExecutionException;

// main class that runs the blackjack game and displays

public class Display {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        System.out.println("BlackJack Game");

        // create a game of blackjack
        Game blackjack = new Game();


        //TESTING CODE

        // Test card creation
        // Card card = new Card(CardSuit.SPADES, CardRank.ACE);
        // System.out.println(card.toString());


        // Test the Deck filling
        // Deck fillTest = new Deck(true);
        // System.out.println(fillTest.toString());

        // Test the Hand creation
            //  Deck handDeck = new Deck(true);
            //  Hand hand = new Hand();

            // // // deal two cards to the hand
            //  hand.getCardFromDeck(handDeck);
            //  hand.getCardFromDeck(handDeck);
            //  hand.getCardFromDeck(handDeck);
            //  hand.getCardFromDeck(handDeck);
            
           
            
            // // // display the hand and test toString
            //  System.out.println("Hand: " + hand.toString());
            
            // // //display the deck to make sure cards are gone
            //  System.out.println("Deck: " + handDeck.toString());

            // // Test hand value
            //  System.out.println("Hand value: " + hand.getHandValue());

         //test dealer
        //  Dealer dealer = new Dealer();
        

        // // //print dealers hand
        //  System.out.println("Dealer's hand: " + dealer.getHand());






    

    }    


}
