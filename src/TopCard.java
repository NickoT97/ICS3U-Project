public class TopCard {
    public static void TopCard() {

        int index1 = 0; // The first index is the color of the card (red, blue, green, or wild)
        int index2 = 0; // The second index is the number of the card (0-25)
        int topcard; // The top card of the pile

        for(int i = 0; i < 7; i++){
            
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)
            System.out.println(index1);

            if (index1 == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
                index2 = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
            }
            else{
                index2 = (int)(Math.random() * 25); // The second index is the number of the card (0-25)
            }

            // If the card that has been randomly drawn is a value in the spare pile, it will turn into the top card
            // This will take place after the players get their cards
            if(Deck.card[index1][index2] == 5){ 

                topcard = Deck.card[index1][index2]; // The top card of the pile
            
            }

        }
    }
}
