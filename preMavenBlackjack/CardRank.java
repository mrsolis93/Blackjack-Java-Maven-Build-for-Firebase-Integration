public enum CardRank {

    //set the rank values

    ACE("Ace",11),
    TWO("Two",2),
    THREE("Three",3),
    FOUR("Four",4),
    FIVE("Five",5),
    SIX("Six",6),
    SEVEN("Seven",7),
    EIGHT("Eight",8),
    NINE("Nine",9),
    TEN("Ten", 10),
    JACK("Jack",10),
    QUEEN("Queen",10),
    KING("King",10);

    private String rankString;
    int rankValue;

    //if ACE and value is hand value is over 21 then ACE rankValue is set to 1


    //constructor
    CardRank(String rankString, int rankValue) {
        this.rankString = rankString;
        this.rankValue = rankValue;
    }


    // get Rank String
    public String getRankString() {
        return rankString;
    }


    
}
