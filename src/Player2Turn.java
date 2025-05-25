import java.util.Scanner;

public class Player2Turn {
    public static void P2Turn(int[][] card){
        Scanner scan = new Scanner(System.in);
        // Player 2 turn method
        // Will be called when its Player 2's turn to play

        int tc = TopCard.CardTop; // Top card location in deck
        int tcolour = TopCard.topcolour; // The top colour of the pile
        int tcard = TopCard.topcard; // The top number of the pile

        for (int colorIndex = 0; colorIndex < card.length; colorIndex++){
            for (int cardIndex = 0; cardIndex < card[colorIndex].length; cardIndex++){
                if (card[colorIndex][cardIndex] == Deck.p2){ // Check if card is in P2s hand
                    
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

                        else if(cardIndex == 0){
                            x = "0";
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
        String P2response = scan.nextLine();
        
        String[] P2Play = P2response.split(" "); // Split the input into color and number from the space

        String P2color = P2Play[0]; // Get the color from P2 turn

        int P2C = 0; // Integer to store the colour of the card

        if (P2color.equals("red")){ // Check if the color is red
            P2C = 0; // Set the color to red
        }
        else if (P2color.equals("blue")){ // Check if the color is blue
            P2C = 1; // Set the color to blue
        }
        else if (P2color.equals("green")){ // Check if the color is green
            P2C = 2; // Set the color to green
        }
        else if (P2color.equals("wild")){ // Check if the color is wild
            P2C = 3; // Set the color to wild
        }

        int P2number = Integer.parseInt(P2Play[1]); // Get the number from P2 turn

        card[tcolour][tcard] = 4; // Move the top card to the used pile

        tc = card[P2C][P2number] = 3; // Set the card to 3 (remove the card from P1's hand and move to top)

        
        tcolour = P2C;
        tcard = P2number;


        // END OF TURN

        System.out.println("You played: " + P2color + " " + P2number); // Show the card that was played
        System.out.println("The top card is now: " + P2color + " " + P2number); // Show the new top card of the pile
        System.out.println("Your new hand is: "); // Show the new hand of P2
        PlayerOneHand.P1hand(Deck.card); // Call the P2 hand method to show the new hand
        System.out.println("Your turn is over!"); // Show that the turn is over
        System.out.println("Now it's Player 1's turn!"); // Show that it's Player 1's turn

        // Change values of public variables
        TopCard.CardTop = tc;
        TopCard.topcolour = tcolour; 
        TopCard.topcard = tcard; 

    }
}
