// Name:
// USC NetID:
// CSCI455 PA2
// Spring 2019


/**
* 
*/
import java.util.Scanner;
import java.util.ArrayList;

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }

      SolitaireBoard sb = new SolitaireBoard();
      setupSimulator(userConfig, sb);     // init. the SolitaireBoard object 
      runGame(singleStep, sb);            // Run the SolitaireBoard game.
      
   }
   
   // <add private static methods here>
   /**
    * This function is used to set up or init. the SolitaireBoard
    * @param userConfig: user input option. If true: prompt user to enter the array 
    * @param sb: SolitaireBoard class object
    */
   private static void setupSimulator(boolean userConfig, SolitaireBoard sb){
      if(userConfig){
         Scanner sc = new Scanner(System.in);    // Init. input Scanner
         String string = "";
         boolean isInputValid = false;
         int inputNumber = 0;
         int inputSum = 0;
         ArrayList<Integer> myArrList = new ArrayList<Integer>();

         System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
         System.out.println("Please enter a space-separated list of positive integers followed by newline:");

         while(!isInputValid){
            if(sc.hasNext()){
               string = sc.nextLine();
            }
            Scanner in = new Scanner(string);

            while(in.hasNext()){
               // Check whether is digit
               if(!in.hasNextInt()){
                  System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL + ".");
                  System.out.println("Please enter a space-separated list of positive integers followed by newline:");
                  isInputValid = false;
                  inputSum = 0;                     // Set input sum == 0
                  myArrList.clear();                // clear myArrList
                  break;
               }

               // get input number
               inputNumber = in.nextInt(); 
            
               // Check whether the input number is between 0 to card_total
               if(inputNumber <= 0 || inputNumber > SolitaireBoard.CARD_TOTAL){
                  System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL + ".");
                  System.out.println("Please enter a space-separated list of positive integers followed by newline:");
                  isInputValid = false;
                  inputSum = 0;                     // Set input sum == 0
                  myArrList.clear();                // clear myArrList
                  break;
               }
            
               inputSum = inputSum + inputNumber;   // update inputSum
               
               // Check the sum whether is equal to CARD_TOTAL
               if(inputSum > SolitaireBoard.CARD_TOTAL){
                  System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL + ".");
                  System.out.println("Please enter a space-separated list of positive integers followed by newline:");
                  isInputValid = false;
                  inputSum = 0;                     // Set input sum == 0
                  myArrList.clear();                // clear myArrList
                  break;
               }               
               myArrList.add(inputNumber);          // update myArrList
            }
            // Check the sum whether is equal to CARD_TOTAL
            if(inputSum != SolitaireBoard.CARD_TOTAL){
               isInputValid = false;
               inputSum = 0;                     // Set input sum == 0
               myArrList.clear();                // clear myArrList
            }else{
               isInputValid = true;
               sb.initSolitaireBoard(myArrList);        // Init. with user config
               System.out.println("Setting up is correct");
            }
         }
      }
   }

   /**
    * This function is used to run game
    * @param singleStep: if true, user must enter return in the keyboard to cont. the game
    * @param sb: the initialized SolitaireBoard object.
    */

   private static void runGame(boolean singleStep, SolitaireBoard sb){
      System.out.print("Initial configuration: ");
      System.out.println(sb.configString());
      int tracker = 1;

      if(singleStep){
         Scanner sc = new Scanner(System.in);
         sb.playRound();
         System.out.print("[" + tracker + "] Current configuration: ");
         System.out.println(sb.configString());
         tracker++;
         while(!sb.isDone()){
            System.out.print("<Type return to continue>");
            sc.nextLine();
            sb.playRound();
            System.out.print("[" + tracker + "] Current configuration: ");
            System.out.println(sb.configString());
            tracker++;
         }

      }
      else{
         while(!sb.isDone()){
            sb.playRound();
            System.out.print("[" + tracker + "] Current configuration: ");
            System.out.println(sb.configString());
            tracker++;
         }
      }
      System.out.println("Done!");

   }

  
}
