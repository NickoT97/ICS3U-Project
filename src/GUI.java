import java.awt.*;
import javax.swing.*;


// optional GUI, didn't have time to make it

public class GUI {
    public static void gui() {

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

    }
}