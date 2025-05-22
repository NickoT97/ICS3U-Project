import java.util.Scanner;

public class Player1Turn {
    public static void P1Turn(int[][] card){
        Scanner scan = new Scanner(System.in);
        // Player 1 turn method
        // Will be called when its Player 1's turn to play

        int tcolour = TopCard.topcolour; // The top colour of the pile
        int tcard = TopCard.topcard; // The top number of the pile

        for (int colorIndex = 0; colorIndex < card.length; colorIndex++){
            for (int cardIndex = 0; cardIndex < card[colorIndex].length; cardIndex++){
                if (card[colorIndex][cardIndex] == 1){ // Check if card is in P1s hand
                    
                    String color;

                    switch (colorIndex){
                        case 0:  color = "red";   break;
                        case 1:  color = "blue";  break;
                        case 2:  color = "green"; break;
                        default: color = "wild";  break;
                    }

                    if (tcolour == colorIndex || tcard == cardIndex || colorIndex == 3){ // If the top card of the pile is the same color/number as the card in hand
                        // If the card is a wild card (index1 == 3), the player can play any card
                        
                        String x;
                        int y;

                        if(cardIndex % 2 == 0){ // Check if the card is even
                            // If the card is even, it is a "b" card
                            y = cardIndex / 2;
                            x = (y + "b");
                        }
                        else{ // If the card is odd, it is an "a" card
                            y = (cardIndex + 1)/2;
                            x = (y + "a");
                        }


                        System.out.println("You can play this card: " + color + " " + x);

                    }

                }
            }
        }

        
        // STATE THE TOP CARD OF THE USED PILE

        String colour; // String to store the color of the card

        String x;
        int y;
        
        if(tcard % 2 == 0){
            y = tcard / 2;
            x = (y + "b");
        }
        else{
            y = (tcard + 1)/2;
            x = (y + "a");
        }

        switch (tcolour){
            case 0:  colour = "red";   break;
            case 1:  colour = "blue";  break;
            case 2:  colour = "green"; break;
            default: colour = "wild";  break;
        }
                

        System.out.println("The top card is: " + colour + " " + x); // Show the top card of the pile
        System.out.println("Which card do you want to play? (enter the color and number)"); // ask the user which card they want to play
        
        // Scan the input for the User's Turn
        String P1response = scan.nextLine();
        
        String[] P1Play = P1response.split(" "); // Split the input into color and number from the space

        String P1color = P1Play[0]; // Get the color from P1 turn

        int P1C = 0; // Integer to store the colour of the card

        if (P1color.equals("red")){ // Check if the color is red
            P1C = 0; // Set the color to red
        }
        else if (P1color.equals("blue")){ // Check if the color is blue
            P1C = 1; // Set the color to blue
        }
        else if (P1color.equals("green")){ // Check if the color is green
            P1C = 2; // Set the color to green
        }
        else if (P1color.equals("wild")){ // Check if the color is wild
            P1C = 3; // Set the color to wild
        }

        int P1number = Integer.parseInt(P1Play[1]); // Get the number from P1 turn

        card[tcolour][tcard] = 4; // Move the top card to the used pile

        card[P1C][P1number] = 3; // Set the card to 3 (remove the card from P1's hand and move to top)

        tcolour = P1C;
        tcard = P1number;




        // END OF TURN

        System.out.println("You played: " + P1color + " " + P1number); // Show the card that was played
        System.out.println("The top card is now: " + P1color + " " + P1number); // Show the new top card of the pile
        System.out.println("Your new hand is: "); // Show the new hand of P1
        PlayerOneHand.P1hand(Deck.card); // Call the P1 hand method to show the new hand
        System.out.println("Your turn is over!"); // Show that the turn is over
        System.out.println("Now it's Player 2's turn!"); // Show that it's Player 2's turn


    }
}
