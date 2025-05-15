// Player 1 hand show method.

class PlayerOneHand{
    public void P1hand(int[][] card){
    
        for (int colorIndex = 0; colorIndex < card.length; colorIndex++){
            for (int cardIndex = 0; cardIndex < card[colorIndex].length; cardIndex++){
                if (card[colorIndex][cardIndex] == 1){
                    String color;
                    switch (colorIndex){
                        case 0:  color = "red";   break;
                        case 1:  color = "blue";  break;
                        case 2:  color = "green"; break;
                        default: color = "wild";  break;
                    }
                    
                    System.out.println(color + " " + cardIndex);

                }
            }
        }
        
        System.out.println();
        
    }
}