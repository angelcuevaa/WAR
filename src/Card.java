//@author Angel Cueva


public class Card {
    private Deck.Suits suit;
    private Deck.Ranks rank;

    public Card(Deck.Ranks r, Deck.Suits s){
        suit = s;
        rank = r;
    }
    public void display(){
        if (rank.getValue() <= 10 && rank.getValue() >= 2){
            System.out.print(rank.getValue());
        }
        else{
            System.out.print(rank);
        }
        System.out.print(suit.getValue());
        System.out.print(", ");
    }
    public int getValue() {
        return rank.getValue();
    }


}