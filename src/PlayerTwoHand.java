// Player 2 hand show method.

class PlayerTwoHand{
    public static void P2hand(int[][] card){
        
        System.out.println("Player 2's hand: ");

        for (int colorIndex = 0; colorIndex < card.length; colorIndex++){
            for (int cardIndex = 0; cardIndex < card[colorIndex].length; cardIndex++){
                if (Deck.card[colorIndex][cardIndex] == Deck.p2){
                    String color;
                    switch (colorIndex){
                        case 0:  color = "red";   break;
                        case 1:  color = "blue";  break;
                        case 2:  color = "green"; break;
                        default: color = "wild";  break;
                    }

                    String colour; // String to store the color of the card
                    String x = null;
                    int y = 0;

                    if(cardIndex % 2 == 0){
                        y = cardIndex / 2;
                        x = (y + "b");
                    }

                    else if(cardIndex == 0){
                        x = "0";
                    }

                    else{
                        y = (cardIndex + 1) / 2;
                        x = (y + "a");
                    }
                    
                    System.out.println(color + " " + x);

                }
            }
        }
        
        for (int i = 0; i < 3; i++) { // Spacing
            System.out.println();
        }
        
    }
}