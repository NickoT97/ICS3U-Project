import java.awt.*;
import javax.swing.*;

public class Game{
    public static void main(String [] args){

        JFrame frame = new JFrame("Uno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(960,540);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.CYAN);

        ImageIcon background = new ImageIcon(("/Users/nicko/Downloads/PokerTable.jpeg"));
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

    }
}

class Deck{
    public static void cards() {
        String[] red = new String[25];
        String[] blue = new String[25];
        String[] green = new String[25];
        String[] wild = new String[8];

        int index = 0;


    
    
    
    }
}