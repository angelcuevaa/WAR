//@author Angel Cueva

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        while (true) {
            System.out.println("\n1. New Deck");
            System.out.println("2. Shuffle Deck");
            System.out.println("3. Display Deck");
            System.out.println("4. Play War");
            System.out.println("5. Exit");
            int menu_choice = menu();
            if (menu_choice == 1) {
                d1 = new Deck();
            }
            if (menu_choice == 2) {
                d1.shuffle();
            }
            if (menu_choice == 3) {
                d1.display();
            }
            if (menu_choice == 4){
                Hand h1 = new Hand();
                getPlayerHands(h1,d1);
                System.out.println("Player 1 hand: " ) ;
                h1.displayPLayer1Hand();
                System.out.println("\nPlayer 2 hand: " ) ;
                h1.displayPlayer2Hand();
                System.out.println("\nEnter the maximum number of battles");
                Scanner scan = new Scanner (System.in);
                int maxBatttle = scan.nextInt();
                battles(maxBatttle, h1);
                System.out.print("Player 1 hand: ");
                h1.displayPLayer1Hand();
                System.out.println();
                System.out.print("Player 2 hand: ");
                h1.displayPlayer2Hand();
            }

            if (menu_choice == 5){
                break;
            }
        }
    }

    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a menu choice.");
        int menu_choice = scan.nextInt();
        while (menu_choice < 1 || menu_choice > 5) {
            System.out.println("Invalid, enter a menu choice.");
            menu_choice = scan.nextInt();
        }
        return menu_choice;
    }
    public static void getPlayerHands(Hand h1, Deck d1){
        for (int i = 0; i < 26; i++){
            Card c1 = d1.deal();
            Card c2 = d1.deal();
            h1.addToPlayer1(c1);
            h1.addToPlayer2(c2);
        }
    }
    public static void battles(int maxBattle, Hand h1){
        for (int i = 0; i < maxBattle; i++) {
            if (isWinner(h1)) {
                break;
            }
            Card c1 = h1.player1Deal();
            System.out.print("Player 1 plays ");
            c1.display();
            System.out.print("\nPlayer 2 plays ");
            Card c2 = h1.player2deal();
            c2.display();

            if (c1.getValue() < c2.getValue()) {
                System.out.println("\nPlayer 2 wins the round");
                h1.addToPlayer2(c1);
                h1.addToPlayer2(c2);
            } else if (c1.getValue() > c2.getValue()) {
                System.out.println("\nPlayer 1 wins the round");
                h1.addToPlayer1(c1);
                h1.addToPlayer1(c2);
            } else {
                War(h1, c1, c2);
            }
        }
        if (isWinner(h1)) {
            System.out.println("Game Over");
            if (h1.cards1Left() == 0) {
                System.out.println("Player 2 wins");
            } else if (h1.cards2Left() == 0) {
                System.out.println("Player 1 wins");

            }
        }
    }
    public static void War(Hand h1 , Card c3, Card c4) {
        System.out.println("WAR TIME!");
        ArrayList<Card> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (isWinner(h1)) {
                break;
            }
            System.out.println("War card for player 1 xx");
            System.out.println("War card for player 2 xx");
            temp.add(h1.player1Deal());
            temp.add(h1.player2deal());
        }
        if (isWinner(h1)) {
            System.out.println("Game Over");
            if (h1.cards1Left() == 0) {
                System.out.println("Player 2 wins");
            } else if (h1.cards2Left() == 0) {
                System.out.println("Player 1 wins");

            }
        } else {

            Card c1 = h1.player1Deal();
            System.out.print("Player 1 plays ");
            c1.display();
            System.out.print("\nPlayer 2 plays ");
            Card c2 = h1.player2deal();
            c2.display();

            if (c1.getValue() < c2.getValue()) {
                System.out.println("\nPlayer 2 wins");
                h1.addToPlayer2(c1);
                h1.addToPlayer2(c2);
                h1.addToPlayer2(c3);
                h1.addToPlayer2(c4);

                for (Card c : temp) {
                    h1.addToPlayer2(c);
                }
            } else if (c1.getValue() > c2.getValue()) {
                System.out.println("\nPlayer 1 wins");
                h1.addToPlayer1(c1);
                h1.addToPlayer1(c2);
                h1.addToPlayer1(c3);
                h1.addToPlayer1(c4);

                for (Card c : temp) {
                    h1.addToPlayer1(c);
                }
            }
            else{
                War(h1, c1, c2);
            }

        }
    }
    public static boolean isWinner(Hand h1){
        if (h1.cards1Left() == 0 || h1.cards2Left() == 0){
            return true;
        }

        else{
            return false;
        }
    }
}