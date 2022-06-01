// inherits from Person

public class Dealer extends Person{

    public Dealer() {
        super.setPosition("Dealer");
    }

// print the dealers hand with one card face down
    public void printDealerHand() {
        System.out.println(this.getPosition() + "'s Hand':\n" + super.getHand().getCard(0) + " and one face down trap card\n");
    
    }


    
}
