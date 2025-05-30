import java.util.Scanner;

//Method that makes it so the player has to type "next" to hide his cards (clear the console), then the other player must type "next" to show their own cards (the next player in rotation).

public class Clearing{
    
    // turn is declared as negative 1 so that the turns only start counting when the first dealing is done. 
    public static int Turn = -1;

    public static void clearing(){
        
        Scanner scanner = new Scanner(System.in);
        
        Turn = -1;
        
        String response = null;

        response = scanner.nextLine();
        
        //checks if console input was "next"
        if(response.equals("next")){
                    
            //clears console using 100 new lines
            for(int i = 0; i < 100; ++i) {
            System.out.println();
            }

            // adds 1 to the turn to let the next player know what turn they are on.
            Turn++;
            response = null;
            }
            
            response = scanner.nextLine();

            if(response.equals("next")){
                if(Turn >=1){

                System.out.println("Turn #" + Turn); // Prints out what turn number it is
            }
        }
    }
}