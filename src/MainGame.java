import java.util.Scanner;

public class MainGame{
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Uno!"); // welcom message
        System.out.println("Do you want to play? (yes/no)"); // ask the user if they want to play the game
            String response = scan.nextLine().toLowerCase();

        if (response.equals("yes")){
            System.out.println("Great! Let's play!");
            System.out.println("Handing out 7 cards...");

            System.out.println("Your cards are: ");
            
            Deck.cards(); // call the cards method in the Deck class, and draw 7 cards
        }

        else if (response.equals("no")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        else {
            System.out.println("Not a valid response.");
        }


    }
}





