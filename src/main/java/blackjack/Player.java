package blackjack;

import java.util.Scanner;

// Player class inherits from person class

public class Player extends Person {

    // Create a new Player
    public Player() {

        super.setPosition("Player");

    }
    

    // Method for player to hit or stay
    public void hitOrStay(Deck deck) {

         Scanner input = new Scanner(System.in);
         String choice = "";
         Boolean hitOrStay = true;
         

        // Ask player to hit or stay while we are getting input
        while(hitOrStay) {
            try{
                System.out.println("Would you like to hit or stay? (h/s)");
                choice = input.nextLine();

                // if player hits
                if(choice.equals("h")) {
                    //give player a card and print their choice
                    this.hit(deck);

                    // if player has blackjack or busted cannot hit anymore
                    if(this.blackJack() || this.getHand().getHandValue() > 20) {
                        hitOrStay = false;
                        return;
                    }

                    //if player hasnt busted or blackjack, ask them to hit or stay again
                    else {
                        hitOrStay = false;
                        this.hitOrStay(deck);
                    }
                }
                else if(choice.equals("s")) {
                    // if player stays
                    System.out.println("You chose to stay.");
                    hitOrStay = false;
                }
                else {
                    System.out.println("Invalid input. Please enter h or s.");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid input. Please enter h or s.");
            }

        }

       

    }

    

}