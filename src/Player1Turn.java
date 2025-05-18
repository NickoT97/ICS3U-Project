import java.util.Scanner;

public class Player1Turn {
    public void P1Turn(int[][] card){
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

                        System.out.println("You can play this card: " + color + " " + cardIndex);
                    }
                    
                    else{
                        System.out.println("You cannot play this card: " + color + " " + cardIndex);
                    }

                }
            }
        }

        System.out.println("Which card do you want to play? (enter the color and number)"); // ask the user which card they want to play
        // Scan the input
        
    }
}
