package CardGame;

import java.util.Random;
import java.util.Scanner;
/**
 * This class models a simple card guessing game
 * 
 * @author Philip Isidro
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    
    //this is a new change
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //creates an array of Card of 7 
        Card[] hand = new Card[7];
           
        //creates random
        Random random = new Random();
        
        //this is a change
        for (int i = 0; i < hand.length; i++) {
            int value = random.nextInt(13) + 1;
            String suit = Card.SUITS[random.nextInt(4)];
        }

        // print them out for debugging purposes
        System.out.println("Here are the cards in the hand");
        for (Card card : hand) {
            System.out.printf("%d of %s\n", card.getValue(), card.getSuit());
        }

        // Now ask the user for a card
        System.out.println("Pick a suit for your card");
        
        for (int i = 0; i < Card.SUITS.length; i++){
            System.out.print((i+1) + ": " + Card.SUITS[i]);
        }

        int suit = input.nextInt();

        System.out.println("Enter a value (1 to 13)");
        int value = input.nextInt();
        
        Card userGuess = new Card(value, Card.SUITS[suit - 1]);

        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue()
                    && card.getSuit().equals(userGuess.getSuit())) {
                match = true;
                break;
            }
        }
    
        String response = match ? "Right guess": "No match";
        
        System.out.println(response);
    }
    
}
