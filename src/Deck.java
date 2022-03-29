//@author Angel Cueva



import java.util.Random;
import java.util.ArrayList;

public class Deck {
    enum Suits{
        HEART('H'), SPADE('S'), DIAMOND('D'), CLUB('C');
        public char suit;

        private Suits(char suit){
            this.suit = suit;
        }
        public char getValue(){
            return suit;
        }
    }
    enum Ranks{
        A(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        J(11), Q(12), K(13);

        public int rank;

        private Ranks(int rank){
            this.rank = rank;
        }
        public int getValue(){
            return rank;
        }

    }
    public ArrayList<Card> storage;


    public Deck() {

        storage = new ArrayList<Card>();
        int i = 0;
        for (Suits s : Suits.values()){
            for (Ranks r : Ranks.values()){
                Card c1 = new Card(r,s);
                storage.add(c1);
            }
        }
    }
    public void display() {
        int i = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 13; column++) {
                storage.get(i).display();
                i++;
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void shuffle(){
        Random rand = new Random();
        for (int i = 0; i < 100000; i++){
            int x = rand.nextInt(52);
            int y = rand.nextInt(52);
            Card temp = storage.get(x);
            storage.set(x, storage.get(y));
            storage.set(y, temp);
        }
    }
    public Card deal(){
        return storage.remove(0);
    }

    public int cardsLeft(){
        return storage.size();
    }
}





