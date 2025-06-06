public class Deck{
    
    //memory numbers declared. These are variables so we can change the numbers if we need to
    public static int p1 = 1; // player 1's hand
    public static int p2 = 2; // player 2's hand
    public static int top = 3; // top of pile (last card played)
    public static int use = 4; // used pile 
    public static int sp = 5; // spare pile
    public static int[][] card = new int[4][];
    
    public static void cards() {

        // SETTING UP THE DECK
        String x;
        int y;

        card[0] = new int[19]; // Red
        
        for (int i = 0; i < 19; i++){
            card[0][i] = sp; // Give each card a value of 5, which means it is in the deck
            }

        card[1] = new int[19]; // Blue
        
        for (int i = 0; i < 19; i++){
            card[1][i] = sp; // Give each card a value of 5, which means it is in the deck
        }

        card[2] = new int[19]; // Green
        
        for (int i = 0; i < 19; i++){
            card[2][i] = sp; // Give each card a value of 5, which means it is in the deck
        }

        card[3] = new int[8]; // Wild
        
        for (int i = 0; i < 8; i++){
            card[3][i] = sp; // Give each card a value of 5, which means it is in the deck
        }



        // GIVING PLAYER 1 CARDS

        int index1 = 0;
        int index2 = 0;
        
        String colour = null;
        
        //card dealing for player 1
        
        int i = 0;

        System.out.println("Player 1's Hand:");
        
        for(i = 0; i < 7; i++){
            
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)

            if (index1 == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
                index2 = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
            }
            else{
                index2 = (int)(Math.random() * 19); // The second index is the number index of the card (0-18)
            }

            if(card[index1][index2] == sp){ // If the card is in the spare pile (ready for dealing)

                String colourdefinition;

                switch (index1){ // Give each number a designated colour
                    case 0:  colourdefinition = "red";   break;
                    case 1:  colourdefinition = "blue";  break;
                    case 2:  colourdefinition = "green"; break;
                    default: colourdefinition = "wild";  break;
                }

                if(index2 % 2 == 0 && index2 != 0){ // If remainder is 0 (even), it is succeeded by "b"
                    y = index2 / 2;
                    x = (y + "b");
                }
                
                else if (index2 == 0){ // If the number is 0, it's just labeled as 0
                    x = "0";
                }

                else{ // If remainder is not 0 (odd), it is succeeded by "a"
                    y = (index2 + 1) / 2;
                    x = (y + "a");
                }
               
                card[index1][index2] = p1; // Give the card a value of one, which means it is in player one's hand now.
                
                System.out.println(colourdefinition + ' ' + x);
            }

            else{
                i--;
            }
        }



        //clear console to rotate to player 2
        Clearing.clearing();
        



        // GIVING PLAYER 2 CARDS
        //card dealing for player 2

        System.out.println("Player 2's Hand:");

        for(i = 0; i < 7; i++){
            
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)

            if (index1 == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
                index2 = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
            }
            else{
                index2 = (int)(Math.random() * 19); // The second index is the number index of the card (0-18)
            }

            if(card[index1][index2] == sp){ // If the card is in the spare pile (ready for dealing)

                String colourdefinition;

                switch (index1){ // Give each number a designated colour
                    case 0:  colourdefinition = "red";   break;
                    case 1:  colourdefinition = "blue";  break;
                    case 2:  colourdefinition = "green"; break;
                    default: colourdefinition = "wild";  break;
                }

                if(index2 % 2 == 0 && index2 != 0){ // If remainder is 0 (even), it is succeeded by "b"
                    y = index2 / 2;
                    x = (y + "b");
                }
                
                else if (index2 == 0){ // If the number is 0, it's just labeled as 0
                    x = "0";
                }

                else{ // If remainder is not 0 (odd), it is succeeded by "a"
                    y = (index2 + 1) / 2;
                    x = (y + "a");
                }
               
                card[index1][index2] = p2; // Give the card a value of one, which means it is in player two's hand now.
                System.out.println(colourdefinition + ' ' + x);
            }

            else{
                i--;
            }
        }
    
        //clear console
        Clearing.clearing();
    
    }


    
    //method used to pickup a random card from the spare pile
    //user decides whether they want to pickup or not at the start of their turn
    public static void pickup(int a) {
        int index1;
        int index2;
        String x;
        int y;
        String colour;

        while (true){ //while loop to loop through the array
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)
            
            if (index1 == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards                
                index2 = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
            }
            else{
                index2 = (int)(Math.random() * 19); // The second index is the number index of the card (0-18)
            }

            if(card[index1][index2] == sp){ // If the card is in the spare pile (ready for dealing)
                card[index1][index2] = a; //the card is placed into the designated player's hand (a)
                break; //leave the while loop when added to player'hand
            }
        }

        switch (index1){ // Give each number a designated colour
            case 0:  colour = "red";   break;
            case 1:  colour = "blue";  break;
            case 2:  colour = "green"; break;
            default: colour = "wild";  break;
        }

        if(index2 % 2 == 0 && index2 != 0){ // If remainder is 0 (even), it is succeeded by "b"
            y = index2 / 2;
            x = (y + "b");
        }
                
        else if (index2 == 0){ // If the number is 0, it's just labeled as 0
            x = "0";
        }

        else{ // If remainder is not 0 (odd), it is succeeded by "a"
            y = (index2 + 1) / 2;
            x = (y + "a");
        }

        System.out.println("You picked up " + colour + " " + x);

    }



    //method used to count the cards in the player's hand
    //if one player has 0 cards, they win the game
    public static int countCards(int a) {
        
        int count = 0; 
        
        for (int colorIndex = 0; colorIndex < card.length; colorIndex++){ //iterate through the colours
            for (int cardIndex = 0; cardIndex < card[colorIndex].length; cardIndex++){ //iterate through the numbers
                if (card[colorIndex][cardIndex] == a){ // check to see if card is in player's hand
        
                    count++; //if in player's hand, the count variable is used to total up the cards in the hand
                    
                }
            }
        }
        return count; //return the amount of cards in the player's hand
    }
}