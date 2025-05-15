import java.util.Scanner;

public class Clearing{
    Scanner scanner = new Scanner(System.in);
    
    // turn is declared as negative 1 so that the turns only start counting when the first dealing is done. 
    int Turn = -1;
    
    //Method that makes it so the player has to type "next" to hide his cards (clear the console), then the other player must type "next" to show their own cards (the next player in rotation).
    public void clearing(){

        String next = null;
        
        next = scanner.nextLine();
        
            //checks if console input was "next"
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