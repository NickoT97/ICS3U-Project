// This method will only be called once at the start of the game to determine the top card of the pile

public class TopCard {

    public static int topcolour; // The top colour of the pile
    public static int topcard; // The top number of the pile
    public static int CardTop; // The top number of the pile

    public static void TopCard(int[][] card) {
            
        topcolour = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)

        if (topcolour == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
            topcard = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
        }
        
        else{
            topcard = (int)(Math.random() * 25); // The second index is the number of the card (0-25)
        }

        // If the card that has been randomly drawn is a value in the spare pile, it will turn into the top card
        // This will take place after the players get their cards
        if(Deck.card[topcolour][topcard] == Deck.sp){ 

            String colour;
            String x;
            int y;

            switch (topcolour){
                case 0:  colour = "red";   break;
                case 1:  colour = "blue";  break;
                case 2:  colour = "green"; break;
                default: colour = "wild";  break;
            }

            if(topcard % 2 == 0){ // If remainder is 0 (even), it is succeeded by "b"
                y = topcard / 2;
                x = (y + "b");
            }
                
            else if (topcard == 0){ // If the number is 0, it's just labeled as 0
                x = "0";
            }

            else{ // If remainder is not 0 (odd), it is succeeded by "a"
                y = (topcard + 1) / 2;
                x = (y + "a");
            }

            CardTop = Deck.card[topcolour][topcard] = Deck.top; // The top card of the pile

            System.out.println("The top card is: " + colour + " " + x);
            
        }
    }
}