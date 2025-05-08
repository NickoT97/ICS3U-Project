import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Game{
    
    public int p1 = 1; // player 1's hand
    public int p2 = 2; // player 2's hand
    public int top = 3; // top of pile (last card(s) played)
    public int use = 4; // used pile (last 10 cards played)
    public int sp = 5; // spare pile
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        

        JFrame frame = new JFrame("Uno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(960,540);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.RED);

        ImageIcon background = new ImageIcon("/Users/nicko/Desktop/Uno/UnoBackground.jpg");
        Image img = background.getImage();

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        frame.add(panel);
        frame.setVisible(true); 


        System.out.println("Welcome to Uno!");
        System.out.println("Do you want to play? (yes/no)"); // Ask the user if they want to play the game
            String response = scan.nextLine().toLowerCase();

        if (response.equals("yes")){
            System.out.println("Great! Let's play!");
            System.out.println("Handing out 7 cards...");

            System.out.println("Your cards are: ");
            Deck.cards(); // Call the cards method in the Deck class, and draw 7 cards

        }

        else if (response.equals("no")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        else {
            System.out.println("Not a valid response.");
        }


    }
}


class Clearing{
    private Scanner scanner = new Scanner(System.in);
    // turn is declared as negative 1 so that the turns only start counting when the first dealing is done. 
    private int Turn = -1;
    //Method that makes it so the player has to type "next" to hide his cards (clear the console), then the other player must type "next" to show their own cards (the next player in rotation).
    public void clearing(){

        String next = null;
        next = scanner.nextLine();
        //checks if console input was "clear"
            if(next.equals("next")){
                //clears console
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // adds 1 to the turn to let the next player know what turn they are on.
                Turn++;
                next = null;
                }
        next = scanner.nextLine();
            if(next.equals("next")){
                
                if(Turn >=1){

                    System.out.println("Turn #" + Turn);
                }

                return;
            }
        
}
}





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
        System.out.println("What card would you like to play?");
        System.out.println();

        Int x = scan.nextInt();
        Int y = scan.nextInt();

        if((((x == TopC) && y > TopN)) || (y > TopN)){

            //makes current card a used rather than top
            card[TopC][TopN] = 4;

            //declares current position as new top
            card[x][y] = top;

            // makes top current position for later use
            TopC = x;
            TopN = y;
        }


        
        
                    }
}













class Deck{
    Int x = null;
    Int y = null;
    Int TopC = null;
    Int TopN = null;


            
    public static void cards() {


        //declaring the clearing method
        Clearing clearer = new Clearing();


 
        
                //declaring player 1s hand display method
                PlayerOneHand hand1 = new PlayerOneHand();
                
  

    //memory numbers declared. These are variables so we can change the numbers if we need to. (If we want to add more players, or we need another variable for whatever reason)




        int[][] card = new int[4][];
        
        card[0] = new int[25]; // Red
        
        for (int i = 0; i < 25; i++){
            card[0][i] = sp; // Give each card a value of 4, which means it is in the deck
            }

        card[1] = new int[25]; // Blue
        
        for (int i = 0; i < 25; i++){
            card[1][i] = sp; // Give each card a value of 4, which means it is in the deck
        }

        card[2] = new int[25]; // Green
        
        for (int i = 0; i < 25; i++){
            card[2][i] = sp; // Give each card a value of 4, which means it is in the deck
        }

        card[3] = new int[8]; // Wild
        
        for (int i = 0; i < 8; i++){
            card[3][i] = sp; // Give each card a value of 4, which means it is in the deck
        }

    

        

        int index1 = 0;
        int index2 = 0;
        
        String colour = null;
        
        //card dealing for player 1
        int i = 0;
        for(i = 0; i < 7; i++){
            
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)

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
    
        // card dealing for player 2

        for(i = 0; i < 7; i++){
            
            index1 = (int)(Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)

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


        //rounds


        hand1.P1hand(card);

        clearer.clearing();
        
        

        }






 
    
    }