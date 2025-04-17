import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

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
        System.out.println("Do you want to play? (yes/no)");
            String response = scan.nextLine().toLowerCase();

        if (response.equals("yes")){
            System.out.println("Great! Let's play!");
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
        String[][] card = new String[4][];
        card[0] = new String[25]; // Red
        card[1] = new String[25]; // Blue
        card[2] = new String[25]; // Green
        card[3] = new String[8]; // Wild

        int[] location = new int[83]; 

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < 7; i++){
            index1 = (int) Math.random() * 4;
            index2 = (int) Math.random() * 25;

            System.out.println(card[index1][index2]);
        }
    
    
    }
}