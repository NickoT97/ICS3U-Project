// This method will only be called once at the start of the game to determine the top card of the pile

public class TopCard {

    public static int topcolour; // The top colour of the pile
    public static int topcard; // The top number of the pile
    public static boolean wildTop = false; //wild is just 0 as it doesn't have a value

    public static void TopCard(int[][] card) {
            
        topcolour = (int)(Math.random() * 3); // The first index is the color of the card (red, blue, or green - no wild cards)

        topcard = (int)(Math.random() * 19); // The second index is the number of the card (0-18)

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

            if(topcard % 2 == 0 && topcard != 0){ // If remainder is 0 (even), it is succeeded by "b"
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

            Deck.card[topcolour][topcard] = Deck.top; // The top card of the pile

            System.out.println("The top card is: " + colour + " " + x);
            
        }
    }
}