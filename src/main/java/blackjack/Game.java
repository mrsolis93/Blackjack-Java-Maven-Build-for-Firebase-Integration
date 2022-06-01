package blackjack;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import blackjack.service.FirebaseServices;


public class Game {

    @Autowired
    private FirebaseServices fireBaseService;


    // declare variables
    private Deck deck;
    private Player player;
    private Dealer dealer;

    private int wins;
    private int losses;
    private int ties;
    private int totalGames;

    Boolean playAgain = true;

    

    public Game() throws InterruptedException, ExecutionException {
        
        wins = 0;
        losses = 0;
        ties = 0;
        totalGames = 0;

        

        while(playAgain){
            //create a new deck
            deck = new Deck(true);

            //shuffle the deck
            deck.shuffle();

            new Deck();

            //create a new dealer
            dealer = new Dealer();

            //create a new player
            player = new Player();

            //initiate the game start sequence
            startGame();
        }



    }

    // function to prompt and play again
    public void playAgain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Play again? (y/n)");
        String answer = input.nextLine();
        if (answer.equals("y")) {
            playAgain = true;
        }
        else if(answer.equals("n")) {
            System.out.println("Thanks for playing!");
            playAgain = false;
        }
        else {
            System.out.println("Invalid input. Please enter y or n.");
            playAgain();
        }
    }

    

    public void startGame() throws InterruptedException, ExecutionException{
        


            // deal one card to the player
            player.getHand().getCardFromDeck(deck);

            // deal one card to the dealer
            dealer.getHand().getCardFromDeck(deck);

            // deal one card to the player
            player.getHand().getCardFromDeck(deck);

            // deal one card to the dealer
            dealer.getHand().getCardFromDeck(deck);

            // print the dealer's hand
            dealer.printDealerHand();

            // print the player's hand
            player.printHand();

            //Check if dealer has blackjack
            if(dealer.getHand().getHandValue() == 21) {

                //check if player also has blackjack
                if(player.getHand().getHandValue() == 21) {
                    // if both have blackjack, it's a tie
                    ties++;
                    
                    System.out.println("It's a tie! Dealer has blackjack and player also has blackjack.");


                    totalGames++;
                    playAgain();
                }

                else{
                    // if dealer has blackjack and player does not, player loses
                    losses++;
                    
                    System.out.println("Dealer has Blackjack! You lose!");


                    totalGames++;
                    playAgain();
                }

            }

            //Check if player has blackjack
            else if(player.getHand().getHandValue() == 21) {
                // if player has blackjack, player wins
                wins++;
                
                System.out.println("You have Blackjack! You win!");
                player.printHand();

                totalGames++;
                playAgain();
            }

            // ask the player if they want to hit or stay
            player.hitOrStay(deck);

            // Check if player has busted after hitOrStay Loop
            if(player.getHand().getHandValue() > 21){
                System.out.println("Player has busted!");


                System.out.println("Dealer wins!");
                losses++;
                totalGames++;
                System.out.println("Total Games: " + totalGames);
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println("Ties: " + ties);
                System.out.println("");
            }

            // If you havent busted, dealer gets a turn (dealer keeps drawing until he gets 17)
            while(dealer.getHand().getHandValue() < 17){
                dealer.hit(deck);
            }

            //Check who won and print the results Cover all scenarios

            // Player has busted
            if(player.getHand().getHandValue() > 21){
                System.out.println("Player has busted!");


                System.out.println("Dealer wins!");
                losses++;
                totalGames++;
                System.out.println("Total Games: " + totalGames);
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println("Ties: " + ties);
                System.out.println("");
                playAgain();
            }

            //Dealer has busted
            else if(dealer.getHand().getHandValue() > 21){
                System.out.println("Dealer has busted!");


                System.out.println("Player wins!");
                wins++;
                totalGames++;
                System.out.println("Total Games: " + totalGames);
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println("Ties: " + ties);
                // System.out.println("Recorded to Firebase");
                // fireBaseService.GameSaving(wins, losses, ties, totalGames);
                playAgain();
            }

            // Tied 
            else if(player.getHand().getHandValue() == dealer.getHand().getHandValue()){
                System.out.println("Tie!");


                ties++;
                totalGames++;
                System.out.println("Total Games: " + totalGames);
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println("Ties: " + ties);
                // System.out.println("Recorded to Firebase");
                
                // //output to firebase
                // fireBaseService.GameSaving(wins, losses, ties, totalGames);

                playAgain();
            }

            // Player gets closer to 21
            else if(player.getHand().getHandValue() > dealer.getHand().getHandValue()){
                System.out.println("Player wins!");


                wins++;
                totalGames++;
                System.out.println("Total Games: " + totalGames);
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println("Ties: " + ties);
                // System.out.println("Recorded to Firebase");
                // fireBaseService.GameSaving(wins, losses, ties, totalGames);
                playAgain();
            }

            //Dealer gets closer to 21
            else if(player.getHand().getHandValue() < dealer.getHand().getHandValue()){
                System.out.println("Dealer wins!");


                losses++;
                totalGames++;
                System.out.println("Total Games: " + totalGames);
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println("Ties: " + ties);
                // System.out.println("Recorded to Firebase");
                // fireBaseService.GameSaving(wins, losses, ties, totalGames);
                playAgain();
            }


    }

            //function to get number of wins
        public int getWins() {
            return wins;
        }
}
