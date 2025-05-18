public class TopCard {

    public static int topcolour; // The top colour of the pile
    public static int topcard; // The top number of the pile

    public static void TopCard() {

        int topcolour = 0; // The first index is the color of the card (red, blue, green, or wild)
        int topcard = 0; // The second index is the number of the card (0-25)

        for(int i = 0; i < 7; i++){
            
            topcolour = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)
            System.out.println(topcolour);

            if (topcolour == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
                topcard = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
            }
            else{
                topcard = (int)(Math.random() * 25); // The second index is the number of the card (0-25)
            }

            // If the card that has been randomly drawn is a value in the spare pile, it will turn into the top card
            // This will take place after the players get their cards
            if(Deck.card[topcolour][topcard] == 5){ 

                topcard = Deck.card[topcolour][topcard]; // The top card of the pile
            
            }

        }
    }
}
