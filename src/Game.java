import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Game{
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

class Deck{
    public static void cards() {
        int[][] card = new int[4][];
        
        card[0] = new int[25]; // Red
        
        for (int i = 0; i < 25; i++){
            card[0][0] = 4; // Give each card a value of 4, which means it is in the deck
            }

        card[1] = new int[25]; // Blue
        
        for (int i = 0; i < 25; i++){
            card[1][i] = 4; // Give each card a value of 4, which means it is in the deck
        }

        card[2] = new int[25]; // Green
        
        for (int i = 0; i < 25; i++){
            card[2][i] = 4; // Give each card a value of 4, which means it is in the deck
        }

        card[3] = new int[8]; // Wild
        
        for (int i = 0; i < 25; i++){
            card[3][i] = 4; // Give each card a value of 4, which means it is in the deck
        }

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < 7; i++){
            index1 = (int) (Math.random() * 4); // The first index is the color of the card (red, blue, green, or wild)
            index2 = (int) (Math.random() * 25); // The second index is the number of the card (0-25)
            
            if (index1 == 3) // If the card is wild (index1 == 3), the randomizer will draw from a pile of 8 cards
                index2 = (int) (Math.random() * 8); // Thw ild card has a pile of 8 cards
            }

            System.out.println(card[index1][index2]);

            card[index1][index2] = 1; // Give the card a value of one, which means it is in the player's hand
        }

    }