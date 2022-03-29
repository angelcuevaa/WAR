//@author Angel Cueva


import java.util.ArrayList;
public class Hand extends Deck {
    public ArrayList<Card> Player1;
    public ArrayList<Card> Player2;

    public Hand() {
        Player1 = new ArrayList<>();
        Player2 = new ArrayList<>();
    }

    public void addToPlayer1(Card c1) {
        Player1.add(c1);
    }

    public void addToPlayer2(Card c2) {
        Player2.add(c2);
    }

    public ArrayList<Card> getPlayer1Hand() {
        return Player1;
    }

    public ArrayList<Card> getPlayer2Hand() {
        return Player2;
    }

    public void displayPLayer1Hand() {
        for (Card c : Player1) {
            c.display();
        }

    }

    public void displayPlayer2Hand() {
        int i = 0;
        for (Card c : Player2) {
            c.display();
        }
    }

    public Card player1Deal() {
        return Player1.remove(0);
    }

    public Card player2deal() {
        return Player2.remove(0);
    }

    public int cards1Left() {
        return Player1.size();
    }

    public int cards2Left() {
        return Player2.size();

    }
}


