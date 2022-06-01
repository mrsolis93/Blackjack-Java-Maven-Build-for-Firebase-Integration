package blackjack;

// abstract class because it has no implementation only children classes

public abstract class Person {

    private Hand hand;
    private String position;

// create a person function with hand
    public Person() {
        this.hand = new Hand();
        this.position = "";

    }

// setters and getters 

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // does the person have blackjack
    public boolean blackJack() {
        if(this.getHand().getHandValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }

    //print the person's hand
    public void printHand() {
        System.out.println(this.getPosition() + "'s Hand:\n" + this.getHand().toString());
        //print the hand value
        System.out.println(this.getPosition() + "'s Hand Value: " + this.getHand().getHandValue());
    }

    // hit the person's hand
    public void hit(Deck deck) {
        //get card
        this.getHand().getCardFromDeck(deck);
        //print action
        System.out.println(this.position + " hits.");
        // print the hand
        this.printHand();

    }







    
}
