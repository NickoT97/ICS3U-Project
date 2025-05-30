// Coders: Nicko Tsagogeorgas, Jamie Usmar
// Date of Completion: dd/mm/yyyy
// Course Code: ICS3U
// Teacher: Mr. Nucci

import java.util.Scanner;

public class ARunGame{
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Uno!"); // welcome message
        System.out.println("Do you want to play? (yes/no)"); // ask the user if they want to play the game
            String response = scan.nextLine().toLowerCase();

        if (response.equals("yes")){
            System.out.println("Great! Let's play!");
            System.out.println("Handing out 7 cards to both players...");

            // The Game Starts here
            Deck.cards(); // call the cards method in the Deck class, and draw 7 cards
            TopCard.TopCard(Deck.card); // call the top card method, stating the top card of the pile

            //while loop used to call the methods needed
            //if someone reaches 0 cards, they are the winner

            while (Deck.countCards(1) > 0 && Deck.countCards(2) > 0){ //if everybody has more than 0 cards, the game will play

                // Insert for loop until one player runs out of cards. Then if statement for winner.
                Clearing.clearing(); // call the clearing method
                
                PlayerOneHand.P1hand(Deck.card); // call the player 1 hand method
                Player1Turn.P1Turn(Deck.card); // call the player 1 turn method

                if(Deck.countCards(1) == 0){ // after player 1's turn, if they have 0 cards, they win the game
                    System.out.println("Player 1 wins the game!");
                    System.exit(0); // exits game
                }
                
                Clearing.clearing(); // call the clearing method
                
                PlayerTwoHand.P2hand(Deck.card); // call the player 2 hand method
                Player2Turn.P2Turn(Deck.card); // call the player 2 turn method

                if(Deck.countCards(2) == 0){ // after player 2's turn, if they have 0 cards, they win the game
                    System.out.println("Player 2 wins the game!");
                    System.exit(0); //exits game
                }
                
                Clearing.clearing();
            }

        }

        else if (response.equals("no")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        else {
            System.out.println("Not a valid response.");
        }

        scan.close();
    }
}





