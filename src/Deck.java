public class Deck{
    
    //memory numbers declared. These are variables so we can change the numbers if we need to. (If we want to add more players, or we need another variable for whatever reason)
    public static int p1 = 1; // player 1's hand
    public static int p2 = 2; // player 2's hand
    public static int top = 3; // top of pile (last card(s) played)
    public static int use = 4; // used pile (last 10 cards played)
    public static int sp = 5; // spare pile
    public static int[][] card = new int[4][];
    
    public static void cards() {

        //declaring the clearing method
        Clearing clearer = new Clearing();
       
        //declaring player 1s hand display method
        PlayerOneHand hand1 = new PlayerOneHand();

        //declaring player 2s hand display method
        PlayerTwoHand hand2 = new PlayerTwoHand();



        // SETTING UP THE DECK

        
        card[0] = new int[25]; // Red
        
        for (int i = 0; i < 25; i++){
            card[0][i] = sp; // Give each card a value of 5, which means it is in the deck
            }

        card[1] = new int[25]; // Blue
        
        for (int i = 0; i < 25; i++){
            card[1][i] = sp; // Give each card a value of 5, which means it is in the deck
        }

        card[2] = new int[25]; // Green
        
        for (int i = 0; i < 25; i++){
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
        for(i = 0; i < 7; i++){
            
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)
            System.out.println(index1);

            if (index1 == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
                index2 = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
            }
            else{
                index2 = (int)(Math.random() * 25); // The second index is the number of the card (0-25)
            }

            if(card[index1][index2] == sp){

                if(index1 == 0){
                    colour = "red";
                }

                if(index1 == 1){
                   colour = "blue";
                }

                if(index1 == 2){
                    colour = "green";
                }

                if(index1 == 3){
                    colour = "wild";
                }
                
               
                card[index1][index2] = p1; // Give the card a value of one, which means it is in player one's hand now.
                System.out.println(colour + ' ' + index2);
            }
            else{
                i--;
            }
        }




        //clear console to rotate to player 2
        clearer.clearing();
    




        // GIVING PLAYER 2 CARDS

        for(i = 0; i < 7; i++){
            
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)
            System.out.println(index1);

            if (index1 == 3){ // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
                index2 = (int)(Math.random() * 8); // The wild card has a pile of 8 cards
            }
            else{
                index2 = (int)(Math.random() * 25); // The second index is the number of the card (0-25)
            }

            if(card[index1][index2] == sp){

                if(index1 == 0){
                    colour = "red";
                }

                if(index1 == 1){
                   colour = "blue";
                }

                if(index1 == 2){
                    colour = "green";
                }

                if(index1 == 3){
                    colour = "wild";
                }
                
               
                card[index1][index2] = p2; // Give the card a value of one, which means it is in player one's hand now.
                System.out.println(colour + ' ' + index2);
            }
            else{
                i--;
            }
        }





        // using the clear tool.
        clearer.clearing();


        // 

        hand1.P1hand(card);

        clearer.clearing();

        hand2.P2hand(card);

        clearer.clearing();
        

        }
}