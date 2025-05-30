import java.util.Scanner;

public class Player1Turn {
    public static void P1Turn(int[][] card){
        Scanner scan = new Scanner(System.in);
        // Player 1 turn method
        // Will be called when its Player 1's turn to play

        int tcolour = TopCard.topcolour; // The top colour of the pile
        int tcard = TopCard.topcard; // The top number of the pile
        int colorIndex;
        int cardIndex;
        int oldTcolour = tcolour; //save value of old top card colour
        int oldTnumber = tcard; //save value of old top card number
        boolean hasPlayableCard = false; //used to check if the player has a playable card. used with the pickup() method

        for (colorIndex = 0; colorIndex < card.length; colorIndex++){
            for (cardIndex = 0; cardIndex < card[colorIndex].length; cardIndex++){
                if (card[colorIndex][cardIndex] == Deck.p1){ // Check if card is in P1s hand

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

                        if(cardIndex % 2 == 0 && cardIndex != 0){ // Check if the card is even
                            // If the card is even, it is a "b" card
                            y = cardIndex / 2;
                            x = (y + "b");
                        }

                        else if(cardIndex == 0){ // If the card is odd, it is an "a" card
                            x = "0";
                        }

                        else{ // If the card is odd, it is an "a" card
                            y = (cardIndex + 1)/2;
                            x = (y + "a");
                        }


                        System.out.println("You can play this card: " + color + " " + x);
                        hasPlayableCard = true;

                    }

                }
            }
        }


        
        // STATE THE TOP CARD OF THE USED PILE

        String colour; // String to store the color of the card

        String x;
        int y;
        
        if(tcard % 2 == 0 && tcard != 0){
            y = tcard / 2;
            x = (y + "b");
        }
        
        else if (tcard == 0){
            x = "0";
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
                

        if (TopCard.wildTop == true){
            String wildColourName = "";

            switch (TopCard.topcolour){
            case 0:  wildColourName = "red";   break;
            case 1:  wildColourName = "blue";  break;
            case 2:  wildColourName = "green"; break;
            }
            System.out.println("The colour of the wild card is: " + wildColourName);

        }
        else {
            System.out.println("The top card is: " + colour + " " + x); // Show the top card of the pile
        }



        //ask user if they would like to pickup a card
        String pickupResponse;

        do {
            
            while (hasPlayableCard == false){ //if the player doesn't have any playable cards, it forces a pickup
                System.out.println("No playable cards. Automatically picking up a card.");
                Deck.pickup(1); //pickup card

                //this for loop checks if the player has any playable cards
                for (colorIndex = 0; colorIndex < card.length; colorIndex++){
                    for (cardIndex = 0; cardIndex < card[colorIndex].length; cardIndex++){
                        if (card[colorIndex][cardIndex] == Deck.p1 && (tcolour == colorIndex || tcard == cardIndex || colorIndex == 3)){
                            //iterate through the array
                            //if the user has a card that matches the top card's requirements, they have a playable card
                            hasPlayableCard = true;
                            break; //exit the inner for loop
                        }
                    }

                    if (hasPlayableCard == true){break;} //exit the outer for loop
                }


            }
            
            //give user the option if they would like to optionally pick up a card
            while (true){

                System.out.println("Would you like to pick up a card? (yes/no) ");
                pickupResponse = scan.nextLine();
                
                if (pickupResponse.equals("yes")){ //if yes, user picks up a card and gets the question asked again
                    Deck.pickup(1);
                    break;
                }

                else if (pickupResponse.equals("no")) { //if no, user doesn't pick up a card
                    break;
                }

                else { //otherwise, the user will be prompted to give a valid answer
                    System.out.println("Not a valid response. Try again.");
                    continue;
                }

                
            }
        } while(pickupResponse.equals("yes"));


        System.out.println("Which card do you want to play? (ex. red 1 a)"); // ask the user which card they want to play





        // Declaring variables outside of the while loop
        String P1response;
        String P1color;
        String P1Letter;
        int P1C;
        int P1number;
        int cardNumIndex;


        // USER PLAYS A CARD
        // check if user is allowed to play the card based on the colour, number, letter, if it is in the player's hand, and if it matches requirements of top card
        while (true){
            P1response = scan.nextLine();
            
            String[] P1Play = P1response.split(" "); // Split the input into color, number, & letter from the spaces

            P1color = P1Play[0]; // Get the color from P1 turn


            // CHECK FORMATING

            if (P1Play.length < 2 || P1Play.length > 3){
                System.out.println("Improper format. Try again");
                continue;
            }


            // COLOUR CHECK
            
            P1C = 0; // Integer to store the colour of the card

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
            else{ // if it is an invalid colour, the while loop restarts and requires the user to pick a correct colour
                System.out.println("Invalid colour, try again.");
                continue;
            }


            // NUMBER CHECK

            try { //tries running this line
                P1number = Integer.parseInt(P1Play[1]); // Get the number from P1 turn
            }

            catch (NumberFormatException e){ //if there was an error in try, this would catch the exception and prevent the program from crashing
                System.out.println("Not a valid number. Try again.");
                continue;
            }
            


            // LETTER CHECK

            P1Letter = "";
            cardNumIndex = 0; // Integer to store the index of the card in the array

            if (P1Play.length == 3){ //if the card has a letter in it, aka, not a 0 card
                P1Letter = P1Play[2]; // Get the letter from P1 turn

                // Reverse the naming of the card since the array is from 0-18
                // Player names a card from 0-10, but the array is from 0-18
                // Reverse the letter naming to get the correct index


                if (P1Letter.equals("b")){ //for even
                    cardNumIndex = P1number * 2;
                }
                
                else if (P1Letter.equals("a")){ //for odd
                    cardNumIndex = (P1number * 2) - 1; 
                }
                else{
                    System.out.println("Invalid letter. Try again.");
                    continue;
                }

            }

            else if(P1Play.length == 2){ //if the card number is 0
                cardNumIndex = P1number;
            }

            else{
                System.out.println("Invalid input. Please enter a valid card.");
                continue; // Exit the method if the input is invalid
            }


            // CHECK IF PLAYER HAS THE CARD

            if (card[P1C][cardNumIndex] != Deck.p1){
                System.out.println("You don't have that card. Try again.");
                continue; // card is not Player 1's hand
            }


            // VERIFY IF CARD MATCHES CRITERIA OF TOP CARD
            
            if (tcolour == P1C || tcard == cardNumIndex || colorIndex == 3 || P1C == 3){
                if (P1C == 3){ //if the card played is a wild card
                    String colourChange;
                    int wildCardColour;
                    
                    while (true){
                        System.out.println("What colour would you like? (red/blue/green)");
                        colourChange = scan.nextLine();


                        switch (colourChange){
                            case "red": wildCardColour = 0;    break;
                            case "blue": wildCardColour = 1;   break;
                            case "green": wildCardColour = 2;  break; 
                            default: System.out.println("Not a valid colour. Try again"); continue;
                        }
                        break; //exit loop if colour is chosen
                    }
                    tcolour = wildCardColour; //make top card the wild card colour chosen
                    break;
                }
                
                else { //if the card played is anything but a wild card
                    break; // a valid card has been played
                }
            }

            else{
                System.out.println("You can't play that card based on the top card.");
                continue;
            }
        }


        card[oldTcolour][oldTnumber] = Deck.use; // Move the top card to the used pile

        card[P1C][cardNumIndex] = Deck.top; // Set the card to 3 (remove the card from P1's hand and move to top)

        String tcolourName = ""; //name for the top colour in the instance that the user plays a wild card

        switch (tcolour){
            case 0: tcolourName = "red";    break;
            case 1: tcolourName = "blue";   break;
            case 2: tcolourName = "green";  break; 
        }

        
        // END OF TURN

        System.out.println("You played: " + P1color + " " + P1number + P1Letter + "\n\n"); // Show the card that was played
        
        if (Deck.countCards(1) > 0){ //if the player still has cards in their hand, the following will be printed
            if (P1C != 3){
                System.out.println("The top card is now: " + P1color + " " + P1number + P1Letter); // Show the new top card of the pile
            }

            else if (P1C == 3){
                System.out.println("The top colour is now: " + tcolourName); // Show the new top colour of the pile
            }

            PlayerOneHand.P1hand(Deck.card); // Call the P1 hand method to show the new hand

            // Change values of public variables
            if (P1C != 3){
                TopCard.topcolour = P1C; 
                TopCard.topcard = cardNumIndex; 
                TopCard.wildTop = false;
            }

            else if (P1C == 3){
                TopCard.topcolour = tcolour; 
                TopCard.wildTop = true;
                TopCard.topcard = 0;
            }
        }

        else{} //if the player has 0 cards, nothing is said
               //print statements in main method are then printed
        
        System.out.println("Your turn is over!"); // Show that the turn is over
    }
}
