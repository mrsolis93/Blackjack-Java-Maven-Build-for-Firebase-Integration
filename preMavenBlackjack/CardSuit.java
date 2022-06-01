public enum CardSuit {

    SPADES ("Spades"),
    HEARTS ("Hearts"),
    CLUBS ("Clubs"),
    DIAMONDS ("Diamonds");
    
    
    String suitType;

    CardSuit(String suitType) {
        this.suitType = suitType;
    }


    //getters and setters
    public String getSuitType() {
        return suitType;
    }

    public void setSuitType(String suitType) {
        this.suitType = suitType;
    }

    //toString method

    public String toString() {
        return suitType;
    }

}
