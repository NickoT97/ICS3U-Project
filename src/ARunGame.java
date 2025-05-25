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

            // Insert for loop until one player runs out of cards. Then if statement for winner.
            Clearing.clearing(); // call the clearing method
            
            PlayerOneHand.P1hand(Deck.card); // call the player 1 hand method
            Player1Turn.P1Turn(Deck.card); // call the player 1 turn method
            
            Clearing.clearing(); // call the clearing method
            
            PlayerTwoHand.P2hand(Deck.card); // call the player 2 hand method
            Player2Turn.P2Turn(Deck.card);
            
            Clearing.clearing();

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





